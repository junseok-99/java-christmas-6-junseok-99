package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.SplitTypes;
import christmas.util.validation.ValidationDateOfVisit;
import christmas.util.validation.ValidationOrder;

import java.util.List;
import java.util.stream.Stream;

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

    public static List<String> inputOrders() {
        try {
            System.out.println(InputMessages.ORDER.getMessage());
            String orderString = input();
            ValidationOrder.validateOrder(orderString);
            List<String> orders = makeOrders(orderString);
            return orders;
        } catch (IllegalArgumentException invalidDateOfVisitException) {
            System.out.println(invalidDateOfVisitException.getMessage());
            return inputOrders();
        }
    }

    private static List<String> makeOrders(String orderString) {
        return Stream.of(orderString.split(SplitTypes.ORDER_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .toList();
    }

    private static String input() {
        return Console.readLine();
    }
}
