package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.OrderDTO;
import christmas.util.validation.ValidationDateOfVisit;
import christmas.util.validation.ValidationOrder;

import java.util.List;

public class InputView {

    public static Integer inputDateOfVisit() {
        try {
            System.out.println(InputMessages.DATE_OF_VISIT.getMessage());
            String dateOfVisitString = input();
            ValidationDateOfVisit.validateDateOfVisit(dateOfVisitString);
            Integer dateOfVisit = Integer.parseInt(dateOfVisitString);
            return dateOfVisit;
        } catch (IllegalArgumentException invalidDateOfVisitException) {
            System.out.println(invalidDateOfVisitException.getMessage());
            return inputDateOfVisit();
        }
    }

    public static List<OrderDTO> inputOrders() {
        try {
            System.out.println(InputMessages.ORDER.getMessage());
            String orderString = input();
            ValidationOrder.validateOrder(orderString);
            return null;
        } catch (IllegalArgumentException invalidDateOfVisitException) {
            System.out.println(invalidDateOfVisitException.getMessage());
            return inputOrders();
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
