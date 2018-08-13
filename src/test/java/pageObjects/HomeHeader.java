package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeHeader extends PageObjectsBase{

    public By homeNav = By.id("header_home");
    public By coverLetterNav = By.id("header_coverletter");
    public By resumeNav = By.id("header_resume");
    public By aboutNav = By.id("header_about");
    public By playgroundNav = By.id("header_playground");

    public HomeHeader(WebDriver driver){
        super(driver);
    }

    public PlaygroundHeader clickTestPlaygroundLink(){
        waitAndClick(playgroundNav);
        return new PlaygroundHeader(driver);
    }

}
