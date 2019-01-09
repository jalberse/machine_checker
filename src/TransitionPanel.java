import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class TransitionPanel extends JPanel {
    private int stateID; // tracks which state this transition leads from
    private char oldOnSymbol;
    private char currOnSymbol;
    private int oldToState;
    private int currToState;
    private JLabel onLabel;
    private JLabel toLabel;
    private ArrayList<Character> onList; // Necessary to keep updated compare on DFA update.
    private SpinnerListModel onModel;
    private JSpinner onSpinner;
    private ArrayList<Integer> toList;
    private SpinnerListModel toModel;
    private JSpinner toSpinner;

    public TransitionPanel (int id) {
        stateID = id;
        onLabel = new JLabel("On");
        toLabel = new JLabel("to");

        oldOnSymbol = '0';
        currOnSymbol = '0';
        oldToState = 0;
        currToState = 0;

        onList = new ArrayList<>();
        onList.add('0');
        onModel = new SpinnerListModel(onList);
        onSpinner = new JSpinner(onModel);
        onSpinner.addChangeListener(e -> {
            oldOnSymbol = currOnSymbol;
            currOnSymbol = (char)onSpinner.getValue();
            fireChangeEvent();
        });
        toList = new ArrayList<>();
        toList.add(0);
        toModel = new SpinnerListModel(toList);
        toSpinner = new JSpinner(toModel);
        toSpinner.addChangeListener(e -> {
            oldToState = currToState;
            currToState = (int)toSpinner.getValue();
            fireChangeEvent();
        });
        add(onLabel);
        add(onSpinner);
        add(toLabel);
        add(toSpinner);
    }

    public void addChangeListener(ChangeListener listener){
        listenerList.add(ChangeListener.class,listener);
    }

    public void fireChangeEvent(){
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener listener : listenerList.getListeners(ChangeListener.class)){
            listener.stateChanged(e);
        }
    }

    public char getOldOnSymbol(){
        return oldOnSymbol;
    }

    public int getOldToState(){ return oldToState; }

    public char getOnValue(){
        return (char) onSpinner.getValue();
    }

    public int getToValue(){
        return (int)toSpinner.getValue();
    }

    public int getState() { return stateID; }

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
