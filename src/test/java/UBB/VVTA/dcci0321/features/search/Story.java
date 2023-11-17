package UBB.VVTA.dcci0321.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import UBB.VVTA.dcci0321.steps.serenity.*;

@RunWith(SerenityRunner.class)
public class Story {

    @Managed(uniqueSession = true, driver="firefox")
    public WebDriver webdriver;

    @Steps
    public EndUserLoginSteps loginsteps;

    @Steps
    public EndUserCreateDeleteFolder createdeletesteps;

    @Steps
    public EndUserLogoutSteps logoutsteps;

    @Issue("login valid")
    @Test
    public void login_valid() {
        // Log in to SCS UBB Cluj portal with SCS credentials
        loginsteps.goto_home_ftppage_with_credentials("vvss","strugure");

        loginsteps.acceptCookiesIfPresent();
        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta34", "vvta34");
    }

    @Issue("create directory")
    @Test
    public void create_dir() {
        // Log in to SCS UBB Cluj portal with SCS credentials
        loginsteps.goto_home_ftppage_with_credentials("vvss","strugure");

        loginsteps.acceptCookiesIfPresent();
        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta34", "vvta34");

        // Perform the create directory steps
        createdeletesteps.createDir("dir1");
    }

    @Issue("delete directory")
    @Test
    public void delete_dir() {
        // Log in to SCS UBB Cluj portal with SCS credentials
        loginsteps.goto_home_ftppage_with_credentials("vvss","strugure");

        loginsteps.acceptCookiesIfPresent();
        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta34", "vvta34");

        // Perform the create and delete directory steps
        createdeletesteps.createDir("dir1");
        createdeletesteps.deleteDir();
    }

    @Issue("logout")
    @Test
    public void logout() {
        // Log in to SCS UBB Cluj portal with SCS credentials
        loginsteps.goto_home_ftppage_with_credentials("vvss","strugure");
        loginsteps.acceptCookiesIfPresent();
        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta34", "vvta34");

        // Perform the logout steps
        webdriver.manage().window().maximize();
        logoutsteps.logout();
        logoutsteps.verify_message("logged out");
    }
}