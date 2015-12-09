
import java.util.Arrays;

public class Carte {
	
	private String color;
	
	private String value;
	
	public static String[] tabColor = new String[] {"pique", "coeur", "treffle", "carreau"};

	public static String[] tabValue = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	public Carte(String _color, String _value)
	{
		color = _color;
		value = _value;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int compareTo(Carte aCard) {
		int curCard = Arrays.binarySearch(tabValue, this.value);
		int compareCard = Arrays.binarySearch(tabValue, aCard.value);
		
		return curCard > compareCard ? 1 : (curCard < compareCard ? 0 : 2);
	}
	
}
