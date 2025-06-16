package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class functionalProgramming {

    public static void main(String[] args) {

        //combined example

        Predicate<Integer> predicate = x -> x%2==0;
        Function<Integer,Integer> function = x -> x*x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        //BiPredict, BiConsumer, BiFunction

        BiPredicate<Integer,Integer> isSumEven = (x,y) -> (x+y) % 2==0;

        System.out.println(isSumEven.test(5,5));

        // Method reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");

        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);
    }
}
