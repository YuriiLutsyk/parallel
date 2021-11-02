package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.TestRunner;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class MailPage extends TestRunner {
    private final SelenideElement
            createLetter = $(".make_message > a"),
            whom = $ ("#to"),
            topic = $ (".field [name='subject']"),
            bodyOfLetter = $ (".text_editor_browser [name='body']"),
            sendButton = $(".Left > p [name='send']"),
            messageBody = $(".message_body"),
            messageTopic = $("body > * div.message_header.clear > h3"),
            deleteMessage = $("body > * fieldset:nth-child(2) > a"),
            sentLetters = $("a[href*='list/sent-mail']"),
            sentItems = $(".list_underlined > li [href*='/list/sent-mail/']");

    private final ElementsCollection
            messages = $$("[href*='read']");

    public ElementsCollection getMessages() {
        return messages;
    }

    public SelenideElement getCreateLetter() {
        return createLetter;
    }

    public SelenideElement getWhom() {
        return whom;
    }

    public SelenideElement getTopic() {
        return topic;
    }

    public SelenideElement getBodyOfLetter() {
        return bodyOfLetter;
    }

    public SelenideElement getSendButton() {
        return sendButton;
    }

    public SelenideElement getMessageBody() {
        return messageBody;
    }

    public SelenideElement getSentLetters() {
        return sentLetters;
    }

    public SelenideElement getMessageTopic() {
        return messageTopic;
    }

    public SelenideElement getDeleteMessage() {
        return deleteMessage;
    }

    public SelenideElement getSentItems() {
        return sentItems;
    }

    public MailPage clickOnCreateLetter() {
        getCreateLetter().shouldBe(enabled).click();
        return this;
    }

    public MailPage clickOnSentItems() {
        getSentItems().shouldBe(enabled).click();
        return this;
    }

    public MailPage fillOutWhom(String email) {
        getWhom().shouldBe(enabled).setValue(email);
        return this;
    }

    public MailPage fillOutTopic() {
        getTopic().shouldBe(enabled).setValue("Test");
        return this;
    }

    public MailPage fillOutBodyOfLetter() {
        getBodyOfLetter().shouldBe(enabled).setValue("Check the content");
        return this;
    }

    public MailPage clickOnSendButton() {
        getSendButton().shouldBe(enabled).click();
        return this;
    }

    public MailPage clickOnSentLetters() {
        getSentLetters().shouldBe(enabled).click();
        return this;
    }

    public MailPage selectSentLetter(String buttonText) {
        getMessages().find(Condition.matchesText("Test")).shouldBe(enabled).click();
//        getMessages().shouldHave(sizeGreaterThan(0));
//        for (int i = 0; getMessages().size() > i; i++) {
//            if (getMessages().get(i).has(matchesText(buttonText))) {
//                getMessages().get(i).shouldBe(enabled).click();
//            }
//        }
        return this;
    }

    public MailPage checkTopic() {
        getMessageTopic().shouldBe(enabled).shouldHave(Condition.text("Test"));
        return this;
    }

    public MailPage checkMessageBody() {
        getMessageBody().shouldBe(enabled).shouldHave(Condition.text("Check the content"));
        return this;
    }

    public void clickOnDeleteMessage() {
        getDeleteMessage().shouldBe(enabled).click();
    }



    public MailPage createLetter() {
        clickOnCreateLetter();
        fillOutWhom(props.getProperty("firstUser.email"));
        fillOutTopic();
        fillOutBodyOfLetter();
        clickOnSendButton();
        return this;
    }

    public MailPage checkSentLetters() {
        clickOnSentLetters();
        selectSentLetter("Test");
        checkTopic();
        checkMessageBody();
        return this;
    }

    public MailPage deleteLetter() {
        clickOnDeleteMessage();
        switchTo().alert().accept();
        return this;
    }
}
