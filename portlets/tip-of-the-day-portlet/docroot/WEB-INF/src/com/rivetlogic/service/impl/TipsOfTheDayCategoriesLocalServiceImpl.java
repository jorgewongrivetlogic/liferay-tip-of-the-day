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

package com.rivetlogic.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.rivetlogic.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.model.TipsOfTheDayCategories;
import com.rivetlogic.service.base.TipsOfTheDayCategoriesLocalServiceBaseImpl;

/**
 * The implementation of the Tips of the Day Categories local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.service.TipsOfTheDayCategoriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author juancarrillo
 * @see com.rivetlogic.service.base.TipsOfTheDayCategoriesLocalServiceBaseImpl
 * @see com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil
 */
public class TipsOfTheDayCategoriesLocalServiceImpl
	extends TipsOfTheDayCategoriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil} to access the Tips of the Day Categories local service.
	 */
	
	public long[] getCategories(long groupId) 
			throws NoSuchTipsOfTheDayCategoriesException, SystemException {
		
		TipsOfTheDayCategories categories = 
				tipsOfTheDayCategoriesPersistence.findByPrimaryKey(groupId);
		
		long[] categoryIds = GetterUtil.getLongValues(
				StringUtil.split(categories.getCategories()));
		
		return categoryIds;
	}
}