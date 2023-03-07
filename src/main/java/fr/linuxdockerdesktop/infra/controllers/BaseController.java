package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.views.ListViewObject;
import fr.linuxdockerdesktop.window.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.core.api.Loader;

public abstract class BaseController {
    protected Loader loader;
    @FXML
    protected Pane tableBox;
    protected static MainWindow window;
    protected BaseController(Loader loader){
        this.window = MainWindow.getInstance();
        this.loader = loader;
    }
    protected BaseController(){} // for FXMLLoader

    protected ListViewObject getViewObject() {
        var entityList = loader.load();
        return ListViewObject.from(entityList);
    }

    public void changeView(ActionEvent event){
        var clickedButton = (Button) event.getSource();
        var sceneName = clickedButton.getId();
        this.window.changeScene(sceneName+".fxml");
    }
}