/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony2;

/**
 *
 * @author visio
 */
import java.io.*;
import java.net.*;

public class SocketServer {

    /**
     * @param args the command line arguments
     */
    private ServerSocket serve;
    private Socket clientSocket;
    private BufferedReader inp;
    private PrintStream outp;
    private InputStreamReader reader;

    public SocketServer(int port) throws IOException {
        serve = new ServerSocket(port);
        System.out.println(serve.getInetAddress().getHostAddress());
        clientSocket = serve.accept();
        System.out.println(serve.getInetAddress().getHostAddress());
        reader = new InputStreamReader(clientSocket.getInputStream());
        inp = new BufferedReader(reader);
        outp = new PrintStream(clientSocket.getOutputStream());
    }

    public void read_text() throws IOException {
        String text = inp.readLine();
        System.out.println(text);
    }

    public void write_text(String text) {
        outp.print(text);
        outp.flush();
    }

    public void close() throws IOException {
        inp.close();
        reader.close();
        clientSocket.close();
        serve.close();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(9999);
        server.read_text();
        //server.write_text("Back");
        server.close();
    }
}
