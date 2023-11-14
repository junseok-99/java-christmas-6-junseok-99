package christmas.domain.event.discount;

import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("크리스마스 할인 이벤트에 적용되는지 테스트한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "티본스테이크-1", "샴페인-1");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        assertTrue(christmas.isSatisfyCondition(customer));
    }

    @Test
    void discountRate() {
    }

    @Test
    void discount() {
    }
}