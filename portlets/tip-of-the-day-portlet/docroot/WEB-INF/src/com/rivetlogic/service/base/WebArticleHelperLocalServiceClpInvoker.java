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

package com.rivetlogic.service.base;

import com.rivetlogic.service.WebArticleHelperLocalServiceUtil;

import java.util.Arrays;

/**
 * @author juancarrillo
 * @generated
 */
public class WebArticleHelperLocalServiceClpInvoker {
	public WebArticleHelperLocalServiceClpInvoker() {
		_methodName34 = "getBeanIdentifier";

		_methodParameterTypes34 = new String[] {  };

		_methodName35 = "setBeanIdentifier";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName38 = "countJournalArticlesByCategoryIds";

		_methodParameterTypes38 = new String[] { "java.util.List" };

		_methodName39 = "getJournalArticlesByCategoryIds";

		_methodParameterTypes39 = new String[] { "long[][]" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return WebArticleHelperLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			WebArticleHelperLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return WebArticleHelperLocalServiceUtil.countJournalArticlesByCategoryIds((java.util.List<java.lang.Long>)arguments[0]);
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return WebArticleHelperLocalServiceUtil.getJournalArticlesByCategoryIds((long[])arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
}