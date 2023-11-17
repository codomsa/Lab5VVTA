package UBB.VVTA.dcci0321.steps.serenity;

import net.thucydides.core.annotations.Step;
import UBB.VVTA.dcci0321.pages.LogoutPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EndUserLogoutSteps {

    LogoutPage logoutPage;

    @Step
    public void logout() {
        logoutPage.logout();
    }

    @Step
    public void verify_message(String message) {
        String logoutMessage = logoutPage.getLogoutConfirmationMessage();
        assertThat(logoutMessage, containsString(message));
    }
}
