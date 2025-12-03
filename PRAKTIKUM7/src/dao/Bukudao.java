package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.Buku;
import connectdb.Connectdb;

public class Bukudao {
	private Connection con;
	
	public Bukudao() {
		this.con = Connectdb.getConnection();
	}
	
	//READ on table buku
	public ObservableList<Buku> getAllBuku(){
		ObservableList<Buku> listBuku = FXCollections.observableArrayList();
		String sql = "SELECT * FROM buku";
		
		try(Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				listBuku.add(new Buku(
						rs.getInt("buku_id"),
						rs.getString("judul"),
						rs.getString("penulis"),
						rs.getDouble("harga"),
						rs.getInt("stok")
						));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listBuku;		
	}
	
	
	//CREATE on table buku
	public void tambahBuku(Buku b) {
		String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, b.getJudul());
			pstmt.setString(2, b.getPenulis());
			pstmt.setDouble(3, b.getHarga());
			pstmt.setInt(4, b.getStok());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE on table buku
	public void updateBuku(Buku b) {
		String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, b.getJudul());
			pstmt.setString(2, b.getPenulis());
			pstmt.setDouble(3, b.getHarga());
			pstmt.setInt(4, b.getStok());
			pstmt.setInt(5, b.getBuku_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DELETE on table buku
	public void hapusBuku(int id) {
		String sql = "DELETE FROM buku WHERE buku_id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

