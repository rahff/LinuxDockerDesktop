package fr.dockerdesk.linuxdockerdesktop.infra.views.components;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SideBarButton extends Button {
    
    public SideBarButton(String text) {
        this.setStyle("-fx-focus-color: red;");
        this.setAlignment(javafx.geometry.Pos.CENTER);
        this.setMnemonicParsing(false);
        this.setPrefHeight(41.0);
        this.setPrefWidth(217.0);
        this.setText(text);
        this.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        this.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        Font font1 = new Font("Dyuthi Regular", 18.0);
        this.setFont(font1);
        Insets insets1 = new Insets(5.0, 0.0, 5.0, 0.0);
        this.setPadding(insets1);
        Cursor cursor1 = Cursor.HAND;
        this.setCursor(cursor1);
    }
}
