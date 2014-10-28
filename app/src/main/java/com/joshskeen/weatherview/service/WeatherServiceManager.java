package com.joshskeen.weatherview.service;

import com.joshskeen.weatherview.BuildConfig;
import com.joshskeen.weatherview.model.WeatherCondition;

import java.util.List;

import retrofit.RestAdapter;

public class WeatherServiceManager {

    public static String SERVICE_ENDPOINT = "http://api.wunderground.com/api/" + BuildConfig.WEATHERVIEW_API_KEY + "/";
    private final WeatherServiceInterface mWeatherServiceInterface;

    public WeatherServiceManager() {
        mWeatherServiceInterface = buildRestAdapter()
                .create(WeatherServiceInterface.class);
    }

    public List<WeatherCondition> getConditionsForAtlanta() {
        return mWeatherServiceInterface.getConditions("Atlanta")
                .getConditionsResponse()
                .getWeatherConditions();
    }

    private RestAdapter buildRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint(SERVICE_ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        System.out.println("==>" + message);
                    }
                })
                .build();
    }
}
