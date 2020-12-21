package Day5;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPOP  extends BasePop {
    @FindBy(id="delayed-alert")
    private WebElement delayedAlert;

    @FindBy(id="delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertPOP(WebDriver driver) {
        super(driver);
        url="https://seleniumui.moderntester.pl/alerts.php";
    }

    public void clickDelayed(){
        delayedAlert.click();
    }
    public String getDelayedLabel(){
        return delayedAlertLabel.getText();
    }
    public void waitAlertAccept(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
