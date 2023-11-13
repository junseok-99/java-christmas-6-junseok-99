package christmas.view;

import christmas.domain.customer.Customer;
import christmas.domain.order.Order;
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

    public static void outputOrders(Order order) {
        Order orders = (Orders) order;
        System.out.println(OutputMessages.ORDER_MENUS.getMessage());
        System.out.println(orders.toString());
    }

    public static void outputBeforeDiscountPrice(Order order) {
        Long beforeDiscountPrice = order.getBeforeDiscountPrice();
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

    public static void outputAfterDiscountPrice(Order orders) {
        Long afterDiscountPrice = orders.getAfterDiscountPrice();
        DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
        System.out.println(OutputMessages.AFTER_PRICE.getMessage());
        System.out.println(formatter.format(afterDiscountPrice));
    }
}
