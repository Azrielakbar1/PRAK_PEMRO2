package PRAK203_2410817110011_MUHAMMADAZRIELAKBAR;
/*1. Dibaris ini terdapat Error karena nama class 'Employee' tidak sama dengan file nya
oleh karena itu nama class diganti 'Pegawai' agar sama dengan nama file*/
public class Pegawai {
	public String nama;
	/*2. Dibaris ini terjadi error karena tipe data 'char' hanya bisa menampung satu karakter,
	 * sedangkan data yang diinput lebih dari satu karakter, sehinggga tipe data yang tepat 
	 * adalah 'String'.*/
	public String asal;
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	
	public String getAsal() {
		return asal;
	}
	/*3. Dibaris ini error karena terdapat method setJabatan dipanggil, dengan sebuah argumen
	 * tetapi dideklarasikan tanpa parameter, sehingga harus ditambahkan parameter yaitu
	 * 'String jabatan'.
	 * 4. Variabel 'j' tidak jelas atau tidak terdefinisi, diperbaiki menjadi 'jabatan'.
	 */
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
}
