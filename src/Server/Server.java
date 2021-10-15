package Server;

import java.io.*;
import java.net.*;

public class Server {

  private ServerSocket serverSocket;

  private void init() {
    try {
      serverSocket = new ServerSocket(9090);
      System.out.println("Server on and accepting connections on port: 9090");

      while(true) {
        new ConnectionHandler(serverSocket.accept());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main (String[] args) {
    Server main = new Server();
    main.init();
  }
  
}
