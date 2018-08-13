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
    public void createUser(){
        HomeHeader hh = new HomeHeader(wdriver);

        hh.clickTestPlaygroundLink()
                .clickFormsLink();
    }
}
