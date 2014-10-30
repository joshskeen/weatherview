package com.joshskeen.weatherview;

import android.app.Activity;
import android.os.Bundle;

import com.joshskeen.weatherview.inject.WeatherviewApplication;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherviewApplication.get(this).inject(this);
    }
}
