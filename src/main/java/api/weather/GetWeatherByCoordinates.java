package api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByCoordinates extends AbstractApiMethodV2{
	public GetWeatherByCoordinates(double lat, double lon) {
		super(null, "api/weather/rs.json");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		replaceUrlPlaceholder("appid", Configuration.getEnvArg("appid"));
		replaceUrlPlaceholder("lat", String.valueOf(lat));
		replaceUrlPlaceholder("lon", String.valueOf(lon));
	}

}
