package openweather;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.PostUserMethod;

import api.weather.GetWeatherByCityID;
import api.weather.GetWeatherByCoordinates;
import api.weather.GetWeatherByZipCode;

public class OpenWeatherTest extends AbstractTest {
	
    @Test(description = "0001")
    @MethodOwner(owner = "ashchavinska")
    public void testGetWeatherByCiryID() throws Exception {
        int kyivCityID = 703447;
        GetWeatherByCityID api = new GetWeatherByCityID(kyivCityID);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }
    
    @Test(description = "0002")
    @MethodOwner(owner = "ashchavinska")
    public void testGetWeatherByZipCode() throws Exception {
        int wilmingtonZipCode = 19808;
        String wilmingtonCountryCode = "us";
        GetWeatherByZipCode api = new GetWeatherByZipCode(wilmingtonZipCode, wilmingtonCountryCode);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.getProperties().setProperty("country", "US");
        //api.addProperties("country", "US");
        api.validateResponse();
    }
    
    @Test(description = "0003")
    @MethodOwner(owner = "ashchavinska")
    public void testGetWeatherByCoordinates() throws Exception {
    	double amsterdamLat = 52.374031;
    	double amsterdamLon = 4.88969;
    	GetWeatherByCoordinates api = new GetWeatherByCoordinates(amsterdamLat, amsterdamLon);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        //api.validateResponse();
    }

}
