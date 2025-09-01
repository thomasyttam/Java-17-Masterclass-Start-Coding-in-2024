package dev.lpa;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Challenge {

    public static void main(String[] args) {

        Path startingPath = Path.of("..");
//        FileVisitor<Path> statsVisitor = new StatsVisitor(1);
        FileVisitor<Path> statsVisitor = new StatsVisitor(Integer.MAX_VALUE); // include all directories

        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatsVisitor implements FileVisitor <Path> {

//        private int level; // level implicitly initialized to zero as it is a class field
        private Path initialPath = null;
        private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();
        private int initialCount;

        private int printLevel;

        private static final String DIR_CNT = "DirCount";
        private static final String FILE_SIZE = "fileSize";
        private static final String FILE_CNT = "fileCount";

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
//            return super.visitFile(file, attrs);
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
//            System.out.println(file.getFileName());
//            System.out.println("\t".repeat(level + 1) + file.getFileName());
//            folderSizes.merge(file.getParent(), 0L, (o, n) -> o += attrs.size());
            var parentMap = folderSizes.get(file.getParent());
            if (parentMap != null) {
                long fileSize = attrs.size();
                parentMap.merge(FILE_SIZE, fileSize, (o, n) -> o += n);
                parentMap.merge(FILE_CNT, 1L, Math::addExact);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc)
                throws IOException {
//            return super.visitFileFailed(file, exc);
            Objects.requireNonNull(file);
            if (exc != null) {
                System.out.println(exc.getClass().getSimpleName() + " " + file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
//            return super.preVisitDirectory(dir, attrs);
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

//            level++;
////            System.out.println(dir.getFileName());
//            System.out.println("\t".repeat(level) + dir.getFileName());
            if (initialPath == null) {
                initialPath = dir;
                initialCount = dir.getNameCount();
            } else {
                int relativeLevel = dir.getNameCount() - initialCount;
                if (relativeLevel == 1) {
                    folderSizes.clear();
                }
                folderSizes.put(dir, new HashMap<>());
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                throws IOException {
//            return super.postVisitDirectory(dir, exc);
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;
//            level--;

            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }

            int relativeLevel = dir.getNameCount() - initialCount;
            if (relativeLevel == 1) {
                folderSizes.forEach((key, value) -> {

                    int level = key.getNameCount() - initialCount - 1;
                    if (level < printLevel) {

//                        System.out.printf("%s[%s] - %,d bytes %n",
//                                "\t".repeat(level), key.getFileName(), value);
                        long size = value.getOrDefault(FILE_SIZE, 0L);
                        System.out.printf("%s[%s] - %,d bytes, %d files, %d folders %n",
                                "\t".repeat(level), key.getFileName(), size,
                                value.getOrDefault(FILE_CNT, 0L),
                                value.getOrDefault(DIR_CNT, 0L));

                    }
                });

            } else {
//                long folderSize = folderSizes.get(dir);
//                folderSizes.merge(dir.getParent(), 0L, (o, n) -> o += folderSize);
                var parentMap = folderSizes.get(dir.getParent());
                var childMap = folderSizes.get(dir);
                long folderCount = childMap.getOrDefault(DIR_CNT, 0L);
                long fileSize = childMap.getOrDefault(FILE_SIZE, 0L);
                long fileCount = childMap.getOrDefault(FILE_CNT, 0L);

                parentMap.merge(DIR_CNT, folderCount + 1, (o, n) -> o += n);
                parentMap.merge(FILE_SIZE, fileSize, Math::addExact);
                parentMap.merge(FILE_CNT, fileCount, Math::addExact);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
