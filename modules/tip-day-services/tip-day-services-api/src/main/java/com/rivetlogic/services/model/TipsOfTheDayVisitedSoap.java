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

package com.rivetlogic.services.model;

import aQute.bnd.annotation.ProviderType;

import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.services.service.http.TipsOfTheDayVisitedServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.services.service.http.TipsOfTheDayVisitedServiceSoap
 * @generated
 */
@ProviderType
public class TipsOfTheDayVisitedSoap implements Serializable {
	public static TipsOfTheDayVisitedSoap toSoapModel(TipsOfTheDayVisited model) {
		TipsOfTheDayVisitedSoap soapModel = new TipsOfTheDayVisitedSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTipId(model.getTipId());

		return soapModel;
	}

	public static TipsOfTheDayVisitedSoap[] toSoapModels(
		TipsOfTheDayVisited[] models) {
		TipsOfTheDayVisitedSoap[] soapModels = new TipsOfTheDayVisitedSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayVisitedSoap[][] toSoapModels(
		TipsOfTheDayVisited[][] models) {
		TipsOfTheDayVisitedSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipsOfTheDayVisitedSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipsOfTheDayVisitedSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayVisitedSoap[] toSoapModels(
		List<TipsOfTheDayVisited> models) {
		List<TipsOfTheDayVisitedSoap> soapModels = new ArrayList<TipsOfTheDayVisitedSoap>(models.size());

		for (TipsOfTheDayVisited model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipsOfTheDayVisitedSoap[soapModels.size()]);
	}

	public TipsOfTheDayVisitedSoap() {
	}

	public TipsOfTheDayVisitedPK getPrimaryKey() {
		return new TipsOfTheDayVisitedPK(_userId, _companyId, _groupId, _tipId);
	}

	public void setPrimaryKey(TipsOfTheDayVisitedPK pk) {
		setUserId(pk.userId);
		setCompanyId(pk.companyId);
		setGroupId(pk.groupId);
		setTipId(pk.tipId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getTipId() {
		return _tipId;
	}

	public void setTipId(String tipId) {
		_tipId = tipId;
	}

	private long _userId;
	private long _companyId;
	private long _groupId;
	private String _tipId;
}