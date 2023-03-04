package fr.dockerdesk.linuxdockerdesktop;


import fr.dockerdesk.linuxdockerdesktop.infra.views.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private MainView root = new MainView();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Linux Docker");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(1100);
        stage.setHeight(780);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}