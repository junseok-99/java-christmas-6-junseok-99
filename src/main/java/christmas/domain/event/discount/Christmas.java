package christmas.domain.event.discount;

import christmas.domain.customer.Customer;

public class Christmas implements Discount {

    private static final Integer MIN_DAY_NUMBER = 1;
    private static final Integer MAX_DAY_NUMBER = 25;
    private static final Integer DISCOUNT_RATE = 1000;
    private static final Integer INCREASE_RATE = 100;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Integer dayOfVisit = customer.getDayOfVisit();
        if (MIN_DAY_NUMBER <= dayOfVisit && dayOfVisit <= MAX_DAY_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Customer customer) {
        Integer increasedRate = (customer.getDayOfVisit() - MIN_DAY_NUMBER) * INCREASE_RATE;
        Long totalDiscountRate = DISCOUNT_RATE + (long) increasedRate;
        return totalDiscountRate;
    }

    @Override
    public void discount(Customer customer) {
        Boolean discountCondition = isSatisfyCondition(customer);
        if (discountCondition) {
            Long discountRate = discountRate(customer);
            customer.discount(discountRate);
        }
    }
}
