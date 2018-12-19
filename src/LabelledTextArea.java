import javax.swing.*;
import java.awt.*;

public class LabelledTextArea extends JPanel{
    private final JLabel label;
    private final JTextArea area;

    public LabelledTextArea(String label){
        this.label = new JLabel(label);
        this.area = new JTextArea();

        setLayout(new BorderLayout());

        add(this.label,BorderLayout.PAGE_START);
        add(area,BorderLayout.CENTER);
    }
}
