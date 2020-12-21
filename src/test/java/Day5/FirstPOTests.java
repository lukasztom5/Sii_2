package Day5;

import Day3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstPOTests extends TestBase{
    @Test
    public void firstTest(){
        FormPOP formPop = new FormPOP(driver);
        formPop.open();
        formPop.fillName("Lukasz","Tomczyk");
        formPop.fillMail("lukasztom5@gmail.com");
        formPop.fillMale();
        formPop.fillAge(15);
        formPop.fillExperience();
        formPop.fillManual();
        formPop.fillAdditional("gfldfkghd");
        formPop.fillCommand();
        formPop.fillContinent();
        formPop.fillFile("src/main/resources/empty.txt");
        formPop.fillSignIn();
        Assert.assertEquals(formPop.fillValidation(),"Form send with success");
    }
    @Test
    public void progressBarTest(){
        ProgressBarPOP progressBarPOP=new ProgressBarPOP(driver);
        progressBarPOP.open();
        Assert.assertTrue(progressBarPOP.progressBarComplete());
    }
    @Test
    public void alertTest(){
        AlertPOP alertPop=new AlertPOP(driver);
        alertPop.open();
        alertPop.clickDelayed();
        alertPop.waitAlertAccept();
        Assert.assertEquals(alertPop.getDelayedLabel(),"OK button pressed");
    }
}
