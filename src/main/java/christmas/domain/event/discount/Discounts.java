package christmas.domain.event.discount;

import christmas.domain.order.Orders;

import java.util.ArrayList;
import java.util.List;

public class Discounts {

    List<Discount> discountList = new ArrayList<>();

    public Discounts() {
        discountList.add(new Christmas());
        discountList.add(new WeekDay());
    }

    public void discount(Orders orders) {
        discountList.stream().forEach(discountItem -> discountItem.discount(orders));
    }
}
