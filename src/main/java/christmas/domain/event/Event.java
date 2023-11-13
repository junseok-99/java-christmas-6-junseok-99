package christmas.domain.event;

import christmas.domain.event.discount.Discounts;
import christmas.domain.order.Orders;

public class Event {

    Discounts discounts;

    public Event() {
        this.discounts = new Discounts();
    }

    public void discount(Orders orders) {
        discounts.discount(orders);
    }
}
