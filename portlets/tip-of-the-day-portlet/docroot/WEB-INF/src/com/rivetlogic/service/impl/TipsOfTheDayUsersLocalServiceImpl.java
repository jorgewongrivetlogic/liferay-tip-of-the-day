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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.model.TipsOfTheDayUsers;
import com.rivetlogic.service.base.TipsOfTheDayUsersLocalServiceBaseImpl;
import com.rivetlogic.tofd.util.WebKeys;

/**
 * The implementation of the Tips of the Day Users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.service.TipsOfTheDayUsersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author juancarrillo
 * @see com.rivetlogic.service.base.TipsOfTheDayUsersLocalServiceBaseImpl
 * @see com.rivetlogic.service.TipsOfTheDayUsersLocalServiceUtil
 */
public class TipsOfTheDayUsersLocalServiceImpl
	extends TipsOfTheDayUsersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.service.TipsOfTheDayUsersLocalServiceUtil} to access the Tips of the Day Users local service.
	 */
	
	public void setUser(long companyId, long groupId, long userId, String status) 
			throws SystemException, PortalException {

		TipsOfTheDayUsers user = 
				tipsOfTheDayUsersPersistence
					.fetchByC_G_U(companyId, groupId, userId);
		
		if (Validator.isNotNull(user)) {
			user.setStatus(status);
			
		} else {
			user = tipsOfTheDayUsersPersistence.create(
					counterLocalService.increment(
							TipsOfTheDayUsers.class.getName()));
			
			user.setCompanyId(companyId);
			user.setGroupId(groupId);
			user.setUserId(userId);
			user.setStatus(status);
			user.setNew(true);
		}
		
		tipsOfTheDayUsersPersistence.update(user);
	}
	
	public TipsOfTheDayUsers getUser(long companyId, long groupId, long userId) 
			throws SystemException, PortalException {
		
		String status = String.valueOf(WebKeys.STATUS_RECEIVE);
		
		TipsOfTheDayUsers user = 
				tipsOfTheDayUsersPersistence.fetchByC_G_U(
						companyId, groupId, userId);
		
		if (Validator.isNull(user)) {
			user = tipsOfTheDayUsersPersistence.create(
					counterLocalService.increment(
							TipsOfTheDayUsers.class.getName()));
			
			user.setCompanyId(companyId);
			user.setGroupId(groupId);
			user.setUserId(userId);
			user.setStatus(status);
			user.setNew(true);
		}
		
		return user;
	}
	
	public String getUserStatus(long companyId, long groupId, long userId) 
			throws SystemException {
		
		String status = String.valueOf(WebKeys.STATUS_RECEIVE);
		
		TipsOfTheDayUsers user = 
				tipsOfTheDayUsersPersistence.fetchByC_G_U(
						companyId, groupId, userId);
		
		if (Validator.isNotNull(user)) {
			status = user.getStatus();
		}
		
		return status;
	}
	
}