package com.rivetlogic.tipday.panel.portlet;

import com.rivetlogic.tipday.panel.constants.TipDayPanelPortletKeys;
import com.rivetlogic.tipday.api.constants.WebKeys;
import com.rivetlogic.tipday.api.utils.TipOfTheDayUtil;
import com.rivetlogic.services.model.TipsOfTheDayCategories;
import com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesImpl;
import com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalServiceUtil;

import java.io.IOException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Component;



/**
 * @author alejandrosoto
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Tip Of The Day",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TipDayPanelPortletKeys.TipDayPanel,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class TipDayPanelPortlet extends MVCPortlet {
	
	private static final Log logger = LogFactoryUtil.getLog(TipDayPanelPortlet.class);
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request,RenderResponse response) 
			throws IOException, PortletException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = request.getPreferences();
		
		try {
			long[] categoryIds = new long[0];
			TipOfTheDayUtil.retrieveCategories(request, themeDisplay, categoryIds);
			request.setAttribute(WebKeys.TIPS_EACH_LOGIN_CHECKED, preferences.getValue(WebKeys.TIPS_EACH_LOGIN_CHECKED, WebKeys.TIPS_EACH_LOGIN_DEFAULT));
			request.setAttribute(WebKeys.TIPS_INTERVAL_VALUE, preferences.getValue(WebKeys.TIPS_INTERVAL_VALUE, WebKeys.TIPS_INTERVAL_DEFAULT));
			request.setAttribute(WebKeys.SHOW_ARTICLE_TITLE, preferences.getValue(WebKeys.SHOW_ARTICLE_TITLE, WebKeys.SHOW_ARTICLE_TITLE_DEFAULT));
			
		} catch (Exception e) {
//			logger.error("Error retrieving categories", e);
		}

		super.doView(request, response);
	}
	
	/**
	 * TipDay panel form action
	 * Persists control panel preferences
	 * 
	 * @param request
	 * @param response
	 * @throws ReadOnlyException
	 * @throws ValidatorException
	 * @throws IOException
	 */
	public void savePreferences(ActionRequest request, ActionResponse response) throws ReadOnlyException, ValidatorException, IOException {
		logger.debug("Saving form");
		ThemeDisplay themeDisplay =  (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = request.getPreferences();
		
		String categoryIds =  ParamUtil.getString(request, WebKeys.ASSET_CATEGORY_IDS);
		long resourcePrimKey = ParamUtil.getLong(request, WebKeys.TIPS_CATEGORIES_ID);
		Integer interval = ParamUtil.getInteger(request, WebKeys.TIPS_INTERVAL_VALUE);
		String oftenRadio = ParamUtil.getString(request, WebKeys.TIPS_OFTEN_RADIO);
		Boolean eachLogin = WebKeys.TIPS_EACH_LOGIN.equals(oftenRadio); 
		Boolean showArticleTitle = ParamUtil.getBoolean(request, WebKeys.SHOW_ARTICLE_TITLE);
		// persist regular fields
		preferences.setValue(WebKeys.TIPS_INTERVAL_VALUE, interval.toString());
		preferences.setValue(WebKeys.TIPS_EACH_LOGIN_CHECKED, eachLogin.toString());		
		preferences.setValue(WebKeys.SHOW_ARTICLE_TITLE, showArticleTitle.toString());
		preferences.store();
		
		// persist categories
		TipsOfTheDayCategories categories = 
				new TipsOfTheDayCategoriesImpl();
		
		categories.setPrimaryKey(resourcePrimKey);
		categories.setGroupId(themeDisplay.getScopeGroupId());
		categories.setCategories(categoryIds);
		
		try {
			if (Validator.isNotNull(resourcePrimKey)){
				TipsOfTheDayCategoriesLocalServiceUtil
					.updateTipsOfTheDayCategories(categories);
				
			} else {
				TipsOfTheDayCategoriesLocalServiceUtil
					.addTipsOfTheDayCategories(categories);					
			}
			
		} catch (SystemException e) {
			logger.error("Error setting categories", e);
		}
	}

}