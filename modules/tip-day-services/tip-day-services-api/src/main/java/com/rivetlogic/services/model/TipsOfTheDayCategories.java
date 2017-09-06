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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TipsOfTheDayCategories service. Represents a row in the &quot;rivetlogic_tipday_TipsOfTheDayCategories&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesModel
 * @see com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesImpl
 * @see com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesModelImpl
 * @generated
 */
@ImplementationClassName("com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesImpl")
@ProviderType
public interface TipsOfTheDayCategories extends TipsOfTheDayCategoriesModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.services.model.impl.TipsOfTheDayCategoriesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TipsOfTheDayCategories, Long> GROUP_ID_ACCESSOR =
		new Accessor<TipsOfTheDayCategories, Long>() {
			@Override
			public Long get(TipsOfTheDayCategories tipsOfTheDayCategories) {
				return tipsOfTheDayCategories.getGroupId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipsOfTheDayCategories> getTypeClass() {
				return TipsOfTheDayCategories.class;
			}
		};
}