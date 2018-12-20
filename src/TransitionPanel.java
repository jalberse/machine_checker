import javax.swing.*;

public class TransitionPanel extends JPanel {
    private JLabel onLabel;
    private JLabel toLabel;
    private JSpinner onSpinner;
    private JSpinner toSpinner;

    public TransitionPanel () {
        onLabel = new JLabel("On");
        toLabel = new JLabel("to");

        // TODO: Specify valid values of these spinners
        onSpinner = new JSpinner();
        toSpinner = new JSpinner();
    }
}
