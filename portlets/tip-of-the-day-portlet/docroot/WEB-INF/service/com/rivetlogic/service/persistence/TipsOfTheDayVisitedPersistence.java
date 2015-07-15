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

import com.rivetlogic.model.TipsOfTheDayVisited;

/**
 * The persistence interface for the Tips of the Day Visited service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TipsOfTheDayVisitedPersistenceImpl
 * @see TipsOfTheDayVisitedUtil
 * @generated
 */
public interface TipsOfTheDayVisitedPersistence extends BasePersistence<TipsOfTheDayVisited> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipsOfTheDayVisitedUtil} to access the Tips of the Day Visited persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @return the range of matching Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findByC_G_U(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findByC_G_U(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tips of the Day Visited
	* @throws com.rivetlogic.NoSuchTipsOfTheDayVisitedException if a matching Tips of the Day Visited could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited findByC_G_U_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayVisitedException;

	/**
	* Returns the first Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tips of the Day Visited, or <code>null</code> if a matching Tips of the Day Visited could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited fetchByC_G_U_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tips of the Day Visited
	* @throws com.rivetlogic.NoSuchTipsOfTheDayVisitedException if a matching Tips of the Day Visited could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited findByC_G_U_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayVisitedException;

	/**
	* Returns the last Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tips of the Day Visited, or <code>null</code> if a matching Tips of the Day Visited could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited fetchByC_G_U_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Tips of the Day Visiteds before and after the current Tips of the Day Visited in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the current Tips of the Day Visited
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Tips of the Day Visited
	* @throws com.rivetlogic.NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited[] findByC_G_U_PrevAndNext(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK,
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayVisitedException;

	/**
	* Removes all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_U(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_U(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Tips of the Day Visited in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayVisited the Tips of the Day Visited
	*/
	public void cacheResult(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited);

	/**
	* Caches the Tips of the Day Visiteds in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayVisiteds the Tips of the Day Visiteds
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> tipsOfTheDayVisiteds);

	/**
	* Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	*
	* @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	* @return the new Tips of the Day Visited
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited create(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK);

	/**
	* Removes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited that was removed
	* @throws com.rivetlogic.NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited remove(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayVisitedException;

	public com.rivetlogic.model.TipsOfTheDayVisited updateImpl(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Tips of the Day Visited with the primary key or throws a {@link com.rivetlogic.NoSuchTipsOfTheDayVisitedException} if it could not be found.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited
	* @throws com.rivetlogic.NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited findByPrimaryKey(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayVisitedException;

	/**
	* Returns the Tips of the Day Visited with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	* @return the Tips of the Day Visited, or <code>null</code> if a Tips of the Day Visited with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.model.TipsOfTheDayVisited fetchByPrimaryKey(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Tips of the Day Visiteds.
	*
	* @return the Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Tips of the Day Visiteds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Visiteds
	* @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.model.TipsOfTheDayVisited> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Tips of the Day Visiteds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tips of the Day Visiteds.
	*
	* @return the number of Tips of the Day Visiteds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}