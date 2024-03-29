package christmas.domain.event.discount;

import christmas.domain.benefit.BenefitTypes;
import christmas.domain.customer.Customer;
import christmas.domain.order.OrderRecord;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.repository.menu.MainDish;

import java.util.List;

public class WeekEnd implements Discount {

    private static final Integer FRIDAY = 1;
    private static final Integer SATURDAY = 2;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Integer dayOfVisit = customer.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (FRIDAY <= dayOfTheWeek && dayOfTheWeek <= SATURDAY) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Customer customer) {
        return WEEK_DISCOUNT_RATE;
    }

    @Override
    public void discount(Customer customer) {
        Boolean discountCondition = isSatisfyCondition(customer);
        Long discountPrice = INITIAL_PRICE;
        if (discountCondition) {
            discountPrice = NEGATIVE_NUMBER * discountMainDish(customer);
            customer.discount(discountPrice);
        }
        customer.putBenefitPrice(BenefitTypes.WEEKEND, discountPrice);
    }

    private Long discountMainDish(Customer customer) {
        Orders orders = (Orders) customer.getOrder();
        Long totalDiscountPrice = INITIAL_PRICE;
        List<OrderRecord> orderList = orders.getOrderList();
        for (OrderRecord order : orderList) {
            String menuName = order.menuName();
            Long count = (long) order.count();
            if (MainDish.contains(menuName)) {
                totalDiscountPrice += (count * discountRate(customer));
            }
        }
        return totalDiscountPrice;
    }
}
