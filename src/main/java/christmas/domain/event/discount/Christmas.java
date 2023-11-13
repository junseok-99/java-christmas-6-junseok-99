package christmas.domain.event.discount;

import christmas.domain.order.Orders;

public class Christmas implements Discount {

    private static final Integer MIN_DAY_NUMBER = 1;
    private static final Integer MAX_DAY_NUMBER = 25;
    private static final Integer DISCOUNT_RATE = 1000;
    private static final Integer INCREASE_RATE = 100;

    @Override
    public Boolean isSatisfyCondition(Orders orders) {
        Integer dayOfVisit = orders.getDayOfVisit();
        if (MIN_DAY_NUMBER <= dayOfVisit && dayOfVisit <= MAX_DAY_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Orders orders) {
        Integer increasedRate = (orders.getDayOfVisit() - MIN_DAY_NUMBER) * INCREASE_RATE;
        Long totalDiscountRate = DISCOUNT_RATE + (long) increasedRate;
        return totalDiscountRate;
    }

    @Override
    public void discount(Orders orders) {
        Boolean discountCondition = isSatisfyCondition(orders);
        if (discountCondition) {
            Long discountRate = discountRate(orders);
            orders.discountPrice(discountRate);
        }
    }
}
