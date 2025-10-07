package PRAK203_2410817110011_MUHAMMADAZRIELAKBAR;

public class Soal3Main {

	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
		p1.nama = "Roi"; 
		p1.asal ="Kingdom of Orvel";
		p1.setJabatan("Assasin");
		/*5. Tidak ada nilai atribut umur, karena permintaan output 17 tahun, maka harus 
		 * diberikan nilai yaitu '17', karena jika tidak dimasukkan nilai atribut umur, 
		 * nilai default nya adalah '0'*/
		p1.umur = 17;
		
		System.out.println("Nama Pegawai : " + p1.getNama());
		System.out.println("Asal : " + p1.getAsal());
		System.out.println("Jabatan : " + p1.jabatan);
		System.out.println("Umur : " + p1.umur + " tahun");
		
		
	}

}
