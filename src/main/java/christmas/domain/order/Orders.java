package christmas.domain.order;

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
}
