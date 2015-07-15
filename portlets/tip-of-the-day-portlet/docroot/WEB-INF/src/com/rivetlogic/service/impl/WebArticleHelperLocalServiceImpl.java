/**
 * Copyright (c) 2014 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.persistence.AssetEntryFinderUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.rivetlogic.service.base.WebArticleHelperLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the Web Article helper local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.service.WebArticleHelperLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author juancarrillo
 * @see com.rivetlogic.service.base.WebArticleHelperLocalServiceBaseImpl
 * @see com.rivetlogic.service.WebArticleHelperLocalServiceUtil
 */
public class WebArticleHelperLocalServiceImpl
	extends WebArticleHelperLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.service.WebArticleHelperLocalServiceUtil} to access the Web Article helper local service.
	 */
	
	public int countJournalArticlesByCategoryIds(List<Long> categoryIds ) {
		int count = 0;
		
		if (categoryIds != null && categoryIds.size() > 0) {
			AssetEntryQuery q = new AssetEntryQuery();
			q.setAllCategoryIds(
					ArrayUtil.toArray(categoryIds.toArray(
							new Long[categoryIds.size()])));
			
			q.setClassName(JournalArticle.class.getName());
			
			try {
				count = AssetEntryFinderUtil.countEntries(q);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
		
		return count;
	}
	
	public List<JournalArticle> getJournalArticlesByCategoryIds(
			long[] categoryIds) {
		
		List<JournalArticle> jaList = new ArrayList<JournalArticle>();
		
		AssetEntryQuery q = new AssetEntryQuery();
		q.setAnyCategoryIds(categoryIds);
		q.setClassName(JournalArticle.class.getName());
		
		try {
			List<AssetEntry> assets = AssetEntryFinderUtil.findEntries(q);
			for (AssetEntry asset:assets) {
				JournalArticle ja = 
						JournalArticleLocalServiceUtil
							.getLatestArticle(asset.getClassPK());
				jaList.add(ja);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return jaList;
	}
	
	private static Log _log = 
			LogFactoryUtil.getLog(WebArticleHelperLocalServiceImpl.class); 
}