package pages;

import org.openqa.selenium.By;

public class InvitePage {
    public By addInviteButton() {
        return By.xpath("//span[normalize-space()='Add Invite']");
    }

    public By visitorNameInput() {
        return By.xpath("//div[@class='modal-content']/div[2]/div/div/div/input[1]");
    }

    public By purposeDropdown() {
        return By.id("Visitor_Visits_0__VisitPurposeID");
    }

    public By subjectInput() {
        return By.id("Visitor_Visits_0__VisitSubject");
    }

    public By companyNameInput() {
        return By.id("Visitor_CompanyName");
    }

    public By visitDateInput() {
        return By.id("Visitor_Visits_0__VisitStartDateTime");
    }

    public By hostSelectBox() {
        return By.cssSelector("span.select2-selection--single");
    }

    public By hostSearchInput() {
        return By.xpath("//*[@id='NewInviteModal']/span/span/span[1]/input");
    }

    public By emailInput() {
        return By.id("Visitor_Email");
    }

    public By saveButton() {
        return By.xpath("//*[@id='visitor-modal-footer']/button[2]");
    }

    public By confirmButton() {
        return By.xpath("//button[normalize-space()='Yes']");
    }
}
