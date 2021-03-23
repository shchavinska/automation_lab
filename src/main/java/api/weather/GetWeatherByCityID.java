package api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByCityID extends AbstractApiMethodV2{
	
	public GetWeatherByCityID(int cityID) {
		super(null, "api/weather/rs.json", "api/weather/apiWeather.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		replaceUrlPlaceholder("appid", Configuration.getEnvArg("appid"));
		replaceUrlPlaceholder("cityID",  String.valueOf(cityID));
	}
}
