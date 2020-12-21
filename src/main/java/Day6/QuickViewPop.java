package Day6;

import Day5.BasePop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickViewPop extends BasePop {
    public QuickViewPop(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="h1.h1")
    private WebElement title;

    @FindBy(name="qty")
    private WebElement quantityWanted;

    @FindBy(css=".add-to-cart")
    private WebElement addToCart;

    @FindBy(css = ".cart-content-btn a")
    private WebElement addedToCartProceedButton;
    @FindBy(css = ".cart-content [data-dismiss]")
    private WebElement continueShooping;

    public String getTitle(){
        return title.getText();
    }
    public void clickAddCart(){
        addToCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(addedToCartProceedButton));
    }
    public void clickContinueShopping(){
        continueShooping.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShooping));
    }
    public void setQuantity(int n){
        quantityWanted.clear();
        quantityWanted.sendKeys(Integer.toString(n));
    }



}
