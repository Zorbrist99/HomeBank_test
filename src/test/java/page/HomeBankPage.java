package page;

import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeBankPage {


    public void openPage() {
        open("https://home.bank/");
    }

    public void searchTextCredit() {
        $("#calc").shouldHave(text("Выберите сумму кредита")).shouldHave(visible);
    }

    public void enterLoanAmount() {
        $(".YErkB  .mftbO").shouldHave(text("500 000")).doubleClick().setValue("3");
    }

    public void choosingLoanTerm() {
        $("#calc").$(byText("5 лет")).click();
    }

    public void checkingEp() {
        $(".lpDR- .NGdZU").shouldHave(text("65 078")).shouldBe(visible);
    }

    public void transferCredits() {
        $(".yTX-P .EdG5g").$(byText("Кредиты")).click();
        $(".ZVi5z").$(byText("Все кредиты")).click();
    }

    public void loanSearchSpecialConditions() {
        $(".DWsAS").shouldHave(text("Кредит на специальных условиях")).shouldBe(visible);
        $(".DWsAS").$(byText("Подробнее")).click();
    }

    public void switchingBetweenPages() {
        String mainWindowHandle = getWebDriver().getWindowHandle(); // Получаем идентификатор текущей (главной) вкладки
        Set<String> allWindowHandles = getWebDriver().getWindowHandles(); // Получаем идентификаторы всех открытых вкладок
        allWindowHandles.remove(mainWindowHandle); // Удаляем идентификатор текущей вкладки из списка
        String newTabHandle = allWindowHandles.iterator().next(); // Получаем идентификатор новой вкладки
        switchTo().window(newTabHandle);
    }

    public void ageVerification() {
        $("[data-name='Topline']").$(byText("Информация")).click();
        $(".NarJS .j6x-7").$(byText("Требования к клиенту")).click();
        $(".I6DbB").shouldHave(text("возраст от 18 до 85 лет.")).shouldBe(visible);
    }

    public void transferInstallment() {
        $(".NarJS").$(byText("Рассрочка")).click();
        $(".yTX-P").$(byText("Магазины партнёров")).click();
    }

    public void findPartner() {
        $(".dgVgt").$(byText("5 КармаNов")).click();
    }

    public void addressVerification() {
        $(".FSequ", 1).shouldHave(text("Москва, проспект Мира, 211к2")).shouldBe(visible);
    }


    public void transferAboutUs() {
        $(".lmQjC").$(byText("About Us")).click();
    }

    public void localizationCheck() {
        $("#products").shouldHave(text("Bank's main products")).shouldBe(visible);
    }

    public void switchingLanguage() {
        $(".DWsAS").$(byText("RU")).click();
        $("#products").shouldHave(text("Основные продукты банка")).shouldBe(visible);
    }
}
