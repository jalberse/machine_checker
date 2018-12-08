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
        this.states = new HashSet<State>();
        this.size = 0;
    }

    /*
        Create a DFA with the given start state and map of states

        @param startState The start state
        @states the states of the machine
     */
    public DFA(State startState, HashSet<State> states) {
        this.startState = startState;
        this.currentState = startState;
        this.states = states;
        size = states.size();
    }

    // TODO: Function to read an input symbol and advance

    /*
        Adds the state to the machine. If this is the first state added to the machine, it is set as the starting state
        and the current state.
        If there is already a state in the machine with the same ID, it is replaced.
     */
    public void addState(State state){
        if (startState == null) {
            startState = state;
            currentState = state;
        }
        if (states.add(state)) ++size; // add the state and increment size if succesful
    }


    /*
        Adds a transition from the given state to the target state specified by the transition.
        If the target state is not already a state in the machine, it is added.

        @param state the state to add a transition from
        @param transition the transition from the state to another
     */
    public void addTransition(State fromState, Transition transition) {
        if (!states.contains(transition.getNewState())) {
            // If the state is not already in the machine, add it
            this.addState(transition.getNewState());
        }
        // Associate the transition with fromState
        fromState.addTransition(transition);
    }

    // TODO: Add and remove states and transitions

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

    // TODO: Print and toString
}
