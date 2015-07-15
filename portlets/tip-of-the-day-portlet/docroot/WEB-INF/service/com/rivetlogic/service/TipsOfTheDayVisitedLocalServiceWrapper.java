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
 * Provides a wrapper for {@link TipsOfTheDayVisitedLocalService}.
 *
 * @author juancarrillo
 * @see TipsOfTheDayVisitedLocalService
 * @generated
 */
public class TipsOfTheDayVisitedLocalServiceWrapper
	implements TipsOfTheDayVisitedLocalService,
		ServiceWrapper<TipsOfTheDayVisitedLocalService> {
	public TipsOfTheDayVisitedLocalServiceWrapper(
		TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		_tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	/**
	* Adds the Tips of the Day Visited to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited addTipsOfTheDayVisited(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.addTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	/**
	* Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	*
	* @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	* @return the new Tips of the Day Visited
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited createTipsOfTheDayVisited(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return _tipsOfTheDayVisitedLocalService.createTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Deletes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	* @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.deleteTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Deletes the Tips of the Day Visited from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.deleteTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipsOfTheDayVisitedLocalService.dynamicQuery();
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tipsOfTheDayVisitedLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipsOfTheDayVisitedLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited fetchTipsOfTheDayVisited(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.fetchTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Returns the Tips of the Day Visited with the primary key.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited
	* @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited getTipsOfTheDayVisited(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @return the range of Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> getTipsOfTheDayVisiteds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisiteds(start,
			end);
	}

	/**
	* Returns the number of Tips of the Day Visiteds.
	*
	* @return the number of Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTipsOfTheDayVisitedsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisitedsCount();
	}

	/**
	* Updates the Tips of the Day Visited in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited updateTipsOfTheDayVisited(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.updateTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tipsOfTheDayVisitedLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tipsOfTheDayVisitedLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tipsOfTheDayVisitedLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void addVisitedTip(long companyId, long groupId, long userId,
		java.lang.String tipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipsOfTheDayVisitedLocalService.addVisitedTip(companyId, groupId,
			userId, tipId);
	}

	@Override
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> getVisitedTips(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getVisitedTips(companyId,
			groupId, userId);
	}

	@Override
	public java.util.List<java.lang.String> getVisitedTipsIds(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisitedLocalService.getVisitedTipsIds(companyId,
			groupId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TipsOfTheDayVisitedLocalService getWrappedTipsOfTheDayVisitedLocalService() {
		return _tipsOfTheDayVisitedLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTipsOfTheDayVisitedLocalService(
		TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		_tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	@Override
	public TipsOfTheDayVisitedLocalService getWrappedService() {
		return _tipsOfTheDayVisitedLocalService;
	}

	@Override
	public void setWrappedService(
		TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		_tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	private TipsOfTheDayVisitedLocalService _tipsOfTheDayVisitedLocalService;
}