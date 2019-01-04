import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class TransitionPanel extends JPanel {
    private JLabel onLabel;
    private JLabel toLabel;
    private JSpinner onSpinner;
    private JSpinner toSpinner;

    public TransitionPanel () {
        onLabel = new JLabel("On");
        toLabel = new JLabel("to");

        // TODO: Specify valid values of these spinners
        SpinnerListModel onModel = new SpinnerListModel(new ArrayList<Character>(
                ((MainFrame)SwingUtilities.windowForComponent(onSpinner)).getInputAlphabet()));
        onSpinner = new JSpinner(onModel);
        toSpinner = new JSpinner();

        add(onLabel);
        add(onSpinner);
        add(toLabel);
        add(toSpinner);
    }

    @Override
    public void dfaUpdated() {

    }
}
