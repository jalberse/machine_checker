public class Main {
    public static void main(String[] args) {
        DFA dfa = new DFA();
        dfa.addState(0,false);
        dfa.addState(1,true);
        System.out.println(dfa);
    }
}
