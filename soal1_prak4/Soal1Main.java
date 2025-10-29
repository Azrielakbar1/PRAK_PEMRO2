package soal1_prak4;
import java.util.Scanner;

public class Soal1Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nama Hewan Peliharaan : ");
		String nama = input.nextLine();
		System.out.print("Ras  : ");
		String ras = input.nextLine();
		input.close();
		HewanPeliharaan kucing = new HewanPeliharaan(nama, ras);
		kucing.display();
		

	}

}
