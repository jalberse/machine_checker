import javax.swing.*;
import java.util.ArrayList;

public class LabelledChecklist extends JPanel {
    private JLabel label;
    private ArrayList<JCheckBox> items;

    public LabelledChecklist(String label){
        this.label = new JLabel("label");
        items = new ArrayList<>();
    }

    // TODO: add() function. How do we want to handle? Pass a state ID since these must be unique?
}
