package cardGames;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_Hand {
	private ArrayList<Card> hand=new ArrayList<Card>();
	
	public BJ_Hand(Card card){
		hand.add(card);
	}
	
	public BJ_Hand(){
		
		hand.add(Card.getRandomCard());
		hand.add(Card.getRandomCard());
		
	}
	
	public static BJ_Hand newHand(){
		BJ_Hand nHand = new BJ_Hand();
		return nHand;
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	public String toString(){
		String s="";
		for(int i = 0;i<hand.size();i++){
			s+=(hand.get(i).toString() + " \n");
		}
		return s;
	}
	
	public Card getCard(int index){
		return hand.get(index);
	}
	
	public void deleteCard(int index){
		hand.remove(index);
	}
	
	public void hit(){
		hand.add(Card.getRandomCard());
	}
	
	

	
	public static int cardValue(Card card){
		switch(card.getRank()){
			case 1: return 0;
			case 2: return 2;
			case 3: return 3;
			case 4: return 4;
			case 5: return 5;
			case 6: return 6;
			case 7: return 7;
			case 8: return 8;
			case 9: return 9;
			case 10: return 10;
			case 11: return 10;
			case 12: return 10;
			case 13: return 10;
		}
		return 0;
	}
}
