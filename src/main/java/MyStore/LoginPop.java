package MyStore;

import Day5.BasePop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPop extends BasePop {

    @FindBy(css = "[data-link-action=\"display-register-form\"]")
    private WebElement createAccountLink;

    public void clickCreateAccountLink(){
        createAccountLink.click();
    }



    public LoginPop(WebDriver driver) {
        super(driver);
        url = "http://5.196.7.235/login";
    }
}