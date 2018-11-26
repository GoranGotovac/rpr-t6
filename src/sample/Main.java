package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MjestoRodjenjaModel modelMjestaRodjenja = new MjestoRodjenjaModel();
        modelMjestaRodjenja.dodajMjestoRodjenja();
        OdsjekModel model = new OdsjekModel();
        model.dodajOdsjek();
        StatusModel model2 = new StatusModel();
        model2.dodajStatus();
        StudijModel model3 = new StudijModel();
        model3.dodajStudij();
        CiklusModel model4 = new CiklusModel();
        model4.dodajCiklus();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(new Controller(modelMjestaRodjenja, model, model2,model3,model4));
        Parent root = loader.load();
        root.getStylesheets().add(getClass().getResource("izgled.css").toExternalForm());
        primaryStage.setTitle("Upis");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
