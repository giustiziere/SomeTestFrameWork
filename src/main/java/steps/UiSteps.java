package steps;

import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import pages.GooglePage;
import pages.OpenbankPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.testng.Assert.assertTrue;
import static strings.Urls.OPEN;

public class UiSteps {

    private final GooglePage googlePage = new GooglePage();
    private final OpenbankPage openbankPage = new OpenbankPage();

    @Step
    public UiSteps inputGoogleSearch(String request) {
        googlePage.getRequestField().setValue(request).pressEnter();
        return this;
    }

    @Step
    public UiSteps checkOpenbankExistsInSearch() {
        googlePage.getGoogleResultByLink(OPEN).should(exist, visible);
        return this;
    }

    @Step
    public UiSteps clickOpenbankLink() {
        googlePage.getGoogleResultByLink(OPEN).click();
        return this;
    }

    @Step
    public UiSteps checkOpenbankPage() {
        webdriver().shouldHave(WebDriverConditions.url(OPEN));
        return this;
    }

    @Step
    public UiSteps checkOpenbankExchangeRates() {
        openbankPage.getExchangeRatesBlock().should(exist).scrollIntoView(true);
        openbankPage.getUsdExchangeBlock().shouldHave(text("USD"));
        openbankPage.getEurExchangeBlock().shouldHave(text("EUR"));
        var usdBuy = Double.parseDouble(openbankPage.getUsdBuy().getText().replace(",", "."));
        var usdSell = Double.parseDouble(openbankPage.getUsdSell().getText().replace(",", "."));
        var eurBuy = Double.parseDouble(openbankPage.getEurBuy().getText().replace(",", "."));
        var eurSell = Double.parseDouble(openbankPage.getEurSell().getText().replace(",", "."));
        assertTrue(usdBuy < usdSell);
        assertTrue(eurBuy < eurSell);
        return this;
    }
}
