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

package com.rivetlogic.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.model.TipsOfTheDayUsers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipsOfTheDayUsers in entity cache.
 *
 * @author juancarrillo
 * @see TipsOfTheDayUsers
 * @generated
 */
public class TipsOfTheDayUsersCacheModel implements CacheModel<TipsOfTheDayUsers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{tipUserId=");
		sb.append(tipUserId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", showAll=");
		sb.append(showAll);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipsOfTheDayUsers toEntityModel() {
		TipsOfTheDayUsersImpl tipsOfTheDayUsersImpl = new TipsOfTheDayUsersImpl();

		tipsOfTheDayUsersImpl.setTipUserId(tipUserId);
		tipsOfTheDayUsersImpl.setCompanyId(companyId);
		tipsOfTheDayUsersImpl.setGroupId(groupId);
		tipsOfTheDayUsersImpl.setUserId(userId);

		if (status == null) {
			tipsOfTheDayUsersImpl.setStatus(StringPool.BLANK);
		}
		else {
			tipsOfTheDayUsersImpl.setStatus(status);
		}

		tipsOfTheDayUsersImpl.setShowAll(showAll);

		tipsOfTheDayUsersImpl.resetOriginalValues();

		return tipsOfTheDayUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tipUserId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		status = objectInput.readUTF();
		showAll = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tipUserId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeBoolean(showAll);
	}

	public long tipUserId;
	public long companyId;
	public long groupId;
	public long userId;
	public String status;
	public boolean showAll;
}