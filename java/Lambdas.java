
/*
   Functional Interface: An interface with just one abstract method. And it can have one or more default or static methods in it.
   ** Lambdas can only be used in the context of a Functional Interface.

 * Lambda Expression : A lambda expression is an anonymous function (a function without a name) that can be used to implement a functional interface (an interface with only one abstract method). It allows writing inline implementations without creating a separate class. 
 * 
 * Syntax: 
 * (parameters) -> { expression/body }

 * Functional Interface (Prerequisite for Lambdas): 
    A functional interface is an interface with only one abstract method. Java provides built-in functional interfaces in java.util.function, such as Consumer<T>, Supplier<T>, Predicate<T>, and Function<T, R>, BiConsumer<T, K>, BiPredicate<T, B>, BiFunction<T, R, S>.

    There are a lot of functional interfaces in the java.util.function package. The more common ones include, but are not limited to:

    Function – it takes one argument and returns a result
    Consumer – it takes one argument and returns no result (represents a side effect)
    Supplier – it takes no arguments and returns a result
    Predicate – it takes one argument and returns a boolean
    BiFunction – it takes two arguments and returns a result
    BinaryOperator – it is similar to a BiFunction, taking two arguments and returning a result. The two arguments and the result are all of the same types.
    UnaryOperator – it is similar to a Function, taking a single argument and returning a result of the same type
 * 
 * 
 * Why Use Lambda Expressions?
✅ Reduces boilerplate code
✅ Makes code more concise and readable
✅ Enhances functional programming in Java
✅ Works seamlessly with Streams and Collections
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

class Employee {

    int salary;
    String name;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " $ " + salary;
    }
}

public class Lambdas {

    int x = 0;

    class FirstLevel {

        int x = 1;

        public void methodInFirstLevel(int x) {

            Consumer<Integer> myConsumer = (y) -> {
                int z = 10;

                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                        Lambdas.this.x);
            };

            myConsumer.accept(x);
        }
    }

    public static void main(String[] args) {
        // Lambdas lmd = new Lambdas();
        // Lambdas.FirstLevel fLevel = lmd.new FirstLevel();
        // fLevel.methodInFirstLevel(23);

        MathOperation addition = (a, b) -> a + b;
        System.out.println(addition.operate(1, 2));

        // List.of() returns an immutable collection i.e cannot modify it.
        var employees = new ArrayList<>(List.of(new Employee("Naveen", 20000), new Employee("Gouda", 100000),
                new Employee("Guru", 30000)));

        employees.sort((e1, e2) -> Integer.compare(e2.salary, e1.salary));
        employees.forEach(System.out::println);
    }
}

/*
 * 
 * 
 * 
 * 📌 Differences Between Streams and Collections in Java
 * Both Streams and Collections are used for working with groups of objects, but
 * they serve different purposes and have key differences in their behavior.
 * 
 * 1️⃣ Definition & Purpose
 * Feature Collections Streams
 * Definition:
 * A data structure that stores elements in memory.
 * A sequence of elements processed functionally.
 * Purpose :
 * Designed for storing, modifying, and accessing data.
 * Designed for data processing and transformations.
 * Mutability:
 * Allows modification (add, remove, update).
 * Immutable (does not modify source data).
 * 
 * 2️⃣ Storage vs Computation
 * Storage:
 * Stores elements in memory.
 * Does not store elements (operates on demand).
 * Access:
 * Elements can be accessed randomly via index (like list.get(0)).
 * Elements are accessed sequentially in the pipeline.
 * 
 * 3️⃣ Eager vs Lazy Evaluation
 * Processing:
 * Processes elements immediately (eager evaluation).
 * Processes elements lazily (operations execute only when a terminal operation
 * is invoked).
 * 
 * 4️⃣ Modification and Mutability
 * Modifiable:
 * Supports add(), remove(), set(), etc.
 * Immutable, cannot modify the source.
 * Reusability Can be iterated multiple times. Can be used only once.
 * 
 * 5️⃣ Parallel Processing
 * Parallel Execution:
 * Not built-in (requires explicit threading).
 * Supports parallelStream() for parallel execution.
 * 
 * 6️⃣ Traversal Mechanism
 * Iteration:
 * Uses forEach, iterators, or loops.
 * Uses functional programming operations (map(), filter(), etc.).
 * Direction:
 * Supports bidirectional traversal (ListIterator).
 * Supports only one pass through the data.
 * 
 * 7️⃣ Performance Considerations
 * 
 * Memory Efficiency:
 * Stores all elements in memory.
 * Uses on-demand processing (saves memory).
 * Performance:
 * Can be efficient for small data.
 * Optimized for large data processing (can be parallelized).
 */