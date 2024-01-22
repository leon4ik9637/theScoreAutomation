package mobile.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.utils.AppiumScroll;
import mobile.utils.MobileCommonUtils;

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
    public void userTapsOnTheLogInButton() throws InterruptedException {
        Thread.sleep(10000);
        MobileCommonUtils.tapByCoordinates(androidDriver, 710, 1848);
    }

    @And("enters valid credentials to log in")
    public void entersValidCredentialsToLogIn() throws InterruptedException {

        theScoreLogInPage.emailInputBox.sendKeys("leon050@mail.ru"); // Used my testing email, so we can be logged in
        theScoreLogInPage.passwordInputBox.sendKeys("JohnDoe228"); // This is just for testing purposes, surely we will use Encapsulation
        theScoreLogInPage.loginPageLoginButton.click();

        Thread.sleep(10000);

    }

    @Then("it takes user to Home Page")
    public void itTakesUserToHomePage() throws InterruptedException {

        try{
            if(theScoreHomePage.popupAdDismissal.isDisplayed() || theScoreHomePage.allowLocationButton.isDisplayed()){
                System.out.println("Logged in successfully");
                if(theScoreHomePage.popupAdDismissal.isDisplayed()){
                    theScoreHomePage.popupAdDismissal.click();
                    theScoreHomePage.allowLocationButton.click();
                    theScoreHomePage.permissionAllowButton.click();
                } else if(theScoreHomePage.allowLocationButton.isDisplayed()){
                    theScoreHomePage.allowLocationButton.click();
                    theScoreHomePage.permissionAllowButton.click();
                    theScoreHomePage.popupAdDismissal.click();
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Check your credentials");
        }
        Thread.sleep(5000);
    }

    @When("user selects Leagues")
    public void userSelectsLeagues() throws InterruptedException {
        theScoreHomePage.leaguesButton.click();
        Thread.sleep(10000);
        try{
            if(theScoreLeaguesPage.leaguesTitleText.isDisplayed()){
                System.out.println("User is on the Leagues page");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("User is not on the Leagues page");
        }
    }

    @And("user selects Spain Soccer from the Leagues")
    public void userSelectsSpainSoccerFromTheLeagues() throws InterruptedException {

        Thread.sleep(10000);
        AppiumScroll.verticalScroll(androidDriver);
        Thread.sleep(5000);
        AppiumScroll.verticalScroll(androidDriver);
        Thread.sleep(5000);
        theScoreLeaguesPage.selectLeagueFromListOfLeagues("Spain Soccer");
        Thread.sleep(10000);
    }

    @Then("Spain Soccer League title should be displayed")
    public void spainSoccerLeagueTitleShouldBeDisplayed() throws InterruptedException {

        if(theScoreSpainSoccerLeaguePage.SpainSoccerTitleText
                .getAttribute("text").contains("Spain Soccer")){
            System.out.println("User is on the Spain Soccer league");
        };
        Thread.sleep(5000);
    }

    @And("user selects Table sub-tab")
    public void userSelectsTableSubTab() throws InterruptedException {

//        WaitUtils.waitForListElementVisible(androidDriver, theScoreSpainSoccerLeaguePage.spainSoccerLeagueTabs);

        theScoreSpainSoccerLeaguePage.spainSoccerLeagueTabs.click();
        Thread.sleep(10000);


    }

    @Then("table subtitle should be selected")
    public void tableSubtitleShouldBeDisplayed() {
        try{
            if(theScoreSpainSoccerLeaguePage.spainSoccerLeagueTabs.isSelected()){
                System.out.println("User is on the Spain Soccer League Table");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Table is not selected");
        }
    }

    @When("user taps on back navigation")
    public void userTapsOnBackNavigation() {
        theScoreSpainSoccerLeaguePage.spainSoccerLeagueBackNavigationButton.click();
    }

    @Then("previous page Leagues is displayed")
    public void previousPageIsDisplayed() throws InterruptedException {
        Thread.sleep(10000);
        try{
            if(theScoreLeaguesPage.leaguesTitleText.isDisplayed()){
                System.out.println("User is on the previous Leagues page");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("User is not on the Leagues page");
        }
    }
}
