import java.util.ArrayList;
import java.util.HashMap;

/*
    Models a single state of a machine (vertex in its graph)

    @author John Alberse
*/
public class State {
    private int id; // Unique identifier for the state
    private HashMap transitions = new HashMap(); // <char, Transtion>
    private boolean accepting; // True if element of set of accepting states

    public State(int id) {
        this.id = id;
        this.accepting = false;
    }

    /*
    Adds a transition function to the state. If the input symbol for the provided transition already has a transition
        on this state, the old transition is replaced.
    @param transition The transition to be added
     */
    public void addTransition(Transition transition) {
        transitions.put(transition.getInputSymbol(),transition);
    }
}
