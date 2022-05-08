import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utils.DriverFactory;
import utils.DriverUtils;

public class StepDefinitions {
    String actualPageTitle;
    String actualLoginText;
    String actualRegisterText;
    String wrongPasswordMsg;
    String actualToastMsg;

// Login page
@Given("user is on the homepage of the portal")
public void user_is_on_the_homepage_of_the_portal() {

    BasePage.driverUtils.navigateToUrl(DriverFactory.properties.getProperty("url"));

}

    @When("user navigates to the login page")
    public void user_navigates_to_the_login_page() {

        BasePage.homePage.clickLoginLink();

    }

    @Then("user should see the Login header")
    public void user_should_see_the_login_header() {

        actualLoginText = BasePage.loginPage.getLoginText();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedLoginText"),actualLoginText);

    }

    @When("user logins with the <email>, <password>")
    public void user_logins_with_the_email_password(io.cucumber.datatable.DataTable dataTable) {

        BasePage.loginPage.enterEmail(dataTable.cell(1,0));
        BasePage.loginPage.enterPassword(dataTable.cell(1,1));
        BasePage.loginPage.clickLoginButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully()// throws InterruptedException
    {
        //Thread.sleep(100);
        Assertions.assertTrue(BasePage.homePage.logoutButtonCheck());

    }

    @Then("user should see an error message stating username\\/password incorrect")
    public void user_should_see_an_error_message_stating_username_password_incorrect()
    {

        wrongPasswordMsg = BasePage.loginPage.getToastMessage();
        Assertions.assertEquals(DriverFactory.properties.getProperty("wrongPasswordMsg"),wrongPasswordMsg);

    }

    @When("user navigates from login to the Register page")
    public void user_navigates_from_login_to_the_register_page() {

        BasePage.homePage.clickRegisterLink();

    }

    @Then("user should see the Register header")
    public void user_should_see_the_register_header() {

        actualRegisterText = BasePage.registerPage.getRegisterCheckText();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedRegisterText"),actualRegisterText);

    }

// Register feature

    @When("user navigates to the Register page")
    public void user_navigates_to_the_register_page() {
        BasePage.homePage.clickRegisterLink();

    }

    @When("user provides their <firstname>, <lastname>, <email> and <password>")
    public void user_provides_their_firstname_lastname_email_and_password(io.cucumber.datatable.DataTable dataTable) {

        BasePage.registerPage.enterFirstname(dataTable.cell(1,0));
        BasePage.registerPage.enterLastname(dataTable.cell(1,1));
        BasePage.registerPage.enterEmail(dataTable.cell(1,2));
        BasePage.registerPage.enterPassword(dataTable.cell(1,3));

        BasePage.registerPage.clickRegisterButton();
    }

    @Then("user should be registered successfully")
    public void user_should_be_registered_successfully() {

        Assertions.assertTrue(BasePage.homePage.logoutButtonCheck());

    }

    @Then("user should see an error message stating that user already exists")
    public void user_should_see_an_error_message_stating_that_user_already_exists() {
        actualToastMsg = BasePage.registerPage.getToastMessage();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedEmailInUse"),actualToastMsg);

    }

    @Then("user should see an error message stating alphanumeric password is required")
    public void user_should_see_an_error_message_stating_alphanumeric_password_is_required() {
        actualToastMsg = BasePage.registerPage.getToastMessage();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedAlphanumericPwdMsg"),actualToastMsg);

    }

    @When("user clicks on register button")
    public void user_clicks_on_register_button() {

        BasePage.registerPage.clickRegisterButton();

    }

    @Then("user should see an error message stating that mandatory fields are missing")
    public void user_should_see_an_error_message_stating_that_mandatory_fields_are_missing() {
        actualToastMsg = BasePage.registerPage.getToastMessage();
        Assertions.assertEquals(DriverFactory.properties.getProperty("mandatoryFieldsMsg"),actualToastMsg);

    }

    @When("user navigates to the login page from register page")
    public void user_navigates_to_the_login_page_from_register_page() {

        BasePage.registerPage.clickLoginLink();
    }



/*
    @Given("user is on the homepage of HealthCare App")
    public void user_is_on_the_homepage_of_health_care_app() {
        BasePage.driverUtils.navigateToUrl(DriverFactory.properties.getProperty("url"));
    }
    @Then("user will be on the homepage")
    public void user_will_be_on_the_homepage() {
        actualPageTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedHomePageTitle"),actualPageTitle);

    }
    @When("user clicks on the login link")
    public void user_clicks_on_the_login_link() {
        BasePage.homePage.clickLoginLink();

    }
    @Then("user will be navigated to the login page")
    public void user_will_be_navigated_to_the_login_page() {
        actualLoginText = BasePage.loginPage.getLoginText();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedLoginText"),actualLoginText);

    }
    @When("user enters email password")
    public void user_enters_email_password(io.cucumber.datatable.DataTable dataTable) {
        BasePage.loginPage.enterEmail(dataTable.cell(1,0));
        BasePage.loginPage.enterPassword(dataTable.cell(1,1));

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        BasePage.loginPage.clickLoginButton();

    }
    @Then("user will be logged in successfully")
    public void user_will_be_logged_in_successfully() {
        Assertions.assertTrue(BasePage.homePage.verifyLogout());

    }

    @When("user clicks on the register link on the navbar")
    public void user_clicks_on_the_register_link_on_the_navbar() {
        BasePage.homePage.clickRegisterLink();
    }

    @Then("user will be navigated to the register page")
    public void user_will_be_navigated_to_the_register_page() {
        actualRegisterText = BasePage.registerPage.getRegisterCheckText();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedRegisterText"),actualRegisterText);
    }

    @When("user enters firstname lastname email password")
    public void user_enters_firstname_lastname_email_password(io.cucumber.datatable.DataTable dataTable) {
        BasePage.registerPage.enterFirstname(dataTable.cell(1,0));
        BasePage.registerPage.enterLastname(dataTable.cell(1,1));
        BasePage.registerPage.enterEmail(dataTable.cell(1,2));
        BasePage.registerPage.enterPassword(dataTable.cell(1,3));
    }

    @When("user clicks on register button")
    public void user_clicks_on_register_button() {

        BasePage.registerPage.clickRegisterButton();
    }

    @Then("user will be registered successfully")
    public void user_will_be_registered_successfully() {

        Assertions.assertTrue(BasePage.homePage.verifyLogout());
    }

    @Then("user will be shown an error message stating user already exists")
    public void user_will_be_shown_an_error_message_stating_user_already_exists() {

        actualEmailInUseMsg = BasePage.driverUtils.getAlertTextMessage();
        Assertions.assertEquals(DriverFactory.properties.getProperty("expectedEmailInUse"),actualEmailInUseMsg);
    }

    @Then("user will be shown an error message stating alphanumeric password is required")
    public void user_will_be_shown_an_error_message_stating_alphanumeric_password_is_required() {

    }

    @Then("user will be shown an error message stating that mandatory fields are missing")
    public void user_will_be_shown_an_error_message_stating_that_mandatory_fields_are_missing() {

    }

 */

}
