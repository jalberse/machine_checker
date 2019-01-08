import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatePanel extends JPanel {
    private int stateID;
    private JPanel header;
    private JLabel label;
    private JButton removeTransitionButton;
    private JButton addTransitionButton;
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
            // Update DFA

            // Update GUI
            transitions.add(new TransitionPanel());
            removeAll();
            add(header);
            for(TransitionPanel transition: transitions){
                add(transition);
            }
            ((MainFrame)SwingUtilities.windowForComponent(this)).dfaUpdated();
            revalidate();
            repaint();
        });
        hc.gridx = 2;
        header.add(addTransitionButton,hc);

        add(header);
    }

    // TODO: Add/remove transition on button click
}
