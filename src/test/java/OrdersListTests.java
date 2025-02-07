
import org.example.MainPage;
import org.example.OrderPage;
import org.example.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrdersListTests extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String startDateRent;
    private final String comments;

    public OrdersListTests(String firstName, String lastName, String deliveryAddress, String phone, String startDate, String comments) {
        this.startDateRent = startDate;
        this.comments = comments;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = deliveryAddress;
        this.phone = phone;

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
        MainPage mainPage = new MainPage(driver);
        mainPage.pushHeaderOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, address, phone);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, comments);

        assertTrue(rentPage.checkModalWindowEnabled());
        driver.close();
    }

    //Заказ через кнопку в серелине страницы
    @Test
    public void testOrderMiddlePageButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToPushOrderButton();
        mainPage.pushOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, address, phone);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, comments);

        assertTrue(rentPage.checkModalWindowEnabled());
        driver.close();
    }
}