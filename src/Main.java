public class Main {
    public static void main(String[] args) {
        DFA dfa = new DFA();
        State state0 = new State();
        State state1 = new State(1);
        dfa.addState(state0);
        dfa.addState(state1);
    }
}
