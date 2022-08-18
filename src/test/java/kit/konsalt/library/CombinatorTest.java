package kit.konsalt.library;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinatorTest {

    @Test
    void createColumn() {
        List<Integer> actual = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3);
        ArrayList<Integer> expected = new Combinator().createColumn(27, 9, List.of(1, 2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateSteps() {
        List<Integer> actual = List.of(12, 4, 1, 1);

        List<Integer> a1 = List.of(1, 2, 3);
        List<Integer> a2 = List.of(1, 2, 3);
        List<Integer> a3 = List.of(1, 2, 3, 4);
        List<Integer> a4 = List.of(1);
        List<List<Integer>> array = List.of(a1, a2, a3, a4);
        List<Integer> steps = new Combinator().generateSteps(array);
        assertThat(actual).isEqualTo(steps);

    }

    @Test
    void combine() {
        List<List<Integer>> actual = List.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(3, 2, 3), List.of(3, 2, 4), List.of(4, 2, 3), List.of(4, 2, 4), List.of(5, 2, 3), List.of(5, 2, 4));
        List<Integer> a1 = List.of(1, 3, 4, 5);
        List<Integer> a2 = List.of(2);
        List<Integer> a3 = List.of(3, 4);
        List<List<Integer>> array = List.of(a1, a2, a3);
        List<List<Integer>> combine = new Combinator().getCombination(array);
        assertThat(actual).isEqualTo(combine);
    }
}
