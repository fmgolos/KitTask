package kit.konsalt.library;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void convert() {
        List<Integer> actual = List.of(1, 2, 3, 4, 5, 7, 9, 10, 11, 12);
        List<String> input = List.of("1-5,7,9-11", "12");
        Parser parser = new Parser();
        List<Integer> expected = parser.convert(input);
        assertThat(actual).isEqualTo(expected);
    }
}