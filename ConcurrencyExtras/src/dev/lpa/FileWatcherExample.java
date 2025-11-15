package dev.lpa;

import java.nio.file.FileSystems;
import java.nio.file.WatchService;

public class FileWatcherExample {

    public static void main(String[] args) {
        
        WatchService watchService = FileSystems.getDefault().newWatchService();
    }
}
