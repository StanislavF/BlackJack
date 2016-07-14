package cardGames;

import java.util.Scanner;


public class BJ_Game {
	static Scanner sc=new Scanner(System.in);
	static BJ_Hand[] playerHand = new BJ_Hand[4];
	static int compResult;
	static BJ_Hand compHand = new BJ_Hand();
	static int splitCount=0, currentHand=0;
	static int[] playerResult={0,0,0,0};
	
	public static void main(String [] args){
		playerHand[0]=BJ_Hand.newHand();
		System.out.println("Welcome player!!! \n"
				+ "Computers firstcard is: " + compHand.getCard(0) + "\n\n");
		System.out.println("And yor hand is:\n" + playerHand[currentHand]);
		// Counts the number of Splits max(4)
	    	// After each split start again from the first hand
		for(;currentHand<=splitCount;currentHand++){
			while(playerResult[currentHand]<21){// Breaks when the player is bustet or holds
				System.out.println("You can choose between: hit, hold");
				if(playerHand[0].getHand().size()==2 && currentHand==0){ //Allows the player to split
  										    //if he has 2 cards of equivalent value
					if(Card.equalsNum(playerHand[currentHand].getCard(0), playerHand[currentHand].getCard(1))){
						System.out.println("You can split too");
					}
				}
				String playerChoice=sc.nextLine();
				playerChoice=playerChoice.toLowerCase();
				//Checks if the input is right
				while(!playerChoice.equals("hit") && !playerChoice.equals("hold") && !playerChoice.equals("split") ){
					System.out.println("Wrong input");
					System.out.println("You can choose between: hit, hold");
					if(playerHand[0].getHand().size()==2 && currentHand==0){
						if(Card.equalsNum(playerHand[currentHand].getCard(0), playerHand[currentHand].getCard(1))){
							System.out.println("You can split too");
						}
					}
					playerChoice=sc.nextLine();
					playerChoice.toLowerCase();
				}
				if(playerChoice.equals("hit")){ //Adds a card to the player hand
					playerHand[currentHand].hit();
					System.out.println("And yor hand now is:\n" + playerHand[currentHand]);
				}
				playerResult[currentHand]=GameActions.resultCalculator(playerHand[currentHand]);
				if(playerChoice.equals("hold")) break;
				// creates new hand for the player if he/she has choosen to split
				if(playerChoice.equals("split")){
					if(splitCount>3){
						System.out.println("You can split maximum 3 times");
						break;
					}
					splitCount++;
					playerHand[splitCount]=new BJ_Hand(playerHand[0].getCard(1));
					playerHand[0].deleteCard(1);
					currentHand=0;
				}
			}
			
			
		}
		
		// calculating Computees reuslt
		compResult=GameActions.compAction(compHand);
		
		System.out.println("Computer Hand is:");
		System.out.println(compHand);
		System.out.println("And his result is " + compResult);
		for(int i=0;i<=splitCount;i++){
			if(splitCount>0){
				System.out.println("Your result is: hand " + (i+1) +" - " + playerResult[i]);
			}
			if(splitCount==0){
				System.out.println("Your result is " + playerResult[i]);
			}
			
			// determining who is the winner
			if(playerResult[i]>21) System.out.println("Sorry player, you lost");
			else if (compResult>21) System.out.println("Congratulations player!!! You won !!!");
				else if(compResult <playerResult[i]) System.out.println("Congratulations player!!! You won !!!");
					 else System.out.println("Sorry player, you lost");
		}
	}
}
