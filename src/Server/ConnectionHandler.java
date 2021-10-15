package Server;

import java.net.*;
import java.io.*;
import java.nio.file.*;

public class ConnectionHandler extends Thread {

  Socket connectionSocket = null;
  private BufferedInputStream fileIn = null;
  private BufferedReader dataIn = null;
  private DataOutputStream dataOut = null;

  public ConnectionHandler(Socket socket) {
    connectionSocket = socket;
    try {
      dataIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      fileIn = new BufferedInputStream(connectionSocket.getInputStream());
      dataOut = new DataOutputStream(connectionSocket.getOutputStream());

      start();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    while(true) {
      try {
        // String fileName = dataIn.readLine() + "\n";
        // dataIn.close();

        byte[] fileBytes = fileIn.readAllBytes();
        Files.write(Path.of("/Users/ricardorocha/Documents/" + "some.png"), fileBytes);
        System.out.println("File Saved....");
        fileIn.close();

        break;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Disconnected!!!");
  }

}
