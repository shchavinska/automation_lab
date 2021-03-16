package ebaytests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import ebay.pages.HomePage;
import ebay.pages.ProductPage;
import ebay.pages.SearchResItem;
import ebay.pages.SearchResultPage;

public class FiltersCheck extends AbstractTest {
	
    @Test(description = "0009")
    @MethodOwner(owner = "ashchavinska")
    public void checkAuctionFilter() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Search item on eBay
        final String search = "iPhone";
        SearchResultPage searchResPage = homePage.search(search);
        // Verify search result
        List<SearchResItem> searchRes = searchResPage.getSearchRes(); 
        Assert.assertTrue(searchRes.size()>0, "Search result is fail");
        for (SearchResItem item : searchRes) {
        	Assert.assertTrue(item.getTittle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
        
        // Verify auction filter
        SearchResultPage searchResByAuction = searchResPage.clickAuctionButton();
        List<SearchResItem> searchResFilterdByAuction = searchResByAuction.getSearchRes();
        Assert.assertTrue(searchResFilterdByAuction.size()>0, "Search result is fail");
        
        // Check is item on auction
        final int firstPageIndex = 0;
        ProductPage pageOfFirstAuctionElement = searchResFilterdByAuction.get(firstPageIndex).clickElement();
        Assert.assertTrue(pageOfFirstAuctionElement.getBidBtn().isClickable(), "Bid button is unclickable");
    }
    
    @Test(description = "0010")
    @MethodOwner(owner = "ashchavinska")
    public void checkPriceFilter() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Search item on eBay
        final String search = "iPhone";
        SearchResultPage searchResPage = homePage.search(search);
        // Verify search result
        List<SearchResItem> searchRes =searchResPage.getSearchRes();
        Assert.assertTrue(searchRes.size()>0, "Search result is fail");
        for (SearchResItem item : searchRes) {
        	Assert.assertTrue(item.getTittle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
        
        SearchResultPage searchResByPrice = searchResPage.clickPrice120();
        // Verify filter result
        List<SearchResItem> searchResFilterdByPrice = searchResByPrice.getSearchRes();
        Assert.assertTrue(searchResFilterdByPrice.size()>0, "Filter by price fail");
        double maxPrice = 120.00;
        for (SearchResItem item : searchResFilterdByPrice) {
        	Assert.assertTrue(item.getPrice()<= maxPrice, item.getTittle() + " has price> 120.00 " + item.getPrice());
        }
    }

}
