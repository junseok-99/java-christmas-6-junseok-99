package christmas.controller;

import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;
import christmas.domain.order.Orders;
import christmas.repository.MenuRepository;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class OrderController {

    Orders orders;

    public OrderController() {
        initRepository();
        initOrder();
    }

    public void run() {
        OutputView.outputPreview(orders);
        OutputView.outputOrders(orders);
        OutputView.outputBeforeDiscountPrice(orders);
    }

    private void initRepository() {
        MenuRepository.initRepository();
    }
    private void initOrder() {
        Integer inputDateOfVisit = InputView.inputDateOfVisit();
        List<String> inputOrders = InputView.inputOrders();
        DayOfVisit dayOfVisit = new DayOfVisit(inputDateOfVisit);
        OrderLists orderList = new OrderLists(inputOrders);
        orders = new Orders(orderList, dayOfVisit);
    }
}
