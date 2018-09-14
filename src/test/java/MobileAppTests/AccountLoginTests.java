package MobileAppTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.ChrisArroyoApp.HomeScreen;
import testBase.TestBase;

public class AccountLoginTests extends TestBase {

    @BeforeClass
    public static void setUp() throws Exception {
        mobileSetup();
    }

    @AfterClass
    public static void tearDown() {
        mdriver.quit();
        mdriver = null;
    }

    @Test
    public void loginTest(){
        HomeScreen hs = new HomeScreen(mdriver);

        try{
            hs.clickAccountLogin()
                    .typeEmail("testing@gmail.com")
                    .typePass("password")
                    .clickSubmit();
        }
        catch (Exception e){
            failedTestCaseSteps(String.valueOf(e));
        }
    }
}
