package sample;

import interfaces.impl.CollectionAdressBook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Person;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Адресная книга");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        testData();
    }

    private void testData(){
        CollectionAdressBook adressBook = new CollectionAdressBook();

        Person person = new Person();
        person.setFio("fio1");
        person.setPhone("12345");

        Person person2 = new Person();
        person2.setFio("fio2");
        person2.setPhone("67890");

        adressBook.add(person);
        adressBook.add(person2);

        person.setPhone("8-800-555-555");

        adressBook.delete(person);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
