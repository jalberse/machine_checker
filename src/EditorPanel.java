import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditorPanel extends JPanel {

    // TODO: Will need tooltip and block update button when anything not valid

    private LabelledTextArea descriptionArea;
    private LabelledSpinner numberOfStatesSpinner;
    private LabelledTextField inputAlphabetField;
    // TODO: Array of transition function panels which have 3 components for inputs and outputs?
    private ArrayList<JCheckBox> acceptingStates;
    private JButton updateMachineButton;

    public EditorPanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        descriptionArea = new LabelledTextArea("Description");
        numberOfStatesSpinner = new LabelledSpinner("Number of States");
        inputAlphabetField = new LabelledTextField("Input Alphabet");
        acceptingStates = new ArrayList<>();
        acceptingStates.add(new JCheckBox("0"));
        updateMachineButton = new JButton("Update Machine");

        add(descriptionArea);
        add(numberOfStatesSpinner);
        add(inputAlphabetField);
        for (int i = 0; i < acceptingStates.size(); ++i){
            add(acceptingStates.get(i));
        }
        add(updateMachineButton);
    }
}
