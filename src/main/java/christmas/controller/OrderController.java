package christmas.controller;

import christmas.domain.event.Event;
import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;
import christmas.domain.order.Orders;
import christmas.repository.MenuRepository;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class OrderController {

    private static final Long MIN_ORDER_PRICE = 10_000L;

    private Orders orders;
    private Event event;

    public OrderController() {
        initRepository();
        initOrder();
        initEvent();
    }

    public void run() {
        processEvent();
        exit();
    }

    public void exit() {
        OutputView.outputPreview(orders);
        OutputView.outputOrders(orders);
        OutputView.outputBeforeDiscountPrice(orders.getBeforeDiscountPrice());
    }

    public void processEvent() {
        Long totalPrice = orders.getBeforeDiscountPrice();
        if (totalPrice >= MIN_ORDER_PRICE) {
            event.discount(orders);
        }
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

    private void initEvent() {
        event = new Event();
    }
}
