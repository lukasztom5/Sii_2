package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormAlternatePop extends BasePop{

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

    public FormAlternatePop(WebDriver driver) {
        super(driver);
        url="https://seleniumui.moderntester.pl/form.php";
    }
    public FormAlternatePop fillName(String firstName,String lastName){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        return this;
    }
    public FormAlternatePop fillMail(String eMail){
        inputEmail.sendKeys(eMail);
        return this;
    }
    public FormAlternatePop fillMale(){
        inputMale.click();
        return this;
    }
    public FormAlternatePop fillAge(int age){
        inputAge.sendKeys(Integer.toString(age));
        return this;
    }
    public FormAlternatePop fillExperience(){
        getRandomElement(inputExperience).click();
        return this;
    }
    public FormAlternatePop fillManual(){
        inputManual.click();
        return this;
    }
    public FormAlternatePop fillAdditional(String add){
        inputAdditional.sendKeys(add);
        return this;
    }
    public FormAlternatePop fillCommand(){
        Select command=new Select(inputCommand);
        List<WebElement> commandList=command.getOptions();
        int howMany = getRandomNumber(commandList.size());
        for(int i=0;i<howMany;i++){
            command.selectByIndex(i);
        }
        return this;
    }
    public FormAlternatePop fillContinent(){
        Select continents=new Select(inputContinent);
        List<WebElement> continentList=continents.getOptions();
        continentList.remove(0);
        WebElement randomOption = getRandomElement(continentList);
        continents.selectByVisibleText(randomOption.getText());
        return this;
    }
    public FormAlternatePop fillFile(String src){
        File file=new File(src);
        inputInputFile.sendKeys(file.getAbsolutePath());
        return this;
    }
    public FormAlternatePop fillSignIn(){
        signIn.click();
        return this;
    }
    public String fillValidation(){
        return inputValidation.getText();
    }
}
