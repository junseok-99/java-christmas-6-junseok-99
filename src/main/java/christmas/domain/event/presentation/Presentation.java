package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;

public interface Presentation {

    Long NEGATIVE_NUMBER = -1L;
    Long INITIAL_PRICE = 0L;


    Boolean isSatisfyCondition(Customer customer);
    void present(Customer customer);
}
