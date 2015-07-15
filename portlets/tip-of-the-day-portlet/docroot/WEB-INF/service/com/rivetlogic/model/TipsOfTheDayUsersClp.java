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
import com.rivetlogic.service.TipsOfTheDayUsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class TipsOfTheDayUsersClp extends BaseModelImpl<TipsOfTheDayUsers>
	implements TipsOfTheDayUsers {
	public TipsOfTheDayUsersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TipsOfTheDayUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TipsOfTheDayUsers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tipUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTipUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tipUserId", getTipUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("status", getStatus());
		attributes.put("showAll", getShowAll());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tipUserId = (Long)attributes.get("tipUserId");

		if (tipUserId != null) {
			setTipUserId(tipUserId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean showAll = (Boolean)attributes.get("showAll");

		if (showAll != null) {
			setShowAll(showAll);
		}
	}

	@Override
	public long getTipUserId() {
		return _tipUserId;
	}

	@Override
	public void setTipUserId(long tipUserId) {
		_tipUserId = tipUserId;

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTipUserId", long.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, tipUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getTipUserId(), "uuid", _tipUserUuid);
	}

	@Override
	public void setTipUserUuid(String tipUserUuid) {
		_tipUserUuid = tipUserUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, companyId);
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

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, userId);
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
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getShowAll() {
		return _showAll;
	}

	@Override
	public boolean isShowAll() {
		return _showAll;
	}

	@Override
	public void setShowAll(boolean showAll) {
		_showAll = showAll;

		if (_tipsOfTheDayUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tipsOfTheDayUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setShowAll", boolean.class);

				method.invoke(_tipsOfTheDayUsersRemoteModel, showAll);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTipsOfTheDayUsersRemoteModel() {
		return _tipsOfTheDayUsersRemoteModel;
	}

	public void setTipsOfTheDayUsersRemoteModel(
		BaseModel<?> tipsOfTheDayUsersRemoteModel) {
		_tipsOfTheDayUsersRemoteModel = tipsOfTheDayUsersRemoteModel;
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

		Class<?> remoteModelClass = _tipsOfTheDayUsersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tipsOfTheDayUsersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TipsOfTheDayUsersLocalServiceUtil.addTipsOfTheDayUsers(this);
		}
		else {
			TipsOfTheDayUsersLocalServiceUtil.updateTipsOfTheDayUsers(this);
		}
	}

	@Override
	public TipsOfTheDayUsers toEscapedModel() {
		return (TipsOfTheDayUsers)ProxyUtil.newProxyInstance(TipsOfTheDayUsers.class.getClassLoader(),
			new Class[] { TipsOfTheDayUsers.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TipsOfTheDayUsersClp clone = new TipsOfTheDayUsersClp();

		clone.setTipUserId(getTipUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setStatus(getStatus());
		clone.setShowAll(getShowAll());

		return clone;
	}

	@Override
	public int compareTo(TipsOfTheDayUsers tipsOfTheDayUsers) {
		long primaryKey = tipsOfTheDayUsers.getPrimaryKey();

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

		if (!(obj instanceof TipsOfTheDayUsersClp)) {
			return false;
		}

		TipsOfTheDayUsersClp tipsOfTheDayUsers = (TipsOfTheDayUsersClp)obj;

		long primaryKey = tipsOfTheDayUsers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{tipUserId=");
		sb.append(getTipUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", showAll=");
		sb.append(getShowAll());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.model.TipsOfTheDayUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tipUserId</column-name><column-value><![CDATA[");
		sb.append(getTipUserId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showAll</column-name><column-value><![CDATA[");
		sb.append(getShowAll());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tipUserId;
	private String _tipUserUuid;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _status;
	private boolean _showAll;
	private BaseModel<?> _tipsOfTheDayUsersRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.service.ClpSerializer.class;
}