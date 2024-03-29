public class TransitionKey implements Comparable<TransitionKey> {
    private int state;
    private char inputSymbol;

    public TransitionKey(final int state, final char inputSymbol){
        this.state = state;
        this.inputSymbol = inputSymbol;
    }

    public int getState(){
        return state;
    }

    public char getInputSymbol(){
        return inputSymbol;
    }

    @Override
    public boolean equals(final Object O){
        if (O == null) return false;
        if(!(O instanceof TransitionKey)) return false;
        if (this.state !=((TransitionKey) O).getState()) return false;
        if (this.inputSymbol != ((TransitionKey) O).getInputSymbol()) return false;
        return true;
    }

    public int compareTo(TransitionKey O){
        if (this.state < O.state) return -1;
        if (this.state > O.state) return 1;
        if (this.inputSymbol < O.inputSymbol) return -1;
        if (this.inputSymbol > O.inputSymbol) return 1;
        return 0;
    }

    @Override
    public int hashCode(){
        return (state << 16) + (int)inputSymbol;
    }
}
