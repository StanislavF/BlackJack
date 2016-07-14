package cardGames;

import java.util.Random;

public class Card {
	
	private static final String[] ranks = {null, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	private static final String[] suits ={"Clubs", "Diamonds", "Hearts", "Spades"};
	private int rank,suit;
	
	public Card(){
		Random r= new Random();
		this.rank = r.nextInt(13)+1;
		this.suit = r.nextInt(4);
	}
	
	public Card(int rank, int suit){
		this.rank=rank;
		this.suit=suit;
	}
	
	//compares if the cards are equal
	public static boolean equals(Card c1,Card c2){
		return (c1.rank==c2.rank && c1.suit==c2.suit);
	}
	
	//Compares the value of the rank of 2 cards
	public static boolean equalsNum(Card c1,Card c2){
		if((c1.rank==10 || c1.rank==11 || c1.rank==12 || c1.rank==13)&&
			(c2.rank==10 || c2.rank==11 || c2.rank==12 || c2.rank==13)) return true;
		return (c1.rank==c2.rank);
	}
	
	
	public int getRank(){
		return this.rank;
	}
	
	public static Card getRandomCard(){
		Card card=new Card();
		return card;
	}
	
	public String toString(){
		return ranks[rank]+" of "+suits[suit];
	}
	

	
}
