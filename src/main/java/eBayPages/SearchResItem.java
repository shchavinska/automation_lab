package eBayPages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;

public class SearchResItem extends AbstractUIObject {
    @FindBy(xpath = ".//h3")
    private ExtendedWebElement modelLabel;


    public SearchResItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readModel() {
    	System.out.println(modelLabel.getText());
        return modelLabel.getText();
    }
	
}
