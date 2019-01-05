import javax.swing.*;
import java.util.ArrayList;

public class TransitionPanel extends JPanel {
    private JLabel onLabel;
    private JLabel toLabel;
    private ArrayList<Character> onList; // Necessary to keep updated compare on DFA update.
    private SpinnerListModel onModel;
    private JSpinner onSpinner;
    private ArrayList<Integer> toList;
    private SpinnerListModel toModel;
    private JSpinner toSpinner;

    public TransitionPanel () {
        onLabel = new JLabel("On");
        toLabel = new JLabel("to");

        // TODO: Create with correct data from dfa
        // TODO: Add update DFA transitions when spinners updated
        onList = new ArrayList<>();
        onList.add('0');
        onModel = new SpinnerListModel(onList);
        onSpinner = new JSpinner(onModel);
        toList = new ArrayList<>();
        toList.add(0);
        toModel = new SpinnerListModel(toList);
        toSpinner = new JSpinner(toModel);

        add(onLabel);
        add(onSpinner);
        add(toLabel);
        add(toSpinner);
    }


    public void updateOnList(ArrayList<Character> list){
        char curr = (char)onSpinner.getValue();
        onModel.setList(list);
        try {
            onModel.setValue(curr);
        } catch (IllegalArgumentException e){
            onModel.setValue(list.get(0));
        }
    }

    public void updateToList(ArrayList<Integer> list) {
        int curr = (int)toSpinner.getValue();
        toModel.setList(list);
        try {
            toModel.setValue(curr);
        } catch (IllegalArgumentException e){
            toModel.setValue(list.get(0));
        }
    }
}
