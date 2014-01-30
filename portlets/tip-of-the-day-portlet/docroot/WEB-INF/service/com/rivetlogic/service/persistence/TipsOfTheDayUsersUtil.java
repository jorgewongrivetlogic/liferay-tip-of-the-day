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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.model.TipsOfTheDayUsers;

import java.util.List;

/**
 * The persistence utility for the Tips of the Day Users service. This utility wraps {@link TipsOfTheDayUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersPersistence
 * @see TipsOfTheDayUsersPersistenceImpl
 * @generated
 */
public class TipsOfTheDayUsersUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TipsOfTheDayUsers tipsOfTheDayUsers) {
		getPersistence().clearCache(tipsOfTheDayUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipsOfTheDayUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TipsOfTheDayUsers update(TipsOfTheDayUsers tipsOfTheDayUsers)
		throws SystemException {
		return getPersistence().update(tipsOfTheDayUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TipsOfTheDayUsers update(
		TipsOfTheDayUsers tipsOfTheDayUsers, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tipsOfTheDayUsers, serviceContext);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link com.rivetlogic.NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users
	* @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a matching Tips of the Day Users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers findByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayUsersException {
		return getPersistence().findByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers fetchByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the Tips of the Day Users where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Tips of the Day Users, or <code>null</code> if a matching Tips of the Day Users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers fetchByC_G_U(
		long companyId, long groupId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers removeByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayUsersException {
		return getPersistence().removeByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the number of Tips of the Day Userses where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_U(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_U(companyId, groupId, userId);
	}

	/**
	* Caches the Tips of the Day Users in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUsers the Tips of the Day Users
	*/
	public static void cacheResult(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		getPersistence().cacheResult(tipsOfTheDayUsers);
	}

	/**
	* Caches the Tips of the Day Userses in the entity cache if it is enabled.
	*
	* @param tipsOfTheDayUserses the Tips of the Day Userses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.model.TipsOfTheDayUsers> tipsOfTheDayUserses) {
		getPersistence().cacheResult(tipsOfTheDayUserses);
	}

	/**
	* Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	*
	* @param tipUserId the primary key for the new Tips of the Day Users
	* @return the new Tips of the Day Users
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers create(long tipUserId) {
		return getPersistence().create(tipUserId);
	}

	/**
	* Removes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users that was removed
	* @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers remove(long tipUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayUsersException {
		return getPersistence().remove(tipUserId);
	}

	public static com.rivetlogic.model.TipsOfTheDayUsers updateImpl(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tipsOfTheDayUsers);
	}

	/**
	* Returns the Tips of the Day Users with the primary key or throws a {@link com.rivetlogic.NoSuchTipsOfTheDayUsersException} if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users
	* @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers findByPrimaryKey(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.NoSuchTipsOfTheDayUsersException {
		return getPersistence().findByPrimaryKey(tipUserId);
	}

	/**
	* Returns the Tips of the Day Users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipUserId the primary key of the Tips of the Day Users
	* @return the Tips of the Day Users, or <code>null</code> if a Tips of the Day Users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.model.TipsOfTheDayUsers fetchByPrimaryKey(
		long tipUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tipUserId);
	}

	/**
	* Returns all the Tips of the Day Userses.
	*
	* @return the Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.model.TipsOfTheDayUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @return the range of Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.model.TipsOfTheDayUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Tips of the Day Userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Tips of the Day Userses
	* @param end the upper bound of the range of Tips of the Day Userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.model.TipsOfTheDayUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Tips of the Day Userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Tips of the Day Userses.
	*
	* @return the number of Tips of the Day Userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TipsOfTheDayUsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TipsOfTheDayUsersPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.service.ClpSerializer.getServletContextName(),
					TipsOfTheDayUsersPersistence.class.getName());

			ReferenceRegistry.registerReference(TipsOfTheDayUsersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TipsOfTheDayUsersPersistence persistence) {
	}

	private static TipsOfTheDayUsersPersistence _persistence;
}