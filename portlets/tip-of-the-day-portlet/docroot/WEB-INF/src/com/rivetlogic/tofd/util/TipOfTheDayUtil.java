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

package com.rivetlogic.tofd.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.rivetlogic.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.model.TipsOfTheDayCategories;
import com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil;

import javax.portlet.PortletRequest;

public class TipOfTheDayUtil {
	
	/**
	 * Get selected categories in control panel
	 */
	public static long[] retrieveCategories(PortletRequest request, 
			ThemeDisplay themeDisplay, long[] categoryIds) 
		throws PortalException, SystemException {
		
		try {
			TipsOfTheDayCategories tipsCategories = 
					TipsOfTheDayCategoriesLocalServiceUtil
						.getTipsOfTheDayCategories(
								themeDisplay.getScopeGroupId());
			
			if (Validator.isNotNull(tipsCategories)) {
				categoryIds = GetterUtil.getLongValues(
						StringUtil.split(tipsCategories.getCategories()));
				
				request.setAttribute(WebKeys.TIPS_CATEGORIES_ID, 
						tipsCategories.getPrimaryKey());
			}
		} catch (NoSuchTipsOfTheDayCategoriesException e) {
			categoryIds = null;
		}
		
		if (categoryIds != null ) {
			String selectedCategories = StringUtil.merge(categoryIds);
			
			request.setAttribute(WebKeys.CUR_CATEGORY_IDS, selectedCategories);
			
			logger.debug("curCategoryIds: " + selectedCategories);
		}
		
		return categoryIds;
	}
	
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayUtil.class);

}
