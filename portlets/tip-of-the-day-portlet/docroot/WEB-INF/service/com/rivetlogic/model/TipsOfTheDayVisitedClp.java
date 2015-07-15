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
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.service.ClpSerializer;
import com.rivetlogic.service.TipsOfTheDayVisitedLocalServiceUtil;
import com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class TipsOfTheDayVisitedClp extends BaseModelImpl<TipsOfTheDayVisited>
	implements TipsOfTheDayVisited {
	public TipsOfTheDayVisitedClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TipsOfTheDayVisited.class;
	}

	@Override
	public String getModelClassName() {
		return TipsOfTheDayVisited.class.getName();
	}

	@Override
	public TipsOfTheDayVisitedPK getPrimaryKey() {
		return new TipsOfTheDayVisitedPK(_userId, _companyId, _groupId, _tipId);
	}

	@Override
	public void setPrimaryKey(TipsOfTheDayVisitedPK primaryKey) {
		setUserId(primaryKey.userId);
		setCompanyId(primaryKey.companyId);
		setGroupId(primaryKey.groupId);
		setTipId(primaryKey.tipId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new TipsOfTheDayVisitedPK(_userId, _companyId, _groupId, _tipId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((TipsOfTheDayVisitedPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("tipId", getTipId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String tipId = (String)attributes.get("tipId");

		if (tipId != null) {
			setTipId(tipId);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_tipsOfTheDayVisitedRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayVisitedRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tipsOfTheDayVisitedRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_tipsOfTheDayVisitedRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayVisitedRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tipsOfTheDayVisitedRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_tipsOfTheDayVisitedRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayVisitedRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tipsOfTheDayVisitedRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipId() {
		return _tipId;
	}

	@Override
	public void setTipId(String tipId) {
		_tipId = tipId;

		if (_tipsOfTheDayVisitedRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayVisitedRemoteModel.getClass();

				Method method = clazz.getMethod("setTipId", String.class);

				method.invoke(_tipsOfTheDayVisitedRemoteModel, tipId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTipsOfTheDayVisitedRemoteModel() {
		return _tipsOfTheDayVisitedRemoteModel;
	}

	public void setTipsOfTheDayVisitedRemoteModel(
		BaseModel<?> tipsOfTheDayVisitedRemoteModel) {
		_tipsOfTheDayVisitedRemoteModel = tipsOfTheDayVisitedRemoteModel;
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

		Class<?> remoteModelClass = _tipsOfTheDayVisitedRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tipsOfTheDayVisitedRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TipsOfTheDayVisitedLocalServiceUtil.addTipsOfTheDayVisited(this);
		}
		else {
			TipsOfTheDayVisitedLocalServiceUtil.updateTipsOfTheDayVisited(this);
		}
	}

	@Override
	public TipsOfTheDayVisited toEscapedModel() {
		return (TipsOfTheDayVisited)ProxyUtil.newProxyInstance(TipsOfTheDayVisited.class.getClassLoader(),
			new Class[] { TipsOfTheDayVisited.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TipsOfTheDayVisitedClp clone = new TipsOfTheDayVisitedClp();

		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setTipId(getTipId());

		return clone;
	}

	@Override
	public int compareTo(TipsOfTheDayVisited tipsOfTheDayVisited) {
		TipsOfTheDayVisitedPK primaryKey = tipsOfTheDayVisited.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayVisitedClp)) {
			return false;
		}

		TipsOfTheDayVisitedClp tipsOfTheDayVisited = (TipsOfTheDayVisitedClp)obj;

		TipsOfTheDayVisitedPK primaryKey = tipsOfTheDayVisited.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", tipId=");
		sb.append(getTipId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.model.TipsOfTheDayVisited");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipId</column-name><column-value><![CDATA[");
		sb.append(getTipId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private String _tipId;
	private BaseModel<?> _tipsOfTheDayVisitedRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.service.ClpSerializer.class;
}