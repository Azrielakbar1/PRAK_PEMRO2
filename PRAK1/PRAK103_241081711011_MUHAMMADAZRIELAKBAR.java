package PRAK1;

import java.util.Scanner;

public class PRAK103_241081711011_MUHAMMADAZRIELAKBAR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("");
		int n = scan.nextInt();
		int input = scan.nextInt();
		
		int a = 0;
		int batasDeret = input;
		do {
			if(batasDeret % 2 != 0) {
				System.out.print(batasDeret);
				a++;
				if(a < n) {
					System.out.print(", ");
				}
			}batasDeret++;
		}while(a<n);
		System.out.println();
		scan.close();
	}
	
}


