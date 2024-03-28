package more.oop.blackjack;

public enum Suit {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665'),
    SPADES('\u2660');

    private char symbol;

    public String toString(){
        return Character.toString(this.symbol);
    }

    Suit(char symbol){
        this.symbol =symbol;
    }
}
