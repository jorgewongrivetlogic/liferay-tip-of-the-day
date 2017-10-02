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

package com.rivetlogic.services.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.services.model.TipsOfTheDayUsers;
import com.rivetlogic.services.service.TipsOfTheDayUsersService;
import com.rivetlogic.services.service.persistence.TipsOfTheDayCategoriesPersistence;
import com.rivetlogic.services.service.persistence.TipsOfTheDayUsersPersistence;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the Tips of the Day Users remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.services.service.impl.TipsOfTheDayUsersServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.services.service.impl.TipsOfTheDayUsersServiceImpl
 * @see com.rivetlogic.services.service.TipsOfTheDayUsersServiceUtil
 * @generated
 */
public abstract class TipsOfTheDayUsersServiceBaseImpl extends BaseServiceImpl
	implements TipsOfTheDayUsersService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.services.service.TipsOfTheDayUsersServiceUtil} to access the Tips of the Day Users remote service.
	 */

	/**
	 * Returns the Tips of the Day Categories local service.
	 *
	 * @return the Tips of the Day Categories local service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService getTipsOfTheDayCategoriesLocalService() {
		return tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * Sets the Tips of the Day Categories local service.
	 *
	 * @param tipsOfTheDayCategoriesLocalService the Tips of the Day Categories local service
	 */
	public void setTipsOfTheDayCategoriesLocalService(
		com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		this.tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * Returns the Tips of the Day Categories remote service.
	 *
	 * @return the Tips of the Day Categories remote service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayCategoriesService getTipsOfTheDayCategoriesService() {
		return tipsOfTheDayCategoriesService;
	}

	/**
	 * Sets the Tips of the Day Categories remote service.
	 *
	 * @param tipsOfTheDayCategoriesService the Tips of the Day Categories remote service
	 */
	public void setTipsOfTheDayCategoriesService(
		com.rivetlogic.services.service.TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService) {
		this.tipsOfTheDayCategoriesService = tipsOfTheDayCategoriesService;
	}

	/**
	 * Returns the Tips of the Day Categories persistence.
	 *
	 * @return the Tips of the Day Categories persistence
	 */
	public TipsOfTheDayCategoriesPersistence getTipsOfTheDayCategoriesPersistence() {
		return tipsOfTheDayCategoriesPersistence;
	}

	/**
	 * Sets the Tips of the Day Categories persistence.
	 *
	 * @param tipsOfTheDayCategoriesPersistence the Tips of the Day Categories persistence
	 */
	public void setTipsOfTheDayCategoriesPersistence(
		TipsOfTheDayCategoriesPersistence tipsOfTheDayCategoriesPersistence) {
		this.tipsOfTheDayCategoriesPersistence = tipsOfTheDayCategoriesPersistence;
	}

	/**
	 * Returns the Tips of the Day Users local service.
	 *
	 * @return the Tips of the Day Users local service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayUsersLocalService getTipsOfTheDayUsersLocalService() {
		return tipsOfTheDayUsersLocalService;
	}

	/**
	 * Sets the Tips of the Day Users local service.
	 *
	 * @param tipsOfTheDayUsersLocalService the Tips of the Day Users local service
	 */
	public void setTipsOfTheDayUsersLocalService(
		com.rivetlogic.services.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		this.tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	/**
	 * Returns the Tips of the Day Users remote service.
	 *
	 * @return the Tips of the Day Users remote service
	 */
	public TipsOfTheDayUsersService getTipsOfTheDayUsersService() {
		return tipsOfTheDayUsersService;
	}

	/**
	 * Sets the Tips of the Day Users remote service.
	 *
	 * @param tipsOfTheDayUsersService the Tips of the Day Users remote service
	 */
	public void setTipsOfTheDayUsersService(
		TipsOfTheDayUsersService tipsOfTheDayUsersService) {
		this.tipsOfTheDayUsersService = tipsOfTheDayUsersService;
	}

	/**
	 * Returns the Tips of the Day Users persistence.
	 *
	 * @return the Tips of the Day Users persistence
	 */
	public TipsOfTheDayUsersPersistence getTipsOfTheDayUsersPersistence() {
		return tipsOfTheDayUsersPersistence;
	}

	/**
	 * Sets the Tips of the Day Users persistence.
	 *
	 * @param tipsOfTheDayUsersPersistence the Tips of the Day Users persistence
	 */
	public void setTipsOfTheDayUsersPersistence(
		TipsOfTheDayUsersPersistence tipsOfTheDayUsersPersistence) {
		this.tipsOfTheDayUsersPersistence = tipsOfTheDayUsersPersistence;
	}

	/**
	 * Returns the Tips of the Day Visited local service.
	 *
	 * @return the Tips of the Day Visited local service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService getTipsOfTheDayVisitedLocalService() {
		return tipsOfTheDayVisitedLocalService;
	}

	/**
	 * Sets the Tips of the Day Visited local service.
	 *
	 * @param tipsOfTheDayVisitedLocalService the Tips of the Day Visited local service
	 */
	public void setTipsOfTheDayVisitedLocalService(
		com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		this.tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	/**
	 * Returns the Tips of the Day Visited remote service.
	 *
	 * @return the Tips of the Day Visited remote service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayVisitedService getTipsOfTheDayVisitedService() {
		return tipsOfTheDayVisitedService;
	}

	/**
	 * Sets the Tips of the Day Visited remote service.
	 *
	 * @param tipsOfTheDayVisitedService the Tips of the Day Visited remote service
	 */
	public void setTipsOfTheDayVisitedService(
		com.rivetlogic.services.service.TipsOfTheDayVisitedService tipsOfTheDayVisitedService) {
		this.tipsOfTheDayVisitedService = tipsOfTheDayVisitedService;
	}

	/**
	 * Returns the Tips of the Day Visited persistence.
	 *
	 * @return the Tips of the Day Visited persistence
	 */
	public TipsOfTheDayVisitedPersistence getTipsOfTheDayVisitedPersistence() {
		return tipsOfTheDayVisitedPersistence;
	}

	/**
	 * Sets the Tips of the Day Visited persistence.
	 *
	 * @param tipsOfTheDayVisitedPersistence the Tips of the Day Visited persistence
	 */
	public void setTipsOfTheDayVisitedPersistence(
		TipsOfTheDayVisitedPersistence tipsOfTheDayVisitedPersistence) {
		this.tipsOfTheDayVisitedPersistence = tipsOfTheDayVisitedPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TipsOfTheDayUsersService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TipsOfTheDayUsers.class;
	}

	protected String getModelClassName() {
		return TipsOfTheDayUsers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tipsOfTheDayUsersPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService;
	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayCategoriesService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService;
	@BeanReference(type = TipsOfTheDayCategoriesPersistence.class)
	protected TipsOfTheDayCategoriesPersistence tipsOfTheDayCategoriesPersistence;
	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayUsersLocalService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService;
	@BeanReference(type = TipsOfTheDayUsersService.class)
	protected TipsOfTheDayUsersService tipsOfTheDayUsersService;
	@BeanReference(type = TipsOfTheDayUsersPersistence.class)
	protected TipsOfTheDayUsersPersistence tipsOfTheDayUsersPersistence;
	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService;
	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayVisitedService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayVisitedService tipsOfTheDayVisitedService;
	@BeanReference(type = TipsOfTheDayVisitedPersistence.class)
	protected TipsOfTheDayVisitedPersistence tipsOfTheDayVisitedPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}