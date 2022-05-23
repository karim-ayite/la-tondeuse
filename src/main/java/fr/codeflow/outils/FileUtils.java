package fr.codeflow.outils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static List<String> readFileLines(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (var lines = Files.lines(path)) {
            return lines.toList();
        }
    }

}
