package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertAlternatePop extends BasePop{
    @FindBy(id="delayed-alert")
    private WebElement delayedAlert;

    @FindBy(id="delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertAlternatePop(WebDriver driver) {
        super(driver);
        url="https://seleniumui.moderntester.pl/alerts.php";
    }

    public AlertAlternatePop clickDelayed(){
        delayedAlert.click();
        return this;
    }
    public String getDelayedLabel(){
        return delayedAlertLabel.getText();
    }
    public AlertAlternatePop waitAlertAccept(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }
}
