package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.HomeBankPage;


import static io.qameta.allure.Allure.step;

public class HomeBankWebTests extends TestBase {
    HomeBankPage homeBankPage = new HomeBankPage();

    @Test
    @Tag("Home_Bank")
    @DisplayName("Проверка калькулятора кредита")
    void checkingLoanCalculator() {
        step("Зайти на сайт банка", () -> {
            homeBankPage.openPage();
        });
        step("Проверяем наличие текста 'Выберите сумму кредита'", () -> {
            homeBankPage.searchTextCredit();
        });
        step("Вводим желаемую сумму кредита", () -> {
            homeBankPage.enterLoanAmount();
        });
        step("Выбрать срок кредита 5 лет", () -> {
            homeBankPage.choosingLoanTerm();
        });
        step("Сумма ЕП рассчиталась корректно 65 078 руб.", () -> {
            homeBankPage.checkingEp();
        });
    }


    @Test
    @Tag("Home_Bank")
    @DisplayName("Проверка возрастного ценза по Кредиту на спец. условиях")
    void checkingLoansSection() {
        step("Открыть сайт банка", () -> {
            homeBankPage.openPage();
        });
        step("Перейти в раздел Кредиты -> Все кредиты", () -> {
            homeBankPage.transferCredits();
        });
        step("Найти кредит на специальных условиях, провалиться в него", () -> {
            homeBankPage.loanSearchSpecialConditions();
            homeBankPage.switchingBetweenPages();
        });
        step("Проверяем в требованиях к клиенту возрастной ценз", () -> {
            homeBankPage.ageVerification();
        });
    }


    @Test
    @Tag("Home_Bank")
    @DisplayName("Проверка поиска партнера банка")
    void checkingBankPartnerSearch() {
        step("Открыть сайт банка", () -> {
            homeBankPage.openPage();
        });
        step("Перейти в раздел Рассрочка -> Магазины партнёров", () -> {
            homeBankPage.transferInstallment();
        });
        step("Найти партнёра 5 КармаNов => перейти в карточку", () -> {
            homeBankPage.findPartner();
        });
        step("Проверить что в списке адресов присутствует Москва, проспект Мира, 211к2", () -> {
            homeBankPage.addressVerification();
        });
    }


    @Test
    @Tag("Home_Bank")
    @DisplayName("Проверка локализации сайта")
    void checkingHealthHomeChat() {
        step("Открыть сайт банка", () -> {
            homeBankPage.openPage();
        });
        step("Перейти на страницу About Us", () -> {
            homeBankPage.transferAboutUs();
        });
        step("Проверить EN локализацию", () -> {
            homeBankPage.localizationCheck();
        });
        step("Переключить язык на RU, проверить локализацию", () -> {
            homeBankPage.switchingLanguage();
        });
    }
}
