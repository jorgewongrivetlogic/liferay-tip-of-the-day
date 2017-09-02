/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.rivetlogic.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipsOfTheDayUsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersLocalService
 * @generated
 */
@ProviderType
public class TipsOfTheDayUsersLocalServiceWrapper
	implements TipsOfTheDayUsersLocalService,
		ServiceWrapper<TipsOfTheDayUsersLocalService> {
	public TipsOfTheDayUsersLocalServiceWrapper(
		TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		_tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipsOfTheDayUsersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipsOfTheDayUsersLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipsOfTheDayUsersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayUsersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Tips of the Day Users to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was added
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers addTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return _tipsOfTheDayUsersLocalService.addTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers createTipsOfTheDayUsers(
		long tipUserId) {
		return _tipsOfTheDayUsersLocalService.createTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Deletes the Tips of the Day Users from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return _tipsOfTheDayUsersLocalService.deleteTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Deletes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayUsersLocalService.deleteTipsOfTheDayUsers(tipUserId);
	}

	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers fetchTipsOfTheDayUsers(
		long tipUserId) {
		return _tipsOfTheDayUsersLocalService.fetchTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Returns the Tips of the Day Users with the primary key.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers getTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Updates the Tips of the Day Users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was updated
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayUsers updateTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return _tipsOfTheDayUsersLocalService.updateTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	*/
	@Override
	public int getTipsOfTheDayUsersesCount() {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUsersesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipsOfTheDayUsersLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tipsOfTheDayUsersLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @return the range of Tips of the Day Userses
	*/
	@Override
	public java.util.List<com.rivetlogic.services.model.TipsOfTheDayUsers> getTipsOfTheDayUserses(
		int start, int end) {
		return _tipsOfTheDayUsersLocalService.getTipsOfTheDayUserses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tipsOfTheDayUsersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _tipsOfTheDayUsersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
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