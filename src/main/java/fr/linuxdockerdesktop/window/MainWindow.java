package fr.linuxdockerdesktop.window;

import fr.linuxdockerdesktop.infra.controllers.*;
import fr.linuxdockerdesktop.infra.services.ServiceLocator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


import java.io.IOException;

public class MainWindow {
    private static MainWindow instance;
    private FXMLLoader loader;
    private String baseResourcesPath = "/fr/linuxdockerdesktop/";
    private String mainViewName = "container.fxml";
    private String title = "Linux Docker";
    private Stage stage;
    private ServiceLocator serviceLocator;
    private MainWindow(ServiceLocator serviceLocator) {
        this.loader  = new FXMLLoader();
        this.stage = new Stage();
        this.serviceLocator = serviceLocator;
    }
    public static MainWindow initializeAndGetInstance(ServiceLocator serviceLocator) {
        if(MainWindow.instance == null){
            MainWindow.instance = new MainWindow(serviceLocator);
            return MainWindow.instance;
        }
        return MainWindow.instance;
    }
    public static MainWindow getInstance() {
        if(MainWindow.instance == null){
            throw new RuntimeException("MainWindows instance must be initialize");
        }
        return MainWindow.instance;
    }
    public void init() throws Exception{
        initStage();
        loadScene(mainViewName);
    }

    private void initStage() {
        Screen screen = Screen.getPrimary();
        var screenSize = screen.getVisualBounds();
        stage.setTitle(title);
        stage.setWidth(screenSize.getWidth());
        stage.setHeight(screenSize.getHeight());
    }

    private void loadScene(String sceneName) throws IOException {
        Parent root = loader.load(getClass().getResource(baseResourcesPath+sceneName));
        loader.setController(getSceneController(sceneName));
        Scene currentScene = new Scene(root);
        stage.setScene(currentScene);
        stage.show();
        stage.setX(stage.getX());
    }

    private BaseController getSceneController(String sceneName) {
       switch (sceneName){
           case "container.fxml":
               return new ContainerController(serviceLocator.getContainerLoader());
           case "image.fxml":
               return new ImageController(serviceLocator.getImageLoader());
           case "volume.fxml":
               return new VolumeController(serviceLocator.getVolumeLoader());
           case "network.fxml":
               return new NetworkController(serviceLocator.getNetworkLoader());

           default: throw new RuntimeException("there is no controller for this view");
       }
    }

    public void changeScene(String sceneName) {
        try{
            this.loadScene(sceneName);
        }catch (Exception e) {
            System.out.println("error occured: " + e.getMessage());
            System.exit(1);
        }
    }
}