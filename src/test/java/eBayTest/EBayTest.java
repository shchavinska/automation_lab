package eBayTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import eBayPages.HomePageEBay;
import eBayPages.CartPage;
import eBayPages.ItemPage;
import eBayPages.SearchRes;
import eBayPages.SearchResItem;

public class EBayTest extends AbstractTest {
	
    @Test(description = "0005")
    @MethodOwner(owner = "ashchavinska")
    public void addToCart() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        SearchResItem productPage = homePage.openDailyDealsByNumber(0); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        Assert.assertTrue(cartPage.getQuantity()==1, "Amount of product in cart: 0");
    }
    
    @Test(description = "0006")
    @MethodOwner(owner = "ashchavinska")
    public void addToCartThreeProduct() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        SearchResItem productPage = homePage.openDailyDealsByNumber(0); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        Assert.assertTrue(cartPage.getQuantity()==1, "Amount of product in cart: 0");
        
        // Repeat three times
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.scrollToDailyDealsSection();
        // Open second product from daily deals
        homePage.openDailyDealsByNumber(1); 
        productPage.clickAddToCartBtn();
        Assert.assertTrue(cartPage.getQuantity()==2, "Amount of product in cart: <1");
        
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.scrollToDailyDealsSection();
        // Open third product from daily deals
        homePage.openDailyDealsByNumber(2); 
        productPage.clickAddToCartBtn();
        Assert.assertTrue(cartPage.getQuantity()==3, "Amount of product in cart: <1");
    }
    
    
    @Test(description = "0007")
    @MethodOwner(owner = "ashchavinska")
    public void removeFromCart() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        SearchResItem productPage = homePage.openDailyDealsByNumber(0); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        Assert.assertTrue(cartPage.getQuantity()==1, "Amount of product in cart: 0");
        // On Cart click remove button
        cartPage.clickRemoveBtn();
        // Verify successful remove
        String expectedText = "You don't have any items in your cart.";
        Assert.assertTrue(expectedText.equals(cartPage.getStatus()), "Cart is not empty");
    }
    
	
    @Test(description = "0008")
    @MethodOwner(owner = "ashchavinska")
    public void checkSearch() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Search item on eBay
        final String search = "iPhone";
        SearchRes searchResPage = homePage.search(search);
        // Verify search result
        List<SearchResItem> searchRes = searchResPage.getSearchRes();
        Assert.assertTrue(searchRes.size()>0, "Search result is fail");
        for (SearchResItem item : searchRes) {
        	Assert.assertTrue(item.getTittle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
    }
    
    
    @Test(description = "0009")
    @MethodOwner(owner = "ashchavinska")
    public void checkAuctionFilter() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Search item on eBay
        final String search = "iPhone";
        SearchRes searchResPage = homePage.search(search);
        // Verify search result
        List<SearchResItem> searchRes = searchResPage.getSearchRes(); 
        Assert.assertTrue(searchRes.size()>0, "Search result is fail");
        for (SearchResItem item : searchRes) {
        	Assert.assertTrue(item.getTittle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
        
        // Verify auction filter
        SearchRes searchResByAuction = searchResPage.clickAuctionButton();
        List<SearchResItem> searchResFilterdByAuction = searchResByAuction.getSearchRes();
        Assert.assertTrue(searchResFilterdByAuction.size()>0, "Search result is fail");
        
        // Check is item on auction
        ItemPage pageOfFirstAuctionElement = searchResFilterdByAuction.get(0).clickElement();
        Assert.assertTrue(pageOfFirstAuctionElement.getBidBtn().isClickable(), "Bid button is unclickable");
    }
	
    
    @Test(description = "0010")
    @MethodOwner(owner = "ashchavinska")
    public void checkPriceFilter() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Search item on eBay
        final String search = "iPhone";
        SearchRes searchResPage = homePage.search(search);
        // Verify search result
        List<SearchResItem> aaa =searchResPage.getSearchRes();
        Assert.assertTrue(aaa.size()>0, "Search result is fail");
        for (SearchResItem item : aaa) {
        	Assert.assertTrue(item.getTittle().toLowerCase().contains(search.toLowerCase()), "Search result is not as required");
        }
        
        SearchRes searchResByPrice = searchResPage.clickPrice120();
        // Verify filter result
        List<SearchResItem> bbb = searchResByPrice.getSearchRes();
        Assert.assertTrue(bbb.size()>0, "Filter by price fail");
        for (SearchResItem item : bbb) {
        	Assert.assertTrue(item.getPrice()<= 120.00, item.getTittle() + " has price> 120.00 " + item.getPrice());
        }
    }
    
    
    @Test(description = "0011")
    @MethodOwner(owner = "ashchavinska")
    public void checkCartRtn() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Open cart page
        CartPage cartPage = homePage.clickCartBtn();
        String expectedText = "You don't have any items in your cart.";
        Assert.assertTrue(expectedText.equals(cartPage.getStatus()), "Cart is not empty");
    }
    
    
    @Test(description = "0012")
    @MethodOwner(owner = "ashchavinska")
    public void checkOptionSelection() {
    	// Open eBay home page and verify page is opened
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals with selection option
        SearchResItem productPage = homePage.openDailyDealsByNumber(3); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        Assert.assertTrue(cartPage.getQuantity()==1, "Amount of product in cart: 0");
    }

}
