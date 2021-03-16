package ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.*;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = Logger.getLogger(ProductPage.class);
	
	@FindBy(xpath = "//a[@id='bidBtn_btn']")
    private ExtendedWebElement bidBtn;
	
    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private ExtendedWebElement addToCartBtn;
    
    @FindBy(xpath = "//select[@id='msku-sel-1']")
    private ExtendedWebElement optionSelect;
    
    @FindBy(xpath = "//select[@id='msku-sel-1']/option[@id='msku-opt-0']")
    private ExtendedWebElement selectFirstOption;
	
    
    public ProductPage(WebDriver driver) {
        super(driver);
    } 
    
    public ExtendedWebElement getBidBtn() {
    	return bidBtn;
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
