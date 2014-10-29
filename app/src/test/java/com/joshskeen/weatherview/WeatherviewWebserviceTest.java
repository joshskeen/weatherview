package com.joshskeen.weatherview;

import com.joshskeen.weatherview.model.WeatherCondition;
import com.joshskeen.weatherview.service.WeatherServiceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class WeatherviewWebserviceTest {

    private WeatherServiceManager mWeatherServiceManager;

    @Before
    public void setup() {
        mWeatherServiceManager = new WeatherServiceManager();
    }

    @Test
    public void testGetCurrentWeatherReturnsExpected() {
        stubFor(get(urlMatching("/conditions/")).willReturn(aResponse().withBodyFile("responses/atlanta-conditions.json")));
        List<WeatherCondition> conditionsForAtlanta = mWeatherServiceManager.getConditionsForAtlanta();
        assertThat(conditionsForAtlanta.size()).isEqualTo(1);
    }
}