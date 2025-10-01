package PRAK1;
import java.util.Scanner;
import java.util.Locale;


public class PRAK105_2410817110011_2410817110011 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useLocale(Locale.US);
		final double PI = 3.14;
		
		System.out.print("Masukkan Jari - jari : ");
		double jarijari = scan.nextDouble();
		System.out.print("Masukkan Tinggi : ");
		double tinggi = scan.nextDouble();
		double volume = PI * jarijari * jarijari * tinggi;
		
		System.out.println("Hasil : ");
		System.out.printf("Volume tabung dengan jari - jari %.1f cm dan tinggi %.1f adalah %.3f m3\n", 
				jarijari, tinggi, volume);
		scan.close();
	}

}
