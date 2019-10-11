package com.pluralsight;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.fail;

public class UnitTest {

    @Test
    public void canGoToHomePage() {
        Pages.homePage().goTo();
        Assert.assertTrue(Pages.homePage().isAt());
    }

    @Test void canGoToJavaPathPage() {
        Pages.pathPages().goTo();
        Pages.pathPages().goToJavaPath();
        Assert.assertTrue(Pages.pathPages().isAt());

    }

    @After
    public void cleanUp() {
        Browser.close();
    }

}
