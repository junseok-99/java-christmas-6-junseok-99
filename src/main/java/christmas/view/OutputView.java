package christmas.view;

import christmas.domain.customer.Customer;
import christmas.domain.order.Orders;

import java.text.DecimalFormat;

public class OutputView {

    public static void outputIntro() {
        System.out.println(OutputMessages.INTRO.getMessage());
    }

    public static void outputPreview(Customer customer) {
        String previewMessage = String.format(OutputMessages.PREVIEW.getMessage(), customer.toDayOfVisitString());
        System.out.println(previewMessage);
    }

    public static void outputOrders(Orders orders) {
        System.out.println(OutputMessages.ORDER_MENUS.getMessage());
        System.out.println(orders.toOrderListString());
    }

    public static void outputBeforeDiscountPrice(Orders orders) {
        Long beforeDiscountPrice = orders.getBeforeDiscountPrice();
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.BEFORE_PRICE.getMessage());
        System.out.println(formatter.format(beforeDiscountPrice));
    }

    public static void outputPresentationMenu(Customer customer) {
        String presentationName = customer.getPresentationName();
        System.out.println(OutputMessages.PRESENTATION_MENU.getMessage());
        System.out.println(presentationName);
        System.out.println();
    }

    public static void outputTotalBenefitPrice(Customer customer) {
        Long totalBenefitPrice = customer.calcTotalBenefitPrice();
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.TOTAL_BENEFIT_PRICE.getMessage());
        System.out.println(formatter.format(totalBenefitPrice));
    }

    public static void outputAfterDiscountPrice(Orders orders) {
        Long afterDiscountPrice = orders.getAfterDiscountPrice();
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.AFTER_PRICE.getMessage());
        System.out.println(formatter.format(afterDiscountPrice));
    }
}
