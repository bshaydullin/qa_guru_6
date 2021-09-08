package qa.guru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void restRepositoryIsssue(){

        step("Открываем главную страницу", ()-> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, ()->{
            $(".header-search-input").val("eroshenkoam/allure-example").submit();
        });

        step("Переходим в раздел Issues", ()-> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Проверяем, что существует Issue с номером "+ ISSUE_NUMBER, ()->{
            $(partialLinkText("Issues")).click();
            $(withText("#"+ISSUE_NUMBER)).shouldBe(visible);
        });

    }
}
