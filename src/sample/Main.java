package sample;

import controller.MainController;
import interfaces.impl.CollectionAdressBook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/main.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("locale.Locale", new Locale("en")));
        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle(fxmlLoader.getResources().getString("adres_book"));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(new Scene(fxmlMain, 300, 275));
        primaryStage.show();

        testData();
    }

    private void testData(){
        // CollectionAdressBook adressBook = new CollectionAdressBook();
        // adressBook.fillTestData();
        // adressBook.print();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
