package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrganizerPage;

public class TestNote extends ConfigurationIUA {
    MainPage mainPage = new MainPage();
    String userName = "Yurii773";
    OrganizerPage organaizer = new OrganizerPage();

    @Test(description = "User create and delete note")
    public void checkNote() {
        mainPage
                .firstLoginFlow()
                .checkUser_name(userName)
                .clickOnGetIuaIcon()
                .clickOnOrganizer();
        organaizer
                .createNote()
                .deleteNote();
    }
}
