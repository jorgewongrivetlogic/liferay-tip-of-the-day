package com.rivetlogic.tipday.api.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.rivetlogic.services.exception.NoSuchTipsOfTheDayCategoriesException;
import com.rivetlogic.services.model.TipsOfTheDayCategories;
import com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalServiceUtil;
import com.rivetlogic.services.service.TipsOfTheDayVisitedLocalServiceUtil;
import com.rivetlogic.tipday.api.constants.WebKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

public class TipOfTheDayUtil {
	private static final Log logger = 
			LogFactoryUtil.getLog(TipOfTheDayUtil.class);
	
	/**
	 * Get selected categories in control panel.
	 *
	 * @param request the request
	 * @param themeDisplay the theme display
	 * @param categoryIds the category ids
	 * @return the long[]
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	public static long[] retrieveCategories(PortletRequest request, 
			ThemeDisplay themeDisplay, long[] categoryIds) 
		throws PortalException, SystemException {
		
		try {
			TipsOfTheDayCategories tipsCategories = 
					TipsOfTheDayCategoriesLocalServiceUtil
						.getTipsOfTheDayCategories(
								themeDisplay.getScopeGroupId());
			
			if (Validator.isNotNull(tipsCategories)) {
				categoryIds = GetterUtil.getLongValues(
						StringUtil.split(tipsCategories.getCategories()));
				
				request.setAttribute(WebKeys.TIPS_CATEGORIES_ID, 
						tipsCategories.getPrimaryKey());
			}
		} catch (NoSuchTipsOfTheDayCategoriesException e) {
			categoryIds = new long[0];
		}
		
		if (categoryIds.length > 0 ) {
			String selectedCategories = StringUtil.merge(categoryIds);
			
			request.setAttribute(WebKeys.CUR_CATEGORY_IDS, selectedCategories);
			
			if (logger.isDebugEnabled())
				logger.debug("curCategoryIds: " + selectedCategories);
		}
		
		return categoryIds;
	}
	
	/**
	 * Get a list of all categories configured for use in the portlet.
	 * 
	 * @param request
	 * @param themeDisplay
	 * @return An array with all the categories ids
	 */
	public static long[] getCategoryIds(RenderRequest request, ThemeDisplay themeDisplay) {
	    long[] categoryIds = new long[0];
	    try {
	    categoryIds = 
                TipOfTheDayUtil.retrieveCategories(
                        request, themeDisplay, categoryIds);
	    } catch(Exception e) {
	        logger.error(e);
	    }
	    return categoryIds;
	}
	
	/**
	 * Get all the article ids to be display in the popup, filtering those already seen by the user.
	 * 
	 * @param request
	 * @param categoryIds
	 * @return An array with all the article ids
	 */
	public static String[] getFilteredArticleIds(RenderRequest request, long[] categoryIds) {
	    List<JournalArticle> articles = TipOfTheDayUtil.getJournalArticlesByCategoryIds(categoryIds);
        
        articles = TipOfTheDayUtil.filterVisitedArticles(request, articles);
                
        String[] articleIds = new String[articles.size()];

        for (int i=0; i < articleIds.length; ++i) {
            articleIds[i] = articles.get(i).getArticleId();
        }
        return articleIds;
	}
	
	/**
	 * Removes tips already seen by the user if the option is enabled.
	 * 
	 * @param request
	 * @param articles
	 * @return The list of tips to display
	 */
	public static List<JournalArticle> filterVisitedArticles(RenderRequest request, List<JournalArticle> articles) {
	    
	    if((Boolean) request.getAttribute(WebKeys.SHOW_ALL_TIPS))
	        return articles;

	    if(logger.isDebugEnabled())
	        logger.debug("Filtering article ids");
	    
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    List<JournalArticle> filtered = new LinkedList<JournalArticle>();
	    List<String> visitedIds = Arrays.asList(new String[]{});
	    try {
	        visitedIds = TipOfTheDayUtil.getVisitedTips(themeDisplay);
	    } catch(SystemException e) {
	        logger.error("Error getting visited ids", e);
	    }
	    for(JournalArticle article : articles) {
	        if(!visitedIds.contains(article.getArticleId()))
	            filtered.add(article);	            
	    }
	    return filtered;
	}
	
	/**
	 * Retrieves journal articles based on a list of categories ids
	 * 
	 * @param categoryIds
	 * @return
	 */
	public static List<JournalArticle> getJournalArticlesByCategoryIds(
			long[] categoryIds) {
		List<JournalArticle> jaList = new ArrayList<JournalArticle>();
		
		if(categoryIds.length > 0) {
		
    		AssetEntryQuery q = new AssetEntryQuery();
    		q.setAnyCategoryIds(categoryIds);
    		q.setClassName(JournalArticle.class.getName());
    		
    		try {
    			
    			List<AssetEntry> assets = AssetEntryLocalServiceUtil.getEntries(q);
    			for (AssetEntry asset:assets) {
    				JournalArticle ja = 
    						JournalArticleLocalServiceUtil
    							.getLatestArticle(asset.getClassPK());
    				jaList.add(ja);
    			}
    		} catch (Exception e) {
    			logger.error(e);
    		}
		}
		return jaList;
	}
	
	/**
	 * Get the tips already seen by the user.
	 * 
	 * @param themeDisplay
	 * @return list of ids already seen by the user
	 * @throws SystemException
	 */
	public static List<String> getVisitedTips(ThemeDisplay themeDisplay) throws SystemException {
	    List<String> ids = new LinkedList<String>();
	    ids = TipsOfTheDayVisitedLocalServiceUtil.getVisitedTipsIds(
	            themeDisplay.getCompanyId(),
	            themeDisplay.getScopeGroupId(),
	            themeDisplay.getUserId());
	    return ids;
	}
	
	/**
	 * Stores the id of a tip been visited by the user.
	 * 
	 * @param request
	 * @param tipId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void saveVisitedTip(PortletRequest request, String tipId) throws PortalException, SystemException {
	    long companyId = PortalUtil.getCompanyId(request);
	    long groupId = PortalUtil.getScopeGroupId(request);
	    long userId = PortalUtil.getUserId(request);
	    TipsOfTheDayVisitedLocalServiceUtil.addVisitedTip(companyId, groupId, userId, tipId);
	}
	
}
