package controller;

import interfaces.impl.CollectionAdressBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.Person;

import javax.swing.text.TableView;
import java.io.IOException;

public class MainController {

    private CollectionAdressBook addressBookImpl = new CollectionAdressBook();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSrch;

    @FXML
    private TextField txtSrch;

    @FXML
    private Label lblCount;

    @FXML
    private TableView tabBook2;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private void initialize(){
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        addressBookImpl.fillTestData();

        // tabBook.setItems(addressBookImpl.getPersonList());

        updateCountLabel();
    }

    private void updateCountLabel(){
        lblCount.setText("Количество записей: " + addressBookImpl.getPersonList().size());
    }

    public void showAdd(ActionEvent actionEvent){
        try {
            // btnAdd.setText("Добавление...");

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/add.fxml"));
            stage.setTitle("Добавить запись");
            stage.setMinHeight(150);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEdit(ActionEvent actionEvent){
        System.out.println("update");
    }

    public void showDelete(ActionEvent actionEvent){
        System.out.println("delete");
    }
}