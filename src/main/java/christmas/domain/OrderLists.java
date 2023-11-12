package christmas.domain;

import christmas.dto.OrderDTO;
import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderLists {
    private final List<OrderDTO> orderList;

    public OrderLists(List<String> orders) {
        orderList = new ArrayList<OrderDTO>();
        makeOrderList(orders);
    }

    private void makeOrderList(List<String> orders) {
        orders.stream().forEach(order -> {
           List<String> menuAndCount = Stream.of(order.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                   .toList();
           String menuName = menuAndCount.get(OrderIndices.MENU.getIndex());
           Integer count = Integer.parseInt(menuAndCount.get(OrderIndices.COUNT.getIndex()));
            orderList.add(new OrderDTO(menuName, count));
        });
    }
}
