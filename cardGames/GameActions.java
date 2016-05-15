package cardGames;
import cardGames.BJ_Hand;
import cardGames.BJ_Game;

public class GameActions {


	public static int compAction (BJ_Hand compHand){
		int compResult=resultCalculator(compHand);
		while(compResult<=16){
			compHand.hit();
			compResult=resultCalculator(compHand);
		}
		
		return compResult;
	}
	
	public static int resultCalculator(BJ_Hand hand){
		int plResult=0, aceFlag=0;
		for(int i=0;i < hand.hand.size();i++){
			if(hand.getCard(i).getRank()==1){ 
				aceFlag++;
				continue;
			}
			plResult+=BJ_Hand.cardValue(hand.getCard(i));
		}
		if(aceFlag>0){
			if(plResult+(10+aceFlag)<=21) plResult+=10+aceFlag;
			else plResult+=aceFlag;
		}
		return plResult;
	}	
}
