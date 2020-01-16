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

    /**
     * TC1
     * INPUT: Bestellen van een hamburger (€2) en een milkshake (€3) zonder korting.
     *
     * OUTPUT: De prijs voor betalen (€5)
     */
    @Test
    void TestCase1() throws NoProductSelectedException {
        Order myOrder = mac.createOrder();
        myOrder.addBurger("Hamburger", 1);
        myOrder.addDrink("Milkshake", 1);

        double price = myOrder.getTotalPrice();
        assertEquals(5, price);
    }

    /**
     * TC2
     * INPUT: Kortingscode voor €5 korting en bestellen van een Milkshake(€5).
     *
     * OUTPUT: De prijs voor betalen (€0)
     */
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
    void TestCase5() throws Exception {
        mac.addDiscountCode("FIFTY", "50%");
        mac.addDiscountCode("QUARTER", "25%");

        Order myOrder = mac.createOrder();
        myOrder.addBurger("Hamburger", 69);
        myOrder.addDiscountCode("FIFTY");

        Order myOrder1 = mac.createOrder();
        myOrder1.addBurger("Hamburger", 10);
        myOrder1.addDiscountCode("QUARTER");

        Order myOrder2 = mac.createOrder();
        myOrder2.addBurger("Hamburger", 5);
        myOrder2.addDiscountCode("FIFTY");

        Order myOrder3 = mac.createOrder();
        myOrder3.addBurger("Hamburger", 3);
        myOrder3.addDiscountCode("QUARTER");

        Assertions.assertDoesNotThrow(() -> {
            mac.printRevenue();
        });
    }
}
