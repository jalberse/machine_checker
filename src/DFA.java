import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;

/*
    A deterministic finite automaton, with an emphasis on implementation reflecting mathematical model of a 5-tuple DFA
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
    private Integer start_state;
    private HashSet<Integer> states;
    private HashSet<Character> inputAlphabet;
    private HashMap<TransitionKey,Integer> transitionFunction; // T, Maps (Q x A) -> Q
    private HashSet<Integer> acceptingStates; // F
    private Integer currentState;
    private String description;

    private ArrayList<DFAListener> listeners;

    /*
        Creates a DFA with one states, no transitions, and no accepting states
     */
    public DFA(){
        this.listeners = new ArrayList<>();
        this.states = new HashSet<Integer>();
        states.add(0);
        this.inputAlphabet = new HashSet<Character>();
        inputAlphabet.add('0');
        this.transitionFunction = new HashMap<>();
        this.acceptingStates = new HashSet<>();
        this.start_state = 0;
        this.currentState = 0;
        this.description = "";
    }

    // TODO: Handle invalid construction.
    // e.g. if input alpha is null, can break gui
    /*
        Constructs a DFA from the file specified

        @param filename The file containing the DFA. See README for format.
     */
    public DFA(String filename) {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(filename);
            br = new BufferedReader(fr);

            // Description
            this.description = br.readLine();
            // Set of states
            this.states = new HashSet<Integer>();
            int numStates = parseInt(br.readLine());
            for (int i = 0; i < numStates; ++i) {
                this.states.add(i);
            }
            // Alphabet
            this.inputAlphabet = new HashSet<Character>();
            char[] alpha = br.readLine().toCharArray();
            for (char c : alpha) {
                this.inputAlphabet.add(c);
            }
            // Accepting states
            this.acceptingStates = new HashSet<>();
            String[] acceptingStates = br.readLine().split(",");
            for (String s : acceptingStates) {
                this.acceptingStates.add(parseInt(s));
            }
            // Start state
            this.start_state = parseInt(br.readLine());
            this.currentState = this.start_state;
            // Transition function
            this.transitionFunction = new HashMap<>();
            String trans;
            while ((trans = br.readLine()) != null) {
                String[] rule = trans.split(",");
                transitionFunction.put(new TransitionKey(parseInt(rule[0]), rule[1].charAt(0)), parseInt(rule[2]));
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Improperly formatted file");
        } finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e){
                    System.err.println(e);
                }
            }
        }
    }

    /*
        Runs the machine on a word

        @param word The word to run the machine on
        @return true if word is an element of L(M)
                false if the word is not an element of L(M)
     */
    public boolean run(String word) {
        this.currentState = start_state;
        for (int i = 0; i < word.length(); ++i){
            try {
                readSymbol(word.charAt(i));
            } catch (NoSuchTransitionException e) { System.err.println(e); }
        }
        return acceptingStates.contains(currentState);
    }

    /*
        Execute one step of the DFA, i.e. read the inputSymbol and change current state accordingly
        @param inputSymbol the input symbol. New state is determined by T(currentState, inputSymbol)
     */
    private void readSymbol(Character inputSymbol) throws NoSuchTransitionException {
        currentState = transitionFunction.get(new TransitionKey(currentState,inputSymbol));
        if (currentState == null) throw new NoSuchTransitionException();
        fireDfaUpdated();
    }

    public void setDescription(String description){
        this.description = description;
        fireDfaUpdated();
    }

    public void clearTransitionFunction(){
        transitionFunction.clear();
    }

    /*
        Defines the input alphabet as all characters present in the string. Overwrites existing inputAlphabet if any.
        Repeated characters are not added.
        @param alpha The string containing the new alphabet, e.g. ab01 if the alphabet is (a,b,0,1)
     */
    public void setInputAlphabet(String alpha) {
        inputAlphabet.clear();
        for (int i = 0; i < alpha.length(); ++i){
            inputAlphabet.add(alpha.charAt(i));
        }
        fireDfaUpdated();
    }

    /*
        Adds a new state.
        If isAccepting is true, then the state is added to the set of accepting states.
        @param id The id of the state to add
     */
    public void addState(Integer id, boolean isAccepting){
        states.add(id);
        if (isAccepting) acceptingStates.add(id);
        fireDfaUpdated();
    }

    public void removeState(Integer id){
        states.remove(id);
        for (DFAListener listener : listeners) {
            listener.dfaUpdated();
        }
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
            fireDfaUpdated();
        }
        else throw new InvalidTransitionException();
    }

    public void removeTransition(int fromId, char inputSymbol) {
        transitionFunction.remove(new TransitionKey(fromId,inputSymbol));
        fireDfaUpdated();
    }

    public void addAcceptingState(int id){
        acceptingStates.add(id);
        fireDfaUpdated();
    }

    public void removeAcceptingState(int id){
        acceptingStates.remove(id);
        fireDfaUpdated();
    }

    public void addListener(DFAListener o){
        listeners.add(o);
    }

    public void fireDfaUpdated(){
        for (DFAListener listener : listeners) {
            listener.dfaUpdated();
        }
    }

    // Getters
    public Integer getCurrentState() { return this.currentState; }
    public int getSize(){
        return states.size();
    }
    public HashSet<Character> getInputAlphabet() {
        return inputAlphabet;
    }
    public String getDescription() {
        return description;
    }
    public HashSet<Integer> getAcceptingStates() {
        return acceptingStates;
    }
    public HashSet<Integer> getStates() {
        return states;
    }
    public Integer getStart_state() {
        return start_state;
    }
    public HashMap<TransitionKey, Integer> getTransitionFunction() {
        return transitionFunction;
    }

    /*
    Enumerate the machine
    */
    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("DFA%nDescription: %s%n",description));
        buf.append(String.format("Set of States Q: %s%n",states.toString()));
        buf.append(String.format("Input Alphabet A: %s%n",inputAlphabet.toString()));
        buf.append(String.format("Transition Function T:%n"));

        ArrayList<TransitionKey> keys = new ArrayList<>(transitionFunction.keySet());
        Collections.sort(keys);
        keys.forEach((key) -> buf.append(String.format("(q%d,%c) -> q%d%n",
                key.getState(),key.getInputSymbol(),transitionFunction.get(key))));

        buf.append(String.format("Accepting States F: %s%n",acceptingStates.toString()));
        buf.append(String.format("Size: %d%n",getSize()));
        buf.append(String.format("Current state: q%d%n",currentState));
        return buf.toString();
    }
}
