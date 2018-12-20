import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    // TODO: Word input under display
    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    private EditorPanel editor;
    private JScrollPane editorScrollPane;
    private DisplayPanel display;

    public MainFrame() {
        super("Automata");

        setLayout(new BorderLayout());

        editor = new EditorPanel();
        editorScrollPane = new JScrollPane(editor);
        display = new DisplayPanel();

        add(editorScrollPane,BorderLayout.LINE_START);
        add(display,BorderLayout.CENTER);

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
