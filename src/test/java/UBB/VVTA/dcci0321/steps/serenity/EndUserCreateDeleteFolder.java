package UBB.VVTA.dcci0321.steps.serenity;

import net.thucydides.core.annotations.Step;
import UBB.VVTA.dcci0321.pages.HomePage;

public class EndUserCreateDeleteFolder {

    HomePage homePage;

    @Step
    public void createDir(String dirName) {
        homePage.createNewDir();
        homePage.setNewDirName(dirName);
        homePage.confirmYes();
        homePage.goBack();
    }

    @Step
    public void deleteDir() {
        homePage.selectFirstDirectory();
        homePage.clickDelete();
        homePage.confirmDelete();
    }
}
