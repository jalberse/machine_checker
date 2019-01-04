import javax.swing.*;
import java.awt.*;
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
        // Update display
        displayPanel.display(dfa.toString());
        // Update transition input
        for (Component c : editorPanel.getComponents()){
            if (c instanceof StatePanel){
                for (Component t : ((StatePanel) c).getComponents()){
                    if (t instanceof TransitionPanel){
                        // TODO: Check equivalence of input alpabet and state set. If not equal
                        // TODO: with model's list, update. Make sure we don't lose current value if out of range tho
                    }
                }
            }
        }
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
    public void addListener(DFAListener listener){
        dfa.addListener(listener);
    }
    public void addState(Integer id, boolean isAccepting){
        dfa.addState(id,isAccepting);
    }
    public void removeState(Integer id){
        dfa.removeState(id);
    }
    public void setInputAlpabet(String alpha){
        dfa.setInputAlphabet(alpha);
    }
    public HashSet<Character> getInputAlphabet(){
        return dfa.getInputAlphabet();
    }
}
