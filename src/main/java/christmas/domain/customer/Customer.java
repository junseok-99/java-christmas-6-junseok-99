package christmas.domain.customer;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitTypes;
import christmas.domain.benefit.Benefits;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;

import java.util.List;

public class Customer {

    private Order order;
    private Benefit benefit;
    private DayOfVisit dayOfVisit;

    public Customer(List<String> orders, DayOfVisit dayOfVisit) {
        this.order = new Orders(orders);
        this.benefit = new Benefits();
        this.dayOfVisit = dayOfVisit;
    }

    public Order getOrder() {
        return order;
    }

    public String toDayOfVisitString() {
        return dayOfVisit.toString();
    }

    public String getPresentationName() {
        Benefits benefits = (Benefits) getBenefit();
        return benefits.getPresentationHistoryNames();
    }

    public String getBadge() {
        return getBenefit().getBadge();
    }

    public Long toTotalBenefitPrice() {
        return getBenefit().toTotalBenefitPrice();
    }

    public String toBenefitPriceHistoryString() {
        return getBenefit().toBenefitPriceHistoryString();
    }

    public Long calcTotalBenefitPrice() {
        return getBenefit().calcTotalBenefitPrice();
    }

    public Integer getDayOfVisit() {
        return dayOfVisit.getDay();
    }

    public void discount(Long discountPrice) {
        getOrder().discount(discountPrice);
    }

    public void putBenefitPrice(BenefitTypes benefitTypes, Long benefitPrice) {
        getBenefit().putBenefitPrice(benefitTypes, benefitPrice);
    }

    public void addPresentationHistory(String presentationHistory) {
        Benefits benefits = (Benefits) getBenefit();
        benefits.addPresentationHistory(presentationHistory);
    }

    public void setBadge(String badge) {
        getBenefit().setBadge(badge);
    }

    private Benefit getBenefit() {
        return benefit;
    }
}
