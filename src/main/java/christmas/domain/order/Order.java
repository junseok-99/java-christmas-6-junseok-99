package christmas.domain.order;

public class Order {

    private Price price;

    public Order() {
    }

    protected void setPrice(Long orderedTotalPrice) {
        price = new Price(orderedTotalPrice);
    }

    public Long getBeforeDiscountPrice() {
        return price.getBeforeDiscountPrice();
    }

    public Long getAfterDiscountPrice() {
        return price.getAfterDiscountPrice();
    }

    public void discount(Long discountTotalPrice) {
        price.discount(discountTotalPrice);
    }
}
