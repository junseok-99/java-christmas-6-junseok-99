package christmas.domain.event.presentation;

import christmas.domain.benefit.BenefitTypes;
import christmas.domain.customer.Customer;
import christmas.domain.order.Order;
import christmas.repository.menu.Beverage;

public class Champagne implements Presentation {

    private static final Long MIN_PRICE = 120_000L;
    private static final String PRESENTATION_MESSAGE = "샴페인 1개";

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Order order = customer.getOrder();
        Long beforeDiscountPrice = order.getBeforeDiscountPrice();
        if (beforeDiscountPrice >= MIN_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public void present(Customer customer) {
        Boolean presentCondition = isSatisfyCondition(customer);
        Long champagnePrice = INITIAL_PRICE;
        if (presentCondition) {
            champagnePrice = NEGATIVE_NUMBER * Beverage.CHAMPAGNE.getPrice();
            customer.addPresentationHistory(PRESENTATION_MESSAGE);
        }
        customer.putBenefitPrice(BenefitTypes.CHAMPAGNE, champagnePrice);
    }
}
