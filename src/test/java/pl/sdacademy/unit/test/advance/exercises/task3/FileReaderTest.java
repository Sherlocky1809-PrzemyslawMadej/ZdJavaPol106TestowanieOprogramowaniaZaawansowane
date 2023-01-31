package pl.sdacademy.unit.test.advance.exercises.task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private static final String PATH = "src/test/resources/";
    FileReader fileReader = new FileReader();

    @Test
    void shouldThrowWhenFileHasWrongExtension() {
        // when & then
        assertThatThrownBy(() -> fileReader.counterCharacters(new File(PATH + "file.txt")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("wrong extension");
    }

    @Test
    void shouldThrowWhenFileDoesNotExist() {
        // when & then
        assertThatThrownBy(() -> fileReader.counterCharacters(new File(PATH + "randomFile.csv")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("no found file");
    }

    @Test
    void shouldCountCharactersAsExpected() {
        // given
        int expected = 12;
        // when
        int result = fileReader.counterCharacters(new File(PATH + "file.csv"));
        // then
        assertThat(result).isEqualTo(expected);
    }

}