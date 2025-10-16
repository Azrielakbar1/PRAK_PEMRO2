	package soal2;
	import java.util.HashMap;
	
	public class Negara {
		private String nama;
		private String jenisKepemimpinan;
		private String namaPemimpin;
		private int tanggalKemerdekaan;
		private int bulanKemerdekaan;
		private int tahunKemerdekaan;
		
		private final HashMap<Integer, String> MonthName;
		
		public Negara(String nama, String jenisKepemimpinan, String namaPemimpin,
				int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
			this.nama = nama;
			this.jenisKepemimpinan = jenisKepemimpinan;
			this.namaPemimpin = namaPemimpin;
			this.tanggalKemerdekaan= tanggalKemerdekaan;
			this.bulanKemerdekaan = bulanKemerdekaan;
			this.tahunKemerdekaan = tahunKemerdekaan;
			
			this.MonthName = new HashMap<>();
			this.MonthName.put(1, "Januari");
			this.MonthName.put(2, "Februari");
			this.MonthName.put(3, "Maret");
			this.MonthName.put(4, "April");
			this.MonthName.put(5, "Mei");
			this.MonthName.put(6, "Juni");
			this.MonthName.put(7, "Juli");
			this.MonthName.put(8, "Agustus");
			this.MonthName.put(9, "September");
			this.MonthName.put(10, "Oktober");
			this.MonthName.put(11, "November");
			this.MonthName.put(12, "Desember");
		}
		
		public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
			this(nama, jenisKepemimpinan, namaPemimpin, 0, 0, 0);
		}
		
		public void display() {
			String jenisPemimpinFormat;
			
			switch(jenisKepemimpinan.toLowerCase()) {
			case "presiden" :
				jenisPemimpinFormat = "Presiden";
				break;
			case "perdana menteri" :
				jenisPemimpinFormat = "Perdana Menteri";
				break;
			case "monarki" :
				jenisPemimpinFormat = "Raja";
				break;
			default :
				jenisPemimpinFormat = jenisKepemimpinan;
				break;
			}
			
			System.out.println("\nNegara " + this.nama + " mempunyai " 
			+ jenisPemimpinFormat + " bernama " + this.namaPemimpin);
			
			if(!this.jenisKepemimpinan.equalsIgnoreCase("monarki")) {
				System.out.println("Deklarasi Kemerdekaan pada Tanggal " 
			+ this.tanggalKemerdekaan + " " + this.MonthName.get(this.bulanKemerdekaan) + " " 
						+ this.tahunKemerdekaan);
				}
		}
	}
