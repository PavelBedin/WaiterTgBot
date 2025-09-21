import Handlers.Commands.Models.OrderItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void testGetters() {
        OrderItem item = new OrderItem("Apple", 3, 10.5);

        assertEquals("Apple", item.getName());
        assertEquals(3, item.getQuantity());
        assertEquals(10.5, item.getPrice());
    }

    @Test
    void testGetTotal() {
        OrderItem item = new OrderItem("Banana", 4, 2.5);
        double expectedTotal = 4 * 2.5;

        assertEquals(expectedTotal, item.getTotal(), 0.0001);
    }

    @Test
    void testToString() {
        OrderItem item = new OrderItem("Orange", 2, 15.0);
        String expectedString = "2 x Orange = 30.0₽";

        assertEquals(expectedString, item.toString());
    }

    @Test
    void testZeroQuantity() {
        OrderItem item = new OrderItem("Milk", 0, 50.0);
        assertEquals(0.0, item.getTotal(), 0.0001);
        assertEquals("0 x Milk = 0.0₽", item.toString());
    }

    @Test
    void testZeroPrice() {
        OrderItem item = new OrderItem("Water", 5, 0.0);
        assertEquals(0.0, item.getTotal(), 0.0001);
        assertEquals("5 x Water = 0.0₽", item.toString());
    }
}
