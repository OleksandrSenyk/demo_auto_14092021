package ui.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InputPage extends ui.pages.MainPage {

    public InputPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='orb-search-q']")
    private WebElement searchLink;

    @FindBy(xpath = "//*[@id='orb-search-button']")
    private WebElement clickSearch;

    @FindBy(xpath = "//*[@id='main-content']/div[1]/div[3]/div/div/ul/li[8]/div/div/div[1]/div[1]/a")
    private WebElement articleVienne;

    @FindBy(xpath = "//*[@id='main-heading']")
    private WebElement titleArticleVienne;

    @FindBy(xpath = "//*[@id='main-content']/div[1]/div[3]/div/div/ul/li[3]/div/div/div[1]/div[1]/a")
    private WebElement articleBoxing;

    @FindBy(xpath = "//*[@id='page']")
    private WebElement boxingTitle;

    @FindBy(xpath = "//*[@id='idcta-username']")
    private WebElement signInLink;

    @FindBy(xpath = "//*[@id='user-identifier-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='password-input']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='form-message-username']/p/span/span")
    private WebElement emailError;

    @FindBy(xpath = "//*[@id='submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='form-message-password']/p/span/span[3]")
    private WebElement passwError;


//#1
    public void openSearchLink(String text) {
        webElements.inputText(searchLink, text);
    }
    public void clickSearchButton() {
        webElements.clickOnElement(clickSearch);
    }

    public void openArticleVienne() {
        webElements.clickOnElement(articleVienne);
    }

    public String checkTitle() {
        return titleArticleVienne.getText();
    }
//#2
    public void clickArticleBoxing() {
        webElements.clickOnElement(articleBoxing);
    }
    public String checkBoxingTitle() {
        return boxingTitle.getText();
    }
//#3
    public void clickSignInLink() {
    webElements.clickOnElement(signInLink);
    }

    public void inputEmail(String email){
        webElements.inputText(emailInput, email);
    }

    public void inputPassword(String password){
        webElements.inputText(passwordInput, password);
    }

    public String checkErrorTitle () {
        return emailError.getText();
    }
    public void clickSubmitButton() {
        webElements.clickOnElement(submitButton);
    }

    public String checkPasswError (){
        return passwError.getText();
    }
}




