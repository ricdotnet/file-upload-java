package FileUpload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.*;
import java.util.*;

public class Modal extends JDialog {

  private static HashMap<String, JComponent> modals = new HashMap<>();

  public Modal setModalSize(int width, int height) {
    setSize(width, height);

    return this;
  }

  public Modal setModalVisibility(boolean vis) {
    setVisible(vis);

    return this;
  }

  public Modal setModalCenter() {
    setLocationRelativeTo(null);

    return this;
  }

  public Modal setModalId(String id) {
    setName(id);

    return this;
  }

  public Modal addComponent(JComponent component) {
    add(component);
    modals.put(component.getName(), component);

    return this;
  }

  public Modal runMethod(String component, String method) {
    JComponent c = modals.get(component);
    
    if(c.isValid()) {
      for (Method m : c.getClass().getMethods()) {
        if(m.getName().equals(method)) {
          try {
            m.invoke(c, new Object[0]);
          } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    }

    return this;
  }
}
