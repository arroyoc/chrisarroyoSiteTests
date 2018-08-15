package forms;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomeHeader;
import pageObjects.PlaygroundFormsPage;
import testBase.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        PlaygroundFormsPage pgfp = new PlaygroundFormsPage(wdriver);

        String newUserEmail = "testing@gmail.com";
        String newUserPass = "testing";

        try {
            hh.clickTestPlaygroundLink()
                    .clickFormsLink()
                    .typeEmailForm1(newUserEmail)
                    .typePassForm1(newUserPass)
                    .clickSubmitForm1();

                    String actualUserEmail = pgfp.getEmailText();
                    assertEquals(true, newUserEmail.compareTo(actualUserEmail));
        }
        catch (Exception e){
            //defined in testBase.TestBase
            failedTestCaseSteps(String.valueOf(e));
        }

    }
}
