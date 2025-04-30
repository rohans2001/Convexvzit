package pages;

import org.openqa.selenium.By;

public class VisitorLogpage {

	public By visitorLogHostDropdown() {

		return By.xpath("//span[@id='select2-EmployeeId-container']");

	}

	public By visitorLogHostSearchbox() {

		return By.xpath("//input[@role='searchbox']");

	}

	public By visitorInvitestatusDropdown() {

		return By.xpath("//select[@id='InviteStatusId']");

	}

	public By visitorStatusDropdown() {

		return By.xpath("//select[@id='SignInStatusId']");

	}

	public By visitorLogDatePicker() {

		return By.xpath("//input[@id='date-range-picker']");
	}

	public By visitorLogexportButton() {

		return By.xpath("//*[@id='ExportToExcel']");

	}

}
