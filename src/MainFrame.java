import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame{

    // TODO: Word input under display
    // TODO: Menu bar (for saving and loading machines)
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;

    private EditorPanel editor;
    private JScrollPane editorScrollPane;
    private DisplayPanel display;
    private DFA dfa;

    public MainFrame() {
        super("Automata");

        dfa = new DFA();

        setLayout(new BorderLayout());

        editor = new EditorPanel();
        editor.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        editorScrollPane = new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        display = new DisplayPanel();

        add(editorScrollPane,BorderLayout.LINE_START);
        add(display,BorderLayout.CENTER);

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
