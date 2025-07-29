package pages;

import org.openqa.selenium.By;

public class SidebarPage {
	public By visitorMenu() {

		return By.xpath("//*[@id='desktop-sidebar']/li[8]");
	}

	public By inviteSubmenu() {

		return By.xpath("//*[@id='desktop-sidebar']/li[8]/ul/li[2]/a/span[2]");
	}

	public By reportMenu() {

		return By.xpath("//*[@id='desktop-sidebar']/li[10]");
	}

	public By reportSubmenu() {

		return By.xpath("//*[@id='desktop-sidebar']/li[10]/ul/li/a/span[2]");
	}

}
