package com.joshskeen.weatherview.inject;

import com.joshskeen.weatherview.BuildConfig;
import com.joshskeen.weatherview.WeatherviewWebserviceTest;
import com.joshskeen.weatherview.service.WeatherServiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(complete = true, entryPoints = {WeatherviewWebserviceTest.class})
public class WeatherviewTestModule {

    @Provides
    @Singleton
    public WeatherServiceManager providesWeatherServiceManager() {
        String serviceEndpoint = "http://localhost:1111/api/" + BuildConfig.WEATHERVIEW_API_KEY + "/";
        return new WeatherServiceManager(serviceEndpoint);
    }

}
