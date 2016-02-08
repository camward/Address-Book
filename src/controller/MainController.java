package controller;

import interfaces.impl.CollectionAdressBook;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.Person;

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
    private TableView tabBook;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private void initialize(){
        // для множественного выбора записей
        // tabBook.getSelectionModel().getSelectionMode(SelectionMode.MULTIPLE);

        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        addressBookImpl.fillTestData();
        tabBook.setItems(addressBookImpl.getPersonList());
    }

    private void updateCountLabel(){
        lblCount.setText("Количество записей: " + addressBookImpl.getPersonList().size());
    }

    public void showDialog(ActionEvent actionEvent){

        Object source = actionEvent.getSource();

        // если нажата не кнопка, то выходим из метода
        if(!(source instanceof Button)){
            return;
        }

        Button clickedButton = (Button)source;

        Person selectedPerson = (Person)tabBook.getSelectionModel().getSelectedItem();

        switch (clickedButton.getId()){
            case "btnAdd":
                System.out.println("add " + selectedPerson);
                break;

            case "btnEdit":
                System.out.println("edit " + selectedPerson);
                break;

            case "btnDelete":
                System.out.println("delete " + selectedPerson);
                break;
        }

        try {
            // btnAdd.setText("Добавление...");

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
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

}