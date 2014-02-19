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
 * This class is a wrapper for {@link TipsOfTheDayCategories}.
 * </p>
 *
 * @author juancarrillo
 * @see TipsOfTheDayCategories
 * @generated
 */
public class TipsOfTheDayCategoriesWrapper implements TipsOfTheDayCategories,
	ModelWrapper<TipsOfTheDayCategories> {
	public TipsOfTheDayCategoriesWrapper(
		TipsOfTheDayCategories tipsOfTheDayCategories) {
		_tipsOfTheDayCategories = tipsOfTheDayCategories;
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

	/**
	* Returns the primary key of this Tips of the Day Categories.
	*
	* @return the primary key of this Tips of the Day Categories
	*/
	@Override
	public long getPrimaryKey() {
		return _tipsOfTheDayCategories.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Tips of the Day Categories.
	*
	* @param primaryKey the primary key of this Tips of the Day Categories
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipsOfTheDayCategories.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this Tips of the Day Categories.
	*
	* @return the group ID of this Tips of the Day Categories
	*/
	@Override
	public long getGroupId() {
		return _tipsOfTheDayCategories.getGroupId();
	}

	/**
	* Sets the group ID of this Tips of the Day Categories.
	*
	* @param groupId the group ID of this Tips of the Day Categories
	*/
	@Override
	public void setGroupId(long groupId) {
		_tipsOfTheDayCategories.setGroupId(groupId);
	}

	/**
	* Returns the categories of this Tips of the Day Categories.
	*
	* @return the categories of this Tips of the Day Categories
	*/
	@Override
	public java.lang.String getCategories() {
		return _tipsOfTheDayCategories.getCategories();
	}

	/**
	* Sets the categories of this Tips of the Day Categories.
	*
	* @param categories the categories of this Tips of the Day Categories
	*/
	@Override
	public void setCategories(java.lang.String categories) {
		_tipsOfTheDayCategories.setCategories(categories);
	}

	@Override
	public boolean isNew() {
		return _tipsOfTheDayCategories.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tipsOfTheDayCategories.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tipsOfTheDayCategories.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipsOfTheDayCategories.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tipsOfTheDayCategories.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tipsOfTheDayCategories.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipsOfTheDayCategories.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipsOfTheDayCategories.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tipsOfTheDayCategories.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tipsOfTheDayCategories.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipsOfTheDayCategories.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TipsOfTheDayCategoriesWrapper((TipsOfTheDayCategories)_tipsOfTheDayCategories.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.model.TipsOfTheDayCategories tipsOfTheDayCategories) {
		return _tipsOfTheDayCategories.compareTo(tipsOfTheDayCategories);
	}

	@Override
	public int hashCode() {
		return _tipsOfTheDayCategories.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.model.TipsOfTheDayCategories> toCacheModel() {
		return _tipsOfTheDayCategories.toCacheModel();
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories toEscapedModel() {
		return new TipsOfTheDayCategoriesWrapper(_tipsOfTheDayCategories.toEscapedModel());
	}

	@Override
	public com.rivetlogic.model.TipsOfTheDayCategories toUnescapedModel() {
		return new TipsOfTheDayCategoriesWrapper(_tipsOfTheDayCategories.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipsOfTheDayCategories.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipsOfTheDayCategories.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipsOfTheDayCategories.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayCategoriesWrapper)) {
			return false;
		}

		TipsOfTheDayCategoriesWrapper tipsOfTheDayCategoriesWrapper = (TipsOfTheDayCategoriesWrapper)obj;

		if (Validator.equals(_tipsOfTheDayCategories,
					tipsOfTheDayCategoriesWrapper._tipsOfTheDayCategories)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TipsOfTheDayCategories getWrappedTipsOfTheDayCategories() {
		return _tipsOfTheDayCategories;
	}

	@Override
	public TipsOfTheDayCategories getWrappedModel() {
		return _tipsOfTheDayCategories;
	}

	@Override
	public void resetOriginalValues() {
		_tipsOfTheDayCategories.resetOriginalValues();
	}

	private TipsOfTheDayCategories _tipsOfTheDayCategories;
}