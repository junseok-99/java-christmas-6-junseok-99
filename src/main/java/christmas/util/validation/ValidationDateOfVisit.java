package christmas.util.validation;

public class ValidationDateOfVisit {

    private static final String NUMBER_REGEX = "[0-9]";
    private static final String EMPTY_STRING = "";
    private static final String NOT_NUMERIC_MESSAGE = "[ERROR] 숫자만 입력해주세요!";

    private ValidationDateOfVisit() {

    }

    public static void validateDateOfVisit(String dateOfVisit) {
        validateNumeric(dateOfVisit);
    }

    public static void validateNumeric(String dateOfVisit) {
        String replacedDateOfVisit = dateOfVisit.replaceAll(NUMBER_REGEX, EMPTY_STRING);
        if (replacedDateOfVisit.isEmpty() == false) {
            throw new IllegalArgumentException(NOT_NUMERIC_MESSAGE);
        }
    }
}
