package Server;

import java.io.*;
import java.net.*;

/**
 * This class must be ran from the command line.
 * Compile and run.
 * When running set the destination folder as an argument.
 */
public class Server {

  private ServerSocket serverSocket;

  private void init(String destination) {
    try {
      serverSocket = new ServerSocket(9090);
      System.out.println("Server on and accepting connections on port: 9090");

      while(true) {
        new ConnectionHandler(serverSocket.accept(), destination);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main (String[] args) {
    Server main = new Server();
    main.init(args[0]);
  }
  
}
