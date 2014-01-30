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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TipsOfTheDayUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsers
 * @generated
 */
public class TipsOfTheDayUsersWrapper implements TipsOfTheDayUsers,
	ModelWrapper<TipsOfTheDayUsers> {
	public TipsOfTheDayUsersWrapper(TipsOfTheDayUsers tipsOfTheDayUsers) {
		_tipsOfTheDayUsers = tipsOfTheDayUsers;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tipUserId", getTipUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("status", getStatus());

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
	}

	/**
	* Returns the primary key of this Tips of the Day Users.
	*
	* @return the primary key of this Tips of the Day Users
	*/
	@Override
	public long getPrimaryKey() {
		return _tipsOfTheDayUsers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Tips of the Day Users.
	*
	* @param primaryKey the primary key of this Tips of the Day Users
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipsOfTheDayUsers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tip user ID of this Tips of the Day Users.
	*
	* @return the tip user ID of this Tips of the Day Users
	*/
	@Override
	public long getTipUserId() {
		return _tipsOfTheDayUsers.getTipUserId();
	}

	/**
	* Sets the tip user ID of this Tips of the Day Users.
	*
	* @param tipUserId the tip user ID of this Tips of the Day Users
	*/
	@Override
	public void setTipUserId(long tipUserId) {
		_tipsOfTheDayUsers.setTipUserId(tipUserId);
	}

	/**
	* Returns the tip user uuid of this Tips of the Day Users.
	*
	* @return the tip user uuid of this Tips of the Day Users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getTipUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsers.getTipUserUuid();
	}

	/**
	* Sets the tip user uuid of this Tips of the Day Users.
	*
	* @param tipUserUuid the tip user uuid of this Tips of the Day Users
	*/
	@Override
	public void setTipUserUuid(java.lang.String tipUserUuid) {
		_tipsOfTheDayUsers.setTipUserUuid(tipUserUuid);
	}

	/**
	* Returns the company ID of this Tips of the Day Users.
	*
	* @return the company ID of this Tips of the Day Users
	*/
	@Override
	public long getCompanyId() {
		return _tipsOfTheDayUsers.getCompanyId();
	}

	/**
	* Sets the company ID of this Tips of the Day Users.
	*
	* @param companyId the company ID of this Tips of the Day Users
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tipsOfTheDayUsers.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this Tips of the Day Users.
	*
	* @return the group ID of this Tips of the Day Users
	*/
	@Override
	public long getGroupId() {
		return _tipsOfTheDayUsers.getGroupId();
	}

	/**
	* Sets the group ID of this Tips of the Day Users.
	*
	* @param groupId the group ID of this Tips of the Day Users
	*/
	@Override
	public void setGroupId(long groupId) {
		_tipsOfTheDayUsers.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this Tips of the Day Users.
	*
	* @return the user ID of this Tips of the Day Users
	*/
	@Override
	public long getUserId() {
		return _tipsOfTheDayUsers.getUserId();
	}

	/**
	* Sets the user ID of this Tips of the Day Users.
	*
	* @param userId the user ID of this Tips of the Day Users
	*/
	@Override
	public void setUserId(long userId) {
		_tipsOfTheDayUsers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Tips of the Day Users.
	*
	* @return the user uuid of this Tips of the Day Users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayUsers.getUserUuid();
	}

	/**
	* Sets the user uuid of this Tips of the Day Users.
	*
	* @param userUuid the user uuid of this Tips of the Day Users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tipsOfTheDayUsers.setUserUuid(userUuid);
	}

	/**
	* Returns the status of this Tips of the Day Users.
	*
	* @return the status of this Tips of the Day Users
	*/
	@Override
	public java.lang.String getStatus() {
		return _tipsOfTheDayUsers.getStatus();
	}

	/**
	* Sets the status of this Tips of the Day Users.
	*
	* @param status the status of this Tips of the Day Users
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_tipsOfTheDayUsers.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _tipsOfTheDayUsers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tipsOfTheDayUsers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tipsOfTheDayUsers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipsOfTheDayUsers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tipsOfTheDayUsers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tipsOfTheDayUsers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipsOfTheDayUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipsOfTheDayUsers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TipsOfTheDayUsersWrapper((TipsOfTheDayUsers)_tipsOfTheDayUsers.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.model.TipsOfTheDayUsers tipsOfTheDayUsers) {
		return _tipsOfTheDayUsers.compareTo(tipsOfTheDayUsers);
	}

	@Override
	public int hashCode() {
		return _tipsOfTheDayUsers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.model.TipsOfTheDayUsers> toCacheModel() {
		return _tipsOfTheDayUsers.toCacheModel();
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers toEscapedModel() {
		return new TipsOfTheDayUsersWrapper(_tipsOfTheDayUsers.toEscapedModel());
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayUsers toUnescapedModel() {
		return new TipsOfTheDayUsersWrapper(_tipsOfTheDayUsers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipsOfTheDayUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipsOfTheDayUsers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipsOfTheDayUsers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayUsersWrapper)) {
			return false;
		}

		TipsOfTheDayUsersWrapper tipsOfTheDayUsersWrapper = (TipsOfTheDayUsersWrapper)obj;

		if (Validator.equals(_tipsOfTheDayUsers,
					tipsOfTheDayUsersWrapper._tipsOfTheDayUsers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TipsOfTheDayUsers getWrappedTipsOfTheDayUsers() {
		return _tipsOfTheDayUsers;
	}

	@Override
	public TipsOfTheDayUsers getWrappedModel() {
		return _tipsOfTheDayUsers;
	}

	@Override
	public void resetOriginalValues() {
		_tipsOfTheDayUsers.resetOriginalValues();
	}

	private TipsOfTheDayUsers _tipsOfTheDayUsers;
}