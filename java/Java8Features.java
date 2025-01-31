
// Lambda Expressions : 
// Mathod References  : 
// Optional           :
// Functional Interface : 
// Default Methods    :
// Date Api           :
// Streams Api        :

//Method references, introduced in Java 8, are a concise shorthand for referring to methods or constructors.

// Method references are a shorthand for writing lambda expressions when you just need to call a method.

// Cleaner Code: Method references can significantly reduce boilerplate, making your code more concise   and easier to read.
// Increased Productivity: Less code to write means more time for solving real problems. Who doesn't want that?
// Better Expressiveness: They help you express your intent more clearly, especially in functional-style programming.

// Types of Method References
// 1. Reference to a static method
// 2. Reference to an instance method of a particular object
// 3. Reference to an instance method of an arbitrary object of a particular type
// 4. Reference to a constructor

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class Numbers {
    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

    public static List<Integer> findNumbers(List<Integer> nums, BiPredicate<Integer, Integer> p) {
        var result = new ArrayList<Integer>();
        for (Integer i : nums) {
            if (p.test(i, i + 10)) {
                result.add(i);
            }
        }
        return result;
    }
}

public class Java8Features {

    public static void main(String[] args) {
        var nums = List.of(5, 12, 30, 25, 45, 48);
        System.out.println(Numbers.findNumbers(nums, Numbers::isMoreThanFifty));

        MethodReferenceExamples mRFE = new MethodReferenceExamples();
        System.out.println(MethodReferenceExamples.mergeThings("Hello", "World", (a, b) -> a + b));
        System.out
                .println(MethodReferenceExamples.mergeThings("Hola", "Buddy", MethodReferenceExamples::appendStrings));
        System.out.println(MethodReferenceExamples.mergeThings("Hi", "Sam!", mRFE::appendStr2));
    }
}

class MethodReferenceExamples {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> func) {
        return func.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    public String appendStr2(String a, String b) {
        return a + b;
    }

}