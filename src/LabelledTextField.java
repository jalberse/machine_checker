import javax.swing.*;
import java.awt.*;

public class LabelledTextField extends JPanel{
    private final JLabel label;
    private final JTextField field;

    public LabelledTextField(String label){
        this.label = new JLabel(label);
        field = new JTextField();

        setLayout(new BorderLayout());

        add(this.label,BorderLayout.PAGE_START);
        add(field,BorderLayout.CENTER);
    }
}
