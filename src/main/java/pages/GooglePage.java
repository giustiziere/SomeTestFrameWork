package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class GooglePage {
    private final SelenideElement requestField = $(By.name("q"));

    public SelenideElement getGoogleResultByLink(String link) {
        return $x("//a[contains(@href, '" + link + "')]");
    }
}
