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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.service.ClpSerializer;
import com.rivetlogic.service.TipsOfTheDayCategoriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class TipsOfTheDayCategoriesClp extends BaseModelImpl<TipsOfTheDayCategories>
	implements TipsOfTheDayCategories {
	public TipsOfTheDayCategoriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TipsOfTheDayCategories.class;
	}

	@Override
	public String getModelClassName() {
		return TipsOfTheDayCategories.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("categories", getCategories());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String categories = (String)attributes.get("categories");

		if (categories != null) {
			setCategories(categories);
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_tipsOfTheDayCategoriesRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayCategoriesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tipsOfTheDayCategoriesRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategories() {
		return _categories;
	}

	@Override
	public void setCategories(String categories) {
		_categories = categories;

		if (_tipsOfTheDayCategoriesRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayCategoriesRemoteModel.getClass();

				Method method = clazz.getMethod("setCategories", String.class);

				method.invoke(_tipsOfTheDayCategoriesRemoteModel, categories);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTipsOfTheDayCategoriesRemoteModel() {
		return _tipsOfTheDayCategoriesRemoteModel;
	}

	public void setTipsOfTheDayCategoriesRemoteModel(
		BaseModel<?> tipsOfTheDayCategoriesRemoteModel) {
		_tipsOfTheDayCategoriesRemoteModel = tipsOfTheDayCategoriesRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _tipsOfTheDayCategoriesRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_tipsOfTheDayCategoriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TipsOfTheDayCategoriesLocalServiceUtil.addTipsOfTheDayCategories(this);
		}
		else {
			TipsOfTheDayCategoriesLocalServiceUtil.updateTipsOfTheDayCategories(this);
		}
	}

	@Override
	public TipsOfTheDayCategories toEscapedModel() {
		return (TipsOfTheDayCategories)ProxyUtil.newProxyInstance(TipsOfTheDayCategories.class.getClassLoader(),
			new Class[] { TipsOfTheDayCategories.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TipsOfTheDayCategoriesClp clone = new TipsOfTheDayCategoriesClp();

		clone.setGroupId(getGroupId());
		clone.setCategories(getCategories());

		return clone;
	}

	@Override
	public int compareTo(TipsOfTheDayCategories tipsOfTheDayCategories) {
		long primaryKey = tipsOfTheDayCategories.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayCategoriesClp)) {
			return false;
		}

		TipsOfTheDayCategoriesClp tipsOfTheDayCategories = (TipsOfTheDayCategoriesClp)obj;

		long primaryKey = tipsOfTheDayCategories.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", categories=");
		sb.append(getCategories());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.model.TipsOfTheDayCategories");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categories</column-name><column-value><![CDATA[");
		sb.append(getCategories());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private String _categories;
	private BaseModel<?> _tipsOfTheDayCategoriesRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.service.ClpSerializer.class;
}