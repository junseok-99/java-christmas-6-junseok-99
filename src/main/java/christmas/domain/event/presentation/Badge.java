package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;

public class Badge implements Presentation {

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Long totalBenefitPrice = NEGATIVE_NUMBER * customer.calcTotalBenefitPrice();
        if (totalBenefitPrice >= BadgeCondition.STAR.getPrice()) {
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
        Long totalBenefitPrice = NEGATIVE_NUMBER * customer.calcTotalBenefitPrice();
        Long starPrice = BadgeCondition.STAR.getPrice();
        Long treePrice = BadgeCondition.TREE.getPrice();
        Long santaPrice = BadgeCondition.SANTA.getPrice();
        if (starPrice <= totalBenefitPrice && totalBenefitPrice < treePrice) {
            customer.setBadge(BadgeCondition.STAR.getName());
        } else if (treePrice <= totalBenefitPrice && totalBenefitPrice < santaPrice) {
            customer.setBadge(BadgeCondition.TREE.getName());
        } else if (starPrice <= totalBenefitPrice) {
            customer.setBadge(BadgeCondition.SANTA.getName());
        }
    }
}
