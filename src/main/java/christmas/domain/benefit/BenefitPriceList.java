package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class BenefitPriceList {

    private static final Long INITIAL_NUMBER = 0L;

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
}
