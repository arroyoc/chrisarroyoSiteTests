package pageObjects.ChrisArroyoApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class MobilePageObjectsBase {

    private AppiumDriver<AndroidElement> driver;
    private int timeout = 10;

    public MobilePageObjectsBase(AppiumDriver<AndroidElement> driver){
        this.driver = driver;
    }

    private WebElement waitForElement(By locator) throws Exception {

        int count = 0;
        int maxTries = 3;
        while(true) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
                return driver.findElement(locator);
            } catch (Exception e) {
                // handle exception
                if (++count == maxTries) throw e;
            }
        }

    }

    protected List<AndroidElement> waitForElements(By locator)	{
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElements(locator);
    }

    protected void waitAndClick(By locator) throws Exception {
        WebElement element = waitForElement(locator);
        element.click();
    }

    private void executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process proc;
        try {
            proc = Runtime.getRuntime().exec(command);
            proc.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String outputLine = "";
            while ((outputLine = reader.readLine()) != null)
            {
                output.append(outputLine + "\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public MobilePageObjectsBase scanItem(String upc) throws InterruptedException {
        executeCommand("adb shell input text " + upc);
        executeCommand("adb shell input keyevent 66");

        Thread.sleep(1000);

        return this;
    }

    public void successfullySwipeCreditCard() {
        executeCommand("adb shell am broadcast -a com.readytouchpos.smallstore.intent.CARD_APPROVE");
    }

    protected void collapseKb(){
        executeCommand("adb shell input keyevent 4");
    }

    protected void sendEnter(){
        executeCommand("adb shell input keyevent 66");
    }

}

