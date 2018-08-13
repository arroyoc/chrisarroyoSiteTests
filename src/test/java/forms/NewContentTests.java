package forms;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pageObjects.HomeHeader;
import testBase.TestBase;

public class NewContentTests extends TestBase {

    @Before
    public void setUp() throws Exception {
        webSetup();
    }

    @AfterClass
    public static void tearDown(){
        webClose();
    }


    @Test
    public void createUser() throws InterruptedException {
        HomeHeader hh = new HomeHeader(wdriver);

        try {
            hh.clickTestPlaygroundLink()
                    .clickFormsLink()
                    .typeEmailForm1("testing@gmail.com")
                    .typePassForm1("testing")
                    .clickSubmitForm1();
        }
        catch (Exception e){
            failedTestCaseSteps(String.valueOf(e));
        }

    }
}
