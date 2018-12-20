import javax.swing.*;
import java.awt.*;

public class LabelledSpinner extends JPanel{
    private final JLabel label;
    private final JSpinner spinner;

    // TODO: Constructor should specify content of spinner (for non integers)
    public LabelledSpinner(String label){
        this.label = new JLabel(label);
        spinner = new JSpinner();

        setLayout(new BorderLayout());

        add(this.label,BorderLayout.PAGE_START);
        add(spinner,BorderLayout.CENTER);
    }
}