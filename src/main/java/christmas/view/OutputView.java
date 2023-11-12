package christmas.view;

import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;
import christmas.domain.order.Orders;

public class OutputView {

    public static void outputIntro() {
        System.out.println(OutputMessages.INTRO.getMessage());
    }

    public static void outputPreview(Orders orders) {
        String previewMessage = String.format(OutputMessages.PREVIEW.getMessage(), orders.toDayOfVisitString());
        System.out.println(previewMessage);
    }

    public static void outputOrders(Orders orders) {
        System.out.println(OutputMessages.ORDER_MENUS.getMessage());
        System.out.println(orders.toOrderListString());
    }
}
