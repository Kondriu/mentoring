package gmail;

import common.BaseTest;
import org.junit.Test;

public class GmailTest extends BaseTest {

    @Test
    public void getGmailPage(){
        getDriver().get("https://gmail.com");
    }
}
