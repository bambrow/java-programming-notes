package java8.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemo2 {
    public static void main(String[] args) throws IOException {

        // prints all files under src/main/java
        String projectDir = new File(".").getCanonicalPath();
        String showPath = projectDir + "/src/main/java";
        try (Stream<Path> stream = Files.list(Paths.get(showPath))) {
            String listFiles = stream.map(String::valueOf)
                    .map(File::new)
                    .map(File::getName)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("\n"));
            System.out.println(listFiles);
        }

        System.out.println("--------------------");

        // prints all .txt files under . (max depth 3)
        int maxDepth = 3;
        try (Stream<Path> stream =
                     Files.find(
                             Paths.get(projectDir),
                             maxDepth,
                             (path, attr) -> String.valueOf(path).endsWith(".txt"))
        ) {
            String listFiles = stream.map(String::valueOf)
                    .map(File::new)
                    .map(File::getName)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("\n"));
            System.out.println(listFiles);
        }

        System.out.println("--------------------");

        // prints all .txt files under . (max depth 3)
        try (Stream<Path> stream = Files.walk(Paths.get(projectDir), maxDepth)) {
            String listFiles = stream.map(String::valueOf)
                    .map(File::new)
                    .map(File::getName)
                    .filter(path -> !path.startsWith(".") && path.endsWith(".txt"))
                    .sorted()
                    .collect(Collectors.joining("\n"));
            System.out.println(listFiles);
        }

        System.out.println("--------------------");

        // read file using Files.lines
        String readFilePath = projectDir + "/src/main/resources/read_test.txt";
        try (Stream<String> stream = Files.lines(Paths.get(readFilePath))) {
            stream.filter(line -> line.contains("soul"))
                    .map(String::trim)
                    .forEach(System.out::println);
        }

        System.out.println("--------------------");

        // read file using Files.newBufferedReader
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(readFilePath))) {
            reader.lines()
                    .filter(line -> line.contains("soul"))
                    .map(String::trim)
                    .forEach(System.out::println);
        }

    }
}
