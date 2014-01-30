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

package com.rivetlogic.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.model.TipsOfTheDayCategories;

/**
 * The persistence interface for the Tips of the Day Categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesPersistenceImpl
 * @see TipsOfTheDayCategoriesUtil
 * @generated
 */
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
	public void cacheResult(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories);

	/**
	* Caches the Tips of the Day Categorieses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayCategorieses the Tips of the Day Categorieses
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.model.TipsOfTheDayCategories> tipsOfTheDayCategorieses);

	/**
	* Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	*
	* @param groupId the primary key for the new Tips of the Day Categories
	* @return the new Tips of the Day Categories
	*/
	public com.rivetlogic.model.TipsOfTheDayCategories create(long groupId);

	/**
	* Removes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories that was removed
	* @throws com.rivetlogic.NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayCategories remove(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayCategoriesException;

	public com.rivetlogic.model.TipsOfTheDayCategories updateImpl(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Tips of the Day Categories with the primary key or throws a {@link com.rivetlogic.NoSuchTipsOfTheDayCategoriesException} if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories
	* @throws com.rivetlogic.NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayCategories findByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayCategoriesException;

	/**
	* Returns the Tips of the Day Categories with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the Tips of the Day Categories
	* @return the Tips of the Day Categories, or <code>null</code> if a Tips of the Day Categories with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayCategories fetchByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Tips of the Day Categorieses.
	*
	* @return the Tips of the Day Categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayCategories> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.model.TipsOfTheDayCategories> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Tips of the Day Categorieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Categorieses
	* @param end the upper bound of the range of Tips of the Day Categorieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Categorieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayCategories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Tips of the Day Categorieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tips of the Day Categorieses.
	*
	* @return the number of Tips of the Day Categorieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}