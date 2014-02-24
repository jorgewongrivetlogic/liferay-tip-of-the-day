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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.model.TipsOfTheDayCategories;
import com.rivetlogic.model.impl.TipsOfTheDayCategoriesImpl;
import com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil;
import com.rivetlogic.tofd.util.TipOfTheDayUtil;
import com.rivetlogic.tofd.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * 
 * @author juancarrillo
 *
 */
public class TipOfTheDayPortlet extends MVCPortlet {

	public void savePreferences(
			ActionRequest request, ActionResponse response) {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String categoryIds = 
				ParamUtil.getString(request, "assetCategoryIds");
		long resourcePrimKey = 
				ParamUtil.getLong(request, "tipsCategoriesId");
		
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
	
	@Override
	public void doView(RenderRequest request,RenderResponse response) 
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = 
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long[] categoryIds = new long[0];
			
			TipOfTheDayUtil.retrieveCategories(
					request, themeDisplay, categoryIds);
			
		} catch (SystemException e) {
			logger.error("Error retrieving categories", e);
		} catch (PortalException e) {
			logger.error("Error retrieving categories", e);
		}

		super.doView(request, response);
	}
	
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayPortlet.class);
	
}
