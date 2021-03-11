package eBayPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.*;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.interactions.Actions;

public class SearchRes extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(SearchRes.class);

    @FindBy(xpath = "//ul[contains(@class,'srp-results')]/li[contains(@class,'s-item')]")
    private List<SearchResItem> searchRes;

    private String checkbox120 = "//input[@class='checkbox__control' and @aria-label='Under $120.00']";
    
    @FindBy(xpath = "//h2[@class='srp-format-tabs-h2' and contains(text(),'Auction')]")
    private ExtendedWebElement auctionButton;
    
    public SearchRes(WebDriver driver) {
        super(driver);
    } 
   
    public SearchRes clickPrice120() {
    	WebElement element = driver.findElement(By.xpath(checkbox120)); 
    	Actions actions = new Actions(driver); 
    	actions.moveToElement(element);
    	actions.perform();
    	element.click();
    	LOGGER.info("Filter checkbox click.");
 
        return new SearchRes(driver);
    }
    
    public SearchRes clickAuctionButton() {
    	auctionButton.click();
    	return new SearchRes(driver);
    }
    
    public List<SearchResItem> getSearchRes(){
    	return searchRes;
    }
}
