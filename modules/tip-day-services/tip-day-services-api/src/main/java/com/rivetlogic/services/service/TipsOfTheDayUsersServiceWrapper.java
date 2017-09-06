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

package com.rivetlogic.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipsOfTheDayUsersService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersService
 * @generated
 */
@ProviderType
public class TipsOfTheDayUsersServiceWrapper implements TipsOfTheDayUsersService,
	ServiceWrapper<TipsOfTheDayUsersService> {
	public TipsOfTheDayUsersServiceWrapper(
		TipsOfTheDayUsersService tipsOfTheDayUsersService) {
		_tipsOfTheDayUsersService = tipsOfTheDayUsersService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipsOfTheDayUsersService.getOSGiServiceIdentifier();
	}

	@Override
	public TipsOfTheDayUsersService getWrappedService() {
		return _tipsOfTheDayUsersService;
	}

	@Override
	public void setWrappedService(
		TipsOfTheDayUsersService tipsOfTheDayUsersService) {
		_tipsOfTheDayUsersService = tipsOfTheDayUsersService;
	}

	private TipsOfTheDayUsersService _tipsOfTheDayUsersService;
}