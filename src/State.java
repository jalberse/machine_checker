import java.util.ArrayList;
import java.util.HashMap;

/*
    Models a single state of a machine (vertex in its graph), including id, transitions, and whether or not it is
    an accepting state.

    @author John Alberse
*/
public class State {
    private int id; // Unique identifier for the state
    private HashMap<String,State> transitions; // Transitions from this state to another. Key is input symbol
    private boolean accepting; // True if element of set of accepting states

    public State(int id) {
        this.id = id;
        this.transitions = new HashMap<String,State>();
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

    /*
    Given an input symbol, find the transition

    @param inputSymbol the input symbol for the transition
    @return the resultant state of the transition function for the given input symbol on this state
            NULL if there is no transition specified for that input symbol
     */
    public State getNextState(String inputSymbol) {
        return transitions.get(inputSymbol);
    }

    public int getId() { return id; }
    public boolean isAccepting() { return accepting; }

    /*
    Summarize the state
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("State Summary%nid: %d%n",this.id);
        buf.append(String.format("Accepting: %b%n",this.accepting));
        buf.append(String.format("Transitions:%n"));
        transitions.forEach((k,v) -> buf.append(String.format("(q%d,%s) -> q%d",this.id,k,v.id)));
        return buf.toString();
    }
}
