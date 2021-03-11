package ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.*;

public class CartPage extends AbstractPage{
    private static final Logger LOGGER = Logger.getLogger(CartPage.class);
	
	@FindBy(xpath = "//h1[@class='main-title']")
	private ExtendedWebElement quantitiCartElement;
	

	@FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
	private ExtendedWebElement removeBtn;
	
	@FindBy(xpath = "//div[@class='font-title-3']/span/span/span")
	private ExtendedWebElement cartStatus;
	
    public CartPage(WebDriver driver) {
        super(driver);
    } 
    
    public int getQuantity() {
        String[] splited = quantitiCartElement.getText().split(" ");
        int res = Integer.parseInt(splited[2].substring(1));
        LOGGER.info("Get quantity of item in the cart.");
    	return res;
    }
    
    public String getStatus() {
        return cartStatus.getText();
    }
    
    public void clickRemoveBtn() {
    	removeBtn.click();
    }

}
