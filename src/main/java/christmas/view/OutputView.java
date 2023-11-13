package christmas.view;

import christmas.domain.order.Orders;
import christmas.repository.MenuRepository;

import java.text.DecimalFormat;

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

    public static void outputBeforeDiscountPrice(Orders orders) {
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.BEFORE_PRICE.getMessage());
        Long totalPrice = MenuRepository.orderedTotalPrice(orders);
        System.out.print(formatter.format(totalPrice));
        System.out.println(OutputMessages.WON.getMessage());
    }
}
