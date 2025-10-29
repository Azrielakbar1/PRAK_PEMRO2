package soal2_prak4;

public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	public HewanPeliharaan(String r, String n) {
		this.nama = r;
		this.ras = n;
	}
	
	public String getNama() {
		return nama;
	}
	public String getRas() {
		return ras;
	}
	
	public void display() {
		System.out.println();
		System.out.println("Detail Hewan Peliharaan : ");
		System.out.println("Nama hewan peliharaanku adalah : " + nama);
		System.out.println("Dengan ras : " + ras);		
	}
}

