package Day5;

import Day3.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertAlternateTest extends TestBase {
    @Test
    public void alertTest(){
        AlertAlternatePop alertPop=new AlertAlternatePop(driver);
        alertPop.open();
        Assert.assertEquals(alertPop.clickDelayed()
                .waitAlertAccept()
                .getDelayedLabel(),"OK button pressed");
    }
}
