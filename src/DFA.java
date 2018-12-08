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
    final private int startState = 0;
    private int size;
    private int currentState;
    private HashSet<Integer> acceptingStates;

    /*
        Creates a DFA with no states or transitions
     */
    public DFA(){
        // TODO: This
    }


    /*
        Execute one step of the DFA, i.e. read the inputSymbol and change state accordingly

        @param inputSymbol the input symbol. New state is determined by T(currentState, inputSymbol)
     */
    public void readSymbol(Character inputSymbol) throws NoSuchTransitionException{

    }

    // Getters
    public Integer getStartState() {
        return this.startState;
    }
    public Integer getCurrentState() {
        return this.currentState;
    }
    public int getSize(){
        return size;
    }

    /*
        Enumerate the machine
     */
    public String toString(){
        StringBuffer buf = new StringBuffer();
        // TODO: This
        return buf.toString();
    }
}
