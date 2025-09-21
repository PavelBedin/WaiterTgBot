import Handlers.Commands.Accounting.AccountHelper;
import Handlers.Commands.Models.OrderItem;
import Handlers.Commands.Models.WaiterAccount;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountHelperTest {

    @Test
    void testCalculateSingleOrder() {
        Map<Integer, List<OrderItem>> orders = new HashMap<>();
        orders.put(1, List.of(new OrderItem("Apple", 2, 10.0), new OrderItem("Banana", 3, 5.0)));

        WaiterAccount account = AccountHelper.Calculate(orders);

        Map<Integer, Double> expectedTable = new HashMap<>();
        expectedTable.put(1, 35.0);

        assertEquals(expectedTable, account.getTableAccount());
        assertEquals(35, account.getTotalAccount(), 0.0001);
    }

    @Test
    void testCalculateMultipleOrders() {
        Map<Integer, List<OrderItem>> orders = new HashMap<>();
        orders.put(1, List.of(new OrderItem("Apple", 1, 10.0)));
        orders.put(2, List.of(new OrderItem("Banana", 2, 7.5), new OrderItem("Orange", 3, 5.0)));

        WaiterAccount account = AccountHelper.Calculate(orders);

        Map<Integer, Double> expectedTable = new HashMap<>();
        expectedTable.put(1, 10.0);
        expectedTable.put(2, 30.0);

        assertEquals(expectedTable, account.getTableAccount());
        assertEquals(40, account.getTotalAccount(), 0.0001);
    }

    @Test
    void testCalculateEmptyOrders() {
        Map<Integer, List<OrderItem>> orders = new HashMap<>();

        WaiterAccount account = AccountHelper.Calculate(orders);

        assertTrue(account.getTableAccount().isEmpty());
        assertEquals(0.0, account.getTotalAccount(), 0.0001);
    }

    @Test
    void testCalculateOrderWithEmptyItemList() {
        Map<Integer, List<OrderItem>> orders = new HashMap<>();
        orders.put(1, new ArrayList<>()); // пустой список заказов

        WaiterAccount account = AccountHelper.Calculate(orders);

        Map<Integer, Double> expectedTable = new HashMap<>();
        expectedTable.put(1, 0.0);

        assertEquals(expectedTable, account.getTableAccount());
        assertEquals(0.0, account.getTotalAccount(), 0.0001);
    }
}
