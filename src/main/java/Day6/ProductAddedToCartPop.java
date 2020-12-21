package Day6;

import Day5.BasePop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddedToCartPop extends BasePop {
    @FindBy(css = ".cart-content-btn a")
    private WebElement ProceedButton;
    @FindBy(css = ".cart-content [data-dismiss]")
    private WebElement continueShooping;
    @FindBy(css = "#blockcart-modal")
    private WebElement blockingModal;

    public void clickContinueShopping(){
        continueShooping.click();
        wait.until(ExpectedConditions.invisibilityOf(blockingModal));
    }

    public void clickProceed() {
        ProceedButton.click();
    }

    public ProductAddedToCartPop(WebDriver driver) {
        super(driver);
    }
}