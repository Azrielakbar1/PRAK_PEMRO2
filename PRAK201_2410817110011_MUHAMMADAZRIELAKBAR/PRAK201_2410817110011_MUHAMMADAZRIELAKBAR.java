package PRAK201_2410817110011_MUHAMMADAZRIELAKBAR;

public class PRAK201_2410817110011_MUHAMMADAZRIELAKBAR {

	public static void main(String[] args) {
		buah mangga = new buah("Mangga", 0.2, 3500);
		buah apel = new buah("Apel", 0.4,7000);
		buah alpukat = new buah("Alpukat", 0.25, 10000);
		
		apel.hitung(40.0);
		mangga.hitung(15.0);
		alpukat.hitung(12.0);
	}

}