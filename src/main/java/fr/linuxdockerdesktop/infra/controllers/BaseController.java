package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.events.OnLoadEvent;
import fr.linuxdockerdesktop.infra.views.ListViewObject;
import fr.linuxdockerdesktop.window.MainWindow;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.core.api.Loader;

import java.net.URL;
;
import java.util.ResourceBundle;

public abstract class BaseController implements Initializable {

    protected Loader loader;
    @FXML
    AnchorPane tablePane;

    protected static OnLoadEvent onLoadEvent;

    static {
        BaseController.onLoadEvent = new OnLoadEvent(new EventType<>("onLoad"));
    }

    protected BaseController(){} // for FXMLLoader

    protected ListViewObject getViewObject() {
        var entityList = loader.load();
        return ListViewObject.from(entityList);
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablePane.addEventHandler(onLoadEvent.getEventType(), event -> this.onLoad(event));
        tablePane.fireEvent(onLoadEvent);
    }
    public void changeView(ActionEvent event) {
        var clickedButton = (Button) event.getSource();
        var sceneName = clickedButton.getId();
        MainWindow.getInstance().changeScene(sceneName+".fxml");
    }
    private void onLoad(Event event) {
        var table = (AnchorPane) event.getSource();
        table.getChildren().clear();
        table.getChildren().add(getViewObject());
    }
}