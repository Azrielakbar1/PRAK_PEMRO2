package PRAK202_2410817110011_MUHAMMADAZRIELAKBAR;

public class Kopi {
		String namaKopi;
		String ukuran;
		double harga;
		public String Pembeli;
		
		public void info() {
			System.out.println("Nama Kopi : " + this.namaKopi);
			System.out.println("Ukuran : " + this.ukuran);
			System.out.println("Harga : Rp. " + this.harga);
		}
		
		
		public void setPembeli(String nama) {
			this.Pembeli = nama;
		}
		public String getPembeli() {
			return this.Pembeli;
		}
		public double getPajak() {
			return this.harga * 0.11;
		}
}


