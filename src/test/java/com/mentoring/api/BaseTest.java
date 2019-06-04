package com.mentoring.api;

import com.mentoring.api.utills.PropertiesReader;
import org.junit.Before;

public class BaseTest {

    public PropertiesReader propertiesReader;

    @Before
    public void startupSetup() {
        propertiesReader = new PropertiesReader();
    }
}
