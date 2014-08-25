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

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.model.TipsOfTheDayCategories;
import com.rivetlogic.model.impl.TipsOfTheDayCategoriesImpl;
import com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil;
import com.rivetlogic.tofd.util.TipOfTheDayUtil;
import com.rivetlogic.tofd.util.WebKeys;

/**
 * The Class TipOfTheDayPortlet.
 *
 * @author juancarrillo
 */
public class TipOfTheDayPortlet extends MVCPortlet {	
	
	/**
	 * Save preferences.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ReadOnlyException 
	 * @throws IOException 
	 * @throws ValidatorException 
	 */
	public void savePreferences(
			ActionRequest request, ActionResponse response) 
							throws ReadOnlyException, ValidatorException, IOException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletPreferences prefs = request.getPreferences();
		
		String categoryIds = 
				ParamUtil.getString(request, WebKeys.ASSET_CATEGORY_IDS);
		long resourcePrimKey = 
				ParamUtil.getLong(request, WebKeys.TIPS_CATEGORIES_ID);
		Integer interval = 
				ParamUtil.getInteger(request, WebKeys.TIPS_INTERVAL_VALUE);
		String oftenRadio = 
				ParamUtil.getString(request, WebKeys.TIPS_OFTEN_RADIO);
		Boolean eachLogin = WebKeys.TIPS_EACH_LOGIN.equals(oftenRadio); 
		Boolean showArticleTitle = ParamUtil.getBoolean(request, WebKeys.SHOW_ARTICLE_TITLE);
				
		prefs.setValue(WebKeys.TIPS_INTERVAL_VALUE, interval.toString());
		prefs.setValue(WebKeys.TIPS_EACH_LOGIN_CHECKED, eachLogin.toString());		
		prefs.setValue(WebKeys.SHOW_ARTICLE_TITLE, showArticleTitle.toString());
		prefs.store();
		
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
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest request,RenderResponse response) 
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletPreferences prefs = request.getPreferences();
		
		try {
			long[] categoryIds = new long[0];
			
			TipOfTheDayUtil.retrieveCategories(
					request, themeDisplay, categoryIds);
			
			request.setAttribute(WebKeys.TIPS_EACH_LOGIN_CHECKED, 
				prefs.getValue(WebKeys.TIPS_EACH_LOGIN_CHECKED, WebKeys.TIPS_EACH_LOGIN_DEFAULT));
			
			request.setAttribute(WebKeys.TIPS_INTERVAL_VALUE, 
				prefs.getValue(WebKeys.TIPS_INTERVAL_VALUE, WebKeys.TIPS_INTERVAL_DEFAULT));
			request.setAttribute(WebKeys.SHOW_ARTICLE_TITLE, prefs.getValue(
					WebKeys.SHOW_ARTICLE_TITLE,
					WebKeys.SHOW_ARTICLE_TITLE_DEFAULT));
			
		} catch (Exception e) {
			logger.error("Error retrieving categories", e);
		}

		super.doView(request, response);
	}
	
	/** The Constant logger. */
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayPortlet.class);
	
}
