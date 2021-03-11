package eBayPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.*;

public class ItemPage extends AbstractPage {
    //private static final Logger LOGGER = Logger.getLogger(ItemPage.class);
	
	@FindBy(xpath = "//a[@id='bidBtn_btn']")
    private ExtendedWebElement bidBtn;
	
    public ItemPage(WebDriver driver) {
        super(driver);
    } 
    
    public ExtendedWebElement getBidBtn() {
    	return bidBtn;
    }

}
