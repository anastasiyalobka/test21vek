package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TestsForWebsite extends TestBase {
    @Test
    @DisplayName("Проверка наличия категории товара")
    void openCategoriesTest() {
        step("Открыть https://www.21vek.by/", () -> {
            open("https://www.21vek.by/");
        });

        step("Нажать Каталог товаров", () -> {
            $(".styles_catalogButton__1K6kI").click();
        });

        step("Проверить наличие категории Здоровье", () -> {
            $(byText("Здоровье")).click();
        });
    }

    @Test
    @DisplayName("Открытие первого популярного товара")
    void openPageWithPopular() {
        step("Открыть https://www.21vek.by/", () -> {
            open("https://www.21vek.by/");
        });

        step("Открыть популярный товар с главной страницы", () -> {
            $(".foreign_goods__img").click();
        });
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addToBasket() {
        step("Открыть https://www.21vek.by/", () -> {
            open("https://www.21vek.by/");
        });

        step("Открыть популярный товар с главной страницы", () -> {
            $(".foreign_goods__img").click();
        });

        step("Открыть популярный товар с главной страницы", () -> {
            $("[data-ga_action=add_to_cart]").click();
        });
        step("Открыть корзину", () -> {
            $(".headerCartLabel").click();
        });

        sleep(5000);

    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.21vek.by/'", () ->
            open("https://www.21vek.by/"));

        step("Page title should have text 'Онлайн-гипермаркет 21vek.by. Продажа бытовой техники, электроники, товаров для дома по выгодным ценам в интернет-магазине'", () -> {
            String expectedTitle = "Онлайн-гипермаркет 21vek.by. Продажа бытовой техники, электроники, товаров для дома по выгодным ценам в интернет-магазине";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.21vek.by/'", () ->
            open("https://www.21vek.by/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}