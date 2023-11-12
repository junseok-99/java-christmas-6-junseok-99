package christmas.view;

public enum InputMessages {

    DATE_OF_VISIT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    private InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
