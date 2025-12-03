package controller;

import java.sql.Date;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Penjualan;
import model.Buku;
import model.Pelanggan;
import service.PenjualanService;
import service.BukuService;
import service.PelangganService;
import javafx.scene.control.Alert;

public class PenjualanController implements Initializable {
	@FXML private ComboBox<Pelanggan> cbNamaPelanggan;
    @FXML private ComboBox<Buku> cbJudulBuku;
    @FXML private TextField txtJumlah;

    @FXML private TableView<Penjualan> tabelPenjualan;
    @FXML private TableColumn<Penjualan, Integer> kolIDPenjualan;
    @FXML private TableColumn<Penjualan, Integer> kolNamaPenj; // ID Pelanggan
    @FXML private TableColumn<Penjualan, Integer> kolJudulPenj; // ID Buku
    @FXML private TableColumn<Penjualan, Integer> kolJumlahPenj;
    @FXML private TableColumn<Penjualan, Double> kolTotalPenj;
    @FXML private TableColumn<Penjualan, Date> kolTanggalPenj;

    @FXML private Button btnTambahPenjualan;
    @FXML private Button btnHapusPenjualan;
    private PenjualanService penjualanService = new PenjualanService();
    private PelangganService pelangganService = new PelangganService();
    private BukuService bukuService = new BukuService();
    private Penjualan penjualanPilih;
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kolIDPenjualan.setCellValueFactory(new PropertyValueFactory<>("penjualan_id"));
        kolNamaPenj.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        kolJudulPenj.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        kolJumlahPenj.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        kolTotalPenj.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        kolTanggalPenj.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        muatData();
        refreshCombobox(); 

        tabelPenjualan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                penjualanPilih = newVal;
            }
        });
    }
    
    private void muatData() {
        tabelPenjualan.setItems(penjualanService.getAll());
    }
    
    public void refreshCombobox() {
        cbNamaPelanggan.setItems(pelangganService.getAll());
        cbJudulBuku.setItems(bukuService.getAll());
    }
    
    @FXML
    private void aksiTambahPenjualan() {
        if (cbNamaPelanggan.getValue() == null || cbJudulBuku.getValue() == null) {
            System.out.println("Pilih Pelanggan dan Buku!");
            return;
        }
        
        try {
            String jumlahStr = txtJumlah.getText();
            if (jumlahStr.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Peringatan", "Jumlah tidak boleh kosong!");
                return;
            }
            int jumlah = Integer.parseInt(jumlahStr);
            
            penjualanService.catatPenjualan(
                cbNamaPelanggan.getValue().getPelanggan_id(), 
                cbJudulBuku.getValue(),                       
                jumlah
            );
            
            muatData(); 
            refreshCombobox(); 
            
            txtJumlah.clear();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Transaksi berhasil dicatat!");

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error Input", "Masukkan Jumlah Buku dengan Benar!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal Transaksi", e.getMessage());
        }
    }

    @FXML
    private void aksiHapusPenjualan() {
        if (penjualanPilih != null) {
            penjualanService.hapus(penjualanPilih.getPenjualan_id());
            muatData();
            penjualanPilih = null;
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Transaksi dihapus.");
        } else {
        	showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data transaksi di tabel dulu!");
        }
    }
    
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}
