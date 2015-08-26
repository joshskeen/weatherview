package com.joshskeen.weatherview.inject;

import com.joshskeen.weatherview.BuildConfig;
import com.joshskeen.weatherview.MainActivity;
import com.joshskeen.weatherview.service.WeatherServiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(complete = true, entryPoints = {MainActivity.class})
public class WeatherViewModule {

    private WeatherviewApplication mWeatherviewApplication;

    public WeatherViewModule(WeatherviewApplication weatherviewApplication) {
        mWeatherviewApplication = weatherviewApplication;
    }

    @Provides
    @Singleton
    public WeatherServiceManager providesWeatherServiceManager() {
        String serviceEndpoint = "http://api.wunderground.com/api/" + BuildConfig.WEATHERVIEW_API_KEY + "/";
        return new WeatherServiceManager(serviceEndpoint);
    }

}
