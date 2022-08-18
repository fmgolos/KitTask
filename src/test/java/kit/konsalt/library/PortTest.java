package kit.konsalt.library;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PortTest {

    @Test
    void parseIndexes() {
        List<List<Integer>> actual = List.of(List.of(1, 2, 3), List.of(4), List.of(7, 8, 9, 10));
        String input = "1,2,3";
        String input2 = "4";
        String input3 = "7-10";
        List<String> strings = List.of(input, input2, input3);
        List<List<Integer>> expected = new Port(strings).parseIndexes();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getCombinations() {
        List<List<Integer>> actual = List.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(3, 2, 3), List.of(3, 2, 4), List.of(4, 2, 3), List.of(4, 2, 4), List.of(5, 2, 3), List.of(5, 2, 4));
        String input = "1,3-5";
        String input2 = "2";
        String input3 = "3-4";
        List<String> strings = List.of(input, input2, input3);
        List<List<Integer>> expected = new Port(strings).getCombinations();
        assertThat(actual).isEqualTo(expected);
    }
}