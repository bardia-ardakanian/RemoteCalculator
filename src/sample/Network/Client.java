package sample;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

    String address;
    int port;

    private Socket socket            = null;
    private InputStream in      = null;
    private OutputStream out     = null;


    public Client(String address, int port)
    {
        this.port = port;
        this.address = address;
    }

    @Override
    public void run() {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            in  = socket.getInputStream();

            // sends output to the socket
            out = socket.getOutputStream();
        }
        catch(UnknownHostException u)
        {
            System.err.println(u.toString());
        }
        catch(IOException i)
        {
            System.err.println(i.toString());
        }
    }

    public void flushOut() throws IOException {
        out.flush();
    }

    public void write(String data) throws IOException {
        out.write(data.getBytes());
    }

    public String read() throws IOException {
        byte[] buffer = new byte[2048];
        int read = in.read(buffer);
        return new String(buffer, 0, read);
    }
}
