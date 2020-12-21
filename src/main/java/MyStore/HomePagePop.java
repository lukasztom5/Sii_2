package MyStore;

import Day5.BasePop;
import Day6.MiniaturePop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePagePop extends BasePop {
    @FindBy(css=".product-miniature")
    private List<WebElement> allProducts;

    @FindBy(css=".add-to-cart")
    private WebElement quickViewAddToCartButton;

    public String getNameOfNthMiniature(int n){
        return getProductMiniatures().get(n).getProductTitle();
    }

    public void openQuickView(int n){
        getProductMiniatures().get(n).clickQuickView();
        wait.until(ExpectedConditions.elementToBeClickable(quickViewAddToCartButton));
    }

    private List<MiniaturePop> getProductMiniatures(){
        List<MiniaturePop> miniatures = new ArrayList<>();
        for(WebElement e:allProducts){
            miniatures.add(new MiniaturePop(e,driver));
        }
        return miniatures;
    }

    public void printAllPrices(){
        for(MiniaturePop mp:getProductMiniatures()){
            System.out.println(mp.getProductPrice());
        }
    }

    public HomePagePop(WebDriver driver) {
        super(driver);
        url="http://5.196.7.235/";
    }
    public double getPriceOfNthMiniature(int n){
        return getProductMiniatures().get(n).getProductPrice();
    }
    public int miniatureNumber() {
        return allProducts.size();
    }
}
