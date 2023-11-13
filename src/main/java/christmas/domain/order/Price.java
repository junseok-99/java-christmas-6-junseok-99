package christmas.domain.order;

public class Price {

    private final Long beforeDiscountPrice;
    private Long afterDiscountPrice;

    public Price(Long orderedTotalPrice) {
        this.beforeDiscountPrice = orderedTotalPrice;
        this.afterDiscountPrice = orderedTotalPrice;
    }

    public Long getBeforeDiscountPrice() {
        return beforeDiscountPrice;
    }

    public Long getAfterDiscountPrice() {
        return afterDiscountPrice;
    }

    public void discount(Long discountRate) {
        this.afterDiscountPrice -= discountRate;
    }
}
