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

import com.rivetlogic.model.TipsOfTheDayCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipsOfTheDayCategories in entity cache.
 *
 * @author juancarrillo
 * @see TipsOfTheDayCategories
 * @generated
 */
public class TipsOfTheDayCategoriesCacheModel implements CacheModel<TipsOfTheDayCategories>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", categories=");
		sb.append(categories);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipsOfTheDayCategories toEntityModel() {
		TipsOfTheDayCategoriesImpl tipsOfTheDayCategoriesImpl = new TipsOfTheDayCategoriesImpl();

		tipsOfTheDayCategoriesImpl.setGroupId(groupId);

		if (categories == null) {
			tipsOfTheDayCategoriesImpl.setCategories(StringPool.BLANK);
		}
		else {
			tipsOfTheDayCategoriesImpl.setCategories(categories);
		}

		tipsOfTheDayCategoriesImpl.resetOriginalValues();

		return tipsOfTheDayCategoriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		categories = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupId);

		if (categories == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categories);
		}
	}

	public long groupId;
	public String categories;
}