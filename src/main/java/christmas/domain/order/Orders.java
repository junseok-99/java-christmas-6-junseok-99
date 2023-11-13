package christmas.domain.order;

import christmas.domain.benefit.Benefit;

import java.util.List;

public class Orders {

    private OrderList orderList;
    private Benefit benefit;

    public Orders(OrderList orderList) {
        this.orderList = orderList;
        this.benefit = new Benefit();
    }

    public void discount(Long discountRate) {
        orderList.discount(discountRate);
    }

    public void addBenefitPrice(Long benefitPrice) {
        this.benefit.addBenefitPrice(benefitPrice);
    }

    public String toOrderListString() {
        return orderList.toString();
    }

    public List<Order> getOrderList() {
        return orderList.getOrderList();
    }

    public Long getBeforeDiscountPrice() {
        return orderList.getBeforeDiscountPrice();
    }

    public Long getAfterDiscountPrice() {
        return orderList.getAfterDiscountPrice();
    }

    public Long calcTotalBenefitPrice() {
        return benefit.calcTotalBenefitPrice();
    }

    public void setBadge(String badge) {
        benefit.setBadge(badge);
    }
}
