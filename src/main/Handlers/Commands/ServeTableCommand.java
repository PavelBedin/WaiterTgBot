package Handlers.Commands;

import Handlers.Commands.Accounting.AccountHelper;
import Handlers.Commands.Interfaces.Command;
import Handlers.Commands.Interfaces.Disposable;
import Handlers.Commands.Models.OrderItem;
import Handlers.Commands.Models.WaiterAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServeTableCommand implements Command, Disposable {
    private final Map<Integer, List<OrderItem>> orderMap = new HashMap<>();

    @Override
    public String InitMessage() {
        return "Напишите заказ в формате 'номер столика числом-название блюда-количество-стоимость'";
    }

    @Override
    public String Action(String message) {
        String[] values = message.split("-");
        Integer tableNumber = Integer.parseInt(values[0]);
        List<OrderItem> orderItemList;
        if (orderMap.containsKey(tableNumber)) {
            orderItemList = orderMap.get(tableNumber);
        } else {
            orderItemList = new ArrayList<OrderItem>();
            orderMap.put(tableNumber, orderItemList);
        }

        String itemName = values[1];
        int quantity = Integer.parseInt(values[2]);
        double price = Double.parseDouble(values[3]);

        OrderItem item = new OrderItem(itemName, quantity, price);
        orderItemList.add(item);

        return """
                Добавьте позицию в заказ в формате 'номер столика числом-название блюда-количество-стоимость'
                Или /finishService для заверешения обсуживания
                """;
    }

    @Override
    public void Dispose() {
       WaiterAccount waiterAccount = AccountHelper.Calculate(orderMap);
       //Добавить его в базу или другие действия
    }
}
