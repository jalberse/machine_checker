import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatePanel extends JPanel {
    private JPanel header;
    private JLabel label;
    private JButton removeTransitionButton;
    private JButton addTransitionButton;
    private ArrayList<TransitionPanel> transitions;

    public StatePanel(int stateID){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JPanel();
        header.setLayout(new GridBagLayout());
        GridBagConstraints hc = new GridBagConstraints();
        label = new JLabel("State " + stateID);
        hc.insets = new Insets(3,3,3,3);
        hc.gridx = 0;
        hc.gridy = 0;
        hc.weighty = .5;
        header.add(label,hc);
        removeTransitionButton = new JButton("-");
        hc.weighty = 0;
        hc.gridx = 1;
        header.add(removeTransitionButton,hc);
        addTransitionButton = new JButton("+");
        hc.gridx = 2;
        header.add(addTransitionButton,hc);

        add(header);
    }

    // TODO: Add/remove transition on button click
}
