import java.util.HashSet;
import java.util.Iterator;

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

    /*
        Creates a DFA with no states or transitions
     */
    public DFA(){
        this.startState = null;
        this.currentState = null;
        this.states = new HashSet<State>();
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
    }

    /*
        Execute one step of the DFA, i.e. read the inputSymbol and change state accordingly

        @param inputSymbol the input symbol. New state is determined by T(currentState, inputSymbol)
     */
    public void readSymbol(Character inputSymbol) throws NoSuchTransitionException{
        currentState = currentState.getNextState(inputSymbol);
        if (currentState == null) {
            // There is no transition for this symbol on this state
            // i.e. the word is NOT an element of L(M)
            throw new NoSuchTransitionException(String.format("No such transition for %c on q%d%n",inputSymbol,currentState.getId()));
        }
    }

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
        states.add(state);
    }

    // TODO: Add and remove states

    // Getters
    public State getStartState() {
        return this.startState;
    }
    public State getCurrentState() {
        return this.currentState;
    }
    public int getSize(){
        return states.size();
    }

    // Setters
    public void setStartState(State state) {
        this.startState = state;
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }

    /*
        Enumerate the machine
     */
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("Start state: %d%n",startState.getId()));
        buf.append(String.format("Current state: %d%n",currentState.getId()));
        buf.append(String.format("Size: %d%nSTATES%n",states.size()));
        Iterator<State> it = states.iterator();
        while(it.hasNext()){
            State temp = it.next();
            buf.append(temp.toString());
        }
        return buf.toString();
    }
}
