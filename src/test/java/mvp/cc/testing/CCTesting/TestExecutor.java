package mvp.cc.testing.CCTesting;

import mvp.cc.testing.CCData.DataProviderSource;
import org.testng.annotations.*;

/**
 * Created by asalonga on 14/08/2018.
 */
public class TestExecutor {
    private static Application app;
    private static Command command;

    @BeforeTest
    public void startDriver() {
        app = new Application();
        command = new Command(app.getDriver());
    }

    @Test(dataProvider = "claimTestCase", dataProviderClass = DataProviderSource.class)
    public void claimTestCase(String tCase, String tAction, String screen, String tObject, String val) {
        command.perform(tCase, tAction, screen, tObject, val);
    }

}
