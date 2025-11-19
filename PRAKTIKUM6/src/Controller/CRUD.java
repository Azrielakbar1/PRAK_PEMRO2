package Controller;

import Mahasiswa.Mahasiswa; 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CRUD implements Initializable{
	@FXML
    private TableView<Mahasiswa> tabelMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> kolomNim;

    @FXML
    private TableColumn<Mahasiswa, String> kolomNama;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kolomNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        
        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa(1, "John", "123"),       
                new Mahasiswa(2, "Jane", "123"),       
                new Mahasiswa(3, "Jono", "124123"), 
                new Mahasiswa(4, "Agus", "1241234"), 
                new Mahasiswa(5, "Prabobs", "34"), 
                new Mahasiswa(6, "Masanis", "35"), 
                new Mahasiswa(7, "Ganzzhar", "36"),
                new Mahasiswa(8, "Seahroni ", "38"), 
                new Mahasiswa(7, "Oeyakoeya", "39"), 
                new Mahasiswa(9, "Joqoewie", "40") 
            );
        tabelMahasiswa.setItems(data);
        }
}
