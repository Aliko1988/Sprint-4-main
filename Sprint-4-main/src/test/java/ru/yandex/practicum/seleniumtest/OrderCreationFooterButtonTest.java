package ru.yandex.practicum.seleniumtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.pageobject.SamokatPageObject;

@RunWith(Parameterized.class)
public class OrderCreationFooterButtonTest extends AbstractTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rent;



    public OrderCreationFooterButtonTest(String name, String surname, String address, String metro, String phone, String date, String rent){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rent = rent;

    }

    @Parameterized.Parameters
    public static Object[][] createOrderParams() {
        return new Object[][] {
                { "Петров", "Петров", "Петрова 1", "Лубянка", "8901234567891", "22.09.2024", "четверо суток"},
                {"Иван", "Иванов", "Петрова 2", "8901234567892", "21.09.2024", "трое суток"},
                {"Соловей", "Соловьев", "Петрова3", "Лубянка", "8901234567893", "01.01.2025", "сутки"},
        };
    }



    @Test
    public void orderCreationHeaderButtonTest(){        // автоматизированный позитивный сценарий создания заказа с использованием верхней кнопки заказать


        SamokatPageObject mainPageObject = new SamokatPageObject(driver);

        mainPageObject.scrollUntilFooterOrderButton();

        mainPageObject.clickFooterOrderButton();

        mainPageObject.fillNameField(name);

        mainPageObject.fillLastNameField(surname);

        mainPageObject.fillAddressField(address);

        mainPageObject.fillMetroField(metro);

        mainPageObject.fillPhoneField(phone);

        mainPageObject.nextButtonClick();

        mainPageObject.fillDateField(date);

        mainPageObject.fillRentTimeField(rent);

        mainPageObject.totalOrderButtonClick();

        mainPageObject.orderCreateCompleteStep();

        boolean actualResult = mainPageObject.isCreatedNewOrder();

        Assert.assertTrue(actualResult);

    }


}
