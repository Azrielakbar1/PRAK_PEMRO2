package PRAK1;
import java.util.Scanner;

public class PRAK102_2410817110011_MUHAMMADAZRIELAKBAR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("");
		int input = scan.nextInt();
		
		int a = 0;
		int batasDeret = input;
		while (a < 10) {
			if(batasDeret % 5 == 0) {
				int habislima = (batasDeret / 5) - 1;
				System.out.print(habislima);
			} else {
				System.out.print(batasDeret);
			}
			if(a < 9) {
				System.out.print(", ");
			}
			batasDeret++;
			a++;
		}
		System.out.println();
		scan.close();
	}
}
