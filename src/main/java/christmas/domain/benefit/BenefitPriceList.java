package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class BenefitPriceList {

    private static final Long INITIAL_NUMBER = 0L;
    private static final Integer ONE = 1;
    private static final String NO_PRESENTATION = "없음";

    private List<Long> benefitList;

    public BenefitPriceList() {
        this.benefitList = new ArrayList<>();
    }

    public void add(Long benefit) {
        benefitList.add(benefit);
    }

    public Long calcTotalBenefitPrice() {
        Long totalBenefitPrice = INITIAL_NUMBER;
        for (Long benefitPrice : benefitList) {
            if (benefitPrice != null) {
                totalBenefitPrice += benefitPrice;
            }
        }
        return totalBenefitPrice;
    }

    public String getPresentationName() {
        Integer benefitListSize = benefitList.size() - ONE;
        if (benefitList.isEmpty() || benefitList.get(benefitListSize) == null) {
            return NO_PRESENTATION;
        }
        return "샴페인 1개";
    }
}
