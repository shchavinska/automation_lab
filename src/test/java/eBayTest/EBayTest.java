package eBayTest;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By.ByXPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

import eBayPages.HomePageEBay;
import eBayPages.SearchRes;

public class EBayTest extends AbstractTest {
    @Test(description = "00000000000001")
    @MethodOwner(owner = "ashchavinska")
    //@TestPriority(Priority.P3)
    public void checkPriceFilter() {
    	
        HomePageEBay homePage = new HomePageEBay(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        final String search = "iPhone";
        SearchRes searchResPage = homePage.search(search);
        Assert.assertTrue(searchResPage.searchRes.size()>0);
        
  
        Assert.assertTrue(searchResPage.getTitle("iPhone").equals("iPhone"));
        
  
    }

}
