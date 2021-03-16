package ebaytests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import ebay.pages.CartPage;
import ebay.pages.HomePage;
import ebay.pages.ProductPage;
import ebay.pages.SearchResultPage;
import ebay.pages.SearchResItem;

public class EBayTest extends AbstractTest {
	
    @Test(description = "0005")
    @MethodOwner(owner = "ashchavinska")
    public void addToCart() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        final int firstPageIndex = 0;
        ProductPage productPage = homePage.openDailyDealsByNumber(firstPageIndex); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        int expectedAmountItems = 1;
        Assert.assertEquals(cartPage.getQuantity(), expectedAmountItems, "Amount of product in cart: 0");
    }
    
    @Test(description = "0006")
    @MethodOwner(owner = "ashchavinska")
    public void addToCartThreeProduct() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        final int firstPageIndex = 0;
        ProductPage productPage = homePage.openDailyDealsByNumber(firstPageIndex); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        int expectedAmountItems = 1;
        Assert.assertEquals(cartPage.getQuantity(), expectedAmountItems, "Amount of product in cart: 0");
        
        // Repeat three times
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.scrollToDailyDealsSection();
        // Open second product from daily deals
        final int secondPageIndex = 1;
        homePage.openDailyDealsByNumber(secondPageIndex); 
        productPage.clickAddToCartBtn();
        // Expected one more item
        expectedAmountItems += 1;
        Assert.assertEquals(cartPage.getQuantity(), expectedAmountItems, "Amount of product in cart: != 2");
        
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.scrollToDailyDealsSection();
        // Open third product from daily deals
        final int thirdPageIndex = 2;
        homePage.openDailyDealsByNumber(thirdPageIndex); 
        productPage.clickAddToCartBtn();
        // Expected one more item
        expectedAmountItems += 1;
        Assert.assertEquals(cartPage.getQuantity(), expectedAmountItems, "Amount of product in cart: != 3");
    }
    
    
    @Test(description = "0007")
    @MethodOwner(owner = "ashchavinska")
    public void removeFromCart() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals
        final int firstPageIndex = 0;
        ProductPage productPage = homePage.openDailyDealsByNumber(firstPageIndex); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        Assert.assertEquals(cartPage.getQuantity(), 1, "Amount of product in cart: 0");
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
    }
    
    
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
    
    
    @Test(description = "0011")
    @MethodOwner(owner = "ashchavinska")
    public void checkCartButton() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Open cart page
        CartPage cartPage = homePage.clickCartBtn();
        String expectedText = "You don't have any items in your cart.";
        Assert.assertTrue(expectedText.equals(cartPage.getStatus()), "Cart is not empty");
    }
    
    
    @Test(description = "0012")
    @MethodOwner(owner = "ashchavinska")
    public void checkProductOptionSelection() {
    	// Open eBay home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        // Scroll to daily deals section
        homePage.scrollToDailyDealsSection();
        
        // Open first product from daily deals with selection option
        final int pageIndex = 3;
        ProductPage productPage = homePage.openDailyDealsByNumber(pageIndex); 
        // Click "add to card" (if selection necessary click first element)
        CartPage cartPage = productPage.clickAddToCartBtn();
        // Verify amount of product in cart
        int expectedAmountItems = 1;
        Assert.assertEquals(cartPage.getQuantity(), expectedAmountItems, "Amount of product in cart: 0");
    }

}
