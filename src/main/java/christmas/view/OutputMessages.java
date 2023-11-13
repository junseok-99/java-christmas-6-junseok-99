package christmas.view;

public enum OutputMessages {

    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENUS("<주문 메뉴>"),
    BEFORE_PRICE("<할인 전 총주문 금액>"),
    PRESENTATION_MENU("<증정 메뉴>"),
    AFTER_PRICE("<할인 후 예상 결제 금액>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    DECIMAL_FORMAT("###,###원\n");

    private final String message;

    private OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
