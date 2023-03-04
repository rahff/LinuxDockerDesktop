package fr.dockerdesk.linuxdockerdesktop.infra.views.components;



import javafx.scene.control.Button;
import javafx.scene.layout.*;


public class SideBar extends VBox {

    private final int NBR_ROW = 5;
    private GridPane gridPane;
    public SideBar() {
        super();
        this.setStyle("-fx-border-color: black; -fx-border-width: 0 2 0 2;-fx-background-color: #2C2C2C;");
        initGridPane();
        initRows();
        initButtons();
        this.getChildren().add(gridPane);
    }

    private void initGridPane() {
        gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setLayoutY(200.0);
        gridPane.setPrefHeight(400.0);
        gridPane.setPrefWidth(217.0);
        gridPane.add(new Logo(), 1, 0);
    }

    private void initButtons() {
        String[] buttonNames = {"Container", "Images", "Volumes", "Networks"};
        for (int i = 1; i < NBR_ROW; i++) {
            Button button = new SideBarButton(buttonNames[i-1]);
            gridPane.add(button, 1,  i);
        }

    }
    private void initRows() {
        for (int i = 0; i < NBR_ROW; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setMinHeight(10.0);
            rowConstraints.setPrefHeight(80.0);
            rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(rowConstraints);
        }

    }
}
