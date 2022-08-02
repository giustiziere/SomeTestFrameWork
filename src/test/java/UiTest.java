import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.UiSteps;

import static com.codeborne.selenide.Selenide.open;
import static strings.Urls.GOOGLE;

public class UiTest {

    private final UiSteps uiSteps = new UiSteps();

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @Test(description = "Check exchange rates at Openbank site")
    public void openbankTest() {
        open(GOOGLE);
        uiSteps
                .inputGoogleSearch("Открытие")
                .checkOpenbankExistsInSearch()
                .clickOpenbankLink()
                .checkOpenbankPage()
                .checkOpenbankExchangeRates();
    }
}
