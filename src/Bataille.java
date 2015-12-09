import java.util.*;

class Bataille {

	public static void main(String[] args) {
		ArrayList<Carte> cardPackage = new ArrayList<Carte>();
		Joueur player1 = new Joueur();
		Joueur player2 = new Joueur();
		
		// Création des cartes
		for (int i = 0; i < Carte.tabColor.length; i++) {
			for (int j = 0; j < Carte.tabValue.length; j++) {
				Carte aCard = new Carte(Carte.tabColor[i], Carte.tabValue[j]);
				cardPackage.add(aCard);
			}
		}
		
		// Création des paquets pour les joueurs		
		while (player1.getCards() < 26) {
			int random = (int)(Math.random() * cardPackage.size());
			Carte aCard = cardPackage.get(random);
			cardPackage.remove(aCard);
			player1.addCard(aCard);
		}
		
		while (player2.getCards() < 26) {
			int random = (int)(Math.random() * cardPackage.size());
			Carte aCard = cardPackage.get(random);
			cardPackage.remove(aCard);
			player2.addCard(aCard);
		}
		
		while (player1.getCards() != 0 || player2.getCards() != 0) {			
			if (player1.getCards() == 0) {
				System.out.println("======================================================================");
				System.out.println("Le joueur 2 a gagné la partie !");
				System.out.println("Joueur 2 : " + player2.getPoints() + "points");
				System.out.println("Joueur 1 : " + player1.getPoints() + "points");
				System.out.println("======================================================================");
				break;
			}
			else if (player2.getCards() == 0) {
				System.out.println("======================================================================");
				System.out.println("Le joueur 1 a gagné la partie !");
				System.out.println("Joueur 1 : " + player2.getPoints() + "points");
				System.out.println("Joueur 1 : " + player1.getPoints() + "points");
				System.out.println("======================================================================");
				break;
			}
			else {
				Carte player1Card = player1.takeCard();
				Carte player2Card = player2.takeCard();
				
				System.out.println("");
				System.out.println("Joueur 1 : " + player1Card.getValue() + " " + player1Card.getColor());
				System.out.println("Joueur 2 : " + player2Card.getValue() + " " + player2Card.getColor());
				
				int result = player1Card.compareTo(player2Card);
				
				switch (result) {
					case 0:		
						System.out.println("Joueur 2 : Gagne !");
						player2.addPoint();
						player1.removeCard(player1Card);
						player2.addCard(player1Card);
						break;
			
					case 1:
						System.out.println("Joueur 1 : Gagne !");
						player1.addPoint();
						player2.removeCard(player2Card);
						player1.addCard(player2Card);
						break;
						
					case 2:
						System.out.println("Egalité !");
						break;
						
					default:
						System.out.println("Erreur !");
						break;
				}
			}
		}	
	}
}