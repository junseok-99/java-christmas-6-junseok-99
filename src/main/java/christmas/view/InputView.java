package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.validation.ValidationDateOfVisit;

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

    private static String input() {
        return Console.readLine();
    }
}
