package christmas.controller;

import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;
import christmas.view.InputView;

import java.util.List;

public class OrderController {

    private OrderLists orderList;
    private DayOfVisit dayOfVisit;

    public OrderController() {
        initOrder();
    }

    public void initOrder() {
        Integer inputDateOfVisit = InputView.inputDateOfVisit();
        List<String> inputOrders = InputView.inputOrders();
        dayOfVisit = new DayOfVisit(inputDateOfVisit);
        orderList = new OrderLists(inputOrders);
    }
}