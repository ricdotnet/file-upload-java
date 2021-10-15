package FileUpload;

import javax.swing.*;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonActions implements ActionListener {

  Button button = new Button();

  JComponent component;
  Modal modal = new Modal();

  private static HashMap<String, Object> components = new HashMap<>();

  /**
   * This constructor will be called when an action needs to be added relative to
   * a component....
   * 
   * @param component
   */
  public ButtonActions(JComponent component) {
    this.component = component;
    components.put(component.getName(), component);
  }

  /**
   * This constructor will be called when an action need to be added relative to a
   * Modal component...
   * 
   * @param component
   */
  public ButtonActions(Modal modal) {
    this.modal = modal;
    components.put(modal.getName(), modal);
  }

  public ButtonActions() {
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource().getClass().getName().equals("FileUpload.FileChooser")) {
      Object c = components.get("FILE_CHOOSER");
      modal = (Modal) c;

      if(e.getActionCommand().equals("CancelSelection")) {
        modal.setVisible(false);
      }

      if(e.getActionCommand().equals("ApproveSelection")) {
        modal.runMethod("FILE_CHOOSER", "setThisSelectedFiles");
        modal.setModalVisibility(false);
      }
    }

    if (e.getSource().getClass().getName().equals("FileUpload.Button")) {
      String id = button.getButtonId((JButton) e.getSource());

      if (id.equals("UPLOAD_BUTTON")) {
        modal.setModalVisibility(true);
      }
    }
  }

}
