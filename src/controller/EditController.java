package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Person;

public class EditController {
    private Person person;

    @FXML
    private Button addOk;

    @FXML
    private Button addCancel;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblName;


    public void actionClose(ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void setPerson(Person person) {
        if(person == null){
            return;
        }
        this.person = person;
        txtName.setText(person.getFio());
        txtPhone.setText(person.getPhone());
    }

    public Person getPerson(){
        return person;
    }

    public void actionSave(ActionEvent actionEvent){
        person.setPhone(txtPhone.getText());
        person.setFio(txtName.getText());
        actionClose(actionEvent);
    }
}
