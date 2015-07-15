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
import com.liferay.portal.util.PortalUtil;
import com.rivetlogic.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.model.TipsOfTheDayCategories;
import com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil;
import com.rivetlogic.service.TipsOfTheDayVisitedLocalServiceUtil;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletRequest;

/**
 * The Class TipOfTheDayUtil.
 */
public class TipOfTheDayUtil {
	
	/**
	 * Get selected categories in control panel.
	 *
	 * @param request the request
	 * @param themeDisplay the theme display
	 * @param categoryIds the category ids
	 * @return the long[]
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
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
			
			if (logger.isDebugEnabled())
				logger.debug("curCategoryIds: " + selectedCategories);
		}
		
		return categoryIds;
	}
	
	/**
	 * Get the tips already seen by the user.
	 * 
	 * @param themeDisplay
	 * @return list of ids already seen by the user
	 * @throws SystemException
	 */
	public static List<String> getVisitedTips(ThemeDisplay themeDisplay) throws SystemException {
	    List<String> ids = new LinkedList<String>();
	    ids = TipsOfTheDayVisitedLocalServiceUtil.getVisitedTipsIds(
	            themeDisplay.getCompanyId(),
	            themeDisplay.getScopeGroupId(),
	            themeDisplay.getUserId());
	    return ids;
	}
	
	/**
	 * Stores the id of a tip been visited by the user.
	 * 
	 * @param request
	 * @param tipId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void saveVisitedTip(PortletRequest request, String tipId) throws PortalException, SystemException {
	    long companyId = PortalUtil.getCompanyId(request);
	    long groupId = PortalUtil.getScopeGroupId(request);
	    long userId = PortalUtil.getUserId(request);
	    TipsOfTheDayVisitedLocalServiceUtil.addVisitedTip(companyId, groupId, userId, tipId);
	}
	
	/** The Constant logger. */
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayUtil.class);

}
