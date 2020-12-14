package Day3;

import org.testng.annotations.*;

public class AnnotationTest {
    @BeforeClass
    public void executeBeforeClass(){
        System.out.println("To się wykona przed wszystkim");
    }
    @BeforeMethod
    public void executeBeforeMethod(){
        System.out.println("To się wykona przed każdym testem");
    }
    @BeforeMethod
    public void Test(){
        System.out.println("To jest mój pierwszy test");
    }
    @AfterMethod
    public void executeAfterMethod(){
        System.out.println("To się wykona po każdym teście");
    }
    @AfterClass
    public void executeAfterClass(){
        System.out.println("To się wykona po wszystkim");
    }
}
