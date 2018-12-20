import javax.swing.*;
import java.util.ArrayList;

public class StateTransitionsPanel extends JPanel {
    private JLabel label;
    private ArrayList<TransitionPanel> transitions;

    public StateTransitionsPanel(int stateID) {
        label = new JLabel("State " + Integer.toString(stateID));
        transitions = new ArrayList<>(); // Begin with no transitions
    }

    public void addTransition(int from, int to, char c){

    }
}
