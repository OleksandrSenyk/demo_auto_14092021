package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;
import pagesSelenium.Registration2Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    
    public SelenideElement
            submitButtonCreate = $x("//button[@id='SubmitCreate']"),
            fromAccount = $x("form[@id='account-creation_form']/div"),
            genderMr = $("#id_gender1"),
            genderMrs = $("#id_gender2"),
            customerFNInput = $(By.id("customer_firstname")),
            customerLNInput = $(By.id("customer_lastname")),
            emailInput = $(By.id("email")),
            passwordInput = $x("//input[@type='password']"),
            dayDropDown = $(By.id("days")),
            monthsDropDown = $(By.id("months")),
            yearsDropDown = $(By.id("years")),
            checkboxNewsLetter = $(By.id("uniform-newsletter")),
            checkboxNewsOptin = $(By.id("optin")),
            firstNameInput = $x("//input[@id='firstname']"),
            lastNameInput = $x("//input[@id='lastname']"),
            companyName = $(By.id("company")),
            addressByDefault = $x("//div[@class='account_creation']//p[4]//input[@type='text']"),
            cityInput = $x("//input[@id='city']"),
            selectStateByIndex = $x("//select[@id='id_state']"),
            postCodeInput = $x("//input[@id='postcode']"),
            idCountry = $(By.id("id_country")),
            phoneMobileInput = $(By.id("phone_mobile")),
            aliasInput = $(By.id("alias")),
            submitAccount = $(By.id("submitAccount"));

    @Step("Select gender {gender}")
    public RegistrationPage selectGender(String gender) {
        if (gender.equals("1")) {
            genderMr.selectRadio(gender);
        } else {
            genderMrs.selectRadio(gender);
        }
        return this;
    }

    @Step("Input customer first name {firstName}")
    public RegistrationPage inputCustomerFN(String firstName) {
        customerFNInput.setValue(firstName);
        return this;
    }

    @Step("Input customer last name {lastName}")
    public RegistrationPage inputCustomerLN(String lastName) {
        customerLNInput.setValue(lastName);
        return this;
    }

    @Step("Input email {email}")
    public RegistrationPage inputEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Input password {password}")
    public RegistrationPage inputPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Select birthday {day}")
    public RegistrationPage selectBirthDay(String day){
        dayDropDown.selectOptionByValue(day);
        return this;
    }

    @Step("Select birthday month {month}")
    public RegistrationPage selectBirthMonth(String month){
        monthsDropDown.selectOptionByValue(month);
        return this;
    }

    @Step("Select birthday year {year}")
    public RegistrationPage selectBirthYear(String year){
        yearsDropDown.selectOptionByValue(year);
        return this;
    }

    @Step("Input first name {firstName}")
    public RegistrationPage inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Input last name {lastName}")
    public RegistrationPage inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        companyName.setValue(company);
    }

    @Step("Input street {street}")
    public RegistrationPage inputAddressByDefault(String address) {
        addressByDefault.setValue(address);
        return this;
    }

    @Step("Input city {city}")
    public RegistrationPage inputCity(String city) {
        cityInput.setValue(city);
        return this;
    }

    @Step("Select city  {state}")
    public void selectState(String state) {
        selectStateByIndex.selectOptionContainingText(state);
    }

    @Step("Select country {text}")
    public RegistrationPage selectCountry(String text) {
        idCountry.selectOptionContainingText(text);
        return this;
    }

    @Step("Input post code {postCode}")
    public RegistrationPage inputPostcode(String postCode) {
        postCodeInput.setValue(postCode);
        return this;
    }

    @Step("Input mobile {phone}")
    public RegistrationPage inputMobilePhone(String phone) {
        phoneMobileInput.setValue(phone);
        return this;
    }

    @Step("Input alias {alias}")
    public RegistrationPage inputAlias(String alias) {
        aliasInput.setValue(alias);
        return this;
    }

    @Step("Submit account")
    public RegistrationPage clickSubmitAccount() {
        submitAccount.click();
        return this;
    }

    public void registrationNewUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPassword());
        selectBirthDay(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputCompany(account.getCompany());
        inputAddressByDefault(account.getAddress1());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostcode(account.getPostCode());
        selectCountry(account.getCountry());
        inputMobilePhone(account.getPhoneMobile());
        inputAlias(account.getAlias());
   }


}
