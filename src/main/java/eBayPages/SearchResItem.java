package eBayPages;

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
    public ExtendedWebElement priceElement;

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    public ExtendedWebElement addToCartBtn;
    
    @FindBy(xpath = "//select[@id='msku-sel-1']")
    public ExtendedWebElement optionSelect;
    
    @FindBy(xpath = "//select[@id='msku-sel-1']/option[@id='msku-opt-0']")
    public ExtendedWebElement selectFirstOption;
    
 

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
    
    public ItemPage clickElement() {
    	tittleElement.click();
    	return new ItemPage(driver);
    }
    
    public CartPage clickAddToCartBtn() {
    	if (optionSelect.isClickable()) {
    		optionSelect.click();
    		selectFirstOption.click();
    		addToCartBtn.click();
    		LOGGER.info("Select option and click add to cart button.");
    	}
    	else {
    		addToCartBtn.click();
    	}
    	return new CartPage(driver);
    }
    
}

