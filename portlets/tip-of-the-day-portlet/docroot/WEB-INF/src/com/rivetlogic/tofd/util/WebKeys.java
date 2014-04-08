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

/**
 * The Class WebKeys.
 */
public class WebKeys implements com.liferay.portal.kernel.util.WebKeys {
	
	/** The Constant TIPS_OF_THE_DAY_USER. */
	public final static String TIPS_OF_THE_DAY_USER = 
			TipsOfTheDayUsers.class.getName();
	
	/** The Constant UPDATE_SETTINGS. */
	public final static String UPDATE_SETTINGS = "UPDATE_SETTINGS";
	
	/** The Constant DISPLAY. */
	public final static String DISPLAY = "DISPLAY";
	
	/** The Constant CHANGE_USER_STATUS. */
	public final static String CHANGE_USER_STATUS = "USER_STATUS";
	
	/** The Constant STOP_SHOWING. */
	public static final String STOP_SHOWING = "stopShowing";
	
	/** The Constant USER_STATUS. */
	public static final String USER_STATUS = "userStatus";
	
	/** The Constant DISABLE_PREV. */
	public static final String DISABLE_PREV = "disablePrev";
	
	/** The Constant DISABLE_NEXT. */
	public static final String DISABLE_NEXT = "disableNext";
	
	/** The Constant ARTICLE_IDS. */
	public static final String ARTICLE_IDS = "articleIds";
	
	/** The Constant ARTICLE_ID. */
	public static final String ARTICLE_ID = "articleId";
	
	/** The Constant NEXT_ARTICLE_ID. */
	public static final String NEXT_ARTICLE_ID = "nextArticleId";
	
	/** The Constant PREV_ARTICLE_ID. */
	public static final String PREV_ARTICLE_ID = "prevArticleId";
	
	/** The Constant VISITED. */
	public static final String VISITED = "visited";
	
	/** The Constant STATUS_RECEIVE. */
	public static final boolean STATUS_RECEIVE = true;
	
	/** The Constant CUR_CATEGORY_IDS. */
	public static final String CUR_CATEGORY_IDS = "curCategoryIds";
	
	/** The Constant TIPS_CATEGORIES_ID. */
	public static final String TIPS_CATEGORIES_ID = "tipsCategoriesId";
	
	/** The Constant MVC_PATH. */
	public static final String MVC_PATH = "mvcPath";
	
	/** The Constant ASSET_CATEGORY_IDS. */
	public static final String ASSET_CATEGORY_IDS = "assetCategoryIds";
}
