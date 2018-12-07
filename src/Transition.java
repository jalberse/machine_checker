/*
    Unidirectional edge belonging to one State, which indicates which state the machine is sent to on input symbol
 */
public class Transition {
    private String inputSymbol;
    private State result; // state sent to

    public Transition(){
        this.inputSymbol = null;
        this.result = null;
    }

    public Transition(String inputSymbol, State result) {
        this.inputSymbol = inputSymbol;
        this.result = result;
    }
}
