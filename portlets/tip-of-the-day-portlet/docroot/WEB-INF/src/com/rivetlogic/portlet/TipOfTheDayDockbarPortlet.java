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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * The Class TipOfTheDayDockbarPortlet.
 *
 * @author juancarrillo
 */
public class TipOfTheDayDockbarPortlet extends MVCPortlet {
	
	/** The Constant CONTENT_VIEW. */
	public static final String CONTENT_VIEW = "/html/dockbar/content.jsp";
	
	/** The Constant ATTR_SHOW_TIPS. */
	private static final String ATTR_SHOW_TIPS = "showTips";
	
	/** The Constant ERROR_MESSAGE_NO_TIPS_DISPLAY. */
	private static final String ERROR_MESSAGE_NO_TIPS_DISPLAY = "no-tips-to-display";
	
	/** The Constant CONTROL_PANEL_TIPS_PORTLET_ID. */
	private static final String CONTROL_PANEL_TIPS_PORTLET_ID = "1_WAR_tipofthedayportlet";
	
 
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request,RenderResponse response) 
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String userStatus = getUserStatus(request, themeDisplay);
		setPopUpVisibility(request, themeDisplay, userStatus);
			
		super.doView(request, response);
	}
	
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		getUserStatus(request, themeDisplay);
		
		String mvcPath = ParamUtil.getString(request,WebKeys.MVC_PATH);
		
		if (mvcPath.equals(CONTENT_VIEW)) {
			setArticleToDisplay(request);
		}
		
		super.render(request, response);
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(
			ResourceRequest request, ResourceResponse response) 
		throws IOException,PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String action = ParamUtil.getString(request, Constants.CMD);
		
		if (action.equals(WebKeys.DISPLAY)) {
			boolean stopShowing = 
					ParamUtil.getBoolean(request, WebKeys.STOP_SHOWING);
			
			if (logger.isDebugEnabled())
				logger.debug(WebKeys.STOP_SHOWING+StringPool.COLON+stopShowing);
			
			changeShowTips(stopShowing, themeDisplay);
			
		} else if (action.equals(WebKeys.CHANGE_USER_STATUS)) {
			
			String userStatus = getUserStatus(request, themeDisplay);
			setUserVisitance(themeDisplay, userStatus);
		}
		
		super.serveResource(request, response);
	}
	
	/**
	 * Sets the pop up visibility.
	 *
	 * @param request the request
	 * @param themeDisplay the theme display
	 * @param userStatus the user status
	 */
	private void setPopUpVisibility(RenderRequest request, 
			ThemeDisplay themeDisplay, String userStatus) {
		
		try {
			long[] categoryIds = new long[0];
			
			boolean showTips;
			
			showTips = checkShowTips(
					themeDisplay, userStatus);
			categoryIds = 
					TipOfTheDayUtil.retrieveCategories(
							request, themeDisplay, categoryIds);
			
			if (categoryIds != null && categoryIds.length > 0) {
				if(getInitialArticlesToDisplay(request, categoryIds)){
					showTips = false;
				}
				
			} else {
				showTips = false;
			}
			
			request.setAttribute(ATTR_SHOW_TIPS, showTips );
			
		} catch (Exception e) {
			logger.error("Error setting pop up visibility", e);
		}
		
	}
	
	/**
	 * Check show tips.
	 *
	 * @param themeDisplay the theme display
	 * @param userStatus the user status
	 * @return true, if successful
	 * @throws NumberFormatException the number format exception
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	private boolean checkShowTips(
			ThemeDisplay themeDisplay, String userStatus) 
		throws NumberFormatException, PortalException, SystemException {
		
		boolean show = false;
		
		Layout layout = themeDisplay.getLayout();
		
		if (themeDisplay.isSignedIn() && 
				!layout.getGroup().getName().equals(
						GroupConstants.CONTROL_PANEL)) {
			
			if (logger.isDebugEnabled())
				logger.debug("userStatus: "+userStatus);
			
			if (Validator.isNotNull(userStatus)) {
				
				if (userStatus.equals(
						String.valueOf(WebKeys.STATUS_RECEIVE))) {
					show = true;	
					
				} else if (!userStatus.equals(
						String.valueOf(!WebKeys.STATUS_RECEIVE))) {
					
					Calendar currentTime = 
									new GregorianCalendar(themeDisplay.getTimeZone());					
					long companyId = themeDisplay.getCompanyId();
										
					if(getEachLogin(companyId)){
						Date loginDate = themeDisplay.getUser().getLoginDate();
						show = ((currentTime.getTimeInMillis() - loginDate.getTime())/1000) < 1;
					}
					else{

						Integer intervalDays = getIntervalDays(companyId) - 1;
						Calendar lastVisited = new GregorianCalendar();
						lastVisited.setTimeInMillis(Long.valueOf(userStatus));
				
						Calendar referenceDay = 
								new GregorianCalendar(
										currentTime.get(Calendar.YEAR), 
										currentTime.get(Calendar.MONTH), 
										currentTime.get(Calendar.DAY_OF_MONTH));
						
						referenceDay.add(Calendar.DAY_OF_MONTH, -intervalDays);				
						show = lastVisited.before(referenceDay);
						
						if (logger.isDebugEnabled()) {
							logger.debug("last visited: "+ lastVisited.getTime().toString());
							logger.debug("today: "+ referenceDay.getTime().toString());
						}
					}	
				} 
			}
		}
		
		if (logger.isDebugEnabled())
			logger.debug("Show Tip of the Day: "+show);
		
		return show;
	}
	
	/**
	 * Actions called from dockbar switch and pop up checkbox.
	 *
	 * @param stopShowing the stop showing
	 * @param themeDisplay the theme display
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
			
		} catch (Exception e) {
			logger.error("Error changing Show Tips", e);
		}
	}
	
	/**
	 * Sets the user visitance.
	 *
	 * @param themeDisplay the theme display
	 * @param userStatus the user status
	 */
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
					} catch (Exception e) {
						logger.error("Error setting user visitance", e);
					}
			}
		}
	}
	
	/**
	 * Gets the initial articles to display.
	 *
	 * @param request the request
	 * @param categoryIds the category ids
	 * @return the initial articles to display
	 */
	private boolean getInitialArticlesToDisplay(
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
			chooseRandomTip(request, articleIds, StringUtil.split(StringPool.BLANK), 
					Arrays.asList(StringPool.BLANK), StringPool.BLANK);			
		}
		
		if (logger.isDebugEnabled())
			logger.debug("quantity of articles: "+articles.size());
		
		return articles.isEmpty();
	}
	
	/**
	 * Sets the article to display.
	 *
	 * @param request the new article to display
	 */
	private void setArticleToDisplay(RenderRequest request) {
		
		String articleIdsString = ParamUtil.getString(request, WebKeys.ARTICLE_IDS);
		request.setAttribute(
				WebKeys.ARTICLE_IDS, articleIdsString);
		String[] articleIds = StringUtil.split(articleIdsString);
		String articleId = ParamUtil.getString(request, WebKeys.ARTICLE_ID);
		request.setAttribute(WebKeys.ARTICLE_ID, articleId);
		request.setAttribute(WebKeys.SHOW_ARTICLE_TITLE, getShowArticleTitle(PortalUtil.getCompanyId(request)));
		
		if (articleIds.length > 0) {
			
			if (articleIds.length != 1) {
				selectTip(request, articleIds, articleId);
				
			} else {
				request.setAttribute(WebKeys.DISABLE_PREV, true);
				request.setAttribute(WebKeys.DISABLE_NEXT, true);
			}
			
		} else {
			SessionMessages.add(request, ERROR_MESSAGE_NO_TIPS_DISPLAY);
			request.setAttribute(WebKeys.DISABLE_PREV, true);
			request.setAttribute(WebKeys.DISABLE_NEXT, true);
		}
	}
	
	/**
	 * User Status is needed for taking the decision about showing the pop up,
	 * and the checkbox status inside the pop up.
	 *
	 * @param request the request
	 * @param themeDisplay the theme display
	 * @return the user status
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
			
		} catch (Exception e) {
			logger.error("Error retrieving user status", e);
		}
		
		return userStatus;
	}
	
	/**
	 * Select tip.
	 *
	 * @param request the request
	 * @param articleIds the article ids
	 * @param currentArticleId the current article id
	 */
	private void selectTip(RenderRequest request, 
			String[] articleIds, String currentArticleId) {
		
		String attVisited = ParamUtil.getString(request, WebKeys.VISITED);
		
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
			
			if (logger.isDebugEnabled())
				logger.debug("nextArticleId: "+ nextArticleId);
			
			request.setAttribute(WebKeys.NEXT_ARTICLE_ID, nextArticleId);
		}			
			
		if ( (visited.length == 0) || (actualArticlePosition == 0 )) {
			request.setAttribute(WebKeys.DISABLE_PREV, true);
		}
		
		if (actualArticlePosition==-1 ) {
			
			if (visited.length > 0) {
				request.setAttribute(
						WebKeys.VISITED, attVisited + StringPool.COMMA + currentArticleId);
				
			} else {
				request.setAttribute(WebKeys.VISITED, currentArticleId);
			}
			
		} else {
			request.setAttribute(WebKeys.VISITED, attVisited);
		}
	}
	
	/**
	 * Choose previous selected tip.
	 *
	 * @param request the request
	 * @param visited the visited
	 * @param actualArticlePosition the actual article position
	 */
	private void choosePreviousSelectedTip(RenderRequest request, 
			List<String> visited, int actualArticlePosition) {
		
		String prevArticleId = StringPool.BLANK;
		
		if (actualArticlePosition > 0) {
			prevArticleId = visited.get(actualArticlePosition - 1 );
			
		} else if (actualArticlePosition == -1 && visited.size() > 0) {
			prevArticleId = visited.get(visited.size() - 1);
		}
		
		request.setAttribute(WebKeys.PREV_ARTICLE_ID, prevArticleId);
	}
	
	/**
	 * Choose random tip.
	 *
	 * @param request the request
	 * @param articleIds the article ids
	 * @param visited the visited
	 * @param visitedList the visited list
	 * @param actualArticleId the actual article id
	 */
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
		
		if (logger.isDebugEnabled())
			logger.debug("nextRandomArticleId: "+ articleId);
	}
	
	/**
	 * Check tip visited.
	 *
	 * @param visited the visited
	 * @param articleId the article id
	 * @param actualArticleId the actual article id
	 * @return true, if successful
	 */
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
	
	/**
	 * Get "each login" preference.
	 * 
	 * @param themeDisplay
	 * @return the "each login" preference
	 */
	private Boolean getEachLogin(long companyId){
		
		PortletPreferences prefs = getCPPortletPreferences(companyId);
		
		return Boolean.valueOf(prefs != null ? 
			prefs.getValue(WebKeys.TIPS_EACH_LOGIN_CHECKED, 
				WebKeys.TIPS_EACH_LOGIN_DEFAULT) : 
					WebKeys.TIPS_EACH_LOGIN_DEFAULT);
	}
	
	/**
	 * Get "interval days" preference.
	 * 
	 * @param themeDisplay
	 * @return the "interval days" preference
	 */
	private Integer getIntervalDays(long companyId){
		
		PortletPreferences prefs = getCPPortletPreferences(companyId);
		
		return Integer.valueOf(prefs != null ? 
			prefs.getValue(WebKeys.TIPS_INTERVAL_VALUE, 
				WebKeys.TIPS_INTERVAL_DEFAULT) : 
					WebKeys.TIPS_INTERVAL_DEFAULT);
	}
	
	private Boolean getShowArticleTitle(long companyId) {
		PortletPreferences prefs = getCPPortletPreferences(companyId);
		
		return Boolean.valueOf(prefs != null ? 
				prefs.getValue(WebKeys.SHOW_ARTICLE_TITLE, 
					WebKeys.SHOW_ARTICLE_TITLE_DEFAULT) : 
						WebKeys.SHOW_ARTICLE_TITLE_DEFAULT);
	}
	/**
	 * Get portlet preferences of the Control Panel Tips portlet.
	 * 
	 * @param themeDisplay
	 * @return
	 */
	private PortletPreferences getCPPortletPreferences(long companyId){
		long plidCP = 0;
		PortletPreferences prefs = null;
		
		try{
			Group groupTemp = GroupLocalServiceUtil.getGroup(companyId, 
				GroupConstants.CONTROL_PANEL);
			List<Layout> layoutList = LayoutLocalServiceUtil.getLayouts(
				groupTemp.getGroupId(), true, LayoutConstants.TYPE_CONTROL_PANEL);
			
			if(layoutList != null && !layoutList.isEmpty()) {
				plidCP = layoutList.get(0).getPlid(); 
			}		
			
			prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId, 
				PortletKeys.PREFS_OWNER_ID_DEFAULT, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, 
				plidCP, CONTROL_PANEL_TIPS_PORTLET_ID);
			
		} catch(Exception e){
			logger.error("Error getting eachLogin preference", e);
		}
		
		return prefs;	
	}
	
	/** The Constant logger. */
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayDockbarPortlet.class);
}
