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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TipsOfTheDayCategories. This utility wraps
 * {@link com.rivetlogic.services.service.impl.TipsOfTheDayCategoriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesLocalService
 * @see com.rivetlogic.services.service.base.TipsOfTheDayCategoriesLocalServiceBaseImpl
 * @see com.rivetlogic.services.service.impl.TipsOfTheDayCategoriesLocalServiceImpl
 * @generated
 */
@ProviderType
public class TipsOfTheDayCategoriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.services.service.impl.TipsOfTheDayCategoriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the Tips of the Day Categories to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was added
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories addTipsOfTheDayCategories(
		com.rivetlogic.services.model.TipsOfTheDayCategories tipsOfTheDayCategories) {
		return getService().addTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	/**
	* Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	*
	* @param groupId the primary key for the new Tips of the Day Categories
	* @return the new Tips of the Day Categories
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories createTipsOfTheDayCategories(
		long groupId) {
		return getService().createTipsOfTheDayCategories(groupId);
	}

	/**
	* Deletes the Tips of the Day Categories from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories deleteTipsOfTheDayCategories(
		com.rivetlogic.services.model.TipsOfTheDayCategories tipsOfTheDayCategories) {
		return getService().deleteTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	/**
	* Deletes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws PortalException if a Tips of the Day Categories with the primary key could not be found
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories deleteTipsOfTheDayCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTipsOfTheDayCategories(groupId);
	}

	public static com.rivetlogic.services.model.TipsOfTheDayCategories fetchTipsOfTheDayCategories(
		long groupId) {
		return getService().fetchTipsOfTheDayCategories(groupId);
	}

	/**
	* Returns the Tips of the Day Categories with the primary key.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories
	* @throws PortalException if a Tips of the Day Categories with the primary key could not be found
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories getTipsOfTheDayCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTipsOfTheDayCategories(groupId);
	}

	/**
	* Updates the Tips of the Day Categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	* @return the Tips of the Day Categories that was updated
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayCategories updateTipsOfTheDayCategories(
		com.rivetlogic.services.model.TipsOfTheDayCategories tipsOfTheDayCategories) {
		return getService().updateTipsOfTheDayCategories(tipsOfTheDayCategories);
	}

	/**
	* Returns the number of Tips of the Day Categorieses.
	*
	* @return the number of Tips of the Day Categorieses
	*/
	public static int getTipsOfTheDayCategoriesesCount() {
		return getService().getTipsOfTheDayCategoriesesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @return the range of Tips of the Day Categorieses
	*/
	public static java.util.List<com.rivetlogic.services.model.TipsOfTheDayCategories> getTipsOfTheDayCategorieses(
		int start, int end) {
		return getService().getTipsOfTheDayCategorieses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TipsOfTheDayCategoriesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipsOfTheDayCategoriesLocalService, TipsOfTheDayCategoriesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TipsOfTheDayCategoriesLocalService.class);
}