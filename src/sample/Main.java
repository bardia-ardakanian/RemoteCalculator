package sample;

import javafx.application.Application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int port = 7660;
    protected static Server server = new Server(port);
    protected static Client client = new Client("127.0.0.1", port);

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(server);
        pool.execute(client);
        pool.shutdown();

        Application.launch(Calculator.class, args);
    }
}
