package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import tests.TestRunner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class MainPage extends TestRunner {
    private final SelenideElement
            firstEnter = $(".first [href='https://passport.i.ua/login/']"),
            login = $("li [name='login']"),
            password = $("li [name='pass']"),
            secondEnter = $("p [value='Увійти']"),
            loginInFrame = $(".form p [name='login']"),
            passwordInFrame = $("#FloatLogin * > p [name='pass']"),
            enterInFrame = $(".form [value='Увійти']"),
            iuaIcon = $(".ho_logo"),
            entrance = $(".right [title='вийти']"),
            searchField = $("#searchQ"),
            find = $("* > form > input[type=submit]"),
            organizer = $("li > [title='Органайзер']"),
            profile = $("li > [title='профіль']"),
            radio = $(".radio_24"),
            openRadio = $("[href='https://radio.i.ua/']"),
            user_name = $ (".user .user_name"),
            email = $ ("[onclick=\"trackSectionsClick('mbox')\"]");


    public SelenideElement getFirstEnter() {
        return firstEnter;
    }

    public SelenideElement getLogin() {
        return login;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getSecondEnter() {
        return secondEnter;
    }

    public SelenideElement getLoginInFrame() {
        return loginInFrame;
    }

    public SelenideElement getPasswordInFrame() {
        return passwordInFrame;
    }

    public SelenideElement getEnterInFrame() {
        return enterInFrame;
    }

    public SelenideElement getIuaIcon() {
        return iuaIcon;
    }

    public SelenideElement getEntrance() {
        return entrance;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getFind() {
        return find;
    }

    public SelenideElement getOrganizer() {
        return organizer;
    }

    public SelenideElement getProfile() {
        return profile;
    }

    public SelenideElement getRadio() {
        return radio;
    }

    public SelenideElement getOpenRadio() {
        return openRadio;
    }

    public SelenideElement getUser_name() {
        return user_name;
    }

    public SelenideElement getEmail() {
        return email;
    }

    public MainPage clickOnOrganizer() {
        getOrganizer().shouldBe(enabled).click();
        return this;
    }

    public MainPage checkUser_name(String userName) {
        getUser_name().shouldHave(Condition.text(userName));
        return this;
    }

    public MainPage clickOnRadio() {
        getRadio().shouldBe(enabled).click();
        return this;
    }

    public MainPage clickOnOpenRadio() {
        getOpenRadio().shouldBe(enabled).click();
        return this;
    }

    public MainPage clickOnProfile() {
        getProfile().shouldBe(enabled).click();
        return this;
    }

    public void clickOnFirstEnter() {
        getFirstEnter().shouldBe(enabled).click();
    }

    public MainPage clickOnSecondEnter() {
        getSecondEnter().shouldBe(enabled).click();
        return this;
    }

    public void clickOnEnterInFrame() {
        getEnterInFrame().shouldBe(enabled).click();
    }

    public MainPage clickOnGetIuaIcon() {
        getIuaIcon().shouldBe(enabled).click();
        return this;
    }

    public void clickOnEntrance() {
        getEntrance().shouldBe(enabled).click();
    }

    public void fillOutLoginUpper() {
        getLoginInFrame().shouldBe(enabled).setValue("yurii.test7");
    }

    public void fillOutPasswordUpper() {
        getPasswordInFrame().shouldBe(enabled).setValue("7721qweQ");
    }

    public MainPage fillOutLogin(String login) {
        getLogin().shouldBe(enabled).setValue(login);
        return this;
    }

    public MainPage fillOutIncorrectLogin(String loginInc) {
        getLogin().shouldBe(enabled).setValue(loginInc);
        return this;
    }

    public MainPage fillOutPassword(String password) {
        getPassword().shouldBe(enabled).setValue(password);
        return this;
    }

    public void fillOutSearchField() {
        getSearchField().shouldBe(enabled).setValue("cat");
    }

    public void clickOnFind() {
        getFind().shouldBe(enabled).click();
    }


    public MainPage firstLoginFlow() {
        fillOutLogin(props.getProperty("firstUser.username"));
        fillOutPassword(props.getProperty("firstUser.password"));
        clickOnSecondEnter();
        return this;
    }

    public MainPage logOutFlow() {
        clickOnGetIuaIcon();
        clickOnEntrance();
        return this;
    }

    public MainPage secondLoginFlow() {
        clickOnFirstEnter();
        switchTo().parentFrame();
        fillOutLoginUpper();
        fillOutPasswordUpper();
        clickOnEnterInFrame();
        return this;
    }

    public MainPage searchCat() {
        fillOutSearchField();
        clickOnFind();
        return this;
    }

    public MainPage clickOnEmail() {
        getEmail().shouldBe(enabled).click();
        return this;
    }

    public MainPage incorrectLogin() {
        fillOutIncorrectLogin(props.getProperty("incorrectEmail"));
        fillOutPassword(props.getProperty("firstUser.password"));
        clickOnSecondEnter();
        return this;
    }
}



