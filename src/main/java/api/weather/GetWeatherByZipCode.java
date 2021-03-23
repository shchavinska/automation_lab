package api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByZipCode extends AbstractApiMethodV2{
	public GetWeatherByZipCode(int zipCode, String countryCode) {
		super(null, "api/weather/rs.json", "api/weather/apiWeather.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		replaceUrlPlaceholder("appid", Configuration.getEnvArg("appid"));
		replaceUrlPlaceholder("zipCode", String.valueOf(zipCode));
		replaceUrlPlaceholder("countryCode", countryCode);
	}

}
