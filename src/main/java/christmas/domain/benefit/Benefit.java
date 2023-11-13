package christmas.domain.benefit;

import java.util.EnumMap;
import java.util.Map;

public class Benefit {

    protected static final String NONE_BENEFIT = "없음";
    private static final Long INITIAL_NUMBER = 0L;

    private final Map<BenefitTypes, Long> benefitPriceMap;
    private String badge;

    public Benefit() {
        this.benefitPriceMap = new EnumMap<>(BenefitTypes.class);
        this.badge = NONE_BENEFIT;
    }

    public void putBenefitPrice(BenefitTypes benefitTypes, Long benefitPrice) {
        benefitPriceMap.put(benefitTypes, benefitPrice);
    }

    public Long calcTotalBenefitPrice() {
        Long totalBenefitPrice = INITIAL_NUMBER;
        for (BenefitTypes benefitTypes : benefitPriceMap.keySet()) {
            totalBenefitPrice += benefitPriceMap.get(benefitTypes);
        }
        return totalBenefitPrice;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }
}
