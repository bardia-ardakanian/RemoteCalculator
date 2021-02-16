package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server implements Runnable {

    int port;

    private Socket socket             = null;
    private ServerSocket server       = null;
    private InputStream  in           = null;
    private OutputStream out      = null;

    public Server(int port)
    {
        this.port = port;
    }

    @Override
    public void run() {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = socket.getInputStream();
            out = socket.getOutputStream();
        }
        catch(IOException i)
        {
            System.err.println(i);
        }
    }

    public void write() throws IOException {
        //flush previous calculations
        out.flush();

        double num1=0, num2=0;
        String op;
        byte[] buffer = new byte[2048];

        int read = in.read(buffer);
        String data = new String(buffer, 0, read);
        //get numbers
        Scanner sc = new Scanner(data);
        num1 = sc.nextDouble();
        op = sc.next();
        num2 = sc.nextDouble();
        //write result
        String result = String.valueOf(compute(num1, num2, op));
        out.write(result.getBytes());
    }

    private double compute(double num1, double num2, String op){
        switch (op){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                try{
                    return num1 / num2;
                } catch (ArithmeticException  e){
                    System.out.println(e.toString());
                }
            case "%":
                try{
                    return num1 % num2;
                } catch (ArithmeticException  e){
                    System.out.println(e.toString());
                }
            default:
                return 0;
        }
    }
}
