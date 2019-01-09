import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class StatePanel extends JPanel {
    private int stateID;
    private JPanel header;
    private JLabel label;
    private JButton removeTransitionButton;
    private JButton addTransitionButton;
    private JCheckBox acceptingCheckBox;
    private ArrayList<TransitionPanel> transitions;

    public StatePanel(int id){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        stateID = id;
        transitions = new ArrayList<>();

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
        removeTransitionButton.addActionListener(e -> {
            if (!transitions.isEmpty()){
                // Remove the last transition from DFA
                char onSymbol = transitions.get(transitions.size()-1).getOnValue();
                ((MainFrame)SwingUtilities.windowForComponent(this)).removeTransition(stateID,onSymbol);

                // Update GUI
                transitions.remove(transitions.size()-1);
                removeAll();
                add(header);
                for(TransitionPanel transition: transitions){
                    add(transition);
                }
                revalidate();
                repaint();
            }
        });
        hc.weighty = 0;
        hc.gridx = 1;
        header.add(removeTransitionButton,hc);
        addTransitionButton = new JButton("+");

        addTransitionButton.addActionListener(e -> {
            TransitionPanel transition = new TransitionPanel(stateID);

            // Listen for transition input for each transition
            transition.addChangeListener( e2 -> {
                // Remove the old transition from DFA unless the same transition in another TransitionPanel
                boolean delete = true;
                for (TransitionPanel t : transitions){
                    if (t.getOnValue() == transition.getOldOnSymbol() && t.getOldToState() == transition.getOldToState()){
                        // A duplicate transition exists, do not delete
                        delete = false;
                    }
                }
                if (delete){
                    ((MainFrame)SwingUtilities.windowForComponent(this)).removeTransition(
                            transition.getState(),transition.getOldOnSymbol());

                }

                // Add the new transition
                int state = transition.getState();
                char onSymbol = transition.getOnValue();
                int toState = transition.getToValue();
                ((MainFrame)SwingUtilities.windowForComponent(this)).addTransition(state,toState,onSymbol);
            });
            // Update GUI
            transitions.add(transition);
            removeAll(); // remove and add back transition panels to prepare for repainting (maintain order)
            add(header);
            for(TransitionPanel t: transitions){
                add(t);
            }
            ((MainFrame)SwingUtilities.windowForComponent(this)).dfaUpdated();
            revalidate();
            repaint();
        });

        hc.gridx = 2;
        header.add(addTransitionButton,hc);

        acceptingCheckBox = new JCheckBox();
        acceptingCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED){
                ((MainFrame)SwingUtilities.windowForComponent(this)).removeAcceptingState(stateID);
            }
            else{
                ((MainFrame)SwingUtilities.windowForComponent(this)).addAcceptingState(stateID);
            }
        });
        hc.gridx = 3;
        header.add(acceptingCheckBox,hc);

        add(header);
    }
}
