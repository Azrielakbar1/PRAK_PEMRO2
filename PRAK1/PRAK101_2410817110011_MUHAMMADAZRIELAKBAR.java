package PRAK1;
import java.util.Scanner;

public class PRAK101_2410817110011_MUHAMMADAZRIELAKBAR {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap : ");
		String nama = scan.nextLine();
		
		System.out.print("Masukkan Tempat Lahir : ");
		String TTL = scan.nextLine();
		
		System.out.print("Masukkan Tanggal Lahir : ");
		int tgl_lahir = scan.nextInt();
		
		System.out.print("Masukkan Bulan Lahir : ");
		int bln_lahir = scan.nextInt();
		String[] bulan = {
				"Januari", 
				"Februari", 
				"Maret",
				"April",
				"Mei",
				"Juni",
				"Juli",
				"Agustus",
				"September",
				"Oktober",
				"November",
				"Desember",};
		System.out.print("Masukkan Tahun Lahir : ");
		int thn_lahir = scan.nextInt();
		
		System.out.print("Masukkan Tinggi Badan : ");
		int tggi = scan.nextInt();
		if (tggi <= 0) {
			System.out.println("Tinggi Tidak memenuhi");
		}
		
		System.out.print("Masukkan Berat Badan : ");
		double berat = scan.nextDouble();
		if (berat <= 0) {
			System.out.println("Berat Tidak memenuhi");
		}

		System.out.print("Nama Lengkap " + nama + ", " + "Lahir di " + TTL + " pada Tanggal " + tgl_lahir + " " 
		+ bulan[bln_lahir-1] +" "+ thn_lahir + " Tinggi Badan " + tggi +" cm" + " dan Berat Badan " + berat + " kilogram");		
		scan.close();
	}
}


    