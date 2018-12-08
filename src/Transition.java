/*
    Unidirectional edge belonging to one State, which indicates which state the machine is sent to on input symbol
 */
public class Transition {
    private Character inputSymbol;
    private State newState; // state sent to

    public Transition(){
        this.inputSymbol = null;
        this.newState = null;
    }

    public Transition(Character inputSymbol, State newState) {
        this.inputSymbol = inputSymbol;
        this.newState = newState;
    }

    public Character getInputSymbol(){
        return inputSymbol;
    }

    public State getNewState(){
        return newState;
    }
}
