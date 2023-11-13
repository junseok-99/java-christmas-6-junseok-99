package christmas.domain.benefit;

public enum BenefitTypes {
    CHRISTMAS("크리스마스 디데이 할인: "),
    WEEKDAY("평일 할인: "),
    WEEKEND("주말 할인: "),
    SPECIAL("특별 할인: "),
    CHAMPAGNE("증정 이벤트: ");

    private final String benefitFormat;

    private BenefitTypes(String benefitFormat) {
        this.benefitFormat = benefitFormat;
    }

    public String getBenefitFormat() {
        return benefitFormat;
    }
}
