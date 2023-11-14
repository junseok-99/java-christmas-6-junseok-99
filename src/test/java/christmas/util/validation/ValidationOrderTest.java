package christmas.util.validation;

import christmas.repository.MenuRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationOrderTest {

    @BeforeAll
    static void 테스트_전_저장소_초기화() {
        MenuRepository.initRepository();
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 주문인지 테스트한다.")
    @ValueSource(strings = { "aa-1", "티본스테끼-3", "제로콜라-3, 제로콜라-2", " -1, 타파스-1", "해산물파스타-0", "제로콜라--1"})
    void validateInvalidOrder(String orderString) {
        IllegalArgumentException invalidOrderException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationOrder.validateOrder(orderString);
        });
        assertThat(invalidOrderException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("유효한 주문인지 테스트한다.")
    @ValueSource(strings = { "타파스-1,제로콜라-1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "해산물파스타-1,샴페인-1"})
    void validateOrder(String orderString) {
        assertDoesNotThrow(() -> {
            ValidationOrder.validateOrder(orderString);
        });
    }

    @ParameterizedTest
    @DisplayName("각 주문의 형식이 올바르지 않은지 테스트한다.")
    @ValueSource(strings = { "타파스*1", "티본스테이크/--1", "바비큐립--1", "초코케이크!2,제로콜라-1", "해산물파스타$1,샴페인+1"})
    void validateForm(String orderString) {
        IllegalArgumentException invalidFormException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationOrder.validateOrder(orderString);
        });
        assertThat(invalidFormException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("각 주문의 개수가 1보다 작은지 테스트한다.")
    @ValueSource(strings = { "타파스-0", "티본스테이크--1", "초코케이크-0,제로콜라-0", "해산물파스타-0,샴페인--1"})
    void validateMenuCount(String orderString) {
        IllegalArgumentException invalidMenuCountException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationOrder.validateOrder(orderString);
        });
        assertThat(invalidMenuCountException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void validateDuplicateMenu() {
    }

    @Test
    void validateMenuCountSum() {
    }

    @Test
    void validateMenuInRepository() {
    }

    @Test
    void validateAllBeverage() {
    }
}