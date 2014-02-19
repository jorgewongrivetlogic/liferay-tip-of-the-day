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

package com.rivetlogic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.service.http.TipsOfTheDayUsersServiceSoap}.
 *
 * @author juancarrillo
 * @see com.rivetlogic.service.http.TipsOfTheDayUsersServiceSoap
 * @generated
 */
public class TipsOfTheDayUsersSoap implements Serializable {
	public static TipsOfTheDayUsersSoap toSoapModel(TipsOfTheDayUsers model) {
		TipsOfTheDayUsersSoap soapModel = new TipsOfTheDayUsersSoap();

		soapModel.setTipUserId(model.getTipUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TipsOfTheDayUsersSoap[] toSoapModels(
		TipsOfTheDayUsers[] models) {
		TipsOfTheDayUsersSoap[] soapModels = new TipsOfTheDayUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayUsersSoap[][] toSoapModels(
		TipsOfTheDayUsers[][] models) {
		TipsOfTheDayUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipsOfTheDayUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipsOfTheDayUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayUsersSoap[] toSoapModels(
		List<TipsOfTheDayUsers> models) {
		List<TipsOfTheDayUsersSoap> soapModels = new ArrayList<TipsOfTheDayUsersSoap>(models.size());

		for (TipsOfTheDayUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipsOfTheDayUsersSoap[soapModels.size()]);
	}

	public TipsOfTheDayUsersSoap() {
	}

	public long getPrimaryKey() {
		return _tipUserId;
	}

	public void setPrimaryKey(long pk) {
		setTipUserId(pk);
	}

	public long getTipUserId() {
		return _tipUserId;
	}

	public void setTipUserId(long tipUserId) {
		_tipUserId = tipUserId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _tipUserId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _status;
}