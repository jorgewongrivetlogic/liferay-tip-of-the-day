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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.NoSuchTipsOfTheDayUsersException;

import com.rivetlogic.model.TipsOfTheDayUsers;
import com.rivetlogic.model.impl.TipsOfTheDayUsersImpl;
import com.rivetlogic.model.impl.TipsOfTheDayUsersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Tips of the Day Users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TipsOfTheDayUsersPersistence
 * @see TipsOfTheDayUsersUtil
 * @generated
 */
public class TipsOfTheDayUsersPersistenceImpl extends BasePersistenceImpl<TipsOfTheDayUsers>
	implements TipsOfTheDayUsersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipsOfTheDayUsersUtil} to access the Tips of the Day Users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipsOfTheDayUsersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_U = new FinderPath(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TipsOfTheDayUsersModelImpl.COMPANYID_COLUMN_BITMASK |
			TipsOfTheDayUsersModelImpl.GROUPID_COLUMN_BITMASK |
			TipsOfTheDayUsersModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_U = new FinderPath(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

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
	@Override
	public TipsOfTheDayUsers findByC_G_U(long companyId, long groupId,
		long userId) throws NoSuchTipsOfTheDayUsersException, SystemException {
		TipsOfTheDayUsers tipsOfTheDayUsers = fetchByC_G_U(companyId, groupId,
				userId);

		if (tipsOfTheDayUsers == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTipsOfTheDayUsersException(msg.toString());
		}

		return tipsOfTheDayUsers;
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
	@Override
	public TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId) throws SystemException {
		return fetchByC_G_U(companyId, groupId, userId, true);
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
	@Override
	public TipsOfTheDayUsers fetchByC_G_U(long companyId, long groupId,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_U,
					finderArgs, this);
		}

		if (result instanceof TipsOfTheDayUsers) {
			TipsOfTheDayUsers tipsOfTheDayUsers = (TipsOfTheDayUsers)result;

			if ((companyId != tipsOfTheDayUsers.getCompanyId()) ||
					(groupId != tipsOfTheDayUsers.getGroupId()) ||
					(userId != tipsOfTheDayUsers.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TIPSOFTHEDAYUSERS_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				List<TipsOfTheDayUsers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TipsOfTheDayUsersPersistenceImpl.fetchByC_G_U(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TipsOfTheDayUsers tipsOfTheDayUsers = list.get(0);

					result = tipsOfTheDayUsers;

					cacheResult(tipsOfTheDayUsers);

					if ((tipsOfTheDayUsers.getCompanyId() != companyId) ||
							(tipsOfTheDayUsers.getGroupId() != groupId) ||
							(tipsOfTheDayUsers.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
							finderArgs, tipsOfTheDayUsers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TipsOfTheDayUsers)result;
		}
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
	@Override
	public TipsOfTheDayUsers removeByC_G_U(long companyId, long groupId,
		long userId) throws NoSuchTipsOfTheDayUsersException, SystemException {
		TipsOfTheDayUsers tipsOfTheDayUsers = findByC_G_U(companyId, groupId,
				userId);

		return remove(tipsOfTheDayUsers);
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
	@Override
	public int countByC_G_U(long companyId, long groupId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_U;

		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TIPSOFTHEDAYUSERS_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_U_COMPANYID_2 = "tipsOfTheDayUsers.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_GROUPID_2 = "tipsOfTheDayUsers.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_USERID_2 = "tipsOfTheDayUsers.userId = ?";

	public TipsOfTheDayUsersPersistenceImpl() {
		setModelClass(TipsOfTheDayUsers.class);
	}

	/**
	 * Caches the Tips of the Day Users in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayUsers the Tips of the Day Users
	 */
	@Override
	public void cacheResult(TipsOfTheDayUsers tipsOfTheDayUsers) {
		EntityCacheUtil.putResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class, tipsOfTheDayUsers.getPrimaryKey(),
			tipsOfTheDayUsers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
			new Object[] {
				tipsOfTheDayUsers.getCompanyId(), tipsOfTheDayUsers.getGroupId(),
				tipsOfTheDayUsers.getUserId()
			}, tipsOfTheDayUsers);

		tipsOfTheDayUsers.resetOriginalValues();
	}

	/**
	 * Caches the Tips of the Day Userses in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayUserses the Tips of the Day Userses
	 */
	@Override
	public void cacheResult(List<TipsOfTheDayUsers> tipsOfTheDayUserses) {
		for (TipsOfTheDayUsers tipsOfTheDayUsers : tipsOfTheDayUserses) {
			if (EntityCacheUtil.getResult(
						TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayUsersImpl.class,
						tipsOfTheDayUsers.getPrimaryKey()) == null) {
				cacheResult(tipsOfTheDayUsers);
			}
			else {
				tipsOfTheDayUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Tips of the Day Userses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TipsOfTheDayUsersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TipsOfTheDayUsersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Tips of the Day Users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipsOfTheDayUsers tipsOfTheDayUsers) {
		EntityCacheUtil.removeResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class, tipsOfTheDayUsers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tipsOfTheDayUsers);
	}

	@Override
	public void clearCache(List<TipsOfTheDayUsers> tipsOfTheDayUserses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipsOfTheDayUsers tipsOfTheDayUsers : tipsOfTheDayUserses) {
			EntityCacheUtil.removeResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayUsersImpl.class, tipsOfTheDayUsers.getPrimaryKey());

			clearUniqueFindersCache(tipsOfTheDayUsers);
		}
	}

	protected void cacheUniqueFindersCache(TipsOfTheDayUsers tipsOfTheDayUsers) {
		if (tipsOfTheDayUsers.isNew()) {
			Object[] args = new Object[] {
					tipsOfTheDayUsers.getCompanyId(),
					tipsOfTheDayUsers.getGroupId(),
					tipsOfTheDayUsers.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_U, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U, args,
				tipsOfTheDayUsers);
		}
		else {
			TipsOfTheDayUsersModelImpl tipsOfTheDayUsersModelImpl = (TipsOfTheDayUsersModelImpl)tipsOfTheDayUsers;

			if ((tipsOfTheDayUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tipsOfTheDayUsers.getCompanyId(),
						tipsOfTheDayUsers.getGroupId(),
						tipsOfTheDayUsers.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_U, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U, args,
					tipsOfTheDayUsers);
			}
		}
	}

	protected void clearUniqueFindersCache(TipsOfTheDayUsers tipsOfTheDayUsers) {
		TipsOfTheDayUsersModelImpl tipsOfTheDayUsersModelImpl = (TipsOfTheDayUsersModelImpl)tipsOfTheDayUsers;

		Object[] args = new Object[] {
				tipsOfTheDayUsers.getCompanyId(), tipsOfTheDayUsers.getGroupId(),
				tipsOfTheDayUsers.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U, args);

		if ((tipsOfTheDayUsersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					tipsOfTheDayUsersModelImpl.getOriginalCompanyId(),
					tipsOfTheDayUsersModelImpl.getOriginalGroupId(),
					tipsOfTheDayUsersModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U, args);
		}
	}

	/**
	 * Creates a new Tips of the Day Users with the primary key. Does not add the Tips of the Day Users to the database.
	 *
	 * @param tipUserId the primary key for the new Tips of the Day Users
	 * @return the new Tips of the Day Users
	 */
	@Override
	public TipsOfTheDayUsers create(long tipUserId) {
		TipsOfTheDayUsers tipsOfTheDayUsers = new TipsOfTheDayUsersImpl();

		tipsOfTheDayUsers.setNew(true);
		tipsOfTheDayUsers.setPrimaryKey(tipUserId);

		return tipsOfTheDayUsers;
	}

	/**
	 * Removes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipUserId the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users that was removed
	 * @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers remove(long tipUserId)
		throws NoSuchTipsOfTheDayUsersException, SystemException {
		return remove((Serializable)tipUserId);
	}

	/**
	 * Removes the Tips of the Day Users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users that was removed
	 * @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers remove(Serializable primaryKey)
		throws NoSuchTipsOfTheDayUsersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TipsOfTheDayUsers tipsOfTheDayUsers = (TipsOfTheDayUsers)session.get(TipsOfTheDayUsersImpl.class,
					primaryKey);

			if (tipsOfTheDayUsers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipsOfTheDayUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipsOfTheDayUsers);
		}
		catch (NoSuchTipsOfTheDayUsersException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TipsOfTheDayUsers removeImpl(TipsOfTheDayUsers tipsOfTheDayUsers)
		throws SystemException {
		tipsOfTheDayUsers = toUnwrappedModel(tipsOfTheDayUsers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipsOfTheDayUsers)) {
				tipsOfTheDayUsers = (TipsOfTheDayUsers)session.get(TipsOfTheDayUsersImpl.class,
						tipsOfTheDayUsers.getPrimaryKeyObj());
			}

			if (tipsOfTheDayUsers != null) {
				session.delete(tipsOfTheDayUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipsOfTheDayUsers != null) {
			clearCache(tipsOfTheDayUsers);
		}

		return tipsOfTheDayUsers;
	}

	@Override
	public TipsOfTheDayUsers updateImpl(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers)
		throws SystemException {
		tipsOfTheDayUsers = toUnwrappedModel(tipsOfTheDayUsers);

		boolean isNew = tipsOfTheDayUsers.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipsOfTheDayUsers.isNew()) {
				session.save(tipsOfTheDayUsers);

				tipsOfTheDayUsers.setNew(false);
			}
			else {
				session.merge(tipsOfTheDayUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TipsOfTheDayUsersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayUsersImpl.class, tipsOfTheDayUsers.getPrimaryKey(),
			tipsOfTheDayUsers);

		clearUniqueFindersCache(tipsOfTheDayUsers);
		cacheUniqueFindersCache(tipsOfTheDayUsers);

		return tipsOfTheDayUsers;
	}

	protected TipsOfTheDayUsers toUnwrappedModel(
		TipsOfTheDayUsers tipsOfTheDayUsers) {
		if (tipsOfTheDayUsers instanceof TipsOfTheDayUsersImpl) {
			return tipsOfTheDayUsers;
		}

		TipsOfTheDayUsersImpl tipsOfTheDayUsersImpl = new TipsOfTheDayUsersImpl();

		tipsOfTheDayUsersImpl.setNew(tipsOfTheDayUsers.isNew());
		tipsOfTheDayUsersImpl.setPrimaryKey(tipsOfTheDayUsers.getPrimaryKey());

		tipsOfTheDayUsersImpl.setTipUserId(tipsOfTheDayUsers.getTipUserId());
		tipsOfTheDayUsersImpl.setCompanyId(tipsOfTheDayUsers.getCompanyId());
		tipsOfTheDayUsersImpl.setGroupId(tipsOfTheDayUsers.getGroupId());
		tipsOfTheDayUsersImpl.setUserId(tipsOfTheDayUsers.getUserId());
		tipsOfTheDayUsersImpl.setStatus(tipsOfTheDayUsers.getStatus());
		tipsOfTheDayUsersImpl.setShowAll(tipsOfTheDayUsers.isShowAll());

		return tipsOfTheDayUsersImpl;
	}

	/**
	 * Returns the Tips of the Day Users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users
	 * @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipsOfTheDayUsersException, SystemException {
		TipsOfTheDayUsers tipsOfTheDayUsers = fetchByPrimaryKey(primaryKey);

		if (tipsOfTheDayUsers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipsOfTheDayUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipsOfTheDayUsers;
	}

	/**
	 * Returns the Tips of the Day Users with the primary key or throws a {@link com.rivetlogic.NoSuchTipsOfTheDayUsersException} if it could not be found.
	 *
	 * @param tipUserId the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users
	 * @throws com.rivetlogic.NoSuchTipsOfTheDayUsersException if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers findByPrimaryKey(long tipUserId)
		throws NoSuchTipsOfTheDayUsersException, SystemException {
		return findByPrimaryKey((Serializable)tipUserId);
	}

	/**
	 * Returns the Tips of the Day Users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users, or <code>null</code> if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TipsOfTheDayUsers tipsOfTheDayUsers = (TipsOfTheDayUsers)EntityCacheUtil.getResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayUsersImpl.class, primaryKey);

		if (tipsOfTheDayUsers == _nullTipsOfTheDayUsers) {
			return null;
		}

		if (tipsOfTheDayUsers == null) {
			Session session = null;

			try {
				session = openSession();

				tipsOfTheDayUsers = (TipsOfTheDayUsers)session.get(TipsOfTheDayUsersImpl.class,
						primaryKey);

				if (tipsOfTheDayUsers != null) {
					cacheResult(tipsOfTheDayUsers);
				}
				else {
					EntityCacheUtil.putResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayUsersImpl.class, primaryKey,
						_nullTipsOfTheDayUsers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TipsOfTheDayUsersModelImpl.ENTITY_CACHE_ENABLED,
					TipsOfTheDayUsersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipsOfTheDayUsers;
	}

	/**
	 * Returns the Tips of the Day Users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipUserId the primary key of the Tips of the Day Users
	 * @return the Tips of the Day Users, or <code>null</code> if a Tips of the Day Users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TipsOfTheDayUsers fetchByPrimaryKey(long tipUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tipUserId);
	}

	/**
	 * Returns all the Tips of the Day Userses.
	 *
	 * @return the Tips of the Day Userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TipsOfTheDayUsers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipsOfTheDayUsers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<TipsOfTheDayUsers> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TipsOfTheDayUsers> list = (List<TipsOfTheDayUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIPSOFTHEDAYUSERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPSOFTHEDAYUSERS;

				if (pagination) {
					sql = sql.concat(TipsOfTheDayUsersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipsOfTheDayUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TipsOfTheDayUsers>(list);
				}
				else {
					list = (List<TipsOfTheDayUsers>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Tips of the Day Userses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TipsOfTheDayUsers tipsOfTheDayUsers : findAll()) {
			remove(tipsOfTheDayUsers);
		}
	}

	/**
	 * Returns the number of Tips of the Day Userses.
	 *
	 * @return the number of Tips of the Day Userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPSOFTHEDAYUSERS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Tips of the Day Users persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.model.TipsOfTheDayUsers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TipsOfTheDayUsers>> listenersList = new ArrayList<ModelListener<TipsOfTheDayUsers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TipsOfTheDayUsers>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TipsOfTheDayUsersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TIPSOFTHEDAYUSERS = "SELECT tipsOfTheDayUsers FROM TipsOfTheDayUsers tipsOfTheDayUsers";
	private static final String _SQL_SELECT_TIPSOFTHEDAYUSERS_WHERE = "SELECT tipsOfTheDayUsers FROM TipsOfTheDayUsers tipsOfTheDayUsers WHERE ";
	private static final String _SQL_COUNT_TIPSOFTHEDAYUSERS = "SELECT COUNT(tipsOfTheDayUsers) FROM TipsOfTheDayUsers tipsOfTheDayUsers";
	private static final String _SQL_COUNT_TIPSOFTHEDAYUSERS_WHERE = "SELECT COUNT(tipsOfTheDayUsers) FROM TipsOfTheDayUsers tipsOfTheDayUsers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipsOfTheDayUsers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipsOfTheDayUsers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TipsOfTheDayUsers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TipsOfTheDayUsersPersistenceImpl.class);
	private static TipsOfTheDayUsers _nullTipsOfTheDayUsers = new TipsOfTheDayUsersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TipsOfTheDayUsers> toCacheModel() {
				return _nullTipsOfTheDayUsersCacheModel;
			}
		};

	private static CacheModel<TipsOfTheDayUsers> _nullTipsOfTheDayUsersCacheModel =
		new CacheModel<TipsOfTheDayUsers>() {
			@Override
			public TipsOfTheDayUsers toEntityModel() {
				return _nullTipsOfTheDayUsers;
			}
		};
}