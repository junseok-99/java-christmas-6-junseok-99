package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;
import christmas.domain.order.Orders;
import christmas.repository.menu.Beverage;

public class Champagne implements Presentation {

    private static final Long MIN_PRICE = 120_000L;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Orders orders = customer.getOrders();
        Long beforeDiscountPrice = orders.getBeforeDiscountPrice();
        if (beforeDiscountPrice >= MIN_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public void present(Customer customer) {
        Boolean presentCondition = isSatisfyCondition(customer);
        Long champagnePrice = null;
        if (presentCondition) {
            champagnePrice = NEGATIVE_NUMBER * Beverage.CHAMPAGNE.getPrice();
        }
        customer.addBenefitPrice(champagnePrice);
    }
}
