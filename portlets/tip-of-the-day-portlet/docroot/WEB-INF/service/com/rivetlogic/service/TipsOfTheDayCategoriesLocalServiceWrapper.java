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
 * Provides a wrapper for {@link TipsOfTheDayCategoriesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesLocalService
 * @generated
 */
public class TipsOfTheDayCategoriesLocalServiceWrapper
	implements TipsOfTheDayCategoriesLocalService,
		ServiceWrapper<TipsOfTheDayCategoriesLocalService> {
	public TipsOfTheDayCategoriesLocalServiceWrapper(
		TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		_tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
	}

	/**
	* Adds the Tips of the Day Categories to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories addTipsOfTheDayCategories(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.addTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	/**
	* Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	*
	* @param groupId the primary key for the new Tips of the Day Categories
	* @return the new Tips of the Day Categories
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories createTipsOfTheDayCategories(
		long groupId) {
		return _tipsOfTheDayCategoriesLocalService.createTipsOfTheDayCategories(groupId);
	}

	/**
	* Deletes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws PortalException if a Tips of the Day Categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories deleteTipsOfTheDayCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.deleteTipsOfTheDayCategories(groupId);
	}

	/**
	* Deletes the Tips of the Day Categories from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories deleteTipsOfTheDayCategories(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.deleteTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipsOfTheDayCategoriesLocalService.dynamicQuery();
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
		return _tipsOfTheDayCategoriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayCategoriesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayCategoriesLocalService.dynamicQuery(dynamicQuery,
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
		return _tipsOfTheDayCategoriesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipsOfTheDayCategoriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories fetchTipsOfTheDayCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.fetchTipsOfTheDayCategories(groupId);
	}

	/**
	* Returns the Tips of the Day Categories with the primary key.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories
	* @throws PortalException if a Tips of the Day Categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories getTipsOfTheDayCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.getTipsOfTheDayCategories(groupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @return the range of Tips of the Day Categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.model.TipsOfTheDayCategories> getTipsOfTheDayCategorieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.getTipsOfTheDayCategorieses(start,
			end);
	}

	/**
	* Returns the number of Tips of the Day Categorieses.
	*
	* @return the number of Tips of the Day Categorieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTipsOfTheDayCategoriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.getTipsOfTheDayCategoriesesCount();
	}

	/**
	* Updates the Tips of the Day Categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories updateTipsOfTheDayCategories(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayCategoriesLocalService.updateTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tipsOfTheDayCategoriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tipsOfTheDayCategoriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tipsOfTheDayCategoriesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public long[] getCategories(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayCategoriesException {
		return _tipsOfTheDayCategoriesLocalService.getCategories(groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TipsOfTheDayCategoriesLocalService getWrappedTipsOfTheDayCategoriesLocalService() {
		return _tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTipsOfTheDayCategoriesLocalService(
		TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		_tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
	}

	@Override
	public TipsOfTheDayCategoriesLocalService getWrappedService() {
		return _tipsOfTheDayCategoriesLocalService;
	}

	@Override
	public void setWrappedService(
		TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		_tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
	}

	private TipsOfTheDayCategoriesLocalService _tipsOfTheDayCategoriesLocalService;
}