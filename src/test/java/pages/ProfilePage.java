package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement
            addPhoto = $("#user_photo [title='Додати фотографію']"),
            selectFile = (SelenideElement) $ ("#cnrinpFromFileformFile [name='inpFromFileformFile']"),
            buttonLoad = $ ("#user_photo_form [value='Завантажити']"),
            apply = $ ("#insertImgStep2mfuPhotoTM > * input.bold.marginT1");


    public SelenideElement getAddPhoto() {
        return addPhoto;
    }

    public SelenideElement getSelectFile() {
        return selectFile;
    }

    public SelenideElement getButtonLoad() {
        return buttonLoad;
    }

    public SelenideElement getApply() {
        return apply;
    }

    File img = new File("D:\\testimg\\screen.png");

    public void clickOnAddPhoto() {
        getAddPhoto().shouldBe(Condition.enabled).click();
    }

    public  void uploadingFile(){
        getSelectFile().uploadFile(img);
    }

    public void clickOnButtonLoad() {
        getButtonLoad().shouldBe(Condition.enabled).click();
    }

    public void clickOnApply() {
        getApply().shouldBe(Condition.enabled).click();
    }


    public ProfilePage uploadPhoto() {
        clickOnAddPhoto();
        uploadingFile();
        clickOnButtonLoad();
        clickOnApply();
        return this;
    }
}
