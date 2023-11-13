package christmas.domain.benefit;

import christmas.view.OutputMessages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Benefit {

    protected static final String NONE_BENEFIT = "없음";
    protected static final String LINE_BREAKING = "\n";
    protected static final String EMPTY_STRING = "";
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

    public Long toTotalBenefitPrice() {
        Long totalBenefitPrice = INITIAL_NUMBER;
        for (BenefitTypes benefitTypes : benefitPriceMap.keySet()) {
            totalBenefitPrice += benefitPriceMap.get(benefitTypes);
        }
        return totalBenefitPrice;
    }

    public String toBenefitPriceHistoryString() {
        List<String> benefitPriceHistoryList = new ArrayList<>();
        makeBenefitPriceFormat(benefitPriceHistoryList);
        if (benefitPriceHistoryList.isEmpty()) {
            return NONE_BENEFIT;
        }
        return String.join(EMPTY_STRING, benefitPriceHistoryList);
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    protected void makeBenefitPriceFormat(List<String> benefitPriceHistoryList) {
        for (BenefitTypes benefitTypes : benefitPriceMap.keySet()) {
            Long benefitPrice = benefitPriceMap.get(benefitTypes);
            if (benefitPrice < INITIAL_NUMBER) {
                DecimalFormat formatter = new DecimalFormat(OutputMessages.DECIMAL_FORMAT.getMessage());
                String benefitPriceFormat = formatter.format(benefitPrice);
                String benefitPriceHistoryString = String.format(benefitTypes.getBenefitFormat(), benefitPriceFormat);
                benefitPriceHistoryList.add(benefitPriceHistoryString);
            }
        }
    }
}
