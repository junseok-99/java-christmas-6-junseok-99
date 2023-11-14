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

class ChristmasTest {

    private final Christmas christmas;

    public ChristmasTest() {
        this.christmas = new Christmas();
        MenuRepository.initRepository();
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인에 적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "티본스테이크-1", "샴페인-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = christmas.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인에 적용이 안되는지 테스트한다.")
    @ValueSource(ints = {-1, 0, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35})
    void isSatisfyCondition_2(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "티본스테이크-1", "샴페인-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = christmas.isSatisfyCondition(customer);

        assertFalse(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인금액이 올바르게 적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    void discountRate(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "티본스테이크-1", "샴페인-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long startPrice = 1000L;
        Long expectedDiscountPrice = (customer.getDayOfVisit() - 1) * 100 + startPrice;

        Long actualDiscountPrice = christmas.discountRate(customer);

        Assertions.assertThat(expectedDiscountPrice).isEqualTo(actualDiscountPrice);
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 할인금액이 올바르게 적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    void discount(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "티본스테이크-1", "샴페인-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = christmas.discountRate(customer);

        christmas.discount(customer);
        Order order = customer.getOrder();
        Long actualDiscountPrice = order.getBeforeDiscountPrice() - order.getAfterDiscountPrice();

        Assertions.assertThat(expectedDiscountPrice).isEqualTo(actualDiscountPrice);
    }
}