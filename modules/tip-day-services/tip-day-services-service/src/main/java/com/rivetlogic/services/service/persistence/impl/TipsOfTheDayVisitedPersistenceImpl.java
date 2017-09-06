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

package com.rivetlogic.services.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException;
import com.rivetlogic.services.model.TipsOfTheDayVisited;
import com.rivetlogic.services.model.impl.TipsOfTheDayVisitedImpl;
import com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the Tips of the Day Visited service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisitedPersistence
 * @see com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedUtil
 * @generated
 */
@ProviderType
public class TipsOfTheDayVisitedPersistenceImpl extends BasePersistenceImpl<TipsOfTheDayVisited>
	implements TipsOfTheDayVisitedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipsOfTheDayVisitedUtil} to access the Tips of the Day Visited persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipsOfTheDayVisitedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_U = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TipsOfTheDayVisitedModelImpl.COMPANYID_COLUMN_BITMASK |
			TipsOfTheDayVisitedModelImpl.GROUPID_COLUMN_BITMASK |
			TipsOfTheDayVisitedModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_U = new FinderPath(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching Tips of the Day Visiteds
	 */
	@Override
	public List<TipsOfTheDayVisited> findByC_G_U(long companyId, long groupId,
		long userId) {
		return findByC_G_U(companyId, groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipsOfTheDayVisited> findByC_G_U(long companyId, long groupId,
		long userId, int start, int end) {
		return findByC_G_U(companyId, groupId, userId, start, end, null);
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
	@Override
	public List<TipsOfTheDayVisited> findByC_G_U(long companyId, long groupId,
		long userId, int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return findByC_G_U(companyId, groupId, userId, start, end,
			orderByComparator, true);
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
	@Override
	public List<TipsOfTheDayVisited> findByC_G_U(long companyId, long groupId,
		long userId, int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U;
			finderArgs = new Object[] { companyId, groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_U;
			finderArgs = new Object[] {
					companyId, groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<TipsOfTheDayVisited> list = null;

		if (retrieveFromCache) {
			list = (List<TipsOfTheDayVisited>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipsOfTheDayVisited tipsOfTheDayVisited : list) {
					if ((companyId != tipsOfTheDayVisited.getCompanyId()) ||
							(groupId != tipsOfTheDayVisited.getGroupId()) ||
							(userId != tipsOfTheDayVisited.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TIPSOFTHEDAYVISITED_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TipsOfTheDayVisitedModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TipsOfTheDayVisited>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipsOfTheDayVisited>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TipsOfTheDayVisited findByC_G_U_First(long companyId, long groupId,
		long userId, OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws NoSuchTipsOfTheDayVisitedException {
		TipsOfTheDayVisited tipsOfTheDayVisited = fetchByC_G_U_First(companyId,
				groupId, userId, orderByComparator);

		if (tipsOfTheDayVisited != null) {
			return tipsOfTheDayVisited;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTipsOfTheDayVisitedException(msg.toString());
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
	@Override
	public TipsOfTheDayVisited fetchByC_G_U_First(long companyId, long groupId,
		long userId, OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		List<TipsOfTheDayVisited> list = findByC_G_U(companyId, groupId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TipsOfTheDayVisited findByC_G_U_Last(long companyId, long groupId,
		long userId, OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws NoSuchTipsOfTheDayVisitedException {
		TipsOfTheDayVisited tipsOfTheDayVisited = fetchByC_G_U_Last(companyId,
				groupId, userId, orderByComparator);

		if (tipsOfTheDayVisited != null) {
			return tipsOfTheDayVisited;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTipsOfTheDayVisitedException(msg.toString());
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
	@Override
	public TipsOfTheDayVisited fetchByC_G_U_Last(long companyId, long groupId,
		long userId, OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		int count = countByC_G_U(companyId, groupId, userId);

		if (count == 0) {
			return null;
		}

		List<TipsOfTheDayVisited> list = findByC_G_U(companyId, groupId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TipsOfTheDayVisited[] findByC_G_U_PrevAndNext(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK, long companyId,
		long groupId, long userId,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator)
		throws NoSuchTipsOfTheDayVisitedException {
		TipsOfTheDayVisited tipsOfTheDayVisited = findByPrimaryKey(tipsOfTheDayVisitedPK);

		Session session = null;

		try {
			session = openSession();

			TipsOfTheDayVisited[] array = new TipsOfTheDayVisitedImpl[3];

			array[0] = getByC_G_U_PrevAndNext(session, tipsOfTheDayVisited,
					companyId, groupId, userId, orderByComparator, true);

			array[1] = tipsOfTheDayVisited;

			array[2] = getByC_G_U_PrevAndNext(session, tipsOfTheDayVisited,
					companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipsOfTheDayVisited getByC_G_U_PrevAndNext(Session session,
		TipsOfTheDayVisited tipsOfTheDayVisited, long companyId, long groupId,
		long userId, OrderByComparator<TipsOfTheDayVisited> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TIPSOFTHEDAYVISITED_WHERE);

		query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TipsOfTheDayVisitedModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tipsOfTheDayVisited);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TipsOfTheDayVisited> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByC_G_U(long companyId, long groupId, long userId) {
		for (TipsOfTheDayVisited tipsOfTheDayVisited : findByC_G_U(companyId,
				groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tipsOfTheDayVisited);
		}
	}

	/**
	 * Returns the number of Tips of the Day Visiteds where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching Tips of the Day Visiteds
	 */
	@Override
	public int countByC_G_U(long companyId, long groupId, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_U;

		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TIPSOFTHEDAYVISITED_WHERE);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_U_COMPANYID_2 = "tipsOfTheDayVisited.id.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_GROUPID_2 = "tipsOfTheDayVisited.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_USERID_2 = "tipsOfTheDayVisited.id.userId = ?";

	public TipsOfTheDayVisitedPersistenceImpl() {
		setModelClass(TipsOfTheDayVisited.class);
	}

	/**
	 * Caches the Tips of the Day Visited in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayVisited the Tips of the Day Visited
	 */
	@Override
	public void cacheResult(TipsOfTheDayVisited tipsOfTheDayVisited) {
		entityCache.putResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class, tipsOfTheDayVisited.getPrimaryKey(),
			tipsOfTheDayVisited);

		tipsOfTheDayVisited.resetOriginalValues();
	}

	/**
	 * Caches the Tips of the Day Visiteds in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayVisiteds the Tips of the Day Visiteds
	 */
	@Override
	public void cacheResult(List<TipsOfTheDayVisited> tipsOfTheDayVisiteds) {
		for (TipsOfTheDayVisited tipsOfTheDayVisited : tipsOfTheDayVisiteds) {
			if (entityCache.getResult(
						TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayVisitedImpl.class,
						tipsOfTheDayVisited.getPrimaryKey()) == null) {
				cacheResult(tipsOfTheDayVisited);
			}
			else {
				tipsOfTheDayVisited.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Tips of the Day Visiteds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipsOfTheDayVisitedImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Tips of the Day Visited.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipsOfTheDayVisited tipsOfTheDayVisited) {
		entityCache.removeResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class, tipsOfTheDayVisited.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipsOfTheDayVisited> tipsOfTheDayVisiteds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipsOfTheDayVisited tipsOfTheDayVisited : tipsOfTheDayVisiteds) {
			entityCache.removeResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayVisitedImpl.class,
				tipsOfTheDayVisited.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	 * @return the new Tips of the Day Visited
	 */
	@Override
	public TipsOfTheDayVisited create(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		TipsOfTheDayVisited tipsOfTheDayVisited = new TipsOfTheDayVisitedImpl();

		tipsOfTheDayVisited.setNew(true);
		tipsOfTheDayVisited.setPrimaryKey(tipsOfTheDayVisitedPK);

		tipsOfTheDayVisited.setCompanyId(companyProvider.getCompanyId());

		return tipsOfTheDayVisited;
	}

	/**
	 * Removes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was removed
	 * @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited remove(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws NoSuchTipsOfTheDayVisitedException {
		return remove((Serializable)tipsOfTheDayVisitedPK);
	}

	/**
	 * Removes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was removed
	 * @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited remove(Serializable primaryKey)
		throws NoSuchTipsOfTheDayVisitedException {
		Session session = null;

		try {
			session = openSession();

			TipsOfTheDayVisited tipsOfTheDayVisited = (TipsOfTheDayVisited)session.get(TipsOfTheDayVisitedImpl.class,
					primaryKey);

			if (tipsOfTheDayVisited == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipsOfTheDayVisitedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipsOfTheDayVisited);
		}
		catch (NoSuchTipsOfTheDayVisitedException nsee) {
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
	protected TipsOfTheDayVisited removeImpl(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		tipsOfTheDayVisited = toUnwrappedModel(tipsOfTheDayVisited);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipsOfTheDayVisited)) {
				tipsOfTheDayVisited = (TipsOfTheDayVisited)session.get(TipsOfTheDayVisitedImpl.class,
						tipsOfTheDayVisited.getPrimaryKeyObj());
			}

			if (tipsOfTheDayVisited != null) {
				session.delete(tipsOfTheDayVisited);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipsOfTheDayVisited != null) {
			clearCache(tipsOfTheDayVisited);
		}

		return tipsOfTheDayVisited;
	}

	@Override
	public TipsOfTheDayVisited updateImpl(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		tipsOfTheDayVisited = toUnwrappedModel(tipsOfTheDayVisited);

		boolean isNew = tipsOfTheDayVisited.isNew();

		TipsOfTheDayVisitedModelImpl tipsOfTheDayVisitedModelImpl = (TipsOfTheDayVisitedModelImpl)tipsOfTheDayVisited;

		Session session = null;

		try {
			session = openSession();

			if (tipsOfTheDayVisited.isNew()) {
				session.save(tipsOfTheDayVisited);

				tipsOfTheDayVisited.setNew(false);
			}
			else {
				tipsOfTheDayVisited = (TipsOfTheDayVisited)session.merge(tipsOfTheDayVisited);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TipsOfTheDayVisitedModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					tipsOfTheDayVisitedModelImpl.getCompanyId(),
					tipsOfTheDayVisitedModelImpl.getGroupId(),
					tipsOfTheDayVisitedModelImpl.getUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tipsOfTheDayVisitedModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tipsOfTheDayVisitedModelImpl.getOriginalCompanyId(),
						tipsOfTheDayVisitedModelImpl.getOriginalGroupId(),
						tipsOfTheDayVisitedModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U,
					args);

				args = new Object[] {
						tipsOfTheDayVisitedModelImpl.getCompanyId(),
						tipsOfTheDayVisitedModelImpl.getGroupId(),
						tipsOfTheDayVisitedModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_U,
					args);
			}
		}

		entityCache.putResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayVisitedImpl.class, tipsOfTheDayVisited.getPrimaryKey(),
			tipsOfTheDayVisited, false);

		tipsOfTheDayVisited.resetOriginalValues();

		return tipsOfTheDayVisited;
	}

	protected TipsOfTheDayVisited toUnwrappedModel(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		if (tipsOfTheDayVisited instanceof TipsOfTheDayVisitedImpl) {
			return tipsOfTheDayVisited;
		}

		TipsOfTheDayVisitedImpl tipsOfTheDayVisitedImpl = new TipsOfTheDayVisitedImpl();

		tipsOfTheDayVisitedImpl.setNew(tipsOfTheDayVisited.isNew());
		tipsOfTheDayVisitedImpl.setPrimaryKey(tipsOfTheDayVisited.getPrimaryKey());

		tipsOfTheDayVisitedImpl.setUserId(tipsOfTheDayVisited.getUserId());
		tipsOfTheDayVisitedImpl.setCompanyId(tipsOfTheDayVisited.getCompanyId());
		tipsOfTheDayVisitedImpl.setGroupId(tipsOfTheDayVisited.getGroupId());
		tipsOfTheDayVisitedImpl.setTipId(tipsOfTheDayVisited.getTipId());

		return tipsOfTheDayVisitedImpl;
	}

	/**
	 * Returns the Tips of the Day Visited with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited
	 * @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipsOfTheDayVisitedException {
		TipsOfTheDayVisited tipsOfTheDayVisited = fetchByPrimaryKey(primaryKey);

		if (tipsOfTheDayVisited == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipsOfTheDayVisitedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipsOfTheDayVisited;
	}

	/**
	 * Returns the Tips of the Day Visited with the primary key or throws a {@link NoSuchTipsOfTheDayVisitedException} if it could not be found.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited
	 * @throws NoSuchTipsOfTheDayVisitedException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited findByPrimaryKey(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK)
		throws NoSuchTipsOfTheDayVisitedException {
		return findByPrimaryKey((Serializable)tipsOfTheDayVisitedPK);
	}

	/**
	 * Returns the Tips of the Day Visited with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited, or <code>null</code> if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayVisitedImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipsOfTheDayVisited tipsOfTheDayVisited = (TipsOfTheDayVisited)serializable;

		if (tipsOfTheDayVisited == null) {
			Session session = null;

			try {
				session = openSession();

				tipsOfTheDayVisited = (TipsOfTheDayVisited)session.get(TipsOfTheDayVisitedImpl.class,
						primaryKey);

				if (tipsOfTheDayVisited != null) {
					cacheResult(tipsOfTheDayVisited);
				}
				else {
					entityCache.putResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayVisitedImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipsOfTheDayVisitedModelImpl.ENTITY_CACHE_ENABLED,
					TipsOfTheDayVisitedImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipsOfTheDayVisited;
	}

	/**
	 * Returns the Tips of the Day Visited with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited, or <code>null</code> if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited fetchByPrimaryKey(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return fetchByPrimaryKey((Serializable)tipsOfTheDayVisitedPK);
	}

	@Override
	public Map<Serializable, TipsOfTheDayVisited> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipsOfTheDayVisited> map = new HashMap<Serializable, TipsOfTheDayVisited>();

		for (Serializable primaryKey : primaryKeys) {
			TipsOfTheDayVisited tipsOfTheDayVisited = fetchByPrimaryKey(primaryKey);

			if (tipsOfTheDayVisited != null) {
				map.put(primaryKey, tipsOfTheDayVisited);
			}
		}

		return map;
	}

	/**
	 * Returns all the Tips of the Day Visiteds.
	 *
	 * @return the Tips of the Day Visiteds
	 */
	@Override
	public List<TipsOfTheDayVisited> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipsOfTheDayVisited> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TipsOfTheDayVisited> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TipsOfTheDayVisited> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayVisited> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TipsOfTheDayVisited> list = null;

		if (retrieveFromCache) {
			list = (List<TipsOfTheDayVisited>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPSOFTHEDAYVISITED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPSOFTHEDAYVISITED;

				if (pagination) {
					sql = sql.concat(TipsOfTheDayVisitedModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipsOfTheDayVisited>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipsOfTheDayVisited>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Tips of the Day Visiteds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipsOfTheDayVisited tipsOfTheDayVisited : findAll()) {
			remove(tipsOfTheDayVisited);
		}
	}

	/**
	 * Returns the number of Tips of the Day Visiteds.
	 *
	 * @return the number of Tips of the Day Visiteds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPSOFTHEDAYVISITED);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipsOfTheDayVisitedModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the Tips of the Day Visited persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipsOfTheDayVisitedImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPSOFTHEDAYVISITED = "SELECT tipsOfTheDayVisited FROM TipsOfTheDayVisited tipsOfTheDayVisited";
	private static final String _SQL_SELECT_TIPSOFTHEDAYVISITED_WHERE = "SELECT tipsOfTheDayVisited FROM TipsOfTheDayVisited tipsOfTheDayVisited WHERE ";
	private static final String _SQL_COUNT_TIPSOFTHEDAYVISITED = "SELECT COUNT(tipsOfTheDayVisited) FROM TipsOfTheDayVisited tipsOfTheDayVisited";
	private static final String _SQL_COUNT_TIPSOFTHEDAYVISITED_WHERE = "SELECT COUNT(tipsOfTheDayVisited) FROM TipsOfTheDayVisited tipsOfTheDayVisited WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipsOfTheDayVisited.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipsOfTheDayVisited exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TipsOfTheDayVisited exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TipsOfTheDayVisitedPersistenceImpl.class);
}