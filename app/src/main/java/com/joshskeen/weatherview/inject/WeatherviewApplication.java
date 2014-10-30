package com.joshskeen.weatherview.inject;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

public class WeatherviewApplication extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(new WeatherviewModule(this));
    }

    public static WeatherviewApplication get(Context context) {
        return (WeatherviewApplication) context.getApplicationContext();
    }

    public final void inject(Object object) {
        mObjectGraph.inject(object);
    }
}
