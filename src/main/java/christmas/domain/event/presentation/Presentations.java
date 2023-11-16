package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Presentations {

    private List<Presentation> presentationList = new ArrayList<>();

    public Presentations() {
        presentationList.add(new Champagne());
        presentationList.add(new Badge());
    }

    public void present(Customer customer) {
        presentationList.stream().forEach(presentationItem -> presentationItem.present(customer));
    }
}
