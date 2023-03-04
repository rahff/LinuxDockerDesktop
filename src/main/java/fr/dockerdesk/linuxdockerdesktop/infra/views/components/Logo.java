package fr.dockerdesk.linuxdockerdesktop.infra.views.components;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

import java.io.File;

public class Logo extends ImageView {

    public Logo() {
        super();
        setAccessibleText("Logo");
        setFitHeight(71.0);
        setFitWidth(107.0);
        setPreserveRatio(true);
        VBox.setMargin(this, new Insets(0, 50.0, 0, 50.0));
        String filePath = new File("fr/dockerdesk/linuxdockerdesktop/css/logo.png").toURI().toString();
        System.out.println(filePath);
        Image image = new Image(filePath);
        setImage(image);
    }
}
