import java.util.HashMap;
import java.util.HashSet;

/*
    A deterministic finite automata, with an emphasis on implementation reflecting mathematical model of a 5-tuple DFA
    M = (Q, A, T, q0, F) where:
        Q is the set of states
        A is the input alphabet
        T is the transition function T: (Q x A) -> Q
        q0 is the initial state
        F is the set of accepting states

    @author John Alberse
    @date 12/7/2018
 */
public class DFA {
    final private int START_STATE = 0;
    private HashSet<Integer> states;
    private HashSet<Character> inputAlphabet;
    private HashMap<Integer,HashMap<Character,Integer>> transitionFunction; // T, Maps (Q x A) -> Q
    private HashSet<Integer> acceptingStates; // F
    private int currentState;

    /*
        Creates a DFA with no states or transition
     */
    public DFA(){
        this.states = new HashSet<Integer>();
        this.inputAlphabet = new HashSet<Character>();
        this.transitionFunction = new HashMap<>();
        this.acceptingStates = new HashSet<>();
        this.currentState = 0;
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
