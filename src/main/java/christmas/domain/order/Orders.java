package christmas.domain.order;

import java.util.List;

public class Orders {

    private OrderLists orderList;
    private DayOfVisit dayOfVisit;

    public Orders(OrderLists orderList, DayOfVisit dayOfVisit) {
        this.orderList = orderList;
        this.dayOfVisit = dayOfVisit;
    }

    public String toOrderListString() {
        return orderList.toString();
    }

    public String toDayOfVisitString() {
        return dayOfVisit.toString();
    }

    public List<Order> getOrderList() {
        return orderList.getOrderList();
    }

    public Integer getDayOfVisit() {
        return dayOfVisit.getDay();
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
