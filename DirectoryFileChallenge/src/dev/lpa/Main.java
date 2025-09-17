package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path deepestFolders = Path.of("public", "assets", "icons");

        try {
            Files.createDirectories(deepestFolders);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
