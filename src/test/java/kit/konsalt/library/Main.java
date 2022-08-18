package kit.konsalt.library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "1-5,7,9-11";
        String input2 = "2";
        String input3 = "3-7";
        List<String> strings = List.of(input, input2, input3);
        Port port = new Port(strings);
        List<List<Integer>> integers = port.parseIndexes();
        System.out.println(integers);
        List<List<Integer>> combinations = port.getCombinations();
        combinations.forEach(System.out::println);

    }
}
