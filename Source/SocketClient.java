/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony2;

import java.io.*;
import java.net.*;

/**
 *
 * @author visio
 */
public class SocketClient {

    /**
     * @param args the command line arguments
     */
    private Socket clientSocket;
    private BufferedReader inp;
    private InputStreamReader reader;
    private PrintStream outp;

    
    public SocketClient(String host,int port) throws IOException {
        clientSocket = new Socket(host, port);
        reader = new InputStreamReader(clientSocket.getInputStream());
        inp = new BufferedReader(reader);
        outp = new PrintStream(clientSocket.getOutputStream());
    }
    public void read_text() throws IOException{
        String text = inp.readLine();
        System.out.println(text);
    }
    public void write_text(String text) throws IOException{
        outp.print(text);
    }
    
    public void close() throws IOException{
        inp.close();
        reader.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        SocketClient client  = new SocketClient("161.246.94.231",9999);
        client.write_text("Helo");
        client.read_text();
        client.close();
    }
}


