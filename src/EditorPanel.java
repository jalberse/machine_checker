import javax.swing.*;

public class EditorPanel extends JPanel {
    // TODO: Add components for other parts of machine...
    private JTextArea description;

    public EditorPanel(){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        description = new JTextArea();
        add(description);
    }
}
