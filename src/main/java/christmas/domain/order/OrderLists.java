package christmas.domain.order;

import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderLists {

    private static final String LINE_BREAKING = "\n";

    private final List<Order> orderList;

    public OrderLists(List<String> orders) {
        orderList = new ArrayList<Order>();
        makeOrderList(orders);
    }

    private void makeOrderList(List<String> orders) {
        orders.stream().forEach(order -> {
           List<String> menuAndCount = Stream.of(order.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                   .toList();
           String menuName = menuAndCount.get(OrderIndices.MENU.getIndex());
           Integer count = Integer.parseInt(menuAndCount.get(OrderIndices.COUNT.getIndex()));
           orderList.add(new Order(menuName, count));
        });
    }

    @Override
    public String toString() {
        StringBuilder ordersString = new StringBuilder();
        for (Order order : orderList) {
            ordersString.append(order.toString()).append(LINE_BREAKING);
        }
        return ordersString.toString();
    }
}
