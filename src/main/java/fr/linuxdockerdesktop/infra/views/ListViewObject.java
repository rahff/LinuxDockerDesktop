package fr.linuxdockerdesktop.infra.views;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.util.List;


public class ListViewObject extends TableView {
    protected List<List<String>> entityList;
    protected ListViewObject(List<List<String>> entityList){
        this.entityList = entityList;
        this.initColumn(getHeader());
        this.initRows(getRowList());
        setLayoutProperties();
    }

    private void setLayoutProperties() {
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void initColumn(List<String> data) {
        var columnList = FXCollections.observableArrayList();
        var limit = data.size();
        for (int i = 0; i < limit; i++) {
            var columnName = data.get(i);
            var column = new TableColumn<List<String>, String>(columnName);
            final int columnIndex = i;
            column.setCellValueFactory(cellData -> {
                var list = cellData.getValue();
                return new SimpleStringProperty(list.get(columnIndex));
            });
            columnList.add(column);
        }
        this.getColumns().addAll(columnList);
    }
    private void initRows(List<List<String>> data) {
        data.stream().map(list -> FXCollections.observableArrayList(list)).forEach((text) -> this.getItems().add(text));

    }
    public List<String> getHeader() {
        return this.entityList.get(0);
    }

    public List<List<String>> getRowList() {
        return this.entityList.subList(1, entityList.size());
    }

    public static ListViewObject from(List<List<String>> entityList) {
        return new ListViewObject(entityList);
    }
}
