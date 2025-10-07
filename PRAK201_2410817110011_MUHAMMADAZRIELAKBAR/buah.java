package PRAK201_2410817110011_MUHAMMADAZRIELAKBAR;
import java.util.Locale;
public class buah {
		String nama_buah;
		double berat_buah;
		double harga_buah;
		
		public buah(String nama, double berat, double harga) {
			this.nama_buah = nama;
			this.berat_buah = berat;
			this.harga_buah = harga;
		}
		public void hitung(double jumlahBeli) {
			double harga_perkilo = this.harga_buah / this.berat_buah;
			double sebelumdisc = harga_perkilo * jumlahBeli;
			int kelipatandisc = (int)(jumlahBeli / 4);
			double totaldisc = kelipatandisc * (this.harga_buah * 0.08);
			double setelahdisc = sebelumdisc - totaldisc;
			
			System.out.println("Nama Buah : " + this.nama_buah);
			System.out.println("Berat : " + this.berat_buah);
			System.out.println("Harga : " + this.harga_buah);
			System.out.println("Jumlah Beli : " + jumlahBeli + " kg");
			System.out.printf(Locale.US,"Harga Sebelum Diskon : Rp%.2f\n",sebelumdisc);
			System.out.printf(Locale.US,"Total Diskon :  Rp%.2f\n",totaldisc);
			System.out.printf(Locale.US,"Harga Setelah Diskon : Rp%.2f\n", setelahdisc);
			System.out.println();
		}
	}

