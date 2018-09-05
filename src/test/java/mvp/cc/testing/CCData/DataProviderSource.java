package mvp.cc.testing.CCData;

import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * Created by asalonga on 11/08/2018.
 */
public class DataProviderSource {
    @DataProvider(name = "login")
    public static Object[][] getLoginData() throws IOException {
        UtilExcelFile config = new UtilExcelFile("E:\\TestData.xlsx");

        int rows = config.getRowCount(0);
        Object[][] loginData = new Object[rows][2];

        for(int i = 0; i < rows;  i++) {
            loginData[i][0] = config.getData(0, i , 0);
            loginData[i][1] = config.getData(0, i , 1);
        }

        return loginData;
    }

    @DataProvider(name = "unverifiedClaim")
    public static Object[][] getUnverifiedClaim() throws IOException {
        UtilExcelFile config = new UtilExcelFile("E:\\NewClaimList.xlsx");
        int rows = config.getRowCount(0);
        Object[][] basicInfo = new Object[rows][8];

        for(int i = 0; i < rows;  i++) {
            basicInfo[i][0] = config.getData(0, i , 0);
            basicInfo[i][1] = config.getData(0, i , 1);
            basicInfo[i][2] = config.getData(0, i , 2);
            basicInfo[i][3] = config.getData(0, i , 3);
            basicInfo[i][4] = config.getData(0, i , 4);
            basicInfo[i][5] = config.getData(0, i , 5);
            basicInfo[i][6] = config.getData(0, i , 6);
            basicInfo[i][7] = config.getData(0, i , 7);
        }

        return basicInfo;
    }

    @DataProvider(name = "claimTestCase")
    public static Object[][] getTestCases() throws IOException {
        UtilExcelFile config = new UtilExcelFile("E:\\ClaimTestCase.xlsx");
        int rows = config.getRowCount(1);
        Object[][] testCase = new Object[rows][5];

        for(int i = 0; i < rows;  i++) {
            if(i==0){
                continue;
            }
            testCase[i][0] = config.getData(1, i , 0);
            testCase[i][1] = config.getData(1, i , 1);
            testCase[i][2] = config.getData(1, i , 2);
            testCase[i][3] = config.getData(1, i , 3);
            testCase[i][4] = config.getData(1, i , 4);
        }
        return testCase;
    }

}
