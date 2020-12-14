package Day3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class IframeTest extends TestBase{
    @BeforeMethod
    public void OpenIframePage(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }
    @Test
    public void iframeTest(){
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Lukasz");
        driver.findElement(By.id("inputLastName3")).sendKeys("Tomczyk");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("lukasztom5");
        driver.findElement(By.id("inputPassword")).sendKeys("avatar2010");
        WebElement continent = driver.findElement(By.id("selectContinents"));
        Select continents=new Select(continent);
        List<WebElement> continentList=continents.getOptions();
        continentList.remove(0);
        WebElement randomOption = getRandomElement(continentList);
        continents.selectByVisibleText(randomOption.getText());
        List<WebElement> yearsOfExpirience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(yearsOfExpirience).click();
    }
}
