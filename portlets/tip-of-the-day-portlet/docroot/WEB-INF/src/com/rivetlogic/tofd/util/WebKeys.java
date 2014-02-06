/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 3
* of the License.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301, USA.
*/

package com.rivetlogic.tofd.util;

import com.rivetlogic.model.TipsOfTheDayUsers;

public class WebKeys implements com.liferay.portal.kernel.util.WebKeys {
	
	public final static String TIPS_OF_THE_DAY_USER = 
			TipsOfTheDayUsers.class.getName();
	
	public final static String UPDATE_SETTINGS = "UPDATE_SETTINGS";
	
	public final static String DISPLAY = "DISPLAY";
	
	public final static String CHANGE_USER_STATUS = "USER_STATUS";
	
	public static final String STOP_SHOWING = "stopShowing";
	
	public static final String USER_STATUS = "userStatus";
	
	public static final String DISABLE_PREV = "disablePrev";
	
	public static final String DISABLE_NEXT = "disableNext";
	
	public static final String ARTICLE_IDS = "articleIds";
	
	public static final String ARTICLE_ID = "articleId";
	
	public static final String NEXT_ARTICLE_ID = "nextArticleId";
	
	public static final String PREV_ARTICLE_ID = "prevArticleId";
	
	public static final String VISITED = "visited";
	
	public static final boolean STATUS_RECEIVE = true;
	
	public static final String CUR_CATEGORY_IDS = "curCategoryIds";
	
	public static final String TIPS_CATEGORIES_ID = "tipsCategoriesId";
}
