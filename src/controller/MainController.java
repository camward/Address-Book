package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

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

    public void showAdd(ActionEvent actionEvent){
        try {
            btnAdd.setText("Добавление...");

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