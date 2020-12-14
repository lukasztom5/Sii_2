package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliceTest extends TestBase{
    private WebElement drag;
    private WebElement drop;
    private Actions actions;
    @BeforeMethod
    public void OpenIframePage(){
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        actions=new Actions(driver);
    }
    @Test
    public void sliceTest(){
        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(100);
    }
    public void moveTo(int expectedSlideValue){
        int actualSliderValue=getSliderValue();
        if(actualSliderValue>expectedSlideValue){
            moveSlider(expectedSlideValue,Keys.ARROW_LEFT);
        }
        else if(actualSliderValue<expectedSlideValue){
            moveSlider(expectedSlideValue,Keys.ARROW_RIGHT);
        }
    }
    public void moveSlider(int expectedSLiderValue,Keys key){
        while(getSliderValue()!=expectedSLiderValue){
            driver.findElement(By.id("custom-handle")).sendKeys(key);
        }
    }
    public int getSliderValue(){
        return Integer.parseInt(driver.findElement(By.id("custom-handle")).getText());
    }
}
