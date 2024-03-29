package christmas.domain.event.discount;


import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.domain.order.Order;
import christmas.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialTest {

    private final Discount special;

    public SpecialTest() {
        this.special = new Special();
        MenuRepository.initRepository();
    }

    @ParameterizedTest
    @DisplayName("특별 할인이 적용되는지 테스트한다.")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("타파스-1", "티본스테이크-1", "아이스크림-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = special.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("특별 할인이 미적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 26, 27, 28, 29, 30})
    void isSatisfyCondition_2(Integer day) {
        List<String> orderList = List.of("타파스-1", "티본스테이크-1", "아이스크림-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = special.isSatisfyCondition(customer);

        assertFalse(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("특별 할인율이 올바른지 테스트한다.")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void discountRate(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = 1_000L;

        Long actualDiscountPrice = special.discountRate(customer);

        Assertions.assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
    }

    @ParameterizedTest
    @DisplayName("특별 할인이 올바르게 적용되는지 테스트한다.")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void discount(Integer day) {
        List<String> orderList = List.of("타파스-1", "티본스테이크-1", "아이스크림-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = 1_000L;

        special.discount(customer);
        Order order = customer.getOrder();
        Long actualDiscountPrice = order.getBeforeDiscountPrice() - order.getAfterDiscountPrice();

        Assertions.assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
    }
}