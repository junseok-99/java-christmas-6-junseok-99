package christmas.util.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationDateOfVisitTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 예상 방문 날짜 인지 테스트한다.")
    @ValueSource(strings = { "a", "b3", "0", "32", "102394845", "1a3", " ", " 3 ", "3  "})
    void validateInvalidDayOfVisit(String dayOfVisit) {
        IllegalArgumentException invalidDayOfVisitException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationDayOfVisit.validateDayOfVisit(dayOfVisit);
        });
        assertThat(invalidDayOfVisitException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("유효한 예상 방문 날짜 인지 테스트한다.")
    @ValueSource(strings = { "1", "2", "4", "15", "17", "19", "20", "25", "31"})
    void validateDayOfVisit(String dayOfVisit) {
        assertDoesNotThrow(() -> {
            ValidationDayOfVisit.validateDayOfVisit(dayOfVisit);
        });
    }

    @ParameterizedTest
    @DisplayName("예상 방문 날짜가 숫자가 아닌지 테스트한다.")
    @ValueSource(strings = { "a", "b3", "  3", " ", "뮻ㅇ", "abc", "!!@#$%", " /e/", "3/"})
    void validateNumeric(String dayOfVisit) {
        IllegalArgumentException invalidDayOfVisitException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationDayOfVisit.validateNumeric(dayOfVisit);
        });
        assertThat(invalidDayOfVisitException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("예상 방문 날짜의 범위가 1~31이내가 아닌지 테스트한다.")
    @ValueSource(strings = { "0", "-1", "-203", "32", "102394845", "100", "9090"})
    void validateDayRange(String dayOfVisit) {
        IllegalArgumentException invalidDayOfVisitException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationDayOfVisit.validateDayRange(dayOfVisit);
        });
        assertThat(invalidDayOfVisitException.getMessage())
                .isEqualTo("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}