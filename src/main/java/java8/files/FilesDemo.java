package java8.files;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesDemo {
    @SneakyThrows
    public static void main(String[] args) {
        String projectDir = new File(".").getCanonicalPath();
        String readPath = projectDir + "/src/main/resources/read_test.txt";
        List<String> fileLines = Files.readAllLines(Paths.get(readPath));
        System.out.println(fileLines.get(0));
        // I like for you to be still

        byte[] fileData = Files.readAllBytes(Paths.get(readPath));
        String fileContent = new String(fileData, StandardCharsets.UTF_8);
        System.out.println(fileContent.split("\n")[0]);
        // I like for you to be still

        String writePath = projectDir + "/src/main/resources/write_test.txt";
        Files.deleteIfExists(Paths.get(writePath));
        if (!Files.exists(Paths.get(writePath))) {
            Files.createFile(Paths.get(writePath));
            // to create directory:
            // Files.createDirectory(Paths.get(writePath));
        }
        Files.write(Paths.get(writePath), fileContent.getBytes());

        /*
        InputStream ins = Files.newInputStream(Paths.get(readPath));
        OutputStream ops = Files.newOutputStream(Paths.get(writePath));
        Reader reader = Files.newBufferedReader(Paths.get(readPath));
        Writer writer = Files.newBufferedWriter(Paths.get(writePath));

        Files.createTempFile("tmp", "tmp");
        Files.createTempDirectory("tmp");

        Files.copy(Paths.get(readPath), ops);
        Files.copy(Paths.get(readPath), Paths.get(writePath));
        Files.copy(ins, Paths.get(writePath));
        Files.move(Paths.get(readPath), Paths.get(writePath));
         */
    }
}
