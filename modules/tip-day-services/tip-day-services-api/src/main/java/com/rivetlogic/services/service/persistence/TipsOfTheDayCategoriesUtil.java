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

import com.rivetlogic.services.model.TipsOfTheDayCategories;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the Tips of the Day Categories service. This utility wraps {@link com.rivetlogic.services.service.persistence.impl.TipsOfTheDayCategoriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesPersistence
 * @see com.rivetlogic.services.service.persistence.impl.TipsOfTheDayCategoriesPersistenceImpl
 * @generated
 */
@ProviderType
public class TipsOfTheDayCategoriesUtil {
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
	public static void clearCache(TipsOfTheDayCategories tipsOfTheDayCategories) {
		getPersistence().clearCache(tipsOfTheDayCategories);
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
	public static List<TipsOfTheDayCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipsOfTheDayCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipsOfTheDayCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipsOfTheDayCategories> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipsOfTheDayCategories update(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		return getPersistence().update(tipsOfTheDayCategories);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipsOfTheDayCategories update(
		TipsOfTheDayCategories tipsOfTheDayCategories,
		ServiceContext serviceContext) {
		return getPersistence().update(tipsOfTheDayCategories, serviceContext);
	}

	/**
	* Caches the Tips of the Day Categories in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	*/
	public static void cacheResult(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		getPersistence().cacheResult(tipsOfTheDayCategories);
	}

	/**
	* Caches the Tips of the Day Categorieses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayCategorieses the Tips of the Day Categorieses
	*/
	public static void cacheResult(
		List<TipsOfTheDayCategories> tipsOfTheDayCategorieses) {
		getPersistence().cacheResult(tipsOfTheDayCategorieses);
	}

	/**
	* Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	*
	* @param groupId the primary key for the new Tips of the Day Categories
	* @return the new Tips of the Day Categories
	*/
	public static TipsOfTheDayCategories create(long groupId) {
		return getPersistence().create(groupId);
	}

	/**
	* Removes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	*/
	public static TipsOfTheDayCategories remove(long groupId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException {
		return getPersistence().remove(groupId);
	}

	public static TipsOfTheDayCategories updateImpl(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		return getPersistence().updateImpl(tipsOfTheDayCategories);
	}

	/**
	* Returns the Tips of the Day Categories with the primary key or throws a {@link NoSuchTipsOfTheDayCategoriesException} if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories
	* @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	*/
	public static TipsOfTheDayCategories findByPrimaryKey(long groupId)
		throws com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException {
		return getPersistence().findByPrimaryKey(groupId);
	}

	/**
	* Returns the Tips of the Day Categories with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories, or <code>null</code> if a Tips of the Day Categories with the primary key could not be found
	*/
	public static TipsOfTheDayCategories fetchByPrimaryKey(long groupId) {
		return getPersistence().fetchByPrimaryKey(groupId);
	}

	public static java.util.Map<java.io.Serializable, TipsOfTheDayCategories> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the Tips of the Day Categorieses.
	*
	* @return the Tips of the Day Categorieses
	*/
	public static List<TipsOfTheDayCategories> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @return the range of Tips of the Day Categorieses
	*/
	public static List<TipsOfTheDayCategories> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Categorieses
	*/
	public static List<TipsOfTheDayCategories> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayCategories> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of Tips of the Day Categorieses
	*/
	public static List<TipsOfTheDayCategories> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayCategories> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the Tips of the Day Categorieses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Tips of the Day Categorieses.
	*
	* @return the number of Tips of the Day Categorieses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipsOfTheDayCategoriesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipsOfTheDayCategoriesPersistence, TipsOfTheDayCategoriesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipsOfTheDayCategoriesPersistence.class);
}