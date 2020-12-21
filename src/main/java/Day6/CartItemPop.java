package Day6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CartItemPop {
    @FindBy(css = "a.label")
    private WebElement name;

    public String getName() {
        return name.getText();
    }

    public CartItemPop(WebElement productMiniature) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }
}