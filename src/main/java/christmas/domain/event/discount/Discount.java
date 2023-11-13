package christmas.domain.event.discount;

import christmas.domain.order.Orders;

public interface Discount {

    Integer ONE_WEEK = 7;
    Long INITIAL_PRICE = 0L;

    Boolean isSatisfyCondition(Orders orders);
    Long discountRate(Orders orders);
    void discount(Orders orders);
}
