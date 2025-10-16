package soal1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukkan Jumlah Dadu: ");
		int DiceAmount = input.nextInt();
		
		if(DiceAmount <= 0) {
			System.out.println("Error: Jumlah dadu harus lebih dari 0.");
		}else {
			Dadu.play(DiceAmount);
		}
		input.close();
	}
}