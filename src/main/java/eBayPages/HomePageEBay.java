package eBayPages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.*;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

public class HomePageEBay extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePageEBay.class);
    
    @FindBy(xpath="//*[@class='gh-tb ui-autocomplete-input']")
    private ExtendedWebElement searchTextField;
    
    @FindBy(xpath="//*[@class='btn btn-prim gh-spr']")
    private ExtendedWebElement searchButton;


    public HomePageEBay(WebDriver driver) {
        super(driver);
    }

    
    public SearchRes search(String q) {
        searchTextField.type(q);
        searchButton.click();
        return new SearchRes(driver);
 
    }

}
