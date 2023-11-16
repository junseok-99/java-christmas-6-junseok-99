package christmas.domain.event.discount;

import christmas.domain.customer.Customer;

public interface Discount {

    Integer ONE_WEEK = 7;
    Long INITIAL_PRICE = 0L;
    Long WEEK_DISCOUNT_RATE = 2_023L;
    Long NEGATIVE_NUMBER = -1L;

    Boolean isSatisfyCondition(Customer customer);
    Long discountRate(Customer customer);
    void discount(Customer customer);
}
