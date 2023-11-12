package christmas.controller;

import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;
import christmas.domain.order.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class OrderController {

    Orders orders;

    public OrderController() {
        initOrder();
    }

    public void run() {
        OutputView.outputPreview(orders);
        OutputView.outputOrders(orders);
    }

    public void initOrder() {
        Integer inputDateOfVisit = InputView.inputDateOfVisit();
        List<String> inputOrders = InputView.inputOrders();
        DayOfVisit dayOfVisit = new DayOfVisit(inputDateOfVisit);
        OrderLists orderList = new OrderLists(inputOrders);
        orders = new Orders(orderList, dayOfVisit);
    }
}
