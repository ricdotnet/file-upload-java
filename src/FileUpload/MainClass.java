package FileUpload;

import javax.swing.*;

public class MainClass extends JFrame {

  Button upload = new Button();
  FileChooser fileChooser = new FileChooser();
  Modal fileModal = new Modal();

  private void init() {
    setLayout(null);
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    add(addUploadButton());

    setVisible(true);
  }

  private Button addUploadButton() {
    createFileModal();

    upload.setButtonSize(200, 30)
      .setButtonLocation(10, 10)
      .setButtonLabel("Upload")
      .setButtonId("UPLOAD_BUTTON")
      .setButtonAction(fileModal);

    return upload;
  }

  private FileChooser addFileChooser() {
    fileChooser.setFileChooserSize(200, 200)
      .setFileChooserId("FILE_CHOOSER")
      .setButtonActions();

    return fileChooser;
  }

  private Modal createFileModal() {
    fileModal.setModalSize(400, 200)
      .setModalCenter()
      .setModalId("FILE_CHOOSER")
      .addComponent(addFileChooser());

    return fileModal;
  }

  public static void main(String[] args) {
    MainClass main = new MainClass();

    main.init();
  }
  
}
