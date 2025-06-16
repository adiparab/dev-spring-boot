package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

            long startTime = System.currentTimeMillis();

            List<Integer> list = Stream.iterate(1,x->x+1).limit(20000).toList();

            List<Long> factList = list.stream().map(ParallelStreams::factorial).toList();

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for execution:"+(endTime-startTime));


            //with paralles stream
        long startTime1 = System.currentTimeMillis();

        List<Integer> list1 = Stream.iterate(1,x->x+1).limit(20000).toList();

        List<Long> factList1 = list.parallelStream().map(ParallelStreams::factorial).toList();

        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken for parallel stream execution:"+(endTime1-startTime1));
    }


    public static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
