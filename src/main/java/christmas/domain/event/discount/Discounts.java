package christmas.domain.event.discount;

import christmas.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Discounts {

    List<Discount> discountList = new ArrayList<>();

    public Discounts() {
        discountList.add(new Christmas());
        discountList.add(new WeekDay());
        discountList.add(new WeekEnd());
        discountList.add(new Special());
    }

    public void discount(Customer customer) {
        discountList.stream().forEach(discountItem -> discountItem.discount(customer));
    }
}
