public class Main {
    public static void main(String[] args) {
        DFA dfa = new DFA();
        dfa.setDescription("This is a test dfa");
        dfa.setInputAlphabet("abc");
        dfa.addState(0,false);
        dfa.addState(1,true);
        try {
            dfa.addTransition(0,1,'a');
            dfa.addTransition(0,1,'b');
            dfa.addTransition(0,1,'c');
            dfa.addTransition(1,0,'a');
            dfa.addTransition(1,0,'b');
            dfa.addTransition(1,0,'c');
        } catch (InvalidTransitionException e) { System.out.println("Invalid transition"); }
        System.out.println(dfa);

        try {
            System.out.println("Contains ababca?");
            System.out.println(dfa.run("ababca")); // should reject
        } catch (NoSuchTransitionException e) { System.out.println("No such transition error"); }
    }
}
