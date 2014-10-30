package com.joshskeen.weatherview;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.joshskeen.weatherview.model.WeatherCondition;
import com.joshskeen.weatherview.service.WeatherServiceManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class WeatherviewWebserviceTest {

    @Inject
    public WeatherServiceManager mWeatherServiceManager;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(1111);

    @Before
    public void setup() {
        Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
    }

    @Test
    public void testGetCurrentWeatherReturnsExpected() {
        stubFor(get(urlMatching("/api/.*"))
                .atPriority(5)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBodyFile("atlanta-conditions.json")));
        List<WeatherCondition> conditionsForAtlanta = mWeatherServiceManager.getConditionsForAtlanta();
        assertThat(conditionsForAtlanta.size()).isEqualTo(1);
    }

}
