package Day6;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniaturePop{
    private WebDriver driver;
    @FindBy(css=".product-title")
    private WebElement productTitle;

    @FindBy(css=".price")
    private WebElement price;

    @FindBy(css=".thumbnail")
    private WebElement thumbnail;

    @FindBy(css=".quick-view")
    private WebElement quickView;

    public void click(){
        thumbnail.click();
    }
    public String getProductTitle(){
        return productTitle.getText();
    }
    public Double getProductPrice(){
        String priceNumber=price.getText().replace("$","");
        return Double.valueOf(priceNumber);
    }
    public void clickQuickView(){
        Actions action = new Actions(driver);
        action.moveToElement(thumbnail).build().perform();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(quickView));
        quickView.click();
    }
    
    public MiniaturePop(WebElement productMiniature, WebDriver driver){
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature),this);
        this.driver= this.driver;
    }
}
