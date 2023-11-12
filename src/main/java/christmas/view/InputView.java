package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Integer inputDateOfVisit() {
        System.out.println(InputMessages.DATE_OF_VISIT.getMessage());
        String dateOfVisitString = input();
        Integer dateOfVisit = Integer.parseInt(dateOfVisitString);
        return dateOfVisit;
    }

    private static String input() {
        return Console.readLine();
    }
}
