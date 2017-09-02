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
 * The extended model interface for the TipsOfTheDayVisited service. Represents a row in the &quot;rivetlogic_tipday_TipsOfTheDayVisited&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisitedModel
 * @see com.rivetlogic.services.model.impl.TipsOfTheDayVisitedImpl
 * @see com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl
 * @generated
 */
@ImplementationClassName("com.rivetlogic.services.model.impl.TipsOfTheDayVisitedImpl")
@ProviderType
public interface TipsOfTheDayVisited extends TipsOfTheDayVisitedModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TipsOfTheDayVisited, Long> USER_ID_ACCESSOR = new Accessor<TipsOfTheDayVisited, Long>() {
			@Override
			public Long get(TipsOfTheDayVisited tipsOfTheDayVisited) {
				return tipsOfTheDayVisited.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipsOfTheDayVisited> getTypeClass() {
				return TipsOfTheDayVisited.class;
			}
		};

	public static final Accessor<TipsOfTheDayVisited, Long> COMPANY_ID_ACCESSOR = new Accessor<TipsOfTheDayVisited, Long>() {
			@Override
			public Long get(TipsOfTheDayVisited tipsOfTheDayVisited) {
				return tipsOfTheDayVisited.getCompanyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipsOfTheDayVisited> getTypeClass() {
				return TipsOfTheDayVisited.class;
			}
		};

	public static final Accessor<TipsOfTheDayVisited, Long> GROUP_ID_ACCESSOR = new Accessor<TipsOfTheDayVisited, Long>() {
			@Override
			public Long get(TipsOfTheDayVisited tipsOfTheDayVisited) {
				return tipsOfTheDayVisited.getGroupId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipsOfTheDayVisited> getTypeClass() {
				return TipsOfTheDayVisited.class;
			}
		};

	public static final Accessor<TipsOfTheDayVisited, String> TIP_ID_ACCESSOR = new Accessor<TipsOfTheDayVisited, String>() {
			@Override
			public String get(TipsOfTheDayVisited tipsOfTheDayVisited) {
				return tipsOfTheDayVisited.getTipId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<TipsOfTheDayVisited> getTypeClass() {
				return TipsOfTheDayVisited.class;
			}
		};
}