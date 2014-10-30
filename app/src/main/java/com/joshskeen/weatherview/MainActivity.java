package com.joshskeen.weatherview;

import android.os.Bundle;

import com.joshskeen.weatherview.service.WeatherServiceManager;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {

    @Inject
    WeatherServiceManager mWeatherServiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeatherServiceManager.getConditionsForAtlanta();
    }

}
