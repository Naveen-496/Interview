import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class CustomCollector {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(1, 10).boxed().toList();
        Collector<Integer, int[], Integer> sumCollector = Collector.of(
                () -> new int[1],
                (arr, num) -> arr[0] += num,
                (left, right) -> {
                    left[0] += right[0];
                    return left;
                },
                arr -> arr[0]);

        Collector<Integer, int[], Integer> maxCollector = Collector.of(
                () -> new int[1],
                (arr, num) -> arr[0] = Math.max(arr[0], num),
                (left, right) -> {
                    left[0] = Math.max(left[0], right[0]);
                    return left;
                },
                arr -> arr[0]);
        Collector<Integer, int[], String> evenOddCollector = Collector.of(
                () -> new int[2],
                (arr, num) -> arr[num % 2]++,
                (left, right) -> {
                    left[0] += right[0];
                    left[1] += right[1];
                    return left;
                },
                arr -> "Even: " + arr[0] + "\nOdd: " + arr[1]);
        System.out.println("Sum: " + numbers.stream().collect(sumCollector));
        System.out.println("Max: " + numbers.stream().collect(maxCollector));
        System.out.println(numbers.stream().collect(evenOddCollector));
    }
}
