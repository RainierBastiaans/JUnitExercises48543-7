import domain.*;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({CalculatorTest.class, ProductTest.class, CourseTest.class, ShoppingCartTest.class})
public class AllTests {

}