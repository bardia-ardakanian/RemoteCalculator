package sample;

import javafx.application.Application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int port = 7660;
    protected static sample.Server server = new sample.Server(port);
    protected static sample.Client client = new sample.Client("127.0.0.1", port);

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(server);
        pool.execute(client);
        pool.shutdown();

        Application.launch(sample.Calculator.class, args);
    }
}
