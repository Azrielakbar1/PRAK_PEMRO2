package soal2_prak4;

public class Anjing extends HewanPeliharaan {
	private String warnaBulu;
	private String[] kemampuan;
	
	public Anjing(String n, String r, String w, String[] k) {
		super(r, n);
		this.warnaBulu = w;
		this.kemampuan = k;
	}
	
	public String getWarnaBulu() {
		return warnaBulu;
	}
	public String[] getKemampuan() {
		return kemampuan;
	}
	
	public void displayDetailAnjing() {
		super.display();
		System.out.print("Memiliki kemampuan : ");
		for (String k : kemampuan) {
		    System.out.print(k.replace(",", "") + " ");
		}
	}
	

}
