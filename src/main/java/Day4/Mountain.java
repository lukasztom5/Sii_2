package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Mountain {
    private String name;
    private int height;
    private String state;

    public Mountain(WebElement row) {
        List<WebElement> partOfRow = row.findElements(By.cssSelector("td"));
        this.name = partOfRow.get(0).getText();
        this.height = Integer.parseInt(partOfRow.get(3).getText());
        this.state = partOfRow.get(2).getText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
