package Day3;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataPickerTest extends TestBase{
    @BeforeMethod
    public void TablePage(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
    }
    @Test
    public void dataPickerTest(){
        selectDate("10","October",2020);
        Assert.assertEquals(getSelectedDate(),"10/10/2020");
    }
    private void selectDate(String dzien,String miesiac, int rok ){

    }
    private String getSelectedDate(){
        return driver.findElement(By.id("datepicker")).getText();
    }
    public String getMonth(){
        return driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
    }
    public int getYear(){
        return Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText());
    }
    public void goNext(String expectedMonth,int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            veryBadSleep();
        }
    }
    public void goPrev(String expectedMonth,int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            veryBadSleep();
        }
    }
}
