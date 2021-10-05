package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement loginInput;

    @FindBy(id="SubmitCreate")
    private WebElement submitButtonCreate;

    @FindBy(id="customer_firstname")
    private WebElement customerFirstName;

    @FindBy(name="customer_lastname")
    private WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(name = "passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    private WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    private By.ByXPath stateSelect;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcodeInput;

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement idCountry;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement phoneMobileInput;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement aliasInput;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement submitAccount;

    @FindBy(xpath = "//*[@id='center_column']/div/p")
    private WebElement error1;

    @FindBy(xpath = "//*[@id='center_column']/div/ol/li")
    private WebElement errorMessage;



    /**
     * Method open SignIn page
     */
    public void clickSignIn() {
        signInLink.click();
    }

    /**
     * Method click to SignIn page
     */
    public void openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=my-account");
    }

    public void inputEmailCreate(String email) {
        webElements.inputText(loginInput, email);
    }

    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstName, firstName);
    }

    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastName, lastName);
    }

    public void inputEmail(String email) {
        webElements.inputText(emailInput, email);
    }

    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    public void inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
    }

    public void inputStreet(String street) {
        webElements.inputText(streetInput, street);
    }

    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    public void selectState(int index) {
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByIndex(index);
    }

    public void inputPostcode(String postCode) {
        webElements.inputText(postcodeInput, postCode);
    }

    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobileInput, phone);
    }

    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }

    public String checkError1() {
        return error1.getText();
    }

    public String checkErrorMessage() {
        return errorMessage.getText();
    }

}
