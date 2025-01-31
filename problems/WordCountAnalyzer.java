package problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordCountAnalyzer {

    private final ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void processFilesParallel(String folderPath) throws IOException, InterruptedException, Exception {
        List<Path> files = Files.walk(Paths.get(folderPath))
                .filter(Files::isRegularFile)
                .toList();

        List<Future<Void>> tasks = new ArrayList<>();
        for (Path file : files) {
            tasks.add(executor.submit(() -> {
                processFile(file);
                return null;
            }));
        }

        for (Future<Void> task : tasks) {
            task.get();
        }
        executor.shutdown();
    }

    public String processFiles(String folder, int n) throws Exception {
        Map<String, Integer> wordCountMap = new HashMap<>();

        List<Path> files = Files.walk(Paths.get(folder)).filter(Files::isRegularFile).toList();
        long startTime = System.currentTimeMillis();
        files.forEach(file -> {
            try {
                Files.lines(file).flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                        .filter(word -> !word.isEmpty())
                        .forEach(word -> wordCountMap.merge(word, 1, Integer::sum));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Blocking Execution Took: " + (System.currentTimeMillis() - startTime));
        return wordCountMap.entrySet().stream().sorted((w1, w2) -> Integer.compare(w2.getValue(), w1.getValue()))
                .skip(n - 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    private void processFile(Path file) {
        try {

            Files
                    .lines(file)
                    .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                    .filter(word -> !word.isEmpty())
                    .forEach(word -> {
                        wordCountMap.merge(word, 1, Integer::sum);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNthMostFrequentString(int n) {
        System.out.println(wordCountMap);
        return wordCountMap.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .skip(n - 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String getNthLeastFrequencyWord(int n) {
        System.out.println(wordCountMap);
        return wordCountMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .skip(n - 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) throws Exception {
        var analyzer = new WordCountAnalyzer();
        // analyzer.processFilesParallel("files");
        // int nth = 1;
        System.out.println(1 + " most frequecy word: " + analyzer.processFiles("files", 1));
        // System.out.println(nth + " least frequecy word: " +
        // analyzer.getNthLeastFrequencyWord(nth));
    }
}
