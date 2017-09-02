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
 * Provides a wrapper for {@link TipsOfTheDayVisitedLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisitedLocalService
 * @generated
 */
@ProviderType
public class TipsOfTheDayVisitedLocalServiceWrapper
	implements TipsOfTheDayVisitedLocalService,
		ServiceWrapper<TipsOfTheDayVisitedLocalService> {
	public TipsOfTheDayVisitedLocalServiceWrapper(
		TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		_tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipsOfTheDayVisitedLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipsOfTheDayVisitedLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipsOfTheDayVisitedLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayVisitedLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayVisitedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Tips of the Day Visited to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was added
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited addTipsOfTheDayVisited(
		com.rivetlogic.services.model.TipsOfTheDayVisited tipsOfTheDayVisited) {
		return _tipsOfTheDayVisitedLocalService.addTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	/**
	* Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	*
	* @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	* @return the new Tips of the Day Visited
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited createTipsOfTheDayVisited(
		com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return _tipsOfTheDayVisitedLocalService.createTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Deletes the Tips of the Day Visited from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		com.rivetlogic.services.model.TipsOfTheDayVisited tipsOfTheDayVisited) {
		return _tipsOfTheDayVisitedLocalService.deleteTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	/**
	* Deletes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	* @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayVisitedLocalService.deleteTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited fetchTipsOfTheDayVisited(
		com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return _tipsOfTheDayVisitedLocalService.fetchTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Returns the Tips of the Day Visited with the primary key.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited
	* @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited getTipsOfTheDayVisited(
		com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisited(tipsOfTheDayVisitedPK);
	}

	/**
	* Updates the Tips of the Day Visited in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	* @return the Tips of the Day Visited that was updated
	*/
	@Override
	public com.rivetlogic.services.model.TipsOfTheDayVisited updateTipsOfTheDayVisited(
		com.rivetlogic.services.model.TipsOfTheDayVisited tipsOfTheDayVisited) {
		return _tipsOfTheDayVisitedLocalService.updateTipsOfTheDayVisited(tipsOfTheDayVisited);
	}

	/**
	* Returns the number of Tips of the Day Visiteds.
	*
	* @return the number of Tips of the Day Visiteds
	*/
	@Override
	public int getTipsOfTheDayVisitedsCount() {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisitedsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipsOfTheDayVisitedLocalService.getOSGiServiceIdentifier();
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipsOfTheDayVisitedLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @return the range of Tips of the Day Visiteds
	*/
	@Override
	public java.util.List<com.rivetlogic.services.model.TipsOfTheDayVisited> getTipsOfTheDayVisiteds(
		int start, int end) {
		return _tipsOfTheDayVisitedLocalService.getTipsOfTheDayVisiteds(start,
			end);
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
		return _tipsOfTheDayVisitedLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipsOfTheDayVisitedLocalService.dynamicQueryCount(dynamicQuery,
			projection);
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