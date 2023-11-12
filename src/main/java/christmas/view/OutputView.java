package christmas.view;

import christmas.domain.order.DayOfVisit;
import christmas.domain.order.OrderLists;

public class OutputView {

    public static void outputIntro() {
        System.out.println(OutputMessages.INTRO.getMessage());
    }

    public static void outputPreview(DayOfVisit dayOfVisit) {
        String previewMessage = String.format(OutputMessages.PREVIEW.getMessage(), dayOfVisit.toString());
        System.out.println(previewMessage);
    }

    public static void outputOrders(OrderLists orderList) {
        System.out.println(OutputMessages.ORDER_MENUS.getMessage());
        System.out.println(orderList);
    }
}
