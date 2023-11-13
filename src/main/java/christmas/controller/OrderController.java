package christmas.controller;

import christmas.domain.customer.Customer;
import christmas.domain.event.Event;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.repository.MenuRepository;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class OrderController {

    private static final Long MIN_ORDER_PRICE = 10_000L;

    private Customer customer;
    private Event event;

    public OrderController() {
        initRepository();
        initOrder();
        initEvent();
    }

    public void run() {
        processEvent();
        exit();
    }

    public void exit() {
        OutputView.outputPreview(customer);
        OutputView.outputOrders(customer.getOrder());
        OutputView.outputBeforeDiscountPrice(customer.getOrder());
        OutputView.outputPresentationMenu(customer);
        OutputView.outputBenefitPriceHistories(customer);
        OutputView.outputTotalBenefitPrice(customer);
        OutputView.outputAfterDiscountPrice(customer.getOrder());
    }

    public void processEvent() {
        Long totalPrice = customer.getOrder().getBeforeDiscountPrice();
        if (totalPrice >= MIN_ORDER_PRICE) {
            event.discount(customer);
            event.present(customer);
        }
    }

    private void initRepository() {
        MenuRepository.initRepository();
    }

    private void initOrder() {
        Integer inputDateOfVisit = InputView.inputDateOfVisit();
        List<String> inputOrders = InputView.inputOrders();
        customer = new Customer(inputOrders, new DayOfVisit(inputDateOfVisit));
    }

    private void initEvent() {
        event = new Event();
    }
}
