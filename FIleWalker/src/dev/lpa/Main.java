package dev.lpa;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor();

        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatsVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
//            return super.visitFile(file, attrs);
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//            return super.preVisitDirectory(dir, attrs);
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);
            System.out.println(dir.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
}
