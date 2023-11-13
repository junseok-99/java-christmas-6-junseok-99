package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;

public class Badge implements Presentation {

    private static final String STAR_STRING = "별";
    private static final String TREE_STRING = "트리";
    private static final String SANTA_STRING = "산타";

    private static final Long STAR_NUMBER = 5_000L;
    private static final Long TREE_NUMBER = 10_000L;
    private static final Long SANTA_NUMBER = 20_000L;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Long totalBenefitPrice = customer.calcTotalBenefitPrice();
        if (totalBenefitPrice >= STAR_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public void present(Customer customer) {
        Boolean presentCondition = isSatisfyCondition(customer);
        if (presentCondition) {
            presentBadge(customer);
        }
    }

    private void presentBadge(Customer customer) {
        Long totalBenefitPrice = customer.calcTotalBenefitPrice();
        if (STAR_NUMBER <= totalBenefitPrice && totalBenefitPrice < TREE_NUMBER) {
            customer.setBadge(STAR_STRING);
        } else if (TREE_NUMBER <= totalBenefitPrice && totalBenefitPrice < SANTA_NUMBER) {
            customer.setBadge(TREE_STRING);
        } else if (SANTA_NUMBER <= totalBenefitPrice) {
            customer.setBadge(SANTA_STRING);
        }
    }
}
