package christmas.util.validation;

public class ValidationDateOfVisit {

    private static final String NUMBER_REGEX = "[0-9]";
    private static final String EMPTY_STRING = "";
    private static final Integer MIN_DAY = 1;
    private static final Integer MAX_DAY = 31;
    private static final String INVALID_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private ValidationDateOfVisit() {

    }

    public static void validateDateOfVisit(String dateOfVisitString) {
        validateNumeric(dateOfVisitString);
        validateDayRange(dateOfVisitString);
    }

    public static void validateNumeric(String dateOfVisitString) {
        String replacedDateOfVisit = dateOfVisitString.replaceAll(NUMBER_REGEX, EMPTY_STRING);
        if (replacedDateOfVisit.isEmpty() == false) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateDayRange(String dateOfVisitString) {
        Integer dateOfVisit = Integer.parseInt(dateOfVisitString);
        if (dateOfVisit < MIN_DAY || dateOfVisit > MAX_DAY) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }
}
