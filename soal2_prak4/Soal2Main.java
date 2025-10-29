package soal2_prak4;
import java.util.Scanner;

public class Soal2Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Pilih jenis hewan yang ingin diinputkan: ");
		System.out.println("1 =  Kucing ");
		System.out.println("2 = Anjing ");
		System.out.print("Masukkan Pilihan : ");
		int pilihan = input.nextInt();
		input.nextLine();
		
		if (pilihan == 1) {
            System.out.print("Nama hewan peliharaan: ");
            String nama = input.nextLine();
            System.out.print("Ras: ");
            String ras = input.nextLine();
            System.out.print("Warna Bulu: ");
            String warnaBulu = input.nextLine();
            
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            kucing.displayDetailKucing();
	} else if(pilihan == 2) {
		System.out.print("Nama hewan peliharaan: ");
        String nama = input.nextLine();
        System.out.print("Ras: ");
        String ras = input.nextLine();
        System.out.print("Warna Bulu: ");
        String warnaBulu = input.nextLine();
        System.out.print("Kemampuan : ");
        String kemampuanInput = input.nextLine();
        
        String[] kemampuan = kemampuanInput.split("//s*");
        
        Anjing anjing = new Anjing(ras, nama, warnaBulu, kemampuan);
        anjing.displayDetailAnjing();
		} else {
			System.out.println("Plihan tidak ada, Silakan Ulang Lagi ! ");
		}
		input.close();
	}

}
