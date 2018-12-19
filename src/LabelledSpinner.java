import javax.swing.*;
import java.awt.*;

public class LabelledSpinner extends JPanel{
    private final JLabel label;
    private final JSpinner spinner;

    public LabelledSpinner(String label){
        this.label = new JLabel(label);
        spinner = new JSpinner();

        setLayout(new BorderLayout());

        add(this.label,BorderLayout.PAGE_START);
        add(spinner,BorderLayout.CENTER);
    }
}