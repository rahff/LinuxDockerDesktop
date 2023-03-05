package fr.linuxdockerdesktop.infra.views;


import fr.linuxdockerdesktop.core.ports.in.Loader;
import fr.linuxdockerdesktop.core.useCases.ContainerListLoader;
import fr.linuxdockerdesktop.core.useCases.ImageListLoader;
import fr.linuxdockerdesktop.core.useCases.NetworkListLoader;
import fr.linuxdockerdesktop.core.useCases.VolumeListLoader;
import fr.linuxdockerdesktop.infra.adapters.CommandRunner;
import fr.linuxdockerdesktop.infra.views.models.ListViewObject;
import fr.linuxdockerdesktop.window.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class MainView {

    @FXML
    private Pane tableBox;
    private MainWindow window;

    private Router router;
    private Loader loader;

    public MainView() {
        this.window = MainWindow.getInstance();
        this.router = new Router();
        this.loader = new ContainerListLoader(new CommandRunner());
    }

    public void changeContext(ActionEvent event) {
        var clickedRouterLink = (Button) event.getSource();
        var buttonName = clickedRouterLink.getId();
        System.out.println(buttonName);
        switch (buttonName) {
            case "containerRouterLink":
                routeTo(ROUTER_STATE.CONTAINER);
                break;
            case "imageRouterLink":
                routeTo(ROUTER_STATE.IMAGE);
                break;
            case "volumeRouterLink":
                routeTo(ROUTER_STATE.VOLUME);
                break;
            case "networkRouterLink":
                routeTo(ROUTER_STATE.NETWORK);
                break;
            default: throw new RuntimeException("route not found");
        }
    }

    private void routeTo(ROUTER_STATE to) {
        if(router.state == to) return;
        this.loader = getLoader(to);
        this.buildTable();
        router.state = to;
    }

    private void buildTable(){
        tableBox.getChildren().clear();
        var tableContent = ListViewObject.from(loader.load());
        var table = new TableView();
        System.out.println(tableContent.getRowList());
        table.setMinWidth(this.tableBox.getPrefWidth());
        table.setMinHeight(this.tableBox.getPrefHeight());
        table.getColumns().addAll(getTableColumn(tableContent.getHeader()));
        table.getItems().addAll(getTableRowItems(tableContent.getRowList()));
        this.tableBox.getChildren().add(table);
    }

    private List<TableRow> getTableRowItems(List<List<String>> tableContent) {
        var rowList = new ArrayList<TableRow>();
        if (tableContent.size() == 0) return  rowList;
        for (int i = 0; i < tableContent.size(); i++) {
            var row = new TableRow();
            rowList.add(row);
        }
        return rowList;
    }

    private List<TableColumn> getTableColumn(List<String> tableContent) {
        var columnList = new ArrayList<TableColumn>();
        for (int i = 0; i < tableContent.size(); i++) {
            var column = new TableColumn<>(tableContent.get(i));
            columnList.add(column);
        }
        return columnList;
    }

    private Loader getLoader(ROUTER_STATE neededLoader) {
        switch (neededLoader) {
            case CONTAINER:
                return new ContainerListLoader(new CommandRunner());
            case IMAGE:
                return new ImageListLoader(new CommandRunner());
            case VOLUME:
                return new VolumeListLoader(new CommandRunner());
            case NETWORK:
                return new NetworkListLoader(new CommandRunner());

            default: throw new RuntimeException("loader not found");
        }
    }

    private class Router {
        public ROUTER_STATE state = ROUTER_STATE.CONTAINER;
    }

    private enum ROUTER_STATE {
        CONTAINER,IMAGE,VOLUME,NETWORK
    }

}
