package com.rivetlogic.tipday.api.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.services.model.TipsOfTheDayCategories;
import com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalServiceUtil;
import com.rivetlogic.tipday.api.constants.WebKeys;

import javax.portlet.PortletRequest;

public class TipOfTheDayUtil {
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayUtil.class);
	
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
			categoryIds = new long[0];
		}
		
		if (categoryIds.length > 0 ) {
			String selectedCategories = StringUtil.merge(categoryIds);
			
			request.setAttribute(WebKeys.CUR_CATEGORY_IDS, selectedCategories);
			
			if (logger.isDebugEnabled())
				logger.debug("curCategoryIds: " + selectedCategories);
		}
		
		return categoryIds;
	}
}
