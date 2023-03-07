package fr.linuxdockerdesktop;


import fr.linuxdockerdesktop.infra.services.ServiceLocator;
import fr.linuxdockerdesktop.window.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        MainWindow.initializeAndGetInstance(serviceLocator).init();
    }
    public static void main(String[] args) {
        launch();
    }

}