package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration2Page extends MainPage {

    public Registration2Page(WebDriver webDriver) {
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

    @FindBy(xpath = "//div[@id='center_column']/h1")
    private WebElement titleRegisteredAccount;






    /**
     * Method open SignIn page
     */
    public Registration2Page clickSignIn() {
        signInLink.click();
        return this;
    }

    /**
     * Method click to SignIn page
     */
    public Registration2Page openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=my-account");
        return this;
    }

    public Registration2Page inputEmailCreate(String email) {
        loginInput.clear();
        loginInput.sendKeys(email);
        return this;
    }
    public Registration2Page submitButtonCreate() {
        submitButtonCreate.click();
        return this;
    }

    public Registration2Page inputCustomerFN(String firstName) {
        customerFirstName.clear();
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputCustomerLN(String lastName) {
        customerLastName.clear();
        customerLastName.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public Registration2Page inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public Registration2Page inputFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputStreet(String street) {
        streetInput.clear();
        streetInput.sendKeys(street);
        return this;
    }

    public Registration2Page inputCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    public Registration2Page selectState(int index) {
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByIndex(index);
        return this;
    }

    public Registration2Page inputPostcode(String postCode) {
        postcodeInput.clear();
        postcodeInput.sendKeys(postCode);
        return this;
    }

    public Registration2Page inputMobilePhone(String phone) {
        phoneMobileInput.clear();
        phoneMobileInput.sendKeys(phone);
        return this;
    }

    public Registration2Page inputAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        return this;
    }

    public Registration2Page clickSubmitAccount() {
        submitAccount.click();
        return this;
    }

    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }


}

