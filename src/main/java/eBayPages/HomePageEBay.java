package eBayPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.*;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class HomePageEBay extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePageEBay.class);
    
    @FindBy(xpath="//*[@class='gh-tb ui-autocomplete-input']")
    private ExtendedWebElement searchTextField;
    
    @FindBy(xpath="//*[@class='btn btn-prim gh-spr']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath="//div[@class='main-content']/div[contains(@class,'hl-standard-carousel')][last()]//li[contains(@class,'carousel')]")
    private List<ExtendedWebElement> listOfDailyDealsItems;
    
    
    private String dailyDealsField = "//div[@class='main-content']/div[contains(@class,'hl-standard-carousel')][last()]//li[contains(@class,'carousel')]";
 
    @FindBy(xpath="//a[contains(@title,'Your shopping cart')]")
    private ExtendedWebElement cartBtn;
    
    
    public HomePageEBay(WebDriver driver) {
        super(driver);
    }

    public SearchRes search(String q) {
        searchTextField.type(q);
        searchButton.click();
        LOGGER.info("Type search query and click Search button.");
        return new SearchRes(driver);
    }
    
    
    public void scrollToDailyDealsSection() {
    	//WebElement element = driver.findElement(By.xpath(dailyDealsField));
    	WebElement element = listOfDailyDealsItems.get(0).getElement();
    	Actions actions = new Actions(driver); 
    	actions.moveToElement(element);
    	LOGGER.info("Scroll to element.");
    }
    
    public SearchResItem openDailyDealsByNumber(int index) {
    	listOfDailyDealsItems.get(index).click();
    	LOGGER.info("Item page open.");
    	return new SearchResItem(driver);
    }
    
    public CartPage clickCartBtn() {
    	cartBtn.click();
    	return new CartPage(driver);
    }
    
}
