package Day3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class AssertionTest {
    @Test
    public void thisCanPass(){
        Assert.assertEquals(1,1);
        String expectedText="asd";
        Assert.assertEquals("asd",expectedText);
    }
    @Test
    public void youShallNotPass()throws FileNotFoundException {

    }
}
