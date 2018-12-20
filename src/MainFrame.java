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

    public MainFrame() {
        super("Automata");

        setLayout(new BorderLayout());

        editor = new EditorPanel();
        display = new DisplayPanel();

        add(editor,BorderLayout.LINE_START);
        add(display,BorderLayout.CENTER);

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
