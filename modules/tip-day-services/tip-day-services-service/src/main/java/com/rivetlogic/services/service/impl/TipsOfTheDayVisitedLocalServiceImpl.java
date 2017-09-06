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

package com.rivetlogic.services.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.services.exception.NoSuchTipsOfTheDayVisitedException;
import com.rivetlogic.services.model.TipsOfTheDayVisited;
import com.rivetlogic.services.service.base.TipsOfTheDayVisitedLocalServiceBaseImpl;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK;

import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the Tips of the Day Visited local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayVisitedLocalServiceBaseImpl
 * @see com.rivetlogic.services.service.TipsOfTheDayVisitedLocalServiceUtil
 */
public class TipsOfTheDayVisitedLocalServiceImpl
	extends TipsOfTheDayVisitedLocalServiceBaseImpl {
	
	private static final Log logger = 
            LogFactoryUtil.getLog(TipsOfTheDayVisitedLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.rivetlogic.services.service.TipsOfTheDayVisitedLocalServiceUtil} to access the Tips of the Day Visited local service.
	 */
	
	public void addVisitedTip(long companyId, long groupId, long userId, String tipId) throws SystemException {
        TipsOfTheDayVisitedPK pk = new TipsOfTheDayVisitedPK(userId, companyId, groupId, tipId);
        TipsOfTheDayVisited tipVisited;
        try {
            tipVisited = tipsOfTheDayVisitedPersistence.findByPrimaryKey(pk);
            if(logger.isDebugEnabled())
                logger.debug("Tip already visited " + tipId);
        } catch (NoSuchTipsOfTheDayVisitedException e) {
            tipVisited = tipsOfTheDayVisitedPersistence.create(pk);
            tipsOfTheDayVisitedPersistence.update(tipVisited);
        }
    }
    
    public List<TipsOfTheDayVisited> getVisitedTips(long companyId, long groupId, long userId) throws SystemException {
        return tipsOfTheDayVisitedPersistence.findByC_G_U(companyId, groupId, userId);
    }
    
    public List<String> getVisitedTipsIds(long companyId, long groupId, long userId) throws SystemException {
        List<String> ids = new LinkedList<String>();
        List<TipsOfTheDayVisited> tips = getVisitedTips(companyId, groupId, userId);
        for(TipsOfTheDayVisited tip : tips)
            ids.add(tip.getTipId());
        return ids;
    }
    
    
}