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

import com.rivetlogic.services.exception.NoSuchTipsOfTheDayUsersException;
import com.rivetlogic.services.model.TipsOfTheDayUsers;

/**
 * The persistence interface for the Tips of the Day Users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.services.service.persistence.impl.TipsOfTheDayUsersPersistenceImpl
 * @see TipsOfTheDayUsersUtil
 * @generated
 */
@ProviderType
public interface TipsOfTheDayUsersPersistence extends BasePersistence<TipsOfTheDayUsers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipsOfTheDayUsersUtil} to access the Tips of the Day Users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users
	* @throws NoSuchTipsOfTheDayUsersException if a matching Tips of the Day Users could not be found
	*/
	public TipsOfTheDayUsers findByC_G_U(long companyId, long groupId,
		long userId) throws NoSuchTipsOfTheDayUsersException;

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	*/
	public TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId);

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	*/
	public TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId, boolean retrieveFromCache);

	/**
	* Removes the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the Tips of the Day Users that was removed
	*/
	public TipsOfTheDayUsers removeByC_G_U(long companyId, long groupId,
		long userId) throws NoSuchTipsOfTheDayUsersException;

	/**
	* Returns the number of Tips of the Day Userses where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Tips of the Day Userses
	*/
	public int countByC_G_U(long companyId, long groupId, long userId);

	/**
	* Caches the Tips of the Day Users in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	*/
	public void cacheResult(TipsOfTheDayUsers tipsOfTheDayUsers);

	/**
	* Caches the Tips of the Day Userses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUserses the Tips of the Day Userses
	*/
	public void cacheResult(
		java.util.List<TipsOfTheDayUsers> tipsOfTheDayUserses);

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	public TipsOfTheDayUsers create(long tipUserId);

	/**
	* Removes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	*/
	public TipsOfTheDayUsers remove(long tipUserId)
		throws NoSuchTipsOfTheDayUsersException;

	public TipsOfTheDayUsers updateImpl(TipsOfTheDayUsers tipsOfTheDayUsers);

	/**
	* Returns the Tips of the Day Users with the primary key or throws a {@link NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	*/
	public TipsOfTheDayUsers findByPrimaryKey(long tipUserId)
		throws NoSuchTipsOfTheDayUsersException;

	/**
	* Returns the Tips of the Day Users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users, or <code>null</code> if a Tips of the Day Users with the primary key could not be found
	*/
	public TipsOfTheDayUsers fetchByPrimaryKey(long tipUserId);

	@Override
	public java.util.Map<java.io.Serializable, TipsOfTheDayUsers> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the Tips of the Day Userses.
	*
	* @return the Tips of the Day Userses
	*/
	public java.util.List<TipsOfTheDayUsers> findAll();

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
	public java.util.List<TipsOfTheDayUsers> findAll(int start, int end);

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
	public java.util.List<TipsOfTheDayUsers> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipsOfTheDayUsers> orderByComparator);

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
	public java.util.List<TipsOfTheDayUsers> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipsOfTheDayUsers> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the Tips of the Day Userses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	*/
	public int countAll();
}