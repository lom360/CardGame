package Game;

public class DecksOfCards {
	public static void main(String[] args) {
		Card card1 = new Card();
		Card card2 = new Card('B', Card.Suit.clubs);
		Card card3 = new Card('T', Card.Suit.hearts);
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
	}
}

class Card {
	enum Suit {clubs, diamonds, hearts, spades};
	private char value;
	private Suit suit;
	private boolean errorFlag;
	
    // Default Constructor
	public Card() {
		setValue('A');
		setSuit(Suit.spades);
		errorFlag = isValid('A', Suit.spades);
	}
	
	// Clone Constructor
	public Card(Card original) {
		setValue(original.value);
		setSuit(original.suit);
		errorFlag = isValid(original.value, original.suit);
	}
	
	// Constructor
	public Card(char value, Suit suit) {
		setValue(value);
		setSuit(suit);
		errorFlag = isValid(value, suit);
	}
	
	public String toString() {
		if(errorFlag) 
			return "** illegal **";
		else 
			return this.value + " of " + this.suit;
	}
	
	private void setValue(char value) {
		this.value = value;
	}
	
	private void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	
	private boolean isValid(char value, Suit suit) {
		char[] cardValue = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
		for(int i = 0; i < cardValue.length; i++) {
			if(value == cardValue[i]) {
				return false;
			}
		}
		return true;
	}
}