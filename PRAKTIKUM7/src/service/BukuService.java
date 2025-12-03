package service;

import dao.Bukudao;
import model.Buku;
import javafx.collections.ObservableList;

public class BukuService{
	private Bukudao dao;
	
	public BukuService() {
		this.dao = new Bukudao();
	}
	
	public ObservableList<Buku> getAll(){
		return dao.getAllBuku();
	}
	
	public void tambah(Buku b) throws Exception {
		validasiBuku(b);
		dao.tambahBuku(b);
	}
	
	public void update(Buku b) throws Exception{
		validasiBuku(b);
		dao.updateBuku(b);
	}
	
	public void hapus(int id) {
        dao.hapusBuku(id);
    }
	
	private void validasiBuku(Buku b) throws Exception {
		if(b.getHarga() < 0) {
			throw new Exception("Masukkan Harga dengan Benar!");
		}
		
		if(b.getStok() < 0) {
			throw new Exception("Masukkan Stok dengan Benar!");
		}
		
		if(b.getPenulis().matches(".*\\d.*")) {
			throw new Exception("Masukkan nama penulis dengan benar!");
		}
		
		if(b.getJudul().trim().isEmpty()) {
			throw new Exception("Masukkan Judul !");
		}
	}
}
