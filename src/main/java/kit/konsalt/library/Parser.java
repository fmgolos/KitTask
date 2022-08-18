package kit.konsalt.library;

import java.util.ArrayList;
import java.util.List;

final class Parser {
    public List<Integer> convert(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String element : input) {
            String[] split = element.split(",");
            for (String i : split) {
                if (i.contains("-")) {
                    addRange(i, result);
                } else addSingle(i, result);
            }
        }
        return result;
    }

    private void addSingle(String element, List<Integer> result) {
        result.add(Integer.parseInt(element));
    }

    private void addRange(String range, List<Integer> result) {
        String[] strings = range.split("-");
        int from = Integer.parseInt(strings[0]);
        int to = Integer.parseInt(strings[1]);
        for (int i = from; i <= to; i++) {
            result.add(i);
        }
    }
}

