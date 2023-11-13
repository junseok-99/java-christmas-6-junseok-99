package christmas.domain.event;

import christmas.domain.customer.Customer;
import christmas.domain.event.discount.Discounts;
import christmas.domain.order.Orders;

public class Event {

    Discounts discounts;

    public Event() {
        this.discounts = new Discounts();
    }

    public void discount(Customer customer) {
        discounts.discount(customer);
    }
}
