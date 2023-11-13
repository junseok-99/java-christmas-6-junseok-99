package christmas.domain.benefit;

public class Benefit {

    private static final String NO_BADGE = "없음";

    private BenefitPriceList benefitPriceList;
    private String badge;

    public Benefit() {
        this.benefitPriceList = new BenefitPriceList();
        this.badge = NO_BADGE;
    }

    public void addBenefitPrice(Long benefitPrice) {
        benefitPriceList.add(benefitPrice);
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public Long calcTotalBenefitPrice() {
        return benefitPriceList.calcTotalBenefitPrice();
    }
}
