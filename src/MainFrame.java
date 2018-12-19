import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private EditorPanel editor;
    private DisplayPanel display;

    public MainFrame() {
        super("Automata");

        setLayout(new BorderLayout());

        editor = new EditorPanel();
        display = new DisplayPanel();

        add(editor,BorderLayout.WEST);
        add(display,BorderLayout.CENTER);

        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
