package com.mentoring.suites;

import com.mentoring.api.restapiexample.RestApiExampleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
        RestApiExampleTest.class
)

public class SmokeTest {
}
