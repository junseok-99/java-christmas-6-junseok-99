package christmas.domain.event.discount;

import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.repository.MenuRepository;
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
    @DisplayName("평일 할인에 적용되는지 테스트한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void isSatisfyCondition(Integer day) {
        List<String> orderList = List.of("타파스-1", "제로콜라-1", "아이스크림-2", "초코케이크-5");
        Customer customer = new Customer(orderList, new DayOfVisit(day));

        Boolean isSatisfyCondition = weekDay.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @ParameterizedTest
    void discountRate() {
    }

    @ParameterizedTest
    void discount() {
    }
}