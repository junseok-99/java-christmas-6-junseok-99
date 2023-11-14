package christmas.domain.event.discount;

import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekEndTest {

    private final Discount weekEnd;

    public WeekEndTest() {
        this.weekEnd = new WeekEnd();
        MenuRepository.initRepository();
    }

    @ParameterizedTest
    @DisplayName("주말 할인이 적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("티본스테이크-3", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-3", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = weekEnd.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("주말 할인이 미적용되는지 테스트한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void isSatisfyCondition_2(Integer day) {
        List<String> orderList = List.of("티본스테이크-3", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-3", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = weekEnd.isSatisfyCondition(customer);

        assertFalse(isSatisfyCondition);
    }

    @ParameterizedTest
    @DisplayName("주말 할인율이 올바른지 테스트한다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void discountRate(Integer day) {
        List<String> orderList = List.of("티본스테이크-3", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-3", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(day));
        Long expectedDiscountPrice = 2_023L;

        Long actualDiscountPrice = weekEnd.discountRate(customer);

        Assertions.assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
    }

    @Test
    void discount() {
    }
}