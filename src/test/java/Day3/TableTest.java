package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Day4.Mountain;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends TestBase{
    @BeforeMethod
    public void TablePage(){
        driver.get("https://seleniumui.moderntester.pl/table.php");
    }
    @Test
    public void tableTest(){
        List<WebElement> table= driver.findElements(By.cssSelector("tbody>tr"));
        List<Mountain> mountains=new ArrayList<>();
        for(WebElement we:table){
            mountains.add(new Mountain(we));
        }
        for(Mountain m:mountains){
            if(m.getHeight()>4500 && m.getState().contains("Switzerland")){
                System.out.println(m.toString());
            }
        }

    }

}
