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

package com.rivetlogic.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipsOfTheDayCategoriesService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesService
 * @generated
 */
public class TipsOfTheDayCategoriesServiceWrapper
	implements TipsOfTheDayCategoriesService,
		ServiceWrapper<TipsOfTheDayCategoriesService> {
	public TipsOfTheDayCategoriesServiceWrapper(
		TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService) {
		_tipsOfTheDayCategoriesService = tipsOfTheDayCategoriesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tipsOfTheDayCategoriesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tipsOfTheDayCategoriesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tipsOfTheDayCategoriesService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TipsOfTheDayCategoriesService getWrappedTipsOfTheDayCategoriesService() {
		return _tipsOfTheDayCategoriesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTipsOfTheDayCategoriesService(
		TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService) {
		_tipsOfTheDayCategoriesService = tipsOfTheDayCategoriesService;
	}

	@Override
	public TipsOfTheDayCategoriesService getWrappedService() {
		return _tipsOfTheDayCategoriesService;
	}

	@Override
	public void setWrappedService(
		TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService) {
		_tipsOfTheDayCategoriesService = tipsOfTheDayCategoriesService;
	}

	private TipsOfTheDayCategoriesService _tipsOfTheDayCategoriesService;
}