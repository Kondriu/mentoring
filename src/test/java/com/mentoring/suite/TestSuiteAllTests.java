package com.mentoring.suite;

import com.mentoring.api.openweathermap.OpenWeatherMapCurrentWeatherTest;
import com.mentoring.api.restapiexample.RestApiExampleTest;
import com.mentoring.ui.google.gmail.GmailLettersTest;
import com.mentoring.ui.google.search.GoogleSearchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GmailLettersTest.class,
        GoogleSearchTest.class,
        OpenWeatherMapCurrentWeatherTest.class,
        RestApiExampleTest.class
})


public class TestSuiteAllTests {
}
