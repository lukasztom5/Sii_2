package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FormTest extends TestBase{
    WebDriver driver;
    @Test
    public void formTest() {
        /*WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Jan");*/
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");

        WebElement lastName = driver.findElement(By.cssSelector("input#inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement email = driver.findElement(By.cssSelector("input#inputEmail3"));
        email.sendKeys("jan@kowalski.pl");

        WebElement male = driver.findElement(By.cssSelector("input[value='male']"));
        male.click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("15");

        List<WebElement> yearsOfExpirience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(yearsOfExpirience).click();

        WebElement manualTester = driver.findElement(By.id("gridCheckManulTester"));
        manualTester.click();

        WebElement additionalInfo = driver.findElement(By.cssSelector("#additionalInformations"));
        additionalInfo.sendKeys("Test");

        WebElement comment = driver.findElement(By.id("selectSeleniumCommands"));
        Select commandSelect=new Select(comment);
       // commandSelect.selectByValue("browser-commands");
        List<WebElement> commandList=commandSelect.getOptions();
        int howManyOptions = getRandomNumber(commandList.size());
        for(int i=0;i<howManyOptions;i++){
            commandSelect.selectByIndex(i);
        }

        WebElement continent = driver.findElement(By.id("selectContinents"));
        Select continents=new Select(continent);
        List<WebElement> continentList=continents.getOptions();
        continentList.remove(0);
        WebElement randomOption = getRandomElement(continentList);
        continents.selectByVisibleText(randomOption.getText());

        WebElement fileInput=driver.findElement(By.id("chooseFile"));
        File file=new File("src/main/resources/empty.txt");
        fileInput.sendKeys(file.getAbsolutePath());

        WebElement signIn = driver.findElement(By.cssSelector("button[type='submit']"));
        signIn.click();

        Assert.assertEquals(driver.findElement(By.id("validator-message")).getText(),"Form send with success");

    }




}