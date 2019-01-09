import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class MainFrame extends JFrame implements DFAListener{

    // TODO: Word input under display
    // TODO: Menu bar (for saving and loading machines)
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;

    private EditorPanel editorPanel;
    private JScrollPane editorScrollPane;
    private DisplayPanel displayPanel;
    private DFA dfa;

    public MainFrame() {
        super("Automata");

        dfa = new DFA();
        dfa.addListener(this);

        setLayout(new BorderLayout());

        editorPanel = new EditorPanel();
        editorPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        editorScrollPane = new JScrollPane(editorPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        displayPanel = new DisplayPanel();

        add(editorScrollPane,BorderLayout.LINE_START);
        add(displayPanel,BorderLayout.CENTER);

        displayPanel.display(dfa.toString());

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // DFA has been changed - update UI accordingly
    public void dfaUpdated(){
        // Recursively locate all components of type TransitionPanel to update GUI
        ArrayList<Component> transitionPanels = getAllComponents(editorPanel,TransitionPanel.class);

        // Update the editor GUI (i.e. fix transitions to be valid)
        for (Component t : transitionPanels){
            ((TransitionPanel) t).updateOnList(new ArrayList<>(dfa.getInputAlphabet()));
            ((TransitionPanel) t).updateToList(new ArrayList<>(dfa.getStates()));
        }

        // Update display
        displayPanel.display(dfa.toString());

        revalidate();
        repaint();
    }

    // Returns a list of all sub-components which are of type type.
    public static ArrayList<Component> getAllComponents(final Container c, Class<?> type) {
        Component[] comps = c.getComponents(); // Get children
        ArrayList<Component> compList = new ArrayList<>(); // All descendants
        for (Component comp : comps) {
            if (comp.getClass() == type) compList.add(comp);
            if (comp instanceof  Container) {
                compList.addAll(getAllComponents((Container) comp, type));
            }
        }
        return compList;
    }

    // Methods to modify DFA which editor panel can call (getParent().set*()) etc
    public void setDescription(String description){
        dfa.setDescription(description);
    }

    public void addTransition(Integer fromId, Integer toId, Character inputSymbol){
        try {
            dfa.addTransition(fromId,toId,inputSymbol);
        }
        catch (InvalidTransitionException e){
            System.err.println("Invalid transition");
        }
    }

    public void removeTransition(int state, char inputSymbol){
        dfa.removeTransition(state,inputSymbol);
    }

    public void addState(Integer id, boolean isAccepting){
        dfa.addState(id,isAccepting);
    }
    public void removeState(Integer id){
        dfa.removeState(id);
    }
    public void setInputAlphabet(String alpha){
        dfa.setInputAlphabet(alpha);
    }
    public HashSet<Character> getInputAlphabet(){
        return dfa.getInputAlphabet();
    }
}
