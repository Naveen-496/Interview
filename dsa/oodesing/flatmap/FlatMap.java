package flatmap;

import java.util.*;

public class FlatMap {

    static void uniqueChars() {
        List<String> words = List.of("Java", "Python", "Kotlin");
        List<Character> uniquCharacters = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .distinct()
                .toList();
        System.out.println(uniquCharacters);
    }

    public static void main(String[] args) {
        List<List<Integer>> nestedList = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

        List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).toList();

        System.out.println(flattenedList);

        List<String> sentences = List.of("Hello World", "Java Streams", "flatmap is powerful");

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();

        System.out.println(words);

        uniqueChars();

    }

}
