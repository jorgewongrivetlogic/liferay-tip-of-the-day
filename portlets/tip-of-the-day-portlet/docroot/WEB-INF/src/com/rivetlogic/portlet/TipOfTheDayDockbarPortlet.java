/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 3
* of the License.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301, USA.
*/

package com.rivetlogic.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.model.TipsOfTheDayUsers;
import com.rivetlogic.service.TipsOfTheDayUsersLocalServiceUtil;
import com.rivetlogic.service.WebArticleHelperLocalServiceUtil;
import com.rivetlogic.tofd.util.TipOfTheDayUtil;
import com.rivetlogic.tofd.util.WebKeys;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author juancarrillo
 *
 */
public class TipOfTheDayDockbarPortlet extends MVCPortlet {
 
	@Override
	public void doView(RenderRequest request,RenderResponse response) 
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			String userStatus = getUserStatus(request, themeDisplay);
			setPopUpVisibility(request, themeDisplay, userStatus);
			
		} catch (SystemException e) {
			logger.error(e);
		} catch (PortalException e) {
			logger.error(e);
		}

		super.doView(request, response);
	}
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		getUserStatus(request, themeDisplay);
		
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		
		if (mvcPath.equals("/html/dockbar/content.jsp")) {
			setArticleToDisplay(request);
		}
		
		super.render(request, response);
	}
	
	@Override
	public void serveResource(
			ResourceRequest request, ResourceResponse response) 
		throws IOException,PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String action = ParamUtil.getString(request, Constants.CMD);
		
		if (action.equals(WebKeys.DISPLAY)) {
			boolean stopShowing = 
					ParamUtil.getBoolean(request, "stopShowing");
			logger.debug("stopShowing: "+stopShowing);
			changeShowTips(stopShowing, themeDisplay);
			
		} else if (action.equals(WebKeys.CHANGE_USER_STATUS)) {
			
			String userStatus = getUserStatus(request, themeDisplay);
			setUserVisitance(themeDisplay, userStatus);
		}
		
		super.serveResource(request, response);
	}
	
	private void setPopUpVisibility(RenderRequest request, 
			ThemeDisplay themeDisplay, String userStatus)
		throws PortalException, SystemException {
		
		long[] categoryIds = new long[0];
		
		boolean showTips = checkShowTips(
				themeDisplay, userStatus);
		
		categoryIds = 
				TipOfTheDayUtil.retrieveCategories(
						request, themeDisplay, categoryIds);
		
		if (categoryIds != null ) {
			getInitialArticlesToDisplay(request, categoryIds);
			
		} else {
			showTips = false;
		}
		
		request.setAttribute("showTips", showTips );
	}
	
	private boolean checkShowTips(
			ThemeDisplay themeDisplay, String userStatus) 
		throws NumberFormatException, PortalException, SystemException {
		
		boolean show = false;
		
		Layout layout = themeDisplay.getLayout();
		
		if (themeDisplay.isSignedIn() && 
				!layout.getGroup().getName().equals(
						GroupConstants.CONTROL_PANEL)) {
			
			logger.debug("userStatus: "+userStatus);
			
			if (Validator.isNotNull(userStatus)) {
				
				if (userStatus.equals(
						String.valueOf(WebKeys.STATUS_RECEIVE))) {
					show = true;	
					
				} else if (!userStatus.equals(
						String.valueOf(!WebKeys.STATUS_RECEIVE))) {
					
					Calendar lastVisited = new GregorianCalendar();
					lastVisited.setTimeInMillis(Long.valueOf(userStatus));
					Calendar currentTime = 
							new GregorianCalendar(themeDisplay.getTimeZone());
					
					Calendar today = 
							new GregorianCalendar(
									currentTime.get(Calendar.YEAR), 
									currentTime.get(Calendar.MONTH), 
									currentTime.get(Calendar.DAY_OF_MONTH));
					
					show = lastVisited.before(today);
					
					logger.debug("last visited: "+ 
					lastVisited.getTime().toString());
					logger.debug("today: "+ today.getTime().toString());
				}
			}
		}
		
		logger.debug("Show Tip of the Day: "+show);
		
		return show;
	}
	
	/**
	 * Actions called from dockbar switch and pop up checkbox 
	 */
	private void changeShowTips(
			boolean stopShowing, ThemeDisplay themeDisplay) {
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		
		try {
			if (stopShowing) {
				TipsOfTheDayUsersLocalServiceUtil.setUser(companyId, groupId, 
						userId, String.valueOf(false));
				
			} else {
				
				setUserVisitance(themeDisplay, 
						String.valueOf(WebKeys.STATUS_RECEIVE));
			}
			
		} catch (SystemException e) {
			logger.error(e);
		} catch (PortalException e) {
			logger.error(e);
		}
	}
	
	private void setUserVisitance(
			ThemeDisplay themeDisplay, String userStatus) {
		
		if (themeDisplay.isSignedIn()) {
			
			if (!userStatus.equals(String.valueOf(!WebKeys.STATUS_RECEIVE))) {
				
				Calendar calendar = 
						new GregorianCalendar(themeDisplay.getTimeZone());
				
					try {
						TipsOfTheDayUsersLocalServiceUtil.setUser(
								themeDisplay.getCompanyId(), 
								themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId(), 
								String.valueOf(calendar.getTimeInMillis()));
					} catch (PortalException e) {
						logger.error(e);
					} catch (SystemException e) {
						logger.error(e);
					}
			}
		}
	}
	
	private void getInitialArticlesToDisplay(
			RenderRequest request, long[] categoryIds) {

		List<JournalArticle> articles = 
				WebArticleHelperLocalServiceUtil
					.getJournalArticlesByCategoryIds(categoryIds);
		String[] articleIds = new String[articles.size()];

		for (int i=0; i < articleIds.length; ++i) {
			articleIds[i] = articles.get(i).getArticleId();
		}
		
		request.setAttribute(WebKeys.ARTICLE_IDS, 
				StringUtil.merge(articleIds));
		
		if (articleIds.length > 0) {
			chooseRandomTip(request, articleIds, StringUtil.split(""), 
					Arrays.asList(""), "");			
		}
		
		logger.debug("quantity of articles: "+articles.size());
	}
	
	private void setArticleToDisplay(RenderRequest request) {
		
		String articleIdsString = ParamUtil.getString(request, "articleIds");
		request.setAttribute(
				WebKeys.ARTICLE_IDS, articleIdsString);
		String[] articleIds = StringUtil.split(articleIdsString);
		String articleId = ParamUtil.getString(request, "articleId");
		request.setAttribute(WebKeys.ARTICLE_ID, articleId);
		
		if (articleIds.length > 0) {
			
			if (articleIds.length != 1) {
				selectTip(request, articleIds, articleId);
				
			} else {
				request.setAttribute(WebKeys.DISABLE_PREV, true);
				request.setAttribute(WebKeys.DISABLE_NEXT, true);
			}
			
		} else {
			SessionMessages.add(request, "no-tips-to-display");
			request.setAttribute(WebKeys.DISABLE_PREV, true);
			request.setAttribute(WebKeys.DISABLE_NEXT, true);
		}
	}
	
	/**
	 * User Status is needed for taking the decision about showing the pop up, 
	 * and the checkbox status inside the pop up
	 */
	private String getUserStatus(
			PortletRequest request, ThemeDisplay themeDisplay) {
		
		String userStatus = String.valueOf(!WebKeys.STATUS_RECEIVE);
		
		try {
			userStatus = GetterUtil.getString(
					request.getAttribute(WebKeys.USER_STATUS));
			
			if (Validator.isNull(userStatus)) {
				TipsOfTheDayUsers user = 
						TipsOfTheDayUsersLocalServiceUtil.getUser(
								themeDisplay.getCompanyId(), 
								themeDisplay.getScopeGroupId(), 
								themeDisplay.getUserId());
				
				if (Validator.isNotNull(user)) {
					userStatus = user.getStatus();
					request.setAttribute(
							WebKeys.USER_STATUS, userStatus);
				}
			}
			
			if (userStatus.equals(String.valueOf(!WebKeys.STATUS_RECEIVE))) {
				request.setAttribute(WebKeys.STOP_SHOWING, true);
			}
			
		} catch (SystemException e) {
			logger.error(e);
		} catch (PortalException e) {
			logger.error(e);
		}
		
		return userStatus;
	}
	
	private void selectTip(RenderRequest request, 
			String[] articleIds, String currentArticleId) {
		
		String attVisited = ParamUtil.getString(request, "visited");
		
		String[] visited = StringUtil.split(attVisited);
		
		List<String> visitedList = Arrays.asList(visited);
		
		int actualArticlePosition = visitedList.indexOf(currentArticleId);
		
		choosePreviousSelectedTip(request, visitedList, actualArticlePosition);
		
		if ( (actualArticlePosition == -1) || 
				(actualArticlePosition == (visitedList.size() -1 )) ) {
			
			if (visited.length >= (articleIds.length-1)){
				request.setAttribute(WebKeys.DISABLE_NEXT, true);
				
			} else {
				chooseRandomTip(
						request, articleIds, visited, 
						visitedList, currentArticleId);
			}
			
		} else {
			String nextArticleId = visitedList.get(actualArticlePosition + 1 );
			logger.debug("nextArticleId: "+ nextArticleId);
			request.setAttribute(WebKeys.NEXT_ARTICLE_ID, nextArticleId);
		}			
			
		if ( (visited.length == 0) || (actualArticlePosition == 0 )) {
			request.setAttribute(WebKeys.DISABLE_PREV, true);
		}
		
		if (actualArticlePosition==-1 ) {
			
			if (visited.length > 0) {
				request.setAttribute(
						WebKeys.VISITED, attVisited + "," + currentArticleId);
				
			} else {
				request.setAttribute(WebKeys.VISITED, currentArticleId);
			}
			
		} else {
			request.setAttribute(WebKeys.VISITED, attVisited);
		}
	}
	
	private void choosePreviousSelectedTip(RenderRequest request, 
			List<String> visited, int actualArticlePosition) {
		
		String prevArticleId = "";
		
		if (actualArticlePosition > 0) {
			prevArticleId = visited.get(actualArticlePosition - 1 );
			
		} else if (actualArticlePosition == -1 && visited.size() > 0) {
			prevArticleId = visited.get(visited.size() - 1);
		}
		
		request.setAttribute(WebKeys.PREV_ARTICLE_ID, prevArticleId);
	}
	
	private void chooseRandomTip(RenderRequest request, 
			String[] articleIds, String[] visited, 
			List<String> visitedList, String actualArticleId){

		Random randomGenerator = new Random();
		
		int randomArticle;
		do {
			randomArticle = randomGenerator.nextInt(articleIds.length);
			
		} while(checkTipVisited(
				visited, articleIds[randomArticle], actualArticleId));
		
		String articleId = articleIds[randomArticle];
		request.setAttribute(WebKeys.NEXT_ARTICLE_ID, articleId);
		
		logger.debug("nextRandomArticleId: "+ articleId);
	}
	
	private boolean checkTipVisited(
			String[] visited, String articleId, String actualArticleId) {
		
		boolean isVisited = false;
		
		if (articleId.equals(actualArticleId)) {
			isVisited = true;
		}
		
		if (!isVisited) {
			for (String visitedId : visited) {
				if (visitedId.equals(articleId)) {
					isVisited = true;
				}
			}			
		}
		
		return isVisited;
	}
	
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayDockbarPortlet.class);
}
