import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditorPanel extends JPanel {

    private final int INSET = 4;

    // TODO: Will need tooltip and reset
    // TODO: InputVerifier subclass. Check for where to refactor to a formatted text field
    private JButton updateMachineButton;

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
        this.setPreferredSize(new Dimension(MainFrame.WIDTH / 4, MainFrame.HEIGHT));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(INSET,INSET,INSET,INSET);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Update Machine button
        updateMachineButton = new JButton("Update Machine");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(updateMachineButton,gbc);

        // Description Panel
        descriptionPane = new JPanel();
        descriptionPane.setLayout(new BorderLayout());
        descriptionLabel = new JLabel("Description");
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionPane.add(descriptionLabel,BorderLayout.PAGE_START);
        descriptionPane.add(descriptionTextArea,BorderLayout.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(descriptionPane,gbc);

        // Input Alphabet Panel
        alphabetPanel = new JPanel();
        alphabetLabel = new JLabel("Input Alphabet");
        alphabetField = new JTextField();
        alphabetPanel.setLayout(new BorderLayout());
        alphabetPanel.add(alphabetLabel,BorderLayout.PAGE_START);
        alphabetPanel.add(alphabetField,BorderLayout.CENTER);
        gbc.gridy = 2;
        add(alphabetPanel,gbc);

        // States Panel
        statesPanel = new JPanel();
        statesPanel.setLayout(new BoxLayout(statesPanel,BoxLayout.Y_AXIS));
        statesHeader = new JPanel();
        statesHeader.setLayout(new BorderLayout());
        removeStateButton = new JButton("-");
        statesLabel = new JLabel("States",SwingConstants.CENTER);
        addStateButton = new JButton("+");
        statesHeader.add(removeStateButton,BorderLayout.LINE_START);
        statesHeader.add(statesLabel,BorderLayout.CENTER);
        statesHeader.add(addStateButton,BorderLayout.LINE_END);
        states = new ArrayList<>();
        states.add(new StatePanel(0));
        statesPanel.add(statesHeader);
        statesPanel.add(states.get(0));
        gbc.gridy = 3;
        add(statesPanel,gbc);
    }
}
