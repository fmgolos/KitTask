package kit.konsalt.library;

import java.util.List;
import java.util.stream.Collectors;

public class Port {
    private final List<String> indexes;

    public Port(List<String> indexes) {
        this.indexes = indexes;
    }

    public List<List<Integer>> parseIndexes() {
        List<List<Integer>> lists = indexes.stream().map(it -> new Parser().convert(List.of(it.split(",")))).collect(Collectors.toList());
        return lists;
    }

    public List<List<Integer>> getCombinations() {
        return new Combinator().getCombination(parseIndexes());
    }
}
