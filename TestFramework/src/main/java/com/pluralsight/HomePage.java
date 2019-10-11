package com.pluralsight;

public class HomePage {

    static String url = "http://pluralsight.com";
    static String title = "Pluralsight";

    public void goTo() {
        Browser.goTo(url);
    }

    public boolean isAt() {
        return Browser.title().contains(title);
    }
}
