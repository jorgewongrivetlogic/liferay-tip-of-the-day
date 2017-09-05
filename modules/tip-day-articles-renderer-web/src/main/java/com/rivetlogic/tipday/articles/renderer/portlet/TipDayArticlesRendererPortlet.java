package com.rivetlogic.tipday.articles.renderer.portlet;

import com.rivetlogic.tipday.articles.renderer.constants.TipDayArticlesRendererPortletKeys;
import com.rivetlogic.services.service.TipsOfTheDayUsersLocalServiceUtil;
import com.rivetlogic.tipday.api.constants.WebKeys;
import com.rivetlogic.tipday.api.utils.TipOfTheDayUtil;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author alejandrosoto
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=tip-day-articles-renderer Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portal-javascript=/o/tipoftheday-web/js/tipday-modal.js",
		"com.liferay.portlet.header-portal-javascript=/o/tipoftheday-web/js/tipday-menu.js",
		"javax.portlet.name=" + TipDayArticlesRendererPortletKeys.TipDayArticlesRenderer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TipDayArticlesRendererPortlet extends MVCPortlet {
	private static final Log logger = 
			LogFactoryUtil.getLog(TipDayArticlesRendererPortlet.class);
	
	private static final String USER_SETTING_UPDATE = "user-settings-update";

	private static final String ATTR_SHOW_TIPS = "showTips";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		renderRequest.setAttribute(WebKeys.SHOW_ALL_TIPS, true); // TODO: fill show all tips based on user data
		
		String mode = ParamUtil.getString(renderRequest, "tipDayPortletMode");
		
		// Render article by id
		if (mode.equals("renderArticle")) {
			this.doArticleRenderProcessing(themeDisplay, renderRequest, mode);
			
		// Render Articles Ids so frontend can cycle around the list and render each by id
		} else {
			long[] categoryIds = TipOfTheDayUtil.getCategoryIds(renderRequest, themeDisplay);
			String[] articleIds = TipOfTheDayUtil.getFilteredArticleIds(renderRequest, categoryIds);
			renderRequest.setAttribute(WebKeys.ARTICLE_IDS, StringUtil.merge(articleIds));
			String userStatus = TipOfTheDayUtil.getUserStatus(PortalUtil.getHttpServletRequest(renderRequest), themeDisplay);
			setPopUpVisibility(renderRequest, themeDisplay, userStatus);
		}
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * This gets called when article view is going to render article
	 * 
	 * @param themeDisplay
	 * @param renderRequest
	 * @param mode
	 */
	private void doArticleRenderProcessing(ThemeDisplay themeDisplay, RenderRequest renderRequest, String mode) {
		String articleId = ParamUtil.getString(renderRequest, "articleId");
		logger.debug("Rendering article " + articleId);
		// saveVisitedTip(request, articleId);
		renderRequest.setAttribute("currentArticleId", articleId);
		renderRequest.setAttribute("tipDayPortletMode", mode);
		if (JournalArticleLocalServiceUtil.hasArticle(themeDisplay.getScopeGroupId(), articleId)) {
			try {
				renderRequest.setAttribute("article", JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleId));
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		logger.debug("REQUESTING SERVE RESOURCE");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(resourceRequest, "action");
		logger.debug("action: " + action);
		
		if (USER_SETTING_UPDATE.equals(action)) {
			
			String changedValueName = ParamUtil.getString(resourceRequest, WebKeys.CHANGED_VALUE);
			boolean value = ParamUtil.getBoolean(resourceRequest, "value");
			logger.debug(changedValueName + ": " + value); 
			if (changedValueName.equals(WebKeys.STOP_SHOWING)) {
				changeShowTips(value, themeDisplay);
			}
			if (changedValueName.equals(WebKeys.SHOW_ALL_TIPS)) {
				changeShowAll(value, themeDisplay);
			}
			
		}
		
		// TODO Auto-generated method stub
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	/**
	 * Action called from the dockbar checkbox to hide tips already seen.
	 * 
	 * @param showOnlyNew
	 * @param themeDisplay
	 */
	private void changeShowAll(boolean showOnlyNew, ThemeDisplay themeDisplay) {
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        long userId = themeDisplay.getUserId();
        
        try {
        	TipsOfTheDayUsersLocalServiceUtil.setUserShowAll(companyId, groupId, userId, showOnlyNew);
        } catch (Exception e) {
            logger.error("Error changing Show Tips", e);
        }
    }
	
	/**
	 * Action called from the dockbar checkbox to stop showing tips at login.
	 *
	 * @param stopShowing the stop showing
	 * @param themeDisplay the theme display
	 */
	private void changeShowTips(boolean stopShowing, ThemeDisplay themeDisplay) {
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		
		try {
			if (stopShowing) {
				TipsOfTheDayUsersLocalServiceUtil.setUserStatus(companyId, groupId, userId, String.valueOf(false));
			} else {
				setUserVisitance(themeDisplay, String.valueOf(WebKeys.STATUS_RECEIVE));
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
	private void setUserVisitance(ThemeDisplay themeDisplay, String userStatus) {
		if (themeDisplay.isSignedIn()) {
			if (!userStatus.equals(String.valueOf(!WebKeys.STATUS_RECEIVE))) {
				Calendar calendar = new GregorianCalendar(themeDisplay.getTimeZone());
				try {
					TipsOfTheDayUsersLocalServiceUtil.setUserStatus(
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
	 * Sets the pop up visibility based on the user's configuration and the number of articles.
	 *
	 * @param request the request
	 * @param themeDisplay the theme display
	 * @param userStatus the user status
	 */
	private void setPopUpVisibility(RenderRequest request, ThemeDisplay themeDisplay, String userStatus) {
		try {
		    long[] categoryIds = TipOfTheDayUtil.getCategoryIds(request, themeDisplay);
			boolean showTips = !Validator.isNull(categoryIds) && TipOfTheDayUtil.checkShowTips(themeDisplay, userStatus);
			logger.debug(userStatus);
			if(showTips) {
			    showTips = TipOfTheDayUtil.getFilteredArticleIds(request, categoryIds).length > 0;
			}			
			logger.debug("GETTING POPUP VISIBILITY/SHOW: " + showTips);
			logger.debug(categoryIds.length);
			request.setAttribute(ATTR_SHOW_TIPS, showTips);
			
		} catch (Exception e) {
			logger.error("Error setting pop up visibility", e);
		}
		
	}
}