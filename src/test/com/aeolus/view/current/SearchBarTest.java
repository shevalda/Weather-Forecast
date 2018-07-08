package test.com.aeolus.view.current; 

import com.aeolus.view.current.SearchBar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

/** 
* SearchBar Tester. 
* 
* @author Shevalda Gracielira
* @since <pre>Jul 8, 2018</pre> 
* @version 1.0 
*/ 
public class SearchBarTest { 

  @Test
  public void overallTest() {
    JTextField textField = new JTextField();
    JButton button = new JButton();
    SearchBar sb = new SearchBar(textField, button);
    int labelCount = 0;
    int textFieldCount = 0;
    int buttonCount = 0;
    for (Component c : sb.getPanel().getComponents()) {
      if (c instanceof JLabel) {
        labelCount++;
      } else if (c instanceof JTextField) {
        textFieldCount++;
      } else if (c instanceof JButton) {
        buttonCount++;
      }
    }
    assertEquals(1, labelCount);
    assertEquals(1, textFieldCount);
    assertEquals(1, buttonCount);
  }


} 
