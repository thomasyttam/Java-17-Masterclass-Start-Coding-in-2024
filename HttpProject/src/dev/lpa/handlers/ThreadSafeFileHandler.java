package dev.lpa.handlers;

import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeFileHandler implements HttpResponse.BodyHandler<Path> {

    private final Path path;
    private static final Lock lock = new ReentrantLock();

    public ThreadSafeFileHandler(Path path) {
        this.path = path;
    }

    @Override
    public HttpResponse.BodySubscriber<Path> apply(HttpResponse.ResponseInfo responseInfo) {
        return null;
    }
}
