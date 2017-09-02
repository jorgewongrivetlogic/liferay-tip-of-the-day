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

package com.rivetlogic.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.services.model.TipsOfTheDayVisited;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipsOfTheDayVisited in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisited
 * @generated
 */
@ProviderType
public class TipsOfTheDayVisitedCacheModel implements CacheModel<TipsOfTheDayVisited>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayVisitedCacheModel)) {
			return false;
		}

		TipsOfTheDayVisitedCacheModel tipsOfTheDayVisitedCacheModel = (TipsOfTheDayVisitedCacheModel)obj;

		if (tipsOfTheDayVisitedPK.equals(
					tipsOfTheDayVisitedCacheModel.tipsOfTheDayVisitedPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tipsOfTheDayVisitedPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", tipId=");
		sb.append(tipId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipsOfTheDayVisited toEntityModel() {
		TipsOfTheDayVisitedImpl tipsOfTheDayVisitedImpl = new TipsOfTheDayVisitedImpl();

		tipsOfTheDayVisitedImpl.setUserId(userId);
		tipsOfTheDayVisitedImpl.setCompanyId(companyId);
		tipsOfTheDayVisitedImpl.setGroupId(groupId);

		if (tipId == null) {
			tipsOfTheDayVisitedImpl.setTipId(StringPool.BLANK);
		}
		else {
			tipsOfTheDayVisitedImpl.setTipId(tipId);
		}

		tipsOfTheDayVisitedImpl.resetOriginalValues();

		return tipsOfTheDayVisitedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		tipId = objectInput.readUTF();

		tipsOfTheDayVisitedPK = new TipsOfTheDayVisitedPK(userId, companyId,
				groupId, tipId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (tipId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipId);
		}
	}

	public long userId;
	public long companyId;
	public long groupId;
	public String tipId;
	public transient TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK;
}