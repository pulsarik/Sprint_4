import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.example.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsTest extends BaseTest {
    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;

    public QuestionsTest(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedAnswersList() {
        return new Object[][]{
                {MainPage.questionArrayButtons[0], MainPage.textQuestionsAboutImportant[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.questionArrayButtons[1], MainPage.textQuestionsAboutImportant[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.questionArrayButtons[2], MainPage.textQuestionsAboutImportant[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.questionArrayButtons[3], MainPage.textQuestionsAboutImportant[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.questionArrayButtons[4], MainPage.textQuestionsAboutImportant[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.questionArrayButtons[5], MainPage.textQuestionsAboutImportant[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.questionArrayButtons[6], MainPage.textQuestionsAboutImportant[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.questionArrayButtons[7], MainPage.textQuestionsAboutImportant[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void testEqualsFAQ() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollPageToQuestionsAboutImportant();
        mainPage.pushQuestionButton(questionLocator);
        String actualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Проверьте текст", answerText, actualAnswerText);
    }
}