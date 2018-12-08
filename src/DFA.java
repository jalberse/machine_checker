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
    final private Integer START_STATE = 0;
    private HashSet<Integer> states;
    private HashSet<Character> inputAlphabet;
    private HashMap<TransitionKey,Integer> transitionFunction; // T, Maps (Q x A) -> Q
    private HashSet<Integer> acceptingStates; // F
    private Integer currentState;

    private String description;

    /*
        Creates a DFA with no states or transition
     */
    public DFA(){
        this.states = new HashSet<Integer>();
        this.inputAlphabet = new HashSet<Character>();
        this.transitionFunction = new HashMap<>();
        this.acceptingStates = new HashSet<>();
        this.currentState = 0;
        this.description = "";
    }

    /*
        Constructs a DFA from the file specified
     */
    //public DFA(String filename) {
        // TODO
    //}

    /*
        Execute one step of the DFA, i.e. read the inputSymbol and change current state accordingly
        @param inputSymbol the input symbol. New state is determined by T(currentState, inputSymbol)
     */
    public void readSymbol(Character inputSymbol) throws NoSuchTransitionException {
        currentState = transitionFunction.get(new TransitionKey(currentState,inputSymbol));
        if (currentState == null) throw new NoSuchTransitionException();
    }

    /*
        Defines the input alphabet as all characters present in the string. Overwrites existing inputAlphabet if any.
        @param alpha The string containing the new alphabet, e.g. ab01 if the alphabet is (a,b,0,1)
     */
    public void defineInputAlphabet(String alpha) {
        inputAlphabet.clear();
        for (int i = 0; i < alpha.length(); ++i){
            inputAlphabet.add(alpha.charAt(i));
        }
    }

    /*
        Adds a new state.
        If isAccepting is true, then the state is added to the set of accepting states.
        @param id The id of the state to add
     */
    public void addState(Integer id, boolean isAccepting){
        states.add(id);
        if (isAccepting) acceptingStates.add(id);
    }

    /*
        Adds a transition between two states on an input symbol. If either of the states does not exist, or if
        the input symbol is not an element of the input alphabet, an exception is thrown

        @param fromId Origin of transition
        @param toId the state after the transition
        @param inputSymbol the input symbol
     */
    public void addTransition(Integer fromId, Integer toId, Character inputSymbol) throws InvalidTransitionException {
        if (states.contains(fromId) && states.contains(toId) && inputAlphabet.contains(inputSymbol)){
            TransitionKey key = new TransitionKey(fromId,inputSymbol);
            transitionFunction.put(key,toId);
        }
        else throw new InvalidTransitionException();
    }

    // Getters
    public Integer getCurrentState() {
        return this.currentState;
    }
    public int getSize(){
        return states.size();
    }

    /*
        Enumerate the machine
     */
    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("DFA%n$s%n",description));
        buf.append(String.format("Set of States Q: %s%n",states.toString()));
        buf.append(String.format("Input Alphabet A: %s%n",inputAlphabet.toString()));
        buf.append(String.format("Transition Function T:%n"));
        transitionFunction.forEach((key,toState) ->
                buf.append(String.format("(q%d,%c) -> q%d%n",key.getState(),key.getInputSymbol(),toState)));
        buf.append(String.format("Accepting States F: %s%n",acceptingStates.toString()));
        buf.append(String.format("Size: %d%n",getSize()));
        buf.append(String.format("Current state: q%d%n",currentState));
        return buf.toString();
    }
}
