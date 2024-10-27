package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 빈값_테스트(String mockInput) {
        var runner = new InputValidator(mockInput);

        assertThrows(IllegalArgumentException.class, runner::attemptCountValidator);
        assertThrows(IllegalArgumentException.class, runner::carNameValidator);
    }

    @Test
    void 글자_수_제한_테스트() {
        var runner = new InputValidator("tayo,tayoo,tayooo");

        assertThrows(IllegalArgumentException.class, runner::carNameValidator);
    }
}
