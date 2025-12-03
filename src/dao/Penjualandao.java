package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.Penjualan;
import connectdb.Connectdb;

public class Penjualandao {
	private Connection con;
	
	
	public Penjualandao(){
		this.con = Connectdb.getConnection();
	}
	
	//READ on table penjualan
	public ObservableList<Penjualan> getAllPenjualan(){
		ObservableList<Penjualan> listPenjualan = FXCollections.observableArrayList();
		String sql = "SELECT * FROM penjualan";
		
		try (Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					listPenjualan.add(new Penjualan(
							rs.getInt("penjualan_id"),
							rs.getInt("jumlah"),
							rs.getDouble("total_harga"),
							rs.getDate("tanggal"),
							rs.getInt("pelanggan_id"),
							rs.getInt("buku_id")
							));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return listPenjualan;
	} 
	
	//CREATE on table penjualan
	public void tambahPenjualan(Penjualan p) {
		String sql = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, p.getJumlah());
			pstmt.setDouble(2, p.getTotal_harga());
			pstmt.setDate(3, p.getTanggal());
			pstmt.setInt(4, p.getPelanggan_id());
			pstmt.setInt(5, p.getBuku_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE on table penjualan
	public void updatePenjualan(Penjualan p) {
		String sql = "UPDATE penjualan SET jumlah=?, total_harga=?, tanggal=?, pelanggan_id=?, buku_id=? WHERE penjualan_id =?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, p.getJumlah());
			pstmt.setDouble(2, p.getTotal_harga());
			pstmt.setDate(3, p.getTanggal());
			pstmt.setInt(4, p.getPelanggan_id());
			pstmt.setInt(5, p.getBuku_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DELETE on table penjualan
	public void hapusPenjualan(int id) {
		String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
