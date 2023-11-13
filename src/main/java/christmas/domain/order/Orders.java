package christmas.domain.order;

import java.util.List;

public class Orders {

    private OrderList orderList;
    private BenefitList benefitList;

    public Orders(OrderList orderList) {
        this.orderList = orderList;
        this.benefitList = new BenefitList();
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

    public void discount(Long discountRate) {
        orderList.discount(discountRate);
    }
}
