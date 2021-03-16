package ebay.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.*;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);
    
    @FindBy(xpath="//*[@class='gh-tb ui-autocomplete-input']")
    private ExtendedWebElement searchTextField;
    
    @FindBy(xpath="//*[@class='btn btn-prim gh-spr']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath="//div[@class='main-content']/div[contains(@class,'hl-standard-carousel')][last()]//li[contains(@class,'carousel')]")
    private List<ExtendedWebElement> listOfDailyDealsItems;
 
    @FindBy(xpath="//a[contains(@title,'Your shopping cart')]")
    private ExtendedWebElement cartBtn;
    
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search(String searchValue) {
        searchTextField.type(searchValue);
        searchButton.click();
        LOGGER.info("Type search query and click Search button.");
        return new SearchResultPage(driver);
    }
    
    
    public void scrollToDailyDealsSection() {
    	WebElement element = listOfDailyDealsItems.get(0).getElement();
    	Actions actions = new Actions(driver); 
    	actions.moveToElement(element);
    	LOGGER.info("Scroll to element.");
    }
    
    public ProductPage openDailyDealsByNumber(int index) {
    	listOfDailyDealsItems.get(index).click();
    	LOGGER.info("Item page open.");
    	return new ProductPage(driver);
    }
    
    public CartPage clickCartBtn() {
    	cartBtn.click();
    	return new CartPage(driver);
    }
    
}
