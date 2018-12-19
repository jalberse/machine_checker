import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditorPanel extends JPanel {

    // TODO: Will need tooltip and block update button when anything not valid
    // TODO: InputVerifier subclass. Check for where to refactor to a formatted text field

    private LabelledTextArea descriptionArea;
    private LabelledSpinner numberOfStatesSpinner;
    private LabelledTextField inputAlphabetField;
    // TODO: Array of transition function panels which have 3 components for inputs and outputs?
    //       TODO: There should be a sub-panel for each state's transitions for ease of use
    private LabelledChecklist acceptingStates;
    private JButton updateMachineButton;

    public EditorPanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        descriptionArea = new LabelledTextArea("Description");
        numberOfStatesSpinner = new LabelledSpinner("Number of States");
        inputAlphabetField = new LabelledTextField("Input Alphabet");
        acceptingStates = new LabelledChecklist("Accepting States"); // TODO: Wrap in scroll, could be large
        updateMachineButton = new JButton("Update Machine");

        add(descriptionArea);
        add(numberOfStatesSpinner);
        add(inputAlphabetField);
        add(acceptingStates);
        add(updateMachineButton);
    }
}
