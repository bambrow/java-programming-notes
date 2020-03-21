package java8.try_catch;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TryWithResourcesDemo {
    @SneakyThrows
    public static void main(String[] args) {
        String projectDir = new File(".").getCanonicalPath();
        String readPath = projectDir + "/src/main/resources/read_test.txt";
        // try with resources
        try (InputStream is = new FileInputStream(readPath)) {
            char c = (char) is.read();
            System.out.println(c); // I
        }
        // try with multi catch
        try {
            Thread.sleep(100);
            List<String> lines = Files.readAllLines(Paths.get(readPath));
            System.out.println(lines.get(0));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
