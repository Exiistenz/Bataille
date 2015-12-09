import java.util.*;

public class Joueur {
	private int points;
	
	private ArrayList<Carte> playerCards;
	
	public Joueur() {
		points = 0;
		playerCards = new ArrayList<Carte>();
	}
	
	public boolean addCard(Carte aCard) {
		return playerCards.add(aCard);
	}
	
	public void addPoint() {
		this.points += 1;
	}
	
	
	public Carte takeCard() {
		int random = (int)(Math.random() * playerCards.size());
		Carte aCard = playerCards.get(random);
		
		if (playerCards.remove(aCard)) 
			return aCard;
		else
			return aCard = null;
	}
	
	public boolean removeCard(Carte aCard) {
		return playerCards.remove(aCard);
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getCards() {
		return (int) playerCards.size();
	}
	
}
