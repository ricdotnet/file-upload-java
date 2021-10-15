package FileUpload;

import java.io.*;
import javax.swing.*;

import java.nio.file.*;
import java.util.Random;

public class FileChooser extends JFileChooser {

  // private File[] selectedFiles = null;
  private static File selectedFile = null;
  UploadFile uploadFile = new UploadFile();

  public FileChooser setFileChooserSize(int width, int height) {
    setSize(width, height);

    return this;
  }

  public FileChooser setFileChooserVisibility(boolean vis) {
    setVisible(vis);

    return this;
  }

  public FileChooser setButtonActions() {
    addActionListener(new ButtonActions());

    return this;
  }

  public FileChooser setFileChooserId(String id) {
    setName(id);

    return this;
  }

  public FileChooser setThisSelectedFiles() {
    selectedFile = getSelectedFile();
//    saveFile(selectedFile);
    uploadFile.connectSocket();
    uploadFile.uploadFile(selectedFile);
    selectedFile = null;

    setSelectedFile(new File("")); // reset the file of the modal...

    return this;
  }

  public File getFile() {
    return selectedFile;
  }

  private void saveFile(File file) {
    String path = "/Users/ricardorocha/Desktop";
    try {
      int num = new Random().nextInt(1000);
      Files.write(Paths.get(path, String.valueOf(num)), Files.readAllBytes(Paths.get(file.getAbsolutePath())));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}