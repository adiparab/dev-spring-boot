package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        System.out.println(numbers.stream().filter(x -> x%2==0).toList());
    }
}
