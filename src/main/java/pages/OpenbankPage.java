package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class OpenbankPage {
    private final SelenideElement exchangeRatesBlock = $(By.className("main-page-exchange"));
    private final SelenideElement usdExchangeBlock = exchangeRatesBlock.$(By.className("main-page-exchange__row"), 0);
    private final SelenideElement eurExchangeBlock = exchangeRatesBlock.$(By.className("main-page-exchange__row"), 1);
    private final SelenideElement usdBuy = usdExchangeBlock.$(By.className("main-page-exchange__rate"), 0);
    private final SelenideElement usdSell = usdExchangeBlock.$(By.className("main-page-exchange__rate"), 1);
    private final SelenideElement eurBuy = eurExchangeBlock.$(By.className("main-page-exchange__rate"), 0);
    private final SelenideElement eurSell = eurExchangeBlock.$(By.className("main-page-exchange__rate"), 1);
}
