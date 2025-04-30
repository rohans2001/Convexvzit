package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.SidebarPage;
import pages.VisitorLogpage;
import utils.BaseClass;
import utils.LoginHelper;

public class VisitLogReport extends BaseClass {

	private SidebarPage sidebarPage = new SidebarPage();
	private VisitorLogpage VisitorLogpage = new VisitorLogpage();

	@Test(priority = 1)
	public void visitReport() throws InterruptedException {
		LoginHelper loginHelper = new LoginHelper(driver, wait, js);
		loginHelper.performLogin("admin", "1q2w3E*");

		// navigate to visitor log page

		driver.findElement(sidebarPage.reportMenu()).click();
		WebElement reportMenu = wait.until(ExpectedConditions.elementToBeClickable(sidebarPage.reportSubmenu()));
		js.executeScript("arguments[0].click();", reportMenu);

		driver.findElement(VisitorLogpage.visitorLogHostDropdown()).click();
		WebElement hostSearch = wait
				.until(ExpectedConditions.elementToBeClickable(VisitorLogpage.visitorLogHostSearchbox()));
		hostSearch.sendKeys("ROHAN");
		Thread.sleep(1000);
		hostSearch.sendKeys(Keys.ENTER);

		WebElement datePicker = driver.findElement(VisitorLogpage.visitorLogDatePicker());
		datePicker.clear();
		datePicker.sendKeys("04/01/2024 - 04/30/2025");
		datePicker.sendKeys(Keys.ENTER);

		new Select(driver.findElement(VisitorLogpage.visitorInvitestatusDropdown())).selectByVisibleText("Approved");
		new Select(driver.findElement(VisitorLogpage.visitorStatusDropdown())).selectByVisibleText("Adhoc Visitor");
		Thread.sleep(1000);

		driver.findElement(VisitorLogpage.visitorLogexportButton()).click();
		Thread.sleep(2000);

	}
}
