package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buku;
import service.BukuService;
import javafx.scene.control.Alert;

public class BukuController implements Initializable{
	@FXML private TextField txtJudulBuku;
    @FXML private TextField txtPenulis;
    @FXML private TextField txtHarga;
    @FXML private TextField txtStok;

    @FXML private TableView<Buku> tabelBuku;
    @FXML private TableColumn<Buku, Integer> kolIDBuku;
    @FXML private TableColumn<Buku, String> kolJudulBuku;
    @FXML private TableColumn<Buku, String> kolPenulis;
    @FXML private TableColumn<Buku, Double> kolHarga;
    @FXML private TableColumn<Buku, Integer> kolStok;

    @FXML private Button btnTambahBuku;
    @FXML private Button btnEditBuku;
    @FXML private Button btnHapusBuku;
    
    private BukuService service = new BukuService();
    private Buku bukuPilih;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kolIDBuku.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        kolJudulBuku.setCellValueFactory(new PropertyValueFactory<>("judul"));
        kolPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        kolHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        kolStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        muatData();

        tabelBuku.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                bukuPilih = newVal;
                txtJudulBuku.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
            }
        });
    }
    
    private void muatData() {
        tabelBuku.setItems(service.getAll());
    }
    
    private void clear() {
        txtJudulBuku.clear();
        txtPenulis.clear();
        txtHarga.clear();
        txtStok.clear();
        bukuPilih = null;
    }
	
    @FXML
    private void aksiTambahBuku() {
        try {
        	String hargaText = txtHarga.getText();
        	String hargaBersih = hargaText.replace(".", "");
        	Double harga = Double.parseDouble(hargaBersih);
        	
            Buku b = new Buku(
                txtJudulBuku.getText(),
                txtPenulis.getText(),
                harga,
                Integer.parseInt(txtStok.getText())
            );
            service.tambah(b);
            muatData();
            clear();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Buku berhasil disimpan!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Masukkan Angka dengan Benar!" );
        } catch (Exception e) {
        	showAlert(Alert.AlertType.ERROR, "Gagal Input", e.getMessage());
        }
    }
    
    @FXML
    private void aksiEditBuku() {
        if (bukuPilih != null) {
            try {
            	String judul = txtJudulBuku.getText();
                String penulis = txtPenulis.getText();
                String hargaText = txtHarga.getText();
                String stokText = txtStok.getText();
                String hargaBersih = hargaText.replace(".", "");
                
                bukuPilih.setJudul(judul);
                bukuPilih.setPenulis(penulis);
                
                bukuPilih.setHarga(Double.parseDouble(hargaBersih));
                bukuPilih.setStok(Integer.parseInt(stokText));

                service.update(bukuPilih);
                muatData();
                clear();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Buku Berhasil Diupdate!");
            } catch (NumberFormatException e) {
            	showAlert(Alert.AlertType.ERROR, "Error Input", "Masukkan Angka denga Benar!");
            } catch(Exception e) {
            	showAlert(Alert.AlertType.ERROR, "Gagal Update", e.getMessage());
            } 
        } else {
        	showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih buku di tabel terlebih dahulu!");
        }
    }

    @FXML
    private void aksiHapusBuku() {
        if (bukuPilih != null) {
            service.hapus(bukuPilih.getBuku_id());
            muatData();
            clear();
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
