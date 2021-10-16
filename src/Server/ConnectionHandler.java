package Server;

import java.net.*;
import java.io.*;
import java.nio.file.*;

public class ConnectionHandler extends Thread {

  Socket connectionSocket = null;
  private BufferedInputStream fileIn = null;
  private BufferedReader dataIn = null;
  private DataOutputStream dataOut = null;

  private String destination;
  public ConnectionHandler(Socket socket, String destination) {
    connectionSocket = socket;
    this.destination = destination;
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
        String fileName = String.valueOf(dataIn.readLine());
        StringBuilder path = new StringBuilder();
        path.append(destination).append(fileName);
        // dataIn.close();

        byte[] fileBytes = fileIn.readAllBytes();
        Files.write(Path.of(String.valueOf(path).replace("\0", "")), fileBytes);
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
