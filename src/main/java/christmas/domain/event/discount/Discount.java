package christmas.domain.event.discount;

import christmas.domain.order.Orders;

public interface Discount {

    Boolean isSatisfyCondition(Orders orders);
    Long discountRate(Orders orders);
    void discount(Orders orders);
}
