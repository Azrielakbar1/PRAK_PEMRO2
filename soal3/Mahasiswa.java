package soal3;

public class Mahasiswa {
	private String nama;
	private String NIM;
	
	public Mahasiswa(String nama, String NIM) {
		this.nama= nama;
		this.NIM = NIM;
	}
	
	public String getNama() {
		return nama;
	}
	public String getNIM() {
		return NIM;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setNIM(String NIM) {
		this.NIM= NIM;
	}
}
