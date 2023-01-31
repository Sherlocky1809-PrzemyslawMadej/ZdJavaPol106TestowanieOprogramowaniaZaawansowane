package pl.sdacademy.unit.test.advance.exercises.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongNameData.txt", delimiterString = ";")
    void shouldThrowNameExceptionForThisFileSource(String input) {
        // given
        User user = getData(input);
        // when & then
        assertThatThrownBy(() -> user.valid()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Bad name");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongSurnameData.txt", delimiterString = ";")
    void shouldThrowSurnameExceptionForThisFileSource(String input) {
        // given
        User user = getData(input);
        // when & then
        assertThatThrownBy(() -> user.valid()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Bad surname");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_wrongEmailData.txt", delimiterString = ";")
    void shouldThrowEmailExceptionForThisFileSource(String input) {
        // given
        User user = getData(input);
        // when & then
        assertThatThrownBy(() -> user.valid()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Bad e-mail");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email_correctData.txt", delimiterString = ";")
    void shouldTReturnTrueForThisFileSource(String input) {
        // given
        User user = getData(input);
        // when
        boolean result = user.valid();
        // then
        assertThat(result).isTrue();
    }

    private User getData(String input) {
        String[] words = input.split(",");
        return new User(words[0], words[1], words[2]);
    }
}