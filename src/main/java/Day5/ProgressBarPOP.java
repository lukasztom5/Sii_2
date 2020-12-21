package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarPOP extends BasePop{

    @FindBy(css=".ui-progressbar-complete")
    private WebElement progressBar;

    public boolean progressBarComplete(){
        wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar,"Complete!"));
        return progressBar.isDisplayed();
    }

    public ProgressBarPOP(WebDriver driver) {
        super(driver);
        url="https://seleniumui.moderntester.pl/progressbar.php";
    }
}
