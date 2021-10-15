package FileUpload;

import javax.swing.*;

/**
 * Button class implementing JButton.
 * This class will be called whenever I need a button.
 * Its built in such a way to use chaining.
 * This prevents me from using lots of loose function calls when generating a button.
 */
public class Button extends JButton {

  public Button setButtonSize(int width, int height) {
    setSize(width, height);

    return this;
  }

  public Button setButtonLocation(int x, int y) {
    setLocation(x, y);

    return this;
  }

  public Button setButtonLabel(String label) {
    setText(label);

    return this;
  }

  public Button setButtonId(String id) {
    setName(id);

    return this;
  }

  /**
   * Action relative to a JComponent
   * @param component
   * @return
   */
  public Button setButtonAction(JComponent component) {
    addActionListener(new ButtonActions(component));

    return this;
  }

  /**
   * Action relative to a Modal
   * @param component
   * @return
   */
  public Button setButtonAction(Modal component) {
    addActionListener(new ButtonActions(component));
    
    return this;
  }

  public Button setButtonVisibility(boolean vis) {
    setVisible(vis);

    return this;
  }

  public String getButtonId(JButton button) {
    return button.getName();
  }
  
}
