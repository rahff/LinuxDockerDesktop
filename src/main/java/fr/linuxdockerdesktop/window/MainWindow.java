package fr.linuxdockerdesktop.window;

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
    private String mainViewName = "root.fxml";

    private String title = "Linux Docker";
    private Stage stage;
    private MainWindow() {
        this.loader  = new FXMLLoader();
        this.stage = new Stage();
    }

    public static MainWindow getInstance() {
        if(MainWindow.instance == null){
            MainWindow.instance = new MainWindow();
            return MainWindow.instance;
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
        Scene currentScene = new Scene(root);
        stage.setScene(currentScene);
        stage.show();
        stage.setX(stage.getX());
    }

    public void changeScene(String sceneName) {
        try{
            this.loadScene(sceneName);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}