package mobile.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.utils.WaitUtils;
import org.junit.Assert;

import static mobile.stepDefs.MobileHooks.*;

public class TheScoreLeaguesStepDefs {
    String actualTitle;

    @Given("user is on the Welcome Page")
    // Although there are other ways to test if on Welcome page, but used this one
    public void userIsOnTheWelcomePage() {
        if (theScoreWelcomePage.loginButton.isDisplayed()) {
            System.out.println("App opened successfully");
        } else {
            System.out.println("App not opened as expected");
        }
    }


    @When("user taps on the Log In button")
    public void userTapsOnTheLogInButton() {
        WaitUtils.waitForElementVisible(androidDriver, theScoreWelcomePage.loginButton);
        theScoreWelcomePage.loginButton.click();
    }

    @And("enters valid credentials to log in")
    public void entersValidCredentialsToLogIn() {

        WaitUtils.waitForElementVisible(androidDriver, theScoreLogInPage.emailInputBox);

        theScoreLogInPage.emailInputBox.sendKeys("leon050@mail.ru"); // Used my testing email, so we can be logged in
        theScoreLogInPage.passwordInputBox.sendKeys("JohnDoe228"); // This is just for testing purposes, surely we will use Encapsulation
        theScoreLogInPage.loginButton.click();
        if (theScoreLogInPage.gotItPopup.getText().contains("Got it")) // For testing purpose only. I tried to open using Iphone, it has different popup
            theScoreLogInPage.gotItPopup.click(); // I just need to see the Android app popups, so I know what to do next
    }

    @Then("it takes user to Home Page")
    public void itTakesUserToHomePage() {
        WaitUtils.waitForElementVisible(androidDriver, theScoreHomePage.leaguesButton);

        // Although there are other ways to test if on Home Page, I try this one
        if(theScoreHomePage.leaguesButton.isDisplayed()){
            System.out.println("Logged in successfully");
        }else{
            System.out.println("Check your credentials");
        }
    }

    @When("user selects Leagues")
    public void userSelectsLeagues() {
        theScoreHomePage.leaguesButton.click();
        actualTitle = androidDriver.getTitle();
        Assert.assertTrue(actualTitle.contains("Leagues"));
    }

    @And("user selects Spain Soccer from the Leagues") // Over here we can put {string} instead of Leagues
    public void userSelectsSpainSoccerFromTheLeagues() { // and in the feature file put "Spain Soccer" in double quotation

        WaitUtils.waitForListElementVisible(androidDriver, theScoreLeaguesPage.leagueOptions);

        theScoreLeaguesPage.selectLeagueFromListOfLeagues("Spain Soccer"); // and we add parameters to the method, so it automatically reads whatever is in the double quotation in the feature file
        // so we can then add method clickByVisible text, and it will search in the leagues for that visible text that we require and taps on it, so it becomes reusable
    }

    @Then("Spain Soccer League title should be displayed")
    public void spainSoccerLeagueTitleShouldBeDisplayed() {
        actualTitle = androidDriver.getTitle();
        Assert.assertTrue(actualTitle.contains("Spain Soccer"));
    }

    @And("user selects Table sub-tab")
    public void userSelectsTableSubTab() {

        WaitUtils.waitForListElementVisible(androidDriver, theScoreSpainSoccerLeaguePage.spainSoccerLeagueTabs);

        theScoreSpainSoccerLeaguePage.selectTabFromSpainLeagueTabs("Table");
        // To assert that the Table corresponds to the Spain Soccer League, I need at least Appium Inspector to check
        // what and how it can be done, else I can only think of assertion, if Real Madrid isDisplayed() in the table
    }

    @Then("table subtitle should be displayed")
    public void tableSubtitleShouldBeDisplayed() {
        theScoreSpainSoccerLeaguePage.isTabFromSpainLeagueTabsSelected("Table");
        // This will assert if the table tab is selected, but it only works with radio buttons or checklists,
        // I need Appium Inspector for that
    }

    @When("user taps on back navigation")
    public void userTapsOnBackNavigation() {
        theScoreSpainSoccerLeaguePage.spainSoccerLeagueBackNavigationButton.click();
    }

    @Then("previous page is displayed")
    public void previousPageIsDisplayed() {
        actualTitle = androidDriver.getTitle();
        Assert.assertTrue(actualTitle.contains("Leagues"));
    }
}
