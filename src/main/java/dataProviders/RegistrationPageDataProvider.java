package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser() {
        return new Object[][]{
                {
                    new AccountBuilder()
                            .withGender("Mr.")
                            .withFirstCustomerName("Alex")
                            .withLastCustomerName("Shevchenko")
                            .withEmail(faker.internet().emailAddress())
                            .withPassword(faker.internet().password(8,10,true,true,true))
                            .withBirthDay("10")
                            .withBirthMonth("12")
                            .withBirthYear("1990")
                            .withFirstName("Alex")
                            .withLastName("Shevchenko")
                            .withCompany("Google")
                            .withAddress1("street New York, 21")
                            .withAddress2("street New York, 22")
                            .withCity("New York")
                            .withState("New York")
                            .withPostalCode("12345")
                            .withPhoneMobile("1234567890")
                            .withAlias("Hello!")
                            .build()
                }
        };
    }
}
