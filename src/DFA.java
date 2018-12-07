import java.util.HashMap;
import java.util.HashSet;

/*
    A deterministic finite automata
    M = (Q, A, T, q0, F) where:
        Q is the set of states
        A is the input alphabet, and is implicitly defined as all input symbols part of transitions added to the machine
        T is the transition function T: (Q x A) -> Q. Transitions are associated with each state and sent to other
            states on reading an input symbol
        q0 is the initial state
        F is the set of accepting states. Implicitly defined by having each state track whether or not they accept

    @author John Alberse
    @date 12/7/2018
 */
public class DFA {
    private State startState;
    private State currentState;
    private HashSet<State> states;
    int size; // the number of states

    /*
        Creates a DFA with no states or transitions
     */
    public DFA(){
        this.startState = null;
        this.currentState = null;
        states = new HashSet<State>();
    }


    // Getters
    public State getStartState() {
        return this.startState;
    }
    public State getCurrentState() {
        return this.currentState;
    }

    // Setters
    public void setStartState(State state) {
        this.startState = state;
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
}
