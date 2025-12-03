package service;

import dao.Penjualandao;
import model.Penjualan;
import model.Buku;

import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;

public class PenjualanService {
	private Penjualandao dao;
	
	public PenjualanService() {
		this.dao = new Penjualandao();
	}
	
	public ObservableList<Penjualan> getAll(){
		return dao.getAllPenjualan();
	}
	
	public void catatPenjualan(int id_pelanggan, Buku bukuYangDibeli, int jumlahBeli) throws Exception{
		if (jumlahBeli <= 0) {
            throw new Exception("Jumlah pembelian minimal 1!");
        }
		
		if (jumlahBeli > bukuYangDibeli.getStok()) {
			throw new Exception("Stok buku tidak cukup! (Sisa: " + bukuYangDibeli.getStok() + ")");
		}
		double totalHarga = bukuYangDibeli.getHarga() * jumlahBeli;
		
		Date tanggalSekarang = Date.valueOf(LocalDate.now());
		
		Penjualan p = new Penjualan();
        p.setPelanggan_id(id_pelanggan);
        p.setBuku_id(bukuYangDibeli.getBuku_id());
        p.setJumlah(jumlahBeli);
        p.setTotal_harga(totalHarga);
        p.setTanggal(tanggalSekarang);
		
		dao.tambahPenjualan(p);
	}
	public void hapus(int id) {
		dao.hapusPenjualan(id);
	}
}
