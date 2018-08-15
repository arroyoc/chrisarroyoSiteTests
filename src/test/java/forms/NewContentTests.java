package forms;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomeHeader;
import testBase.TestBase;

public class NewContentTests extends TestBase {

    //Before the tests start, perform setUp..
    @Before
    public void setUp() throws Exception {
        //defined in testBase.TestBase
        webSetup();
    }

    @AfterClass
    public static void tearDown(){
        //defined in testBase.TestBase
        webClose();
    }


    // The purpose of this test is to enter an email/password and click submit on form #1
    @Test
    public void createUser() {
        HomeHeader hh = new HomeHeader(wdriver);

        try {
            hh.clickTestPlaygroundLink()
                    .clickFormsLink()
                    .typeEmailForm1("testing@gmail.com")
                    .typePassForm1("testing")
                    .clickSubmitForm1();
        }
        catch (Exception e){
            //defined in testBase.TestBase
            failedTestCaseSteps(String.valueOf(e));
        }

    }
}
