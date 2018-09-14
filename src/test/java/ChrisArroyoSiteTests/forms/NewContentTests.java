package ChrisArroyoSiteTests.forms;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pageObjects.ChrisArroyoResumeSite.HomeHeader;
import pageObjects.ChrisArroyoResumeSite.PlaygroundFormsPage;
import testBase.TestBase;

import static org.junit.Assert.assertEquals;

public class NewContentTests extends TestBase {

    @BeforeClass //Before the tests start, perform setUp..
    public static void setUp() throws Exception {
        webSetup(); //defined in testBase.TestBase
    }

    @AfterClass
    public static void tearDown(){
        webClose(); //defined in testBase.TestBase
    }


    // The purpose of this test is to enter an email/password and click submit on form #1
    @Test
    public void createUser() {
        HomeHeader hh = new HomeHeader(wdriver);
        PlaygroundFormsPage pgfp = new PlaygroundFormsPage(wdriver);

        String newUserEmail = "testing@gmail.com";
        String newUserPass = "testing";

        //Try to perform the test in full..
        try {
            hh.clickTestPlaygroundLink() //Clicks the "Test Playground navigation link"
                    .clickFormsLink() //Clicks the "Forms" navigation link
                    .typeEmailForm1(newUserEmail) //Type new email into email field
                    .typePassForm1(newUserPass) //Type password into password field
                    .clickSubmitForm1(); //Click the submit button


                    String actualUserEmail = pgfp.getEmailText(); //Get the newly created user email from the table and store it as a String

                    assertEquals(newUserEmail, actualUserEmail); //Verify that the new user exists on the table

                    //Test Passes

        }
        //If an error is found catch it and perform the following:
        catch (Exception e){
            failedTestCaseSteps(String.valueOf(e)); //defined in testBase.TestBase
        }

    }
}
