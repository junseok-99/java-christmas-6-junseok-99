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

class WeekDayTest {

    private final Discount weekDay;

    public WeekDayTest() {
        this.weekDay = new WeekDay();
        MenuRepository.initRepository();
    }

    @ParameterizedTest
    @DisplayName("평일 할인이 적용되는지 테스트한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = weekDay.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("평일 할인이 미적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isSatisfyCondition_2(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = weekDay.isSatisfyCondition(customer);

        assertFalse(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("평일 할인율이 올바른지 테스트한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void discountRate(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = 2_023L;

        Long actualDiscountPrice = weekDay.discountRate(customer);

        Assertions.assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
    }

    @ParameterizedTest
    @DisplayName("평일 할인이 올바르게 적용되는지 테스트한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void discount(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = 2_023L * 7L;

        weekDay.discount(customer);
        Order order = customer.getOrder();
        Long actualDiscountPrice = order.getBeforeDiscountPrice() - order.getAfterDiscountPrice();

        Assertions.assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
    }
}