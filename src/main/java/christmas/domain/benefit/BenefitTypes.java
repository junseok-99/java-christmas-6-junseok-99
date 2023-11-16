package christmas.domain.benefit;

public enum BenefitTypes {
    CHRISTMAS("크리스마스 디데이 할인: %s"),
    WEEKDAY("평일 할인: %s"),
    WEEKEND("주말 할인: %s"),
    SPECIAL("특별 할인: %s"),
    CHAMPAGNE("증정 이벤트: %s");

    private final String benefitFormat;

    private BenefitTypes(String benefitFormat) {
        this.benefitFormat = benefitFormat;
    }

    public String getBenefitFormat() {
        return benefitFormat;
    }
}
