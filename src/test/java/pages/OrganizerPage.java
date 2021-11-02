package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class OrganizerPage {
    private final SelenideElement
            notes = $("li > [href='/notes/']"),
            addNote = $ (".addNote"),
            noteField = $ ("#noteText"),
            save = $ ("b > [value='Зберегти']"),
            deleteNote = $("b > [title='видалити нотатку']");

    public SelenideElement getNotes() {
        return notes;
    }

    public SelenideElement getAddNote() {
        return addNote;
    }

    public SelenideElement getNoteField() {
        return noteField;
    }

    public SelenideElement getSave() {
        return save;
    }

    public SelenideElement getDeleteNote() {
        return deleteNote;
    }

    public void clickOnNotes() {
        getNotes().shouldBe(Condition.enabled).click();
    }

    public void clickOnAddNote() {
        getAddNote().shouldBe(Condition.enabled).click();
    }

    public void fillOutNoteField() {
        getNoteField().shouldBe(Condition.enabled).setValue("Test");
    }

    public void clickOnSave() {
        getSave().shouldBe(Condition.enabled).click();
    }

    public void clickOnDeleteNote() {
        getDeleteNote().shouldBe(Condition.enabled).click();
    }


    public OrganizerPage createNote() {
        clickOnNotes();
        clickOnAddNote();
        fillOutNoteField();
        clickOnSave();
        $ ("body > * div.noteContainer > div > p").shouldHave(Condition.text("Test"));
        return this;
    }
    public OrganizerPage deleteNote() {
        clickOnDeleteNote();
        switchTo().alert().accept();
        return this;
    }
}
