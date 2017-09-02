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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.services.model.TipsOfTheDayCategories;
import com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesImpl;
import com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesModelImpl;
import com.rivetlogic.services.service.persistence.TipsOfTheDayCategoriesPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the Tips of the Day Categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesPersistence
 * @see com.rivetlogic.services.service.persistence.TipsOfTheDayCategoriesUtil
 * @generated
 */
@ProviderType
public class TipsOfTheDayCategoriesPersistenceImpl extends BasePersistenceImpl<TipsOfTheDayCategories>
	implements TipsOfTheDayCategoriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipsOfTheDayCategoriesUtil} to access the Tips of the Day Categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipsOfTheDayCategoriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesModelImpl.FINDER_CACHE_ENABLED,
			TipsOfTheDayCategoriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipsOfTheDayCategoriesPersistenceImpl() {
		setModelClass(TipsOfTheDayCategories.class);
	}

	/**
	 * Caches the Tips of the Day Categories in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayCategories the Tips of the Day Categories
	 */
	@Override
	public void cacheResult(TipsOfTheDayCategories tipsOfTheDayCategories) {
		entityCache.putResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesImpl.class,
			tipsOfTheDayCategories.getPrimaryKey(), tipsOfTheDayCategories);

		tipsOfTheDayCategories.resetOriginalValues();
	}

	/**
	 * Caches the Tips of the Day Categorieses in the entity cache if it is enabled.
	 *
	 * @param tipsOfTheDayCategorieses the Tips of the Day Categorieses
	 */
	@Override
	public void cacheResult(
		List<TipsOfTheDayCategories> tipsOfTheDayCategorieses) {
		for (TipsOfTheDayCategories tipsOfTheDayCategories : tipsOfTheDayCategorieses) {
			if (entityCache.getResult(
						TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayCategoriesImpl.class,
						tipsOfTheDayCategories.getPrimaryKey()) == null) {
				cacheResult(tipsOfTheDayCategories);
			}
			else {
				tipsOfTheDayCategories.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Tips of the Day Categorieses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipsOfTheDayCategoriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Tips of the Day Categories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipsOfTheDayCategories tipsOfTheDayCategories) {
		entityCache.removeResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesImpl.class,
			tipsOfTheDayCategories.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<TipsOfTheDayCategories> tipsOfTheDayCategorieses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipsOfTheDayCategories tipsOfTheDayCategories : tipsOfTheDayCategorieses) {
			entityCache.removeResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayCategoriesImpl.class,
				tipsOfTheDayCategories.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Tips of the Day Categories with the primary key. Does not add the Tips of the Day Categories to the database.
	 *
	 * @param groupId the primary key for the new Tips of the Day Categories
	 * @return the new Tips of the Day Categories
	 */
	@Override
	public TipsOfTheDayCategories create(long groupId) {
		TipsOfTheDayCategories tipsOfTheDayCategories = new TipsOfTheDayCategoriesImpl();

		tipsOfTheDayCategories.setNew(true);
		tipsOfTheDayCategories.setPrimaryKey(groupId);

		return tipsOfTheDayCategories;
	}

	/**
	 * Removes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories that was removed
	 * @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories remove(long groupId)
		throws NoSuchTipsOfTheDayCategoriesException {
		return remove((Serializable)groupId);
	}

	/**
	 * Removes the Tips of the Day Categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories that was removed
	 * @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories remove(Serializable primaryKey)
		throws NoSuchTipsOfTheDayCategoriesException {
		Session session = null;

		try {
			session = openSession();

			TipsOfTheDayCategories tipsOfTheDayCategories = (TipsOfTheDayCategories)session.get(TipsOfTheDayCategoriesImpl.class,
					primaryKey);

			if (tipsOfTheDayCategories == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipsOfTheDayCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipsOfTheDayCategories);
		}
		catch (NoSuchTipsOfTheDayCategoriesException nsee) {
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
	protected TipsOfTheDayCategories removeImpl(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		tipsOfTheDayCategories = toUnwrappedModel(tipsOfTheDayCategories);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipsOfTheDayCategories)) {
				tipsOfTheDayCategories = (TipsOfTheDayCategories)session.get(TipsOfTheDayCategoriesImpl.class,
						tipsOfTheDayCategories.getPrimaryKeyObj());
			}

			if (tipsOfTheDayCategories != null) {
				session.delete(tipsOfTheDayCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipsOfTheDayCategories != null) {
			clearCache(tipsOfTheDayCategories);
		}

		return tipsOfTheDayCategories;
	}

	@Override
	public TipsOfTheDayCategories updateImpl(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		tipsOfTheDayCategories = toUnwrappedModel(tipsOfTheDayCategories);

		boolean isNew = tipsOfTheDayCategories.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipsOfTheDayCategories.isNew()) {
				session.save(tipsOfTheDayCategories);

				tipsOfTheDayCategories.setNew(false);
			}
			else {
				tipsOfTheDayCategories = (TipsOfTheDayCategories)session.merge(tipsOfTheDayCategories);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
			TipsOfTheDayCategoriesImpl.class,
			tipsOfTheDayCategories.getPrimaryKey(), tipsOfTheDayCategories,
			false);

		tipsOfTheDayCategories.resetOriginalValues();

		return tipsOfTheDayCategories;
	}

	protected TipsOfTheDayCategories toUnwrappedModel(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		if (tipsOfTheDayCategories instanceof TipsOfTheDayCategoriesImpl) {
			return tipsOfTheDayCategories;
		}

		TipsOfTheDayCategoriesImpl tipsOfTheDayCategoriesImpl = new TipsOfTheDayCategoriesImpl();

		tipsOfTheDayCategoriesImpl.setNew(tipsOfTheDayCategories.isNew());
		tipsOfTheDayCategoriesImpl.setPrimaryKey(tipsOfTheDayCategories.getPrimaryKey());

		tipsOfTheDayCategoriesImpl.setGroupId(tipsOfTheDayCategories.getGroupId());
		tipsOfTheDayCategoriesImpl.setCategories(tipsOfTheDayCategories.getCategories());

		return tipsOfTheDayCategoriesImpl;
	}

	/**
	 * Returns the Tips of the Day Categories with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories
	 * @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipsOfTheDayCategoriesException {
		TipsOfTheDayCategories tipsOfTheDayCategories = fetchByPrimaryKey(primaryKey);

		if (tipsOfTheDayCategories == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipsOfTheDayCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipsOfTheDayCategories;
	}

	/**
	 * Returns the Tips of the Day Categories with the primary key or throws a {@link NoSuchTipsOfTheDayCategoriesException} if it could not be found.
	 *
	 * @param groupId the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories
	 * @throws NoSuchTipsOfTheDayCategoriesException if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories findByPrimaryKey(long groupId)
		throws NoSuchTipsOfTheDayCategoriesException {
		return findByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns the Tips of the Day Categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories, or <code>null</code> if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
				TipsOfTheDayCategoriesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipsOfTheDayCategories tipsOfTheDayCategories = (TipsOfTheDayCategories)serializable;

		if (tipsOfTheDayCategories == null) {
			Session session = null;

			try {
				session = openSession();

				tipsOfTheDayCategories = (TipsOfTheDayCategories)session.get(TipsOfTheDayCategoriesImpl.class,
						primaryKey);

				if (tipsOfTheDayCategories != null) {
					cacheResult(tipsOfTheDayCategories);
				}
				else {
					entityCache.putResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
						TipsOfTheDayCategoriesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
					TipsOfTheDayCategoriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipsOfTheDayCategories;
	}

	/**
	 * Returns the Tips of the Day Categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the Tips of the Day Categories
	 * @return the Tips of the Day Categories, or <code>null</code> if a Tips of the Day Categories with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayCategories fetchByPrimaryKey(long groupId) {
		return fetchByPrimaryKey((Serializable)groupId);
	}

	@Override
	public Map<Serializable, TipsOfTheDayCategories> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipsOfTheDayCategories> map = new HashMap<Serializable, TipsOfTheDayCategories>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipsOfTheDayCategories tipsOfTheDayCategories = fetchByPrimaryKey(primaryKey);

			if (tipsOfTheDayCategories != null) {
				map.put(primaryKey, tipsOfTheDayCategories);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
					TipsOfTheDayCategoriesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipsOfTheDayCategories)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPSOFTHEDAYCATEGORIES_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TipsOfTheDayCategories tipsOfTheDayCategories : (List<TipsOfTheDayCategories>)q.list()) {
				map.put(tipsOfTheDayCategories.getPrimaryKeyObj(),
					tipsOfTheDayCategories);

				cacheResult(tipsOfTheDayCategories);

				uncachedPrimaryKeys.remove(tipsOfTheDayCategories.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipsOfTheDayCategoriesModelImpl.ENTITY_CACHE_ENABLED,
					TipsOfTheDayCategoriesImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the Tips of the Day Categorieses.
	 *
	 * @return the Tips of the Day Categorieses
	 */
	@Override
	public List<TipsOfTheDayCategories> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipsOfTheDayCategories> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TipsOfTheDayCategories> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayCategories> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TipsOfTheDayCategories> findAll(int start, int end,
		OrderByComparator<TipsOfTheDayCategories> orderByComparator,
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

		List<TipsOfTheDayCategories> list = null;

		if (retrieveFromCache) {
			list = (List<TipsOfTheDayCategories>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPSOFTHEDAYCATEGORIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPSOFTHEDAYCATEGORIES;

				if (pagination) {
					sql = sql.concat(TipsOfTheDayCategoriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipsOfTheDayCategories>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipsOfTheDayCategories>)QueryUtil.list(q,
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
	 * Removes all the Tips of the Day Categorieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipsOfTheDayCategories tipsOfTheDayCategories : findAll()) {
			remove(tipsOfTheDayCategories);
		}
	}

	/**
	 * Returns the number of Tips of the Day Categorieses.
	 *
	 * @return the number of Tips of the Day Categorieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPSOFTHEDAYCATEGORIES);

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
		return TipsOfTheDayCategoriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the Tips of the Day Categories persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipsOfTheDayCategoriesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPSOFTHEDAYCATEGORIES = "SELECT tipsOfTheDayCategories FROM TipsOfTheDayCategories tipsOfTheDayCategories";
	private static final String _SQL_SELECT_TIPSOFTHEDAYCATEGORIES_WHERE_PKS_IN = "SELECT tipsOfTheDayCategories FROM TipsOfTheDayCategories tipsOfTheDayCategories WHERE groupId IN (";
	private static final String _SQL_COUNT_TIPSOFTHEDAYCATEGORIES = "SELECT COUNT(tipsOfTheDayCategories) FROM TipsOfTheDayCategories tipsOfTheDayCategories";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipsOfTheDayCategories.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipsOfTheDayCategories exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipsOfTheDayCategoriesPersistenceImpl.class);
}