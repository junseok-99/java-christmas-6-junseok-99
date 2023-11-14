package christmas.domain.event.presentation;

import christmas.domain.customer.Customer;
import christmas.domain.dayofvisit.DayOfVisit;
import christmas.domain.event.discount.Discounts;
import christmas.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    private final Presentation badge;
    private final Discounts discounts;

    public BadgeTest() {
        this.badge = new Badge();
        this.discounts = new Discounts();
        MenuRepository.initRepository();
    }

    @Test
    @DisplayName("별 배지 부여 이벤트가 적용되는지 테스트한다.")
    void isSatisfyCondition_Star() {
        List<String> orderList = List.of("초코케이크-2", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(4));

        discounts.discount(customer);
        Boolean isSatisfyCondition = badge.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @Test
    @DisplayName("트리 배지 부여 이벤트가 적용되는지 테스트한다.")
    void isSatisfyCondition_Tree() {
        List<String> orderList = List.of("초코케이크-3", "아이스크림-3");
        Customer customer = new Customer(orderList, new DayOfVisit(4));

        discounts.discount(customer);
        Boolean isSatisfyCondition = badge.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @Test
    @DisplayName("산타 배지 부여 이벤트가 적용되는지 테스트한다.")
    void isSatisfyCondition_Santa() {
        List<String> orderList = List.of("초코케이크-5", "아이스크림-5");
        Customer customer = new Customer(orderList, new DayOfVisit(4));

        discounts.discount(customer);
        Boolean isSatisfyCondition = badge.isSatisfyCondition(customer);

        assertTrue(isSatisfyCondition);
    }

    @Test
    @DisplayName("별 배지가 부여되는지 테스트한다.")
    void present_Star() {
        List<String> orderList = List.of("초코케이크-2", "아이스크림-2");
        Customer customer = new Customer(orderList, new DayOfVisit(4));
        String expectedBadge = "별";

        discounts.discount(customer);
        badge.present(customer);
        String actualBadge = customer.getBadge();

        Assertions.assertThat(actualBadge).isEqualTo(expectedBadge);
    }

    @Test
    @DisplayName("트리 배지가 부여되는지 테스트한다.")
    void present_Tree() {
        List<String> orderList = List.of("초코케이크-3", "아이스크림-3");
        Customer customer = new Customer(orderList, new DayOfVisit(4));
        String expectedBadge = "트리";

        discounts.discount(customer);
        badge.present(customer);
        String actualBadge = customer.getBadge();

        Assertions.assertThat(actualBadge).isEqualTo(expectedBadge);
    }

    @Test
    @DisplayName("산타 배지가 부여되는지 테스트한다.")
    void present_Santa() {
        List<String> orderList = List.of("초코케이크-5", "아이스크림-5");
        Customer customer = new Customer(orderList, new DayOfVisit(4));
        String expectedBadge = "산타";

        discounts.discount(customer);
        badge.present(customer);
        String actualBadge = customer.getBadge();

        Assertions.assertThat(actualBadge).isEqualTo(expectedBadge);
    }
}