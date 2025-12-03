package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import model.Pelanggan;
import connectdb.Connectdb;

public class Pelanggandao {
	private Connection con;
	
	public Pelanggandao() {
		this.con = Connectdb.getConnection();
	}
	
	//READ on table Pelanggan
	public ObservableList<Pelanggan> getAllPelanggan(){
		ObservableList<Pelanggan> listPelanggan = FXCollections.observableArrayList();
		String sql = "SELECT * FROM pelanggan";
		
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Pelanggan p = new Pelanggan(
						rs.getInt("pelanggan_id"),
						rs.getString("nama"),
						rs.getString("email"),
						rs.getString("telepon")
						);
				listPelanggan.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listPelanggan;
	} 	
	
	//CREATE on table pelanggan
	public void tambahPelanggan(Pelanggan p) {
		String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, p.getNama());
			pstmt.setString(2, p.getEmail());
			pstmt.setString(3, p.getTelepon());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//UPDATE on table Pelanggan
	public void updatePelanggan(Pelanggan p) {
		String sql = "UPDATE pelanggan SET nama =?, email=?, telepon=? WHERE pelanggan_id =?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, p.getNama());
			pstmt.setString(2, p.getEmail());
			pstmt.setString(3, p.getTelepon());
			pstmt.setInt(4, p.getPelanggan_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DELETE on table Pelanggan
	public void hapusPelanggan(int id) {
		String sql = "DELETE FROM pelanggan WHERE pelanggan_id = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Pelanggan berhasil dihapus di ID : " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

