package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.InvitePage;
import pages.SidebarPage;
import utils.BaseClass;
import utils.ExcelUtil;
import utils.LoginHelper;

public class AddInvite extends BaseClass {

    private List<String> visitorNames;
    private int currentIndex = 0;
	
    private SidebarPage sidebarPage = new SidebarPage();
    private InvitePage invitePage = new InvitePage();

    @BeforeClass
    public void loadNamesFromExcel() throws IOException {
        visitorNames = ExcelUtil.readNamesFromExcel("src/test/resources/visitor_names.xlsx", "Visitors");
    }

    @Test(priority = 1)
    public void loginAndGoToInvitesPage() {
        LoginHelper loginHelper = new LoginHelper(driver, wait, js);
        loginHelper.performLogin("admin", "1q2w3E*");

        // Navigate to Invites
        driver.findElement(sidebarPage.visitorMenu()).click();
        WebElement invitesMenu = wait.until(ExpectedConditions.elementToBeClickable(sidebarPage.inviteSubmenu()));
        js.executeScript("arguments[0].click();", invitesMenu);

        wait.until(ExpectedConditions.presenceOfElementLocated(invitePage.addInviteButton()));
    }

    @Test(priority = 2, invocationCount = 16)
    public void addVisitorInvite() throws InterruptedException {
        if (currentIndex >= visitorNames.size()) {
            throw new RuntimeException("No more visitor names left.");
        }
        String name = visitorNames.get(currentIndex++);
        fillInviteForm(name);
    }

    private void fillInviteForm(String name) throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(invitePage.addInviteButton()));
        js.executeScript("arguments[0].scrollIntoView(true);", addButton);
        js.executeScript("arguments[0].click();", addButton);

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(invitePage.visitorNameInput()));
        nameField.sendKeys(name);

        String clean = name.replaceAll("\\s+", "").replaceAll("[^a-zA-Z]", "").toLowerCase();
        int number = 1000 + new Random().nextInt(9000);
        String email = clean + number + "@yopmail.com";

        new Select(driver.findElement(invitePage.purposeDropdown())).selectByVisibleText("Interview");
        driver.findElement(invitePage.subjectInput()).sendKeys("Interview");
        driver.findElement(invitePage.companyNameInput()).sendKeys("Abc Company");
        js.executeScript("arguments[0].value='2025-08-04';", driver.findElement(invitePage.visitDateInput()));

        driver.findElement(invitePage.hostSelectBox()).click();
        WebElement hostSearch = wait.until(ExpectedConditions.elementToBeClickable(invitePage.hostSearchInput()));
        hostSearch.sendKeys("Rohan");
        Thread.sleep(1000);
        hostSearch.sendKeys(Keys.ENTER);

        driver.findElement(invitePage.emailInput()).sendKeys(email);

        driver.findElement(invitePage.saveButton()).click();

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(invitePage.confirmButton()));
        js.executeScript("arguments[0].click();", confirmButton);
        Reporter.log("Visitor invite form submitted for " + name, true);

    }
}
