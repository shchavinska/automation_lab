package ebay.pages;

import org.openqa.selenium.SearchContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.*;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;


public class SearchResItem extends AbstractUIObject {
    private static final Logger LOGGER = Logger.getLogger(SearchResItem.class);
    
    @FindBy(xpath = ".//h3")
    private ExtendedWebElement tittleElement;
    
    @FindBy(xpath = ".//span[@class='s-item__price']")
    private ExtendedWebElement priceElement;
 

    public SearchResItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public SearchResItem(WebDriver driver) {
        super(driver);
    }

    public String getTittle() {
        return tittleElement.getText();
    }
    
    public double getPrice() {
        String[] splited = priceElement.getText().split(" ");
        double res = Double.parseDouble(splited[0].substring(1));
        //LOGGER.info("Find item price.");
    	return res;
    }
    
    public ProductPage clickElement() {
    	tittleElement.click();
    	return new ProductPage(driver);
    }
    
}

