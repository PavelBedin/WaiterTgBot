package Handlers.Commands.Accounting;

import Handlers.Commands.Models.OrderItem;
import Handlers.Commands.Models.WaiterAccount;

import java.util.*;

public class AccountHelper {
    public static WaiterAccount Calculate(Map<Integer, List<OrderItem>> orderMap) {
        Map<Integer, Double> result = new HashMap<>();
        Set<Integer> keys = orderMap.keySet();
        List<Integer> keyList = new ArrayList<>(keys);
        for (int key : keyList) {
            List<OrderItem> orderItems = orderMap.get(key);
            double total = 0;
            for (OrderItem item : orderItems) {
                total += item.getTotal();
            }
            result.put(key, total);
        }
        return new WaiterAccount(result);
    }
}
