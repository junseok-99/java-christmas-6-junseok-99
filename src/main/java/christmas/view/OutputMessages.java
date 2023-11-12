package christmas.view;

public enum OutputMessages {

    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

    private final String message;

    private OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
