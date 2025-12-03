package service;

import dao.Pelanggandao;
import model.Pelanggan;
import javafx.collections.ObservableList;

public class PelangganService {
	
	private Pelanggandao dao;
	
	public PelangganService() {
		this.dao = new Pelanggandao();
	}
	
	
	//READ
	public ObservableList<Pelanggan> getAll() {
		return dao.getAllPelanggan();
	}
	
	public void tambah(Pelanggan p) throws Exception{
		if (p.getNama().matches(".*\\d.*")) {
            throw new Exception("Masukkan Nama dengan Benar !");
        }

        if (!p.getEmail().contains("gmail.com")) {
            throw new Exception("Masukkan Email dengan Benar !");
        }
        
        if (!p.getTelepon().matches("\\d+")) {
            throw new Exception("Masukkan Nomor Telepon dengan Benar !");
        }
        
        if (p.getTelepon().length() > 12) {
            throw new Exception("Nomor yang anda Ketik terjadi Error !");
        }
		dao.tambahPelanggan(p);
	}
	
	public void update(Pelanggan p) throws Exception{
		if (p.getNama().matches(".*\\d.*")) {
            throw new Exception("Masukkan Nama dengan Benar !");
        }

        if (!p.getEmail().contains("gmail.com")) {
            throw new Exception("Masukkan Email dengan Benar !");
        }
        
        if (!p.getTelepon().matches("\\d+")) {
            throw new Exception("Masukkan Nomor Telepon dengan Benar !");
        }
        
        if (p.getTelepon().length() > 12) {
            throw new Exception("Nomor yang anda Ketik terjadi Error !");
        }
		dao.updatePelanggan(p);
	}
	
	public void hapus(int id) {
        dao.hapusPelanggan(id);
    }
}
