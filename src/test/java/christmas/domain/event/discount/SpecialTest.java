package christmas.domain.event.discount;


import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.repository.MenuRepository;
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
    void discountRate() {
    }

    @ParameterizedTest
    void discount() {
    }
}