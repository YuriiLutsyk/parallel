package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RadioPage {
    private final SelenideElement
            playButtonRadioRocks = $("[onclick*=\"radioy.playIt('/play/radio.roks/')\"]"),
            checkRadiorocks = $(".preview_left_fixed * > h2 [href*='radio.roks/']");

    public SelenideElement getPlayButtonRadioRocks() {
        return playButtonRadioRocks;
    }

    public SelenideElement getCheckRadiorocks() {
        return checkRadiorocks;
    }


    public RadioPage checkRadiorocksText() {
        getCheckRadiorocks().scrollIntoView(true).shouldHave(Condition.text("Radio ROKS")).shouldBe(Condition.enabled);
        return this;
    }

    public void clickOnPlayButtonRadio() {
        getPlayButtonRadioRocks().scrollIntoView(true).shouldBe(Condition.enabled).click();
    }
}