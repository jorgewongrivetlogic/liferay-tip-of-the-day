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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.services.model.TipsOfTheDayCategories;

/**
 * The persistence interface for the Tips of the Day Categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.services.service.persistence.impl.TipsOfTheDayCategoriesPersistenceImpl
 * @see TipsOfTheDayCategoriesUtil
 * @generated
 */
@ProviderType
public interface TipsOfTheDayCategoriesPersistence extends BasePersistence<TipsOfTheDayCategories> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipsOfTheDayCategoriesUtil} to access the Tips of the Day Categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Tips of the Day Categories in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayCategories the Tips of the Day Categories
	*/
	public void cacheResult(TipsOfTheDayCategories tipsOfTheDayCategories);

	/**
	* Caches the Tips of the Day Categorieses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayCategorieses the Tips of the Day Categorieses
	*/
	public void cacheResult(
		java.util.List<TipsOfTheDayCategories> tipsOfTheDayCategorieses);

	/**
	* Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	*
	* @param groupId the primary key for the new Tips of the Day Categories
	* @return the new Tips of the Day Categories
	*/
	public TipsOfTheDayCategories create(long groupId);

	/**
	* Removes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	*/
	public TipsOfTheDayCategories remove(long groupId)
		throws NoSuchTipsOfTheDayCategoriesException;

	public TipsOfTheDayCategories updateImpl(
		TipsOfTheDayCategories tipsOfTheDayCategories);

	/**
	* Returns the Tips of the Day Categories with the primary key or throws a {@link NoSuchTipsOfTheDayCategoriesException} if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories
	* @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	*/
	public TipsOfTheDayCategories findByPrimaryKey(long groupId)
		throws NoSuchTipsOfTheDayCategoriesException;

	/**
	* Returns the Tips of the Day Categories with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories, or <code>null</code> if a Tips of the Day Categories with the primary key could not be found
	*/
	public TipsOfTheDayCategories fetchByPrimaryKey(long groupId);

	@Override
	public java.util.Map<java.io.Serializable, TipsOfTheDayCategories> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the Tips of the Day Categorieses.
	*
	* @return the Tips of the Day Categorieses
	*/
	public java.util.List<TipsOfTheDayCategories> findAll();

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
	public java.util.List<TipsOfTheDayCategories> findAll(int start, int end);

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
	public java.util.List<TipsOfTheDayCategories> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipsOfTheDayCategories> orderByComparator);

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
	public java.util.List<TipsOfTheDayCategories> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipsOfTheDayCategories> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the Tips of the Day Categorieses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of Tips of the Day Categorieses.
	*
	* @return the number of Tips of the Day Categorieses
	*/
	public int countAll();
}