package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.io.File;

public class FormPOP extends BasePop{

    @FindBy(id="inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(id="inputLastName3")
    private WebElement inputLastName;

    @FindBy(id="inputEmail3")
    private WebElement inputEmail;

    @FindBy(css="input[value='male']")
    private WebElement inputMale;

    @FindBy(id="inputAge3")
    private WebElement inputAge;

    @FindBy(name="gridRadiosExperience")
    private List<WebElement> inputExperience;

    @FindBy(id="additionalInformations")
    private WebElement inputAdditional;

    @FindBy(id="selectSeleniumCommands")
    private WebElement inputCommand;

    @FindBy(id="selectContinents")
    private WebElement inputContinent;

    @FindBy(id="chooseFile")
    private WebElement inputInputFile;

    @FindBy(id="gridCheckManulTester")
    private WebElement inputManual;

    @FindBy(css="button[type='submit']")
    private WebElement signIn;

    @FindBy(id="validator-message")
    private WebElement inputValidation;

    public FormPOP(WebDriver driver) {
        super(driver);
        url="https://seleniumui.moderntester.pl/form.php";
    }
    public void fillName(String firstName,String lastName){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
    }
    public void fillMail(String eMail){
        inputEmail.sendKeys(eMail);
    }
    public void fillMale(){
        inputMale.click();
    }
    public void fillAge(int age){
        inputAge.sendKeys(Integer.toString(age));
    }
    public void fillExperience(){
        getRandomElement(inputExperience).click();
    }
    public void fillManual(){
        inputManual.click();
    }
    public void fillAdditional(String add){
        inputAdditional.sendKeys(add);
    }
    public void fillCommand(){
        Select command=new Select(inputCommand);
        List<WebElement> commandList=command.getOptions();
        int howMany = getRandomNumber(commandList.size());
        for(int i=0;i<howMany;i++){
            command.selectByIndex(i);
        }
    }
    public void fillContinent(){
        Select continents=new Select(inputContinent);
        List<WebElement> continentList=continents.getOptions();
        continentList.remove(0);
        WebElement randomOption = getRandomElement(continentList);
        continents.selectByVisibleText(randomOption.getText());
    }
    public void fillFile(String src){
        File file=new File(src);
        inputInputFile.sendKeys(file.getAbsolutePath());
    }
    public void fillSignIn(){
        signIn.click();
    }
    public String fillValidation(){
        return inputValidation.getText();
    }
}
