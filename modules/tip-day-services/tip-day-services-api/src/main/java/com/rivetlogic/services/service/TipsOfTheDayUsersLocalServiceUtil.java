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
 * Provides the local service utility for TipsOfTheDayUsers. This utility wraps
 * {@link com.rivetlogic.services.service.impl.TipsOfTheDayUsersLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersLocalService
 * @see com.rivetlogic.services.service.base.TipsOfTheDayUsersLocalServiceBaseImpl
 * @see com.rivetlogic.services.service.impl.TipsOfTheDayUsersLocalServiceImpl
 * @generated
 */
@ProviderType
public class TipsOfTheDayUsersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.services.service.impl.TipsOfTheDayUsersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean getUserShowAll(long companyId, long groupId,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserShowAll(companyId, groupId, userId);
	}

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
	* Adds the Tips of the Day Users to the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was added
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers addTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return getService().addTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers createTipsOfTheDayUsers(
		long tipUserId) {
		return getService().createTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Deletes the Tips of the Day Users from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return getService().deleteTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Deletes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers deleteTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTipsOfTheDayUsers(tipUserId);
	}

	public static com.rivetlogic.services.model.TipsOfTheDayUsers fetchTipsOfTheDayUsers(
		long tipUserId) {
		return getService().fetchTipsOfTheDayUsers(tipUserId);
	}

	/**
	* Returns the Tips of the Day Users with the primary key.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws PortalException if a Tips of the Day Users with the primary key could not be found
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers getTipsOfTheDayUsers(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTipsOfTheDayUsers(tipUserId);
	}

	public static com.rivetlogic.services.model.TipsOfTheDayUsers getUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUser(companyId, groupId, userId);
	}

	/**
	* Updates the Tips of the Day Users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	* @return the Tips of the Day Users that was updated
	*/
	public static com.rivetlogic.services.model.TipsOfTheDayUsers updateTipsOfTheDayUsers(
		com.rivetlogic.services.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return getService().updateTipsOfTheDayUsers(tipsOfTheDayUsers);
	}

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	*/
	public static int getTipsOfTheDayUsersesCount() {
		return getService().getTipsOfTheDayUsersesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String getUserStatus(long companyId, long groupId,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserStatus(companyId, groupId, userId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<com.rivetlogic.services.model.TipsOfTheDayUsers> getTipsOfTheDayUserses(
		int start, int end) {
		return getService().getTipsOfTheDayUserses(start, end);
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

	public static void setUserShowAll(long companyId, long groupId,
		long userId, java.lang.Boolean showAll)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().setUserShowAll(companyId, groupId, userId, showAll);
	}

	public static void setUserStatus(long companyId, long groupId, long userId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().setUserStatus(companyId, groupId, userId, status);
	}

	public static TipsOfTheDayUsersLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipsOfTheDayUsersLocalService, TipsOfTheDayUsersLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TipsOfTheDayUsersLocalService.class);
}