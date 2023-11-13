package christmas.domain.order;

import christmas.repository.MenuRepository;
import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderLists {

    private static final String LINE_BREAKING = "\n";

    private final List<Order> orderList;
    private final Price price;

    public OrderLists(List<String> orders) {
        orderList = new ArrayList<Order>();
        makeOrderList(orders);
        Long orderedTotalPrice = MenuRepository.orderedTotalPrice(orderList);
        price = new Price(orderedTotalPrice);
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public Long getBeforeDiscountPrice() {
        return price.getBeforeDiscountPrice();
    }

    public Long getAfterDiscountPrice() {
        return price.getAfterDiscountPrice();
    }

    public void discount(Long discountRate) {
        price.discount(discountRate);
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
