package FileUpload;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class UploadFile {

  Socket connectionSocket = null;
  BufferedReader dataIn = null;
  DataOutputStream dataOut = null;

  public UploadFile() {}

  public void connectSocket() {
    try {
      connectionSocket = new Socket("localhost", 9090);
      dataIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      dataOut = new DataOutputStream(connectionSocket.getOutputStream());

//      dataOut.writeUTF("Hello from client!" + "\n");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void uploadFile(File file) {
    try {
//      dataOut.writeUTF(file.getName());
//      dataOut.flush();

      byte[] fileBytes = Files.readAllBytes(Path.of(file.getAbsolutePath()));
      dataOut.write(fileBytes);
      dataOut.flush();

      System.out.println("uploaded....");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private byte[] fileName(String fileName) {
    return fileName.getBytes(StandardCharsets.UTF_8);
  }
  
}
