package christmas.domain.event.discount;

import christmas.domain.customer.Customer;

public class Special implements Discount {

    private static final Integer SUNDAY = 3;
    private static final Integer CHRISTMAS = 25;
    private static final Long SPECIAL_DISCOUNT_RATE = 1_000L;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Integer dayOfVisit = customer.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (dayOfVisit == CHRISTMAS || SUNDAY == dayOfTheWeek) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Customer customer) {
        return SPECIAL_DISCOUNT_RATE;
    }

    @Override
    public void discount(Customer customer) {
        Boolean discountCondition = isSatisfyCondition(customer);
        Long discountPrice = null;
        if (discountCondition) {
            discountPrice = NEGATIVE_NUMBER * discountRate(customer);
            customer.discount(discountPrice);
        }
        customer.addBenefitPrice(discountPrice);
    }
}
