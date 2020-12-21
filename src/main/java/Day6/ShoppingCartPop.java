package Day6;

import Day5.BasePop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPop extends BasePop {
    @FindBy(css = ".cart-item")
    private List<WebElement> allCartItems;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement subtotal;

    @FindBy(css="js-subtotal")
    private WebElement numberOfTotal;

    public double getSubtotal() {
        return Double.valueOf(subtotal.getText().replace("$", ""));
    }
    public int getTotalNumberOfItems(){
        return Integer.parseInt(numberOfTotal.getText().replace("items",""));
    }
    public String getNthCartItemsName(int n) {
        return getCartItems().get(n).getName();
    }


    private List<CartItemPop> getCartItems() {
        List<CartItemPop> cartItems = new ArrayList<>();
        for (WebElement e : allCartItems) {
            cartItems.add(new CartItemPop(e));
        }
        return cartItems;
    }

    public ShoppingCartPop(WebDriver driver) {
        super(driver);
    }
}