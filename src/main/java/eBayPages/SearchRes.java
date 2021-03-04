package eBayPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ModelItem;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;

public class SearchRes extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class,'srp-results')]/li[contains(@class,'s-item')]")
    public List<SearchResItem> searchRes;
    
    
    public SearchRes(WebDriver driver) {
        super(driver);
    } 

    
    public String getTitle(String tittle) {
        for (SearchResItem item : searchRes) {
            if (item.readModel().contains(tittle)) {
       
            	return tittle;
            }
        }
        throw new RuntimeException("Unable to find model: " + tittle);
    }
    

}
