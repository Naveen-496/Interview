import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionChaining {
    public static void main(String[] args) {
        Function<Integer, Integer> add = a -> a + 2;
        Function<Integer, Integer> multiplyTwo = a -> a * 2;
        Function<Integer, Integer> addAndMultiplyTwo = add.andThen(multiplyTwo).andThen(add);

        System.out.println(addAndMultiplyTwo.apply(2));

        Predicate<Integer> isEven = a -> a % 2 == 0;
        Predicate<Integer> isGreaterThan10 = a -> a > 10;
        Predicate<Integer> isEvenAndIsGreaterThan10 = isEven.and(isGreaterThan10);
        Predicate<Integer> isEvenOrIsGreaterThan10 = isEven.or(isEvenAndIsGreaterThan10);
        System.out.println(isEvenAndIsGreaterThan10.test(12));
        System.out.println(isEvenAndIsGreaterThan10.test(5));
        System.out.println(isEvenOrIsGreaterThan10.test(6));
    }
}
