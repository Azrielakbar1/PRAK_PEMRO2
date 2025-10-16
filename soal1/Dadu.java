package soal1;
import java.util.Random;
import java.util.LinkedList;

public class Dadu {
	private int value;
	
	public Dadu() {
		acakNilai();
	}
	
	public void acakNilai() {
		this.value = new Random().nextInt(6) + 1;
	}
	
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value= value;
	}
	
	public static void play(int DiceAmount) {
		LinkedList<Dadu> allDice = new LinkedList<>();
		
		for(int i = 0; i < DiceAmount; i++) {
			allDice.add(new Dadu());
		}
		
		int totaldiceVL = 0;
		System.out.println("Hasil Lemparan Dadu ");
		
		for(int i = 0; i < allDice.size(); i++) {
			Dadu dadu = allDice.get(i);
			int diceValue = dadu.getValue();
			System.out.println("Dadu ke- " + (i + 1) + " bernilai " + diceValue);
			totaldiceVL += diceValue;
		}
		System.out.println("Total dadu keseluruhan " + totaldiceVL);
	}
}
