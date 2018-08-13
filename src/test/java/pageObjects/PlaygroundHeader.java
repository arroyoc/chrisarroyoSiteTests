package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaygroundHeader extends PageObjectsBase {

    private By formsNav = By.id("header_forms");

    public PlaygroundHeader(WebDriver driver){
        super(driver);
    }

    public PlaygroundFormsPage clickFormsLink(){
        waitAndClick(formsNav);
        return new PlaygroundFormsPage(driver);
    }
}
