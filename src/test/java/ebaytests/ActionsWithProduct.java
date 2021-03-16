package ebaytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import ebay.pages.CartPage;
import ebay.pages.HomePage;
import ebay.pages.ProductPage;

public class ActionsWithProduct extends AbstractTest {
	
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
