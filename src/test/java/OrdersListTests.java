import org.example.MainPage;
import org.example.OrderPage;
import org.example.PopUpPage;
import org.example.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.function.Consumer;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrdersListTests extends BaseTest {
    private final String orderCompletedHeader = "Заказ оформлен";
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String startDateRent;
    private final String comments;

    public OrdersListTests(String firstName, String lastName, String address, String phone, String startDateRent, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.startDateRent = startDateRent;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Грета", "Тумберг", "Шабловка 12", "89214341213", "01.01.2025", "На деревню девушке"},
                {"Андрей", "Рыбак", "Ткачей 12", "8921421334455", "02.04.2025", "За углом"},
        };
    }

    @Test
    public void testOrderHeaderButton() {
        placeOrder(MainPage::pushHeaderOrderButton, false);
    }

    @Test
    public void testOrderMiddlePageButton() {
        placeOrder(MainPage::pushBottomOrderButton, true);
    }

    private void placeOrder(Consumer<MainPage> orderButtonAction, boolean needsScroll) {
        MainPage mainPage = new MainPage(driver);
        if (needsScroll) {
            mainPage.scrollToPushOrderButton();
        }
        orderButtonAction.accept(mainPage);

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, address, phone);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, comments);

        PopUpPage popUpPage = new PopUpPage(driver);
        popUpPage.clickOnYes();
        assertTrue(  "Кнопка не найдена на странице!", popUpPage.cancelButtonPresent());
    }
}
