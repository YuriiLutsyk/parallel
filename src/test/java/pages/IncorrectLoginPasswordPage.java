package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class IncorrectLoginPasswordPage {
    private final SelenideElement
            login = $(".form [name='login']"),
            password = $(".form [name='pass']"),
            errorMessage = $("#lform_errCtrl > div"),
            enter = $("* > form > input[type=submit]");

    public SelenideElement getLogin() {
        return login;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getEnter() {
        return enter;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public IncorrectLoginPasswordPage checkError(String alarm) {
        getErrorMessage().shouldHave(Condition.text(alarm));
        return this;
    }

    public IncorrectLoginPasswordPage fillOutLoginErrorPage(String login) {
        getLogin().shouldBe(Condition.enabled).setValue(login);
        return this;
    }

    public IncorrectLoginPasswordPage fillOutPasswordErrorPage(String password) {
        getPassword().shouldBe(Condition.enabled).setValue(password);
        return this;
    }

   public IncorrectLoginPasswordPage fillOutIncLoginErrorPage() {
        getLogin().shouldBe(Condition.enabled).setValue("yurii.test");
        return this;
  }

    public IncorrectLoginPasswordPage fillOutNothing() {
        getLogin().shouldBe(Condition.enabled).clear();
        getPassword().shouldBe(Condition.enabled).clear();
        return this;
    }

    public IncorrectLoginPasswordPage fillOutIncPasswordErrorPage(String passwordInc) {
        getPassword().shouldBe(Condition.enabled).setValue(passwordInc);
        return this;
    }

    public void clickOnEnter() {
        getEnter().shouldBe(enabled).click();
    }

}
