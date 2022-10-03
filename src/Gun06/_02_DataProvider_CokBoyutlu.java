package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

 // bunu simdilik xml de calıstırmadık , burda calıstrıdık.
    @Test(dataProvider = "getData")
    void userNameTest(String username,String password)
    {
        System.out.println("Username="+username+", password="+password);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {
                {"Nurhayat", "122333"},
                {"Alper", "ererere"},
                {"Uğur", "ererer3424"},
                {"Hakan","sdsdsdsds"}
        };

        return data;
    }


}
