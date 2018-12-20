import javax.swing.*;
import java.awt.*;

public class TransitionPanel extends JPanel {

    private LabelledSpinner onSymbol;
    private LabelledSpinner toState;

    public TransitionPanel(){

        onSymbol = new LabelledSpinner("On");
        toState = new LabelledSpinner("to");

        setLayout(new BorderLayout());

        add(onSymbol,BorderLayout.LINE_START);
        add(toState,BorderLayout.CENTER);

    }

}
