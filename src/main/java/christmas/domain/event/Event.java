package christmas.domain.event;

import christmas.domain.customer.Customer;
import christmas.domain.event.discount.Discounts;
import christmas.domain.event.presentation.Presentations;

public class Event {

    Discounts discounts;
    Presentations presentations;

    public Event() {
        this.discounts = new Discounts();
        this.presentations = new Presentations();
    }

    public void discount(Customer customer) {
        discounts.discount(customer);
    }

    public void present(Customer customer) {
        presentations.present(customer);
    }
}
