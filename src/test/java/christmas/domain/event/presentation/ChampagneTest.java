package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.domain.event.discount.Discount;
import christmas.domain.event.discount.Special;
import christmas.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampagneTest {

    private final Presentation champagne;

    public ChampagneTest() {
        this.champagne = new Champagne();
        MenuRepository.initRepository();
    }

    @Test
    @DisplayName("샴페인 증정 이벤트가 적용되는지 테스트한다.")
    void isSatisfyCondition() {
        List<String> orderList = List.of("티본스테이크-3", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-3", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(3));

        Boolean isSatisfyCondition = champagne.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @Test
    @DisplayName("샴페인 증정 이벤트가 미적용되는지 테스트한다.")
    void isSatisfyCondition_2() {
        List<String> orderList = List.of("티본스테이크-1", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(3));

        Boolean isSatisfyCondition = champagne.isSatisfyCondition(customer);

        assertFalse(isSatisfyCondition);
    }

    @Test
    @DisplayName("샴페인이 증정되는지 테스트한다.")
    void present() {
        List<String> orderList = List.of("티본스테이크-3", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-3", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(3));

        champagne.present(customer);
        String presentationNames = customer.getPresentationName();

        assertTrue(presentationNames.contains("샴페인 1개"));
    }
}