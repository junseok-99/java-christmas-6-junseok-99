package christmas.domain.customer;

import christmas.domain.dayofvisit.DayOfVisit;
import christmas.domain.order.Orders;

public class Customer {

    private Orders orders;
    private DayOfVisit dayOfVisit;

    public Customer(Orders orders, DayOfVisit dayOfVisit) {
        this.orders = orders;
        this.dayOfVisit = dayOfVisit;
    }

    public Orders getOrders() {
        return orders;
    }

    public void discount(Long discountPrice) {
        orders.discount(discountPrice);
    }

    public void addBenefitPrice(Long benefitPrice) {
        orders.addBenefitPrice(benefitPrice);
    }

    public Long calcTotalBenefitPrice() {
        return orders.calcTotalBenefitPrice();
    }

    public void setBadge(String badge) {
        orders.setBadge(badge);
    }

    public String toDayOfVisitString() {
        return dayOfVisit.toString();
    }

    public Integer getDayOfVisit() {
        return dayOfVisit.getDay();
    }
}
