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

public class SearchCheck extends AbstractTest {   
	
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
}
