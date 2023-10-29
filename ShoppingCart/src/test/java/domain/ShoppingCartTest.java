package domain;

import org.example.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ShoppingCartTest {
    private Product appel, smartphone;
    private ShoppingCart cart;

    @BeforeAll
    public static void beforeAll() {

    }

    @BeforeEach
    public void setUp(){
        appel = new Product("Golden Star apple", 0.70);
        smartphone = new Product("Samsung Galaxy S10", 899.00);
        cart = new ShoppingCart();
    }

    @Test
    public void testGetBalance() {
        assertEquals(0.00, cart.getBalance());
        cart.addItem(appel);
        assertEquals(0.70, cart.getBalance());
        cart.addItem(smartphone);
        assertEquals(899.70, cart.getBalance());
    }

    @Test
    public void testItemCount() throws ProductNotFoundException {
        assertEquals(0, cart.getItemCount());
        cart.addItem(appel);
        assertEquals(1, cart.getItemCount());
        cart.addItem(smartphone);
        assertEquals(2, cart.getItemCount());
        cart.removeItem(appel);
        assertEquals(1, cart.getItemCount());
        cart.removeItem(smartphone);
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testRemoveAll() {
        cart.addItem(appel);
        cart.addItem(smartphone);
        cart.removeAll();
        assertEquals(0, cart.getItemCount());
    }
}