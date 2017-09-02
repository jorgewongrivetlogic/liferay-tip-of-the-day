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

package com.rivetlogic.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rivetlogic.services.model.TipsOfTheDayUsers;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the Tips of the Day Users service. This utility wraps {@link com.rivetlogic.services.service.persistence.impl.TipsOfTheDayUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersPersistence
 * @see com.rivetlogic.services.service.persistence.impl.TipsOfTheDayUsersPersistenceImpl
 * @generated
 */
@ProviderType
public class TipsOfTheDayUsersUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TipsOfTheDayUsers tipsOfTheDayUsers) {
		getPersistence().clearCache(tipsOfTheDayUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipsOfTheDayUsers> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipsOfTheDayUsers update(TipsOfTheDayUsers tipsOfTheDayUsers) {
		return getPersistence().update(tipsOfTheDayUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipsOfTheDayUsers update(
		TipsOfTheDayUsers tipsOfTheDayUsers, ServiceContext serviceContext) {
		return getPersistence().update(tipsOfTheDayUsers, serviceContext);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users
	* @throws NoSuchTipsOfTheDayUsersException if a matching Tips of the Day Users could not be found
	*/
	public static TipsOfTheDayUsers findByC_G_U(long companyId, long groupId,
		long userId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayUsersException {
		return getPersistence().findByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	*/
	public static TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId) {
		return getPersistence().fetchByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	*/
	public static TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_G_U(companyId, groupId, userId, retrieveFromCache);
	}

	/**
	* Removes the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the Tips of the Day Users that was removed
	*/
	public static TipsOfTheDayUsers removeByC_G_U(long companyId, long groupId,
		long userId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayUsersException {
		return getPersistence().removeByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the number of Tips of the Day Userses where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Tips of the Day Userses
	*/
	public static int countByC_G_U(long companyId, long groupId, long userId) {
		return getPersistence().countByC_G_U(companyId, groupId, userId);
	}

	/**
	* Caches the Tips of the Day Users in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	*/
	public static void cacheResult(TipsOfTheDayUsers tipsOfTheDayUsers) {
		getPersistence().cacheResult(tipsOfTheDayUsers);
	}

	/**
	* Caches the Tips of the Day Userses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUserses the Tips of the Day Userses
	*/
	public static void cacheResult(List<TipsOfTheDayUsers> tipsOfTheDayUserses) {
		getPersistence().cacheResult(tipsOfTheDayUserses);
	}

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	public static TipsOfTheDayUsers create(long tipUserId) {
		return getPersistence().create(tipUserId);
	}

	/**
	* Removes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	*/
	public static TipsOfTheDayUsers remove(long tipUserId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayUsersException {
		return getPersistence().remove(tipUserId);
	}

	public static TipsOfTheDayUsers updateImpl(
		TipsOfTheDayUsers tipsOfTheDayUsers) {
		return getPersistence().updateImpl(tipsOfTheDayUsers);
	}

	/**
	* Returns the Tips of the Day Users with the primary key or throws a {@link NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	*/
	public static TipsOfTheDayUsers findByPrimaryKey(long tipUserId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayUsersException {
		return getPersistence().findByPrimaryKey(tipUserId);
	}

	/**
	* Returns the Tips of the Day Users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users, or <code>null</code> if a Tips of the Day Users with the primary key could not be found
	*/
	public static TipsOfTheDayUsers fetchByPrimaryKey(long tipUserId) {
		return getPersistence().fetchByPrimaryKey(tipUserId);
	}

	public static java.util.Map<java.io.Serializable, TipsOfTheDayUsers> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the Tips of the Day Userses.
	*
	* @return the Tips of the Day Userses
	*/
	public static List<TipsOfTheDayUsers> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @return the range of Tips of the Day Userses
	*/
	public static List<TipsOfTheDayUsers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Userses
	*/
	public static List<TipsOfTheDayUsers> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayUsers> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of Tips of the Day Userses
	*/
	public static List<TipsOfTheDayUsers> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayUsers> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the Tips of the Day Userses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipsOfTheDayUsersPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipsOfTheDayUsersPersistence, TipsOfTheDayUsersPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipsOfTheDayUsersPersistence.class);
}