package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class BasePop {
    protected WebDriver driver;
    protected String url;
    protected WebDriverWait wait;
    public void open(){
        driver.get(url);
    }
    public BasePop(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,20);
    }
    protected WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }
    protected int getRandomNumber(int max){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max)+1;
        return randomNumber;
    }
    protected void veryBadSleep(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
