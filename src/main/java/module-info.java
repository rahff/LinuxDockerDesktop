module fr.linuxdockerdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens fr.linuxdockerdesktop to javafx.fxml;
    exports fr.linuxdockerdesktop;
    opens fr.linuxdockerdesktop.infra.views to javafx.fxml;
    opens fr.linuxdockerdesktop.window to javafx.fxml;
    exports fr.linuxdockerdesktop.core.useCases;
    exports fr.linuxdockerdesktop.core.ports.out;
}