package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);
        // driver.manage().window().setPosition(new Point(3440,0));
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }
    @AfterMethod
    public void  tearDown() {driver.quit();}
    public WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }
    public int getRandomNumber(int max){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max)+1;
        return randomNumber;
    }
    void veryBadSleep(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
