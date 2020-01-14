import com.java3.eindopdracht.NoProductSelectedException;
import com.java3.eindopdracht.Order;
import com.java3.eindopdracht.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Dit zijn de test cases uit ons start document
 */
public class TestCases {

    private Shop mac;


    @BeforeEach
    void setUp() {
        mac = new Shop();
    }

    @AfterEach
    void tearDown() {
        mac = null;
    }

    @Test
    void TestCase1() throws NoProductSelectedException {
        Order myOrder = mac.createOrder();
        myOrder.addBurger("Hamburger", 1);
        myOrder.addDrink("Milkshake", 1);

        double price = myOrder.getTotalPrice();
        assertEquals(5, price);
    }

    @Test
    void TestCase2() throws Exception {

        mac.addDiscountCode("FIVE", "€5");

        Order myOrder = mac.createOrder();
        myOrder.addDrink("Milkshake", 1);
        myOrder.addDiscountCode("FIVE");

        double price = myOrder.getTotalPrice();
        assertEquals(0, price);
    }

    @Test
    void TestCase3() throws Exception {

        mac.addDiscountCode("FIVE", "50%");
        Order myOrder = mac.createOrder();
        myOrder.addDiscountCode("FIVE");

        Assertions.assertThrows(NoProductSelectedException.class, () -> {
            double price = myOrder.getTotalPrice(); //throws the NoProductSelectedException
        });
    }

    @Test
    void TestCase4() throws NoProductSelectedException {
        Order myOrder = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);

        double price = myOrder.getTotalPrice();
        assertEquals(138, price);
    }

    @Test
    void TestCase5() {
        Order myOrder = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);
        Order myOrder1 = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);
        Order myOrder2 = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);
        Order myOrder3 = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);


        Assertions.assertDoesNotThrow(() -> {

        });
    }

}
