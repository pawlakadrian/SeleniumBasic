package Basic;

import Helpers.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TablePage;

public class TablePopTest extends TestBase {

    @BeforeEach
    public void openTablePage() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    public void findSpecifiedMountains() {
        TablePage tablePage = new TablePage(getDriver());

        tablePage.searchSpecifiedDataInTable("Switzerland", 4000);
    }

}
