package christmas.domain.event.discount;

import christmas.domain.benefit.BenefitTypes;
import christmas.domain.customer.Customer;
import christmas.domain.order.OrderRecord;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.repository.menu.Desert;

import java.util.List;

public class WeekDay implements Discount {

    private static final Integer SUNDAY = 3;
    private static final Integer WEDNESDAY = 6;
    private static final Integer THURSDAY = 0;

    @Override
    public Boolean isSatisfyCondition(Customer customer) {
        Integer dayOfVisit = customer.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (dayOfTheWeek.equals(THURSDAY) || (SUNDAY <= dayOfTheWeek && dayOfTheWeek <= WEDNESDAY)) {
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
            discountPrice = NEGATIVE_NUMBER * discountDesert(customer);
            customer.discount(discountPrice);
        }
        customer.putBenefitPrice(BenefitTypes.WEEKDAY, discountPrice);
    }

    private Long discountDesert(Customer customer) {
        Long totalDiscountPrice = INITIAL_PRICE;
        Orders orders = (Orders) customer.getOrder();
        List<OrderRecord> orderList = orders.getOrderList();
        for (OrderRecord order : orderList) {
            String menuName = order.menuName();
            Long count = (long) order.count();
            if (Desert.contains(menuName)) {
                totalDiscountPrice += (count * discountRate(customer));
            }
        }
        return totalDiscountPrice;
    }
}
