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
 * This class is a wrapper for {@link TipsOfTheDayVisited}.
 * </p>
 *
 * @author juancarrillo
 * @see TipsOfTheDayVisited
 * @generated
 */
public class TipsOfTheDayVisitedWrapper implements TipsOfTheDayVisited,
	ModelWrapper<TipsOfTheDayVisited> {
	public TipsOfTheDayVisitedWrapper(TipsOfTheDayVisited tipsOfTheDayVisited) {
		_tipsOfTheDayVisited = tipsOfTheDayVisited;
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

	/**
	* Returns the primary key of this Tips of the Day Visited.
	*
	* @return the primary key of this Tips of the Day Visited
	*/
	@Override
	public com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK getPrimaryKey() {
		return _tipsOfTheDayVisited.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Tips of the Day Visited.
	*
	* @param primaryKey the primary key of this Tips of the Day Visited
	*/
	@Override
	public void setPrimaryKey(
		com.rivetlogic.service.persistence.TipsOfTheDayVisitedPK primaryKey) {
		_tipsOfTheDayVisited.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this Tips of the Day Visited.
	*
	* @return the user ID of this Tips of the Day Visited
	*/
	@Override
	public long getUserId() {
		return _tipsOfTheDayVisited.getUserId();
	}

	/**
	* Sets the user ID of this Tips of the Day Visited.
	*
	* @param userId the user ID of this Tips of the Day Visited
	*/
	@Override
	public void setUserId(long userId) {
		_tipsOfTheDayVisited.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Tips of the Day Visited.
	*
	* @return the user uuid of this Tips of the Day Visited
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipsOfTheDayVisited.getUserUuid();
	}

	/**
	* Sets the user uuid of this Tips of the Day Visited.
	*
	* @param userUuid the user uuid of this Tips of the Day Visited
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tipsOfTheDayVisited.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this Tips of the Day Visited.
	*
	* @return the company ID of this Tips of the Day Visited
	*/
	@Override
	public long getCompanyId() {
		return _tipsOfTheDayVisited.getCompanyId();
	}

	/**
	* Sets the company ID of this Tips of the Day Visited.
	*
	* @param companyId the company ID of this Tips of the Day Visited
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tipsOfTheDayVisited.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this Tips of the Day Visited.
	*
	* @return the group ID of this Tips of the Day Visited
	*/
	@Override
	public long getGroupId() {
		return _tipsOfTheDayVisited.getGroupId();
	}

	/**
	* Sets the group ID of this Tips of the Day Visited.
	*
	* @param groupId the group ID of this Tips of the Day Visited
	*/
	@Override
	public void setGroupId(long groupId) {
		_tipsOfTheDayVisited.setGroupId(groupId);
	}

	/**
	* Returns the tip ID of this Tips of the Day Visited.
	*
	* @return the tip ID of this Tips of the Day Visited
	*/
	@Override
	public java.lang.String getTipId() {
		return _tipsOfTheDayVisited.getTipId();
	}

	/**
	* Sets the tip ID of this Tips of the Day Visited.
	*
	* @param tipId the tip ID of this Tips of the Day Visited
	*/
	@Override
	public void setTipId(java.lang.String tipId) {
		_tipsOfTheDayVisited.setTipId(tipId);
	}

	@Override
	public boolean isNew() {
		return _tipsOfTheDayVisited.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tipsOfTheDayVisited.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tipsOfTheDayVisited.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipsOfTheDayVisited.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tipsOfTheDayVisited.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tipsOfTheDayVisited.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipsOfTheDayVisited.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipsOfTheDayVisited.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tipsOfTheDayVisited.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tipsOfTheDayVisited.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipsOfTheDayVisited.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TipsOfTheDayVisitedWrapper((TipsOfTheDayVisited)_tipsOfTheDayVisited.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.model.TipsOfTheDayVisited tipsOfTheDayVisited) {
		return _tipsOfTheDayVisited.compareTo(tipsOfTheDayVisited);
	}

	@Override
	public int hashCode() {
		return _tipsOfTheDayVisited.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.model.TipsOfTheDayVisited> toCacheModel() {
		return _tipsOfTheDayVisited.toCacheModel();
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited toEscapedModel() {
		return new TipsOfTheDayVisitedWrapper(_tipsOfTheDayVisited.toEscapedModel());
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayVisited toUnescapedModel() {
		return new TipsOfTheDayVisitedWrapper(_tipsOfTheDayVisited.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipsOfTheDayVisited.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipsOfTheDayVisited.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipsOfTheDayVisited.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayVisitedWrapper)) {
			return false;
		}

		TipsOfTheDayVisitedWrapper tipsOfTheDayVisitedWrapper = (TipsOfTheDayVisitedWrapper)obj;

		if (Validator.equals(_tipsOfTheDayVisited,
					tipsOfTheDayVisitedWrapper._tipsOfTheDayVisited)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TipsOfTheDayVisited getWrappedTipsOfTheDayVisited() {
		return _tipsOfTheDayVisited;
	}

	@Override
	public TipsOfTheDayVisited getWrappedModel() {
		return _tipsOfTheDayVisited;
	}

	@Override
	public void resetOriginalValues() {
		_tipsOfTheDayVisited.resetOriginalValues();
	}

	private TipsOfTheDayVisited _tipsOfTheDayVisited;
}