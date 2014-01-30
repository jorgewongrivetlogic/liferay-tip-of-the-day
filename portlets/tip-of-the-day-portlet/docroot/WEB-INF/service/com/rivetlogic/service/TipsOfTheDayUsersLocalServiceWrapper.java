/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipsOfTheDayUsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersLocalService
 * @generated
 */
public class TipsOfTheDayUsersLocalServiceWrapper
	implements TipsOfTheDayUsersLocalService,
		ServiceWrapper<TipsOfTheDayUsersLocalService> {
	public TipsOfTheDayUsersLocalServiceWrapper(
		TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		_tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	/**
	* Adds the Tips of the Day Users to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers addTipsOfTheDayUsers(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.addTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers createTipsOfTheDayUsers(
		long tipUserId) {
		return _tipsOfTheDayUsersLocalService.createTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Deletes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.deleteTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Deletes the Tips of the Day Users from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.deleteTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipsOfTheDayUsersLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers fetchTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.fetchTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Returns the Tips of the Day Users with the primary key.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers getTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUsers(tipUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @return the range of Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.model.TipsOfTheDayUsers> getTipsOfTheDayUserses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUserses(start, end);
	}

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTipsOfTheDayUsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUsersesCount();
	}

	/**
	* Updates the Tips of the Day Users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers updateTipsOfTheDayUsers(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.updateTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tipsOfTheDayUsersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tipsOfTheDayUsersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tipsOfTheDayUsersLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void setUser(long companyId, long groupId, long userId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tipsOfTheDayUsersLocalService.setUser(companyId, groupId, userId,
			status);
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers getUser(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getUser(companyId, groupId, userId);
	}

	@Override
	public java.lang.String getUserStatus(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsersLocalService.getUserStatus(companyId, groupId,
			userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TipsOfTheDayUsersLocalService getWrappedTipsOfTheDayUsersLocalService() {
		return _tipsOfTheDayUsersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTipsOfTheDayUsersLocalService(
		TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		_tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	@Override
	public TipsOfTheDayUsersLocalService getWrappedService() {
		return _tipsOfTheDayUsersLocalService;
	}

	@Override
	public void setWrappedService(
		TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		_tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	private TipsOfTheDayUsersLocalService _tipsOfTheDayUsersLocalService;
}