package christmas.domain.event.presentation;

import christmas.domain.benefit.Benefit;
import christmas.domain.customer.Customer;

public interface Presentation {

    Long NEGATIVE_NUMBER = -1L;

    Boolean isSatisfyCondition(Customer customer);
    void present(Customer customer);
}
