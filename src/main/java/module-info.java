module fr.dockerdesk.linuxdockerdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens fr.dockerdesk.linuxdockerdesktop to javafx.fxml;
    exports fr.dockerdesk.linuxdockerdesktop;
    exports fr.dockerdesk.linuxdockerdesktop.infra.controller;
    opens fr.dockerdesk.linuxdockerdesktop.infra.controller to javafx.fxml;
    exports fr.dockerdesk.linuxdockerdesktop.core.useCases;
    exports fr.dockerdesk.linuxdockerdesktop.core.ports.out;
}