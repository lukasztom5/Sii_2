package Day5;

import Day3.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAlternateTest extends TestBase {
    @Test
    public void firstTest(){
        FormAlternatePop formAlternate = new FormAlternatePop(driver);
        formAlternate.open();
        formAlternate.fillName("Lukasz","Tomczyk")
                .fillMail("lukasztom5@gmail.com")
                .fillAdditional("gsgfd")
                .fillAge(15)
                .fillMale()
                .fillCommand()
                .fillContinent()
                .fillExperience()
                .fillManual()
                .fillFile("src/main/resources/empty.txt")
                .fillSignIn();
        Assert.assertEquals(formAlternate.fillValidation(),"Form send with success");
    }
}
