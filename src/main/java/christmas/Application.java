package christmas;

import christmas.controller.OrderController;
import christmas.domain.order.OrderLists;
import christmas.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();
        orderController.run();
    }
}
