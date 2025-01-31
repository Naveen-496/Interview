
/*
 
 What is a Stream?
A Stream is a sequence of elements from a source (Collection, array, I/O, etc.) that supports functional-style operations.

💡 Key Points:
✔️ Does not store elements (it processes them on demand).
✔️ Lazily evaluated (operations run only when a terminal operation is invoked).
✔️ Supports parallel execution (with .parallelStream()).
✔️ Immutable (original data source remains unchanged).


Stream:

Definition: An interface representing a sequence of elements supporting sequential/parallel aggregate operations without mutating the original data source.


Stream Creation Methods


Stream.empty(): Creates an empty Stream with no elements
collection.stream(): Creates Stream from any Collection
Arrays.stream(): Creates Stream from an array
Stream.of(): Creates Stream from provided values
Stream.iterate(): Creates infinite sequential Stream by iteratively applying function
Stream.generate(): Creates infinite Stream from Supplier function


Intermediate Operations


filter(): Selects elements matching given predicate
map(): Transforms each element using provided function
flatMap(): Transforms each element into stream of elements and flattens results
sorted(): Sorts elements based on natural order or custom comparator
distinct(): Eliminates duplicate elements based on equals()
peek(): Performs action on elements without modifying stream


Terminal Operations


collect(): Accumulates elements into collection/container
reduce(): Reduces stream elements into single value using associative operation
forEach(): Performs action on each element
count(): Returns number of elements in stream
min()/max(): Returns smallest/largest element based on comparator
anyMatch(): Checks if any element matches predicate
allMatch(): Checks if all elements match predicate
noneMatch(): Checks if no elements match predicate


Short-circuiting Operations


findFirst(): Returns first element of stream
findAny(): Returns any element of stream (useful in parallel streams)
limit(): Truncates stream to specified size
skip(): Discards specified number of elements


Important Stream Characteristics


Laziness: Operations only execute when terminal operation called
Non-reusability: Stream can't be reused after terminal operation
Interior mutability: Stream operations don't modify source data
Order: Operations sequence affects performance
Parallelism: Can process elements in parallel using parallel()


Stream Pipeline Components


Source: Data source (collection, array, generator function)
Intermediate operations: Transform stream, return new stream
Terminal operation: Produces result or side-effect, ends stream


Stream Specializations


IntStream: Stream of primitive int values
LongStream: Stream of primitive long values
DoubleStream: Stream of primitive double values



🚀 Interview Questions
✔️ What is the difference between map() and flatMap()?
✔️ How does reduce() work, and when would you use it?
✔️ When should you use parallelStream()?
✔️ What are the differences between findFirst() and findAny()?
✔️ What is the difference between filter() and distinct()?

  What Is Stream Pipelining in Java 8?
    Stream pipelining is the concept of chaining operations together. We do this by splitting the operations that can happen on a stream into two categories: intermediate operations and terminal operations.

    Each intermediate operation returns an instance of Stream itself when it runs. Therefore, we can set up an arbitrary number of intermediate operations to process data, forming a processing pipeline.

    There must then be a terminal operation which returns a final value and terminates the pipeline.


 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data.txt"));
        lines.forEach(System.out::println);
    }
}
