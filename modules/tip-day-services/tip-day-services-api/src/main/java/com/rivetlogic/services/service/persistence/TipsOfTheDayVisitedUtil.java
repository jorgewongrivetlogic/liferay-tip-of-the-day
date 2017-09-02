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

import com.rivetlogic.services.model.TipsOfTheDayVisited;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the Tips of the Day Visited service. This utility wraps {@link com.rivetlogic.services.service.persistence.impl.TipsOfTheDayVisitedPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisitedPersistence
 * @see com.rivetlogic.services.service.persistence.impl.TipsOfTheDayVisitedPersistenceImpl
 * @generated
 */
@ProviderType
public class TipsOfTheDayVisitedUtil {
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
	public static void clearCache(TipsOfTheDayVisited tipsOfTheDayVisited) {
		getPersistence().clearCache(tipsOfTheDayVisited);
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
	public static List<TipsOfTheDayVisited> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipsOfTheDayVisited> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipsOfTheDayVisited> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipsOfTheDayVisited update(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		return getPersistence().update(tipsOfTheDayVisited);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipsOfTheDayVisited update(
		TipsOfTheDayVisited tipsOfTheDayVisited, ServiceContext serviceContext) {
		return getPersistence().update(tipsOfTheDayVisited, serviceContext);
	}

	/**
	* Returns all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findByC_G_U(long companyId,
		long groupId, long userId) {
		return getPersistence().findByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns a range of all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @return the range of matching Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findByC_G_U(long companyId,
		long groupId, long userId, int start, int end) {
		return getPersistence()
				   .findByC_G_U(companyId, groupId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findByC_G_U(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return getPersistence()
				   .findByC_G_U(companyId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findByC_G_U(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_G_U(companyId, groupId, userId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tips of the Day Visited
	* @throws NoSuchTipsOfTheDayVisitedException if a matching Tips of the Day Visited could not be found
	*/
	public static TipsOfTheDayVisited findByC_G_U_First(long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException {
		return getPersistence()
				   .findByC_G_U_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the first Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tips of the Day Visited, or <code>null</code> if a matching Tips of the Day Visited could not be found
	*/
	public static TipsOfTheDayVisited fetchByC_G_U_First(long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return getPersistence()
				   .fetchByC_G_U_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tips of the Day Visited
	* @throws NoSuchTipsOfTheDayVisitedException if a matching Tips of the Day Visited could not be found
	*/
	public static TipsOfTheDayVisited findByC_G_U_Last(long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException {
		return getPersistence()
				   .findByC_G_U_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tips of the Day Visited, or <code>null</code> if a matching Tips of the Day Visited could not be found
	*/
	public static TipsOfTheDayVisited fetchByC_G_U_Last(long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return getPersistence()
				   .fetchByC_G_U_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the Tips of the Day Visiteds before and after the current Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the current Tips of the Day Visited
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Tips of the Day Visited
	* @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	*/
	public static TipsOfTheDayVisited[] findByC_G_U_PrevAndNext(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK, long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException {
		return getPersistence()
				   .findByC_G_U_PrevAndNext(tipsOfTheDayVisitedPK, companyId,
			groupId, userId, orderByComparator);
	}

	/**
	* Removes all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	*/
	public static void removeByC_G_U(long companyId, long groupId, long userId) {
		getPersistence().removeByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the number of Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Tips of the Day Visiteds
	*/
	public static int countByC_G_U(long companyId, long groupId, long userId) {
		return getPersistence().countByC_G_U(companyId, groupId, userId);
	}

	/**
	* Caches the Tips of the Day Visited in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	*/
	public static void cacheResult(TipsOfTheDayVisited tipsOfTheDayVisited) {
		getPersistence().cacheResult(tipsOfTheDayVisited);
	}

	/**
	* Caches the Tips of the Day Visiteds in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayVisiteds the Tips of the Day Visiteds
	*/
	public static void cacheResult(
		List<TipsOfTheDayVisited> tipsOfTheDayVisiteds) {
		getPersistence().cacheResult(tipsOfTheDayVisiteds);
	}

	/**
	* Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	*
	* @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	* @return the new Tips of the Day Visited
	*/
	public static TipsOfTheDayVisited create(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return getPersistence().create(tipsOfTheDayVisitedPK);
	}

	/**
	* Removes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	* @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	*/
	public static TipsOfTheDayVisited remove(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException {
		return getPersistence().remove(tipsOfTheDayVisitedPK);
	}

	public static TipsOfTheDayVisited updateImpl(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		return getPersistence().updateImpl(tipsOfTheDayVisited);
	}

	/**
	* Returns the Tips of the Day Visited with the primary key or throws a {@link NoSuchTipsOfTheDayVisitedException} if it could not be found.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited
	* @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	*/
	public static TipsOfTheDayVisited findByPrimaryKey(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException {
		return getPersistence().findByPrimaryKey(tipsOfTheDayVisitedPK);
	}

	/**
	* Returns the Tips of the Day Visited with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited, or <code>null</code> if a Tips of the Day Visited with the primary key could not be found
	*/
	public static TipsOfTheDayVisited fetchByPrimaryKey(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return getPersistence().fetchByPrimaryKey(tipsOfTheDayVisitedPK);
	}

	public static java.util.Map<java.io.Serializable, TipsOfTheDayVisited> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the Tips of the Day Visiteds.
	*
	* @return the Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @return the range of Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of Tips of the Day Visiteds
	*/
	public static List<TipsOfTheDayVisited> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the Tips of the Day Visiteds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Tips of the Day Visiteds.
	*
	* @return the number of Tips of the Day Visiteds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipsOfTheDayVisitedPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipsOfTheDayVisitedPersistence, TipsOfTheDayVisitedPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipsOfTheDayVisitedPersistence.class);
}