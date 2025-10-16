package soal2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class Main{

	public boolean isValidDate(int date, int month, int year) {
		if (month < 1 || month > 12 || date < 1 || year <= 0 || year > 2025) { 
			return false;
		}

		int maxDays;
		if (month == 2) {
			//kabisatValidation
			boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
			maxDays = isLeap ? 29 : 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			maxDays = 30;
		} else {
			maxDays = 31;
		}

		return date <= maxDays;
	}

	public static void main(String[] args) {
		Main main = new Main();
		Scanner input = new Scanner(System.in);
		LinkedList<Negara> daftarNegara = new LinkedList<>();

		int totalCountry = 0;
		while (true) {
			try {
				System.out.print("Masukkan jumlah negara: ");
				totalCountry = input.nextInt();
				if (totalCountry > 0) {
					input.nextLine(); 
					break; 
				} else {
					System.out.println("Jumlah negara harus lebih dari 0. Silahkan coba lagi.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Input tidak valid. Harap masukkan sebuah angka.");
				input.next(); 
			}
		}

		for (int i = 0; i < totalCountry; i++) {
			System.out.println("\nMasukkan data untuk Negara ke-" + (i + 1));
			System.out.print("Nama Negara: ");
			String nama = input.nextLine();
			
			System.out.print("Jenis Kepemimpinan: ");
			String jenisKepemimpinan = input.nextLine();
			
			System.out.print("Nama Pemimpin: ");
			String namaPemimpin = input.nextLine();

			if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
				daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
			} else {
				int date = 0, month = 0, year = 0;

				while (true) {
					try {
						System.out.print("Tanggal Kemerdekaan: ");
						date = input.nextInt();
						System.out.print("Bulan Kemerdekaan: ");
						month = input.nextInt();
						System.out.print("Tahun Kemerdekaan: ");
						year = input.nextInt();
						input.nextLine();

						if (main.isValidDate(date, month, year)) {
							break;
						} else {
							System.out.println("Tanggal/Bulan/Tahun tidak valid "
									+ "(Tahun tidak boleh > 2025). Silakan masukkan kembali.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Input tanggal, bulan, dan tahun harus berupa angka."
								+ " Silakan masukkan kembali.");
						input.nextLine();
					}
				}
				daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, date, month, year));
			}
		}
		for (Negara negara : daftarNegara) {
			negara.display();
		}
		input.close();
	}
}