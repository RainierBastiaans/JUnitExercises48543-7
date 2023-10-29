package domain;

import org.example.Product;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ProductTest {
    private Product appel;
    private Product smartphone;

    @BeforeAll
    public static void beforeAll() {

    }

    @BeforeEach
    public void setUp(){
        appel = new Product("Golden Star apple", 0.70);
        smartphone = new Product("Samsung Galaxy S10", 899.00);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Golden Star apple", appel.getTitle());
        assertEquals("Samsung Galaxy S10", smartphone.getTitle());
    }

    @Test
    public void testGetPrice() {
        assertEquals(0.70, appel.getPrice());
        assertEquals(899.00, smartphone.getPrice());
    }

    @Test
    public void testNewProductEqualsExistingProduct(){
        Product sameAppel = new Product("Golden Star apple", 0.70);
        assertEquals(appel, sameAppel);
    }
}