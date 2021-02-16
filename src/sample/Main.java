package sample;

import javafx.application.Application;

public class Main {
<<<<<<< HEAD
=======
    private static int port = 5000;
    protected static Server server = new Server(port);
    protected static Client client = new Client("127.0.0.1", port);

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();
>>>>>>> network

    public static void main(String[] args) {
        Application.launch(Calculator.class, args);
    }
}
