import java.util.HashMap;

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
    private HashMap<Integer,State> states;

    public DFA(){
        this.startState = new State(0);
        this.currentState = startState;
        states = new HashMap<Integer,State>();
    }
}
