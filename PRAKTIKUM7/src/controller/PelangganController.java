package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pelanggan;
import service.PelangganService;
import javafx.scene.control.Alert;

public class PelangganController implements Initializable{
	@FXML private TextField txtNamaPelanggan; 
    @FXML private TextField txtEmailPelanggan;
    @FXML private TextField txtTeleponPelanggan;
    
    @FXML private TableView<Pelanggan> tabelPelanggan;
    @FXML private TableColumn<Pelanggan, String> kolNamaPelanggan;
    @FXML private TableColumn<Pelanggan, String> kolEmailPelanggan;
    @FXML private TableColumn<Pelanggan, String> kolTeleponPelanggan;

    @FXML private Button btnTambahPelanggan;
    @FXML private Button btnEditPelanggan;
    @FXML private Button btnHapusPelanggan;
    
    private PelangganService service = new PelangganService();
    private Pelanggan pelangganPilih;
    
    @Override 
    public void initialize(URL location, ResourceBundle resources) {
    	kolNamaPelanggan.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolEmailPelanggan.setCellValueFactory(new PropertyValueFactory<>("email"));
        kolTeleponPelanggan.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        
        muatData();
        
        tabelPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                pelangganPilih = newVal;
                txtNamaPelanggan.setText(newVal.getNama());
                txtEmailPelanggan.setText(newVal.getEmail());
                txtTeleponPelanggan.setText(newVal.getTelepon());
            }
        });
    }
    
    private void muatData() {
        tabelPelanggan.setItems(service.getAll());
    }
    
    private void clear() {
        txtNamaPelanggan.clear();
        txtEmailPelanggan.clear();
        txtTeleponPelanggan.clear();
        pelangganPilih = null;
    }
    
    @FXML
    private void aksiTambahPelanggan() {
        try {
            Pelanggan p = new Pelanggan(
                txtNamaPelanggan.getText(),
                txtEmailPelanggan.getText(),
                txtTeleponPelanggan.getText()
            );
            service.tambah(p);
            muatData();
            clear();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil disimpan!");
        } catch (Exception e) {
        	showAlert(Alert.AlertType.ERROR, "Proses Gagal", e.getMessage());
        }
    }
    
    @FXML
    private void aksiEditPelanggan() {
        if (pelangganPilih != null) {
        	try {
            pelangganPilih.setNama(txtNamaPelanggan.getText());
            pelangganPilih.setEmail(txtEmailPelanggan.getText());
            pelangganPilih.setTelepon(txtTeleponPelanggan.getText());
            
            service.update(pelangganPilih);
            muatData();
            clear();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data Berhasil Diupdate!");
            } catch (Exception e) {
            	showAlert(Alert.AlertType.ERROR, "Proses Update Gagal. Coba Lagi", e.getMessage());
            }
        } else {
        	showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data dulu yang ingin diedit!");
        }
    }
    
    @FXML
    private void aksiHapusPelanggan() {
        if (pelangganPilih != null) {
            service.hapus(pelangganPilih.getPelanggan_id());
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
