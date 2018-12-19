import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    // TODO Just a text area where we print DFA, but implement a real display
    private JTextArea display;

    public DisplayPanel(){
        setLayout(new BorderLayout());
        display = new JTextArea();
        add(display,BorderLayout.CENTER);
    }
}
