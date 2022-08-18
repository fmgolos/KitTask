package kit.konsalt.library;

import java.util.ArrayList;
import java.util.List;

final class Combinator {
    public List<List<Integer>> getCombination(List<List<Integer>> input) {
        List<List<Integer>> columns = new ArrayList<>();
        int numberOfCombinations = input.stream().mapToInt(List::size).reduce(1, (a, b) -> a * b);
        List<Integer> steps = generateSteps(input);
        for (int i = 0; i < input.size(); i++) {
            columns.add(createColumn(numberOfCombinations, steps.get(i), input.get(i)));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numberOfCombinations; i++) {
            ArrayList<Integer> group = new ArrayList<>();
            for (List<Integer> column : columns) {
                group.add(column.get(i));
            }
            result.add(group);
        }
        return result;
    }

    protected ArrayList<Integer> createColumn(int numberOfCombinations, int step, List<Integer> value) {
        ArrayList<Integer> result = new ArrayList<>();
        int repeat = numberOfCombinations / step / value.size();
        for (int r = 0; r < repeat; r++) {
            for (Integer integer : value) {
                for (int s = 0; s < step; s++) {
                    result.add(integer);
                }
            }
        }
        return result;
    }

    protected List<Integer> generateSteps(List<List<Integer>> input) {
        List<Integer> steps = new ArrayList<>();
        int step = input.stream().mapToInt(List::size).reduce(1, (a, b) -> a * b);
        for (List<Integer> integers : input) {
            if (integers.size() == 1) {
                steps.add(1);
            } else {
                step = step / integers.size();
                steps.add(step);
            }
        }
        return steps;
    }
}
