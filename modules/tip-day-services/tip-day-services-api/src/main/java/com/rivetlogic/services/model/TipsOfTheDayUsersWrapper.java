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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TipsOfTheDayUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsers
 * @generated
 */
@ProviderType
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
	public TipsOfTheDayUsers toEscapedModel() {
		return new TipsOfTheDayUsersWrapper(_tipsOfTheDayUsers.toEscapedModel());
	}

	@Override
	public TipsOfTheDayUsers toUnescapedModel() {
		return new TipsOfTheDayUsersWrapper(_tipsOfTheDayUsers.toUnescapedModel());
	}

	/**
	* Returns the show all of this Tips of the Day Users.
	*
	* @return the show all of this Tips of the Day Users
	*/
	@Override
	public boolean getShowAll() {
		return _tipsOfTheDayUsers.getShowAll();
	}

	@Override
	public boolean isCachedModel() {
		return _tipsOfTheDayUsers.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipsOfTheDayUsers.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipsOfTheDayUsers.isNew();
	}

	/**
	* Returns <code>true</code> if this Tips of the Day Users is show all.
	*
	* @return <code>true</code> if this Tips of the Day Users is show all; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowAll() {
		return _tipsOfTheDayUsers.isShowAll();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipsOfTheDayUsers.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TipsOfTheDayUsers> toCacheModel() {
		return _tipsOfTheDayUsers.toCacheModel();
	}

	@Override
	public int compareTo(TipsOfTheDayUsers tipsOfTheDayUsers) {
		return _tipsOfTheDayUsers.compareTo(tipsOfTheDayUsers);
	}

	@Override
	public int hashCode() {
		return _tipsOfTheDayUsers.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipsOfTheDayUsers.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipsOfTheDayUsersWrapper((TipsOfTheDayUsers)_tipsOfTheDayUsers.clone());
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
	* Returns the tip user uuid of this Tips of the Day Users.
	*
	* @return the tip user uuid of this Tips of the Day Users
	*/
	@Override
	public java.lang.String getTipUserUuid() {
		return _tipsOfTheDayUsers.getTipUserUuid();
	}

	/**
	* Returns the user uuid of this Tips of the Day Users.
	*
	* @return the user uuid of this Tips of the Day Users
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tipsOfTheDayUsers.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _tipsOfTheDayUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipsOfTheDayUsers.toXmlString();
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
	* Returns the group ID of this Tips of the Day Users.
	*
	* @return the group ID of this Tips of the Day Users
	*/
	@Override
	public long getGroupId() {
		return _tipsOfTheDayUsers.getGroupId();
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
	* Returns the tip user ID of this Tips of the Day Users.
	*
	* @return the tip user ID of this Tips of the Day Users
	*/
	@Override
	public long getTipUserId() {
		return _tipsOfTheDayUsers.getTipUserId();
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

	@Override
	public void persist() {
		_tipsOfTheDayUsers.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipsOfTheDayUsers.setCachedModel(cachedModel);
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

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipsOfTheDayUsers.setExpandoBridgeAttributes(serviceContext);
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

	@Override
	public void setNew(boolean n) {
		_tipsOfTheDayUsers.setNew(n);
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

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipsOfTheDayUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this Tips of the Day Users is show all.
	*
	* @param showAll the show all of this Tips of the Day Users
	*/
	@Override
	public void setShowAll(boolean showAll) {
		_tipsOfTheDayUsers.setShowAll(showAll);
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
	* Sets the tip user uuid of this Tips of the Day Users.
	*
	* @param tipUserUuid the tip user uuid of this Tips of the Day Users
	*/
	@Override
	public void setTipUserUuid(java.lang.String tipUserUuid) {
		_tipsOfTheDayUsers.setTipUserUuid(tipUserUuid);
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
	* Sets the user uuid of this Tips of the Day Users.
	*
	* @param userUuid the user uuid of this Tips of the Day Users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tipsOfTheDayUsers.setUserUuid(userUuid);
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

		if (Objects.equals(_tipsOfTheDayUsers,
					tipsOfTheDayUsersWrapper._tipsOfTheDayUsers)) {
			return true;
		}

		return false;
	}

	@Override
	public TipsOfTheDayUsers getWrappedModel() {
		return _tipsOfTheDayUsers;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipsOfTheDayUsers.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipsOfTheDayUsers.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipsOfTheDayUsers.resetOriginalValues();
	}

	private final TipsOfTheDayUsers _tipsOfTheDayUsers;
}