import java.io.IOException;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;

public class StreamsTutorial {
    public static void main(String[] args) throws IOException {
        //Tutorial from: https://www.youtube.com/watch?v=t1-YZ6bF-g0
        
        //Source -> Filter -> Sort -> Map -> Collect
        
        //Intermediate operations such as filter, map, or sort return a stream
            //examples are anyMatch(), distinct(), filter(), findFirst(), flatMap(), map(), skip(), sorted()
        //Terminal operations such as forEach, collect, or reduce return a void or non-stream
            //examples are count(), max(), min(), reduce(), summaryStatistics()
        
        System.out.println("----------------------------------------------------------------------------");
        // -------------------------------------------------------------------------------------------------
        System.out.println("Print 1 - 9: ");
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        // -------------------------------------------------------------------------------------------------
        System.out.println("\n\nPrint 1 - 9 (Skip until 5): ");
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::print);// uses method reference
        // -------------------------------------------------------------------------------------------------
        System.out.println("\n\nPrint sum of 1 - 4: ");
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        // -------------------------------------------------------------------------------------------------
        System.out.println("\nPrint 1st vakue after sorting: ");
        Stream.of("A", "B", "C", "1", "2")
                .sorted()
                .findFirst()
                .ifPresent(x -> System.out.println(x));// uses lambda
        // -------------------------------------------------------------------------------------------------
        System.out.println("\nStream from an array, sort, filter, and print: ");
        String[] name = { "Al", "Ann", "Brent", "Amanda", "Hans", "Ash", "Ryan", "John" };
        Arrays.stream(name)
                .filter(x -> x.startsWith("A"))
                .sorted()
                .forEach(System.out::println);
        // -------------------------------------------------------------------------------------------------
        System.out.println("\nAverage of squares of an int array: ");
        Arrays.stream(new int[] { 1, 2, 3, 6, 53, 23, 5, 6, 21 })
                .map(x -> x + x)
                .average()
                .ifPresent(x -> System.out.printf("%.2f", x));
        // -------------------------------------------------------------------------------------------------
        System.out.println("\n\nStream from list, filter, and print: ");
        List<String> people = Arrays.asList("Al", "Brent", "Ash", "Amanda", "Hans", "John", "James");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        // -------------------------------------------------------------------------------------------------
        /*
         * System.out.
         * println("\n\nStream rows from text file, sort, filter, and print: ");
         * Stream<String> bands = Files.lines(Paths.get("bands.txt"));
         * bands
         * .sorted()
         * .filter(x -> x.length() > 13)
         * .forEach(System.out::println);
         * bands.close();
         */
        // -------------------------------------------------------------------------------------------------
        /*
         * System.out.println("\nFilter lines with jit and display: ");
         * List<String> bands2 = Files.lines(Paths.get("bands.txt"))
         * .filter(x -> x.contains("jit"))
         * .collect(Collectors.toList());
         * bands2.forEach(x -> System.out.println(x));
         */
        // -------------------------------------------------------------------------------------------------
        /*
         * System.out.println("\nStream from CSV file and count: ");
         * Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
         * int rowCount = (int) rows1
         * .map(x -> x.split(","))
         * .filter(x -> x.length == 3)
         * .count();
         * System.out.println(rowCount + "rows. ");
         * rows1.close();
         */
        // -------------------------------------------------------------------------------------------------
        // }
        System.out.println("\nReduction - sum: ");
        double total = Stream.of(7.3, 1.5, 4.8)// can also use DoubleStream.of()...
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.printf("Total = %.2f", total);
        // -------------------------------------------------------------------------------------------------
        System.out.println("\n\nReduction - summary statistics: ");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
    }
}
