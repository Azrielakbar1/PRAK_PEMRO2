package soal2_prak4;


public class Kucing extends HewanPeliharaan {
	private String warnaBulu;

	public Kucing(String r, String n, String w) {
		super(r, n);
		this.warnaBulu = w;
		}
	public String getwarnaBulu() {
		return warnaBulu;
	}
	
	public void displayDetailKucing() {
		super.display();
		System.out.println("Memiliki warna bulu :  " + warnaBulu);
	}

}
