import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditorPanel extends JPanel {

    // TODO
        // We have a lot of things (transition JSpinners, input alphabet input, etc...)
        // That require information about the "current" DFA inputted.
        // Instead of having a bunch of listeners between them, let's dynamically modify a DFA
        // Which we then read from to determine valid inputs
        // Also, why have the updateMachineButton? Why not dynamically update the machine display after every mod?
        // Maybe? Gonna have to try and see how it shakes out.

    private final int INSET = 4;

    private JPanel descriptionPane;
    private JLabel descriptionLabel;
    private JTextArea descriptionTextArea;

    private JPanel alphabetPanel;
    private JLabel alphabetLabel;
    private JTextField alphabetField;

    private JPanel statesPanel;
    private JPanel statesHeader;
    private JButton removeStateButton;
    private JLabel statesLabel;
    private JButton addStateButton;
    private ArrayList<StatePanel> states;

    public EditorPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(INSET,INSET,INSET,INSET);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Description Panel
        descriptionPane = new JPanel();
        descriptionPane.setLayout(new BorderLayout());
        descriptionLabel = new JLabel("Description");
        descriptionTextArea = new JTextArea();
        descriptionPane.add(descriptionLabel,BorderLayout.PAGE_START);
        descriptionPane.add(descriptionTextArea,BorderLayout.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(descriptionPane,gbc);

        // Input Alphabet Panel
        alphabetPanel = new JPanel();
        alphabetLabel = new JLabel("Input Alphabet");
        alphabetField = new JTextField();
        alphabetField.addActionListener(e -> {
            ((MainFrame)SwingUtilities.windowForComponent(this)).setInputAlpabet(alphabetField.getText());
        });
        alphabetPanel.setLayout(new BorderLayout());
        alphabetPanel.add(alphabetLabel,BorderLayout.PAGE_START);
        alphabetPanel.add(alphabetField,BorderLayout.CENTER);
        gbc.gridy = 1;
        add(alphabetPanel,gbc);

        // States Panel
        statesPanel = new JPanel();
        statesPanel.setLayout(new BoxLayout(statesPanel,BoxLayout.Y_AXIS));
        statesHeader = new JPanel();
        statesHeader.setLayout(new BorderLayout());
        removeStateButton = new JButton("-");
        removeStateButton.addActionListener(e -> {
            if (states.size() <= 1){
                return; // DFA always at least has one state
            }
            // Update data
            ((MainFrame)SwingUtilities.windowForComponent(this)).removeState(states.size() - 1);
            // Update gui
            states.remove(states.size()-1);
            statesPanel.removeAll();
            statesPanel.add(statesHeader);
            for (StatePanel state : states){
                statesPanel.add(state);
            }
            revalidate();
            repaint();
        });
        statesLabel = new JLabel("States",SwingConstants.CENTER);
        addStateButton = new JButton("+");
        addStateButton.addActionListener(e -> {
            // update data
            ((MainFrame)SwingUtilities.windowForComponent(this)).addState(states.size(),false);
            // update gui
            states.add(new StatePanel(states.size()));
            statesPanel.removeAll();
            statesPanel.add(statesHeader);
            for (StatePanel state : states){
                statesPanel.add(state);
            }
            revalidate();
            repaint();
        });
        statesHeader.add(removeStateButton,BorderLayout.LINE_START);
        statesHeader.add(statesLabel,BorderLayout.CENTER);
        statesHeader.add(addStateButton,BorderLayout.LINE_END);
        states = new ArrayList<>();
        states.add(new StatePanel(0));
        statesPanel.add(statesHeader);
        statesPanel.add(states.get(0));
        gbc.gridy = 2;
        add(statesPanel,gbc);
    }
}
