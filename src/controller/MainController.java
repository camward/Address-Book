package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public void showAdd(ActionEvent actionEvent){
        try {
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