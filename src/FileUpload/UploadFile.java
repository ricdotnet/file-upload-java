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
      connectionSocket = new Socket("admin.rrocha.uk", 9090);
      dataIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      dataOut = new DataOutputStream(connectionSocket.getOutputStream());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void uploadFile(File f) {
    try {
      dataOut.writeUTF(f.getName() + "\n");
      System.out.println(Files.probeContentType(Path.of(f.getAbsolutePath())));

      byte[] fileBytes = Files.readAllBytes(Path.of(f.getAbsolutePath()));
      dataOut.write(fileBytes);
      dataOut.flush();
      dataOut.close();

      System.out.println("uploaded....");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private byte[] fileName(String fileName) {
    return fileName.getBytes(StandardCharsets.UTF_8);
  }
  
}
