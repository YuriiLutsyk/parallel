package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.RadioPage;

public class TestRadio extends ConfigurationIUA {
    MainPage mainPage = new MainPage();
    String userName = "Yurii773";
    RadioPage radioPage = new RadioPage();


    @Test(description = "User open radio")
    public void checkRadio() {
        mainPage
                .firstLoginFlow()
                .checkUser_name(userName)
                .clickOnGetIuaIcon()
                .clickOnRadio()
                .clickOnOpenRadio();
        radioPage
                .checkRadiorocksText()
                .clickOnPlayButtonRadio();
    }
}
