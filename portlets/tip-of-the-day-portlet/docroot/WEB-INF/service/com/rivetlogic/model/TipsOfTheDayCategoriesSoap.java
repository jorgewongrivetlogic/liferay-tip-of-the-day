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
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.service.http.TipsOfTheDayCategoriesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.service.http.TipsOfTheDayCategoriesServiceSoap
 * @generated
 */
public class TipsOfTheDayCategoriesSoap implements Serializable {
	public static TipsOfTheDayCategoriesSoap toSoapModel(
		TipsOfTheDayCategories model) {
		TipsOfTheDayCategoriesSoap soapModel = new TipsOfTheDayCategoriesSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCategories(model.getCategories());

		return soapModel;
	}

	public static TipsOfTheDayCategoriesSoap[] toSoapModels(
		TipsOfTheDayCategories[] models) {
		TipsOfTheDayCategoriesSoap[] soapModels = new TipsOfTheDayCategoriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayCategoriesSoap[][] toSoapModels(
		TipsOfTheDayCategories[][] models) {
		TipsOfTheDayCategoriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipsOfTheDayCategoriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipsOfTheDayCategoriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipsOfTheDayCategoriesSoap[] toSoapModels(
		List<TipsOfTheDayCategories> models) {
		List<TipsOfTheDayCategoriesSoap> soapModels = new ArrayList<TipsOfTheDayCategoriesSoap>(models.size());

		for (TipsOfTheDayCategories model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipsOfTheDayCategoriesSoap[soapModels.size()]);
	}

	public TipsOfTheDayCategoriesSoap() {
	}

	public long getPrimaryKey() {
		return _groupId;
	}

	public void setPrimaryKey(long pk) {
		setGroupId(pk);
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getCategories() {
		return _categories;
	}

	public void setCategories(String categories) {
		_categories = categories;
	}

	private long _groupId;
	private String _categories;
}