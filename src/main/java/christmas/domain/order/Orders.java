package christmas.domain.order;

import christmas.repository.MenuRepository;
import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Orders extends Order {

    private static final String LINE_BREAKING = "\n";

    private final List<OrderRecord> orderList = new ArrayList<OrderRecord>();

    public Orders(List<String> orders) {
        makeOrderList(orders);
        setPrice(getOrderedTotalPrice());
    }

    public List<OrderRecord> getOrderList() {
        return orderList;
    }

    public Long getOrderedTotalPrice() {
        return MenuRepository.orderedTotalPrice(orderList);
    }

    @Override
    public String toString() {
        StringBuilder ordersString = new StringBuilder();
        for (OrderRecord order : orderList) {
            ordersString.append(order.toString()).append(LINE_BREAKING);
        }
        return ordersString.toString();
    }

    private void makeOrderList(List<String> orders) {
        orders.stream().forEach(order -> {
            List<String> menuAndCount = Stream.of(order.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                    .toList();
            String menuName = menuAndCount.get(OrderIndices.MENU.getIndex());
            Integer count = Integer.parseInt(menuAndCount.get(OrderIndices.COUNT.getIndex()));
            orderList.add(new OrderRecord(menuName, count));
        });
    }
}
