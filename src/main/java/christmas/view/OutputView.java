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

    public static void outputBeforeDiscountPrice(Long beforeDiscountPrice) {
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.BEFORE_PRICE.getMessage());
        System.out.print(formatter.format(beforeDiscountPrice));
        System.out.println(OutputMessages.WON.getMessage());
    }

    public static void outputAfterDiscountPrice(Long afterDiscountPrice) {
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.AFTER_PRICE.getMessage());
        System.out.print(formatter.format(afterDiscountPrice));
        System.out.println(OutputMessages.WON.getMessage());
    }
}
