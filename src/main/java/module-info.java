import fr.linuxdockerdesktop.infra.adapters.CommandRunner;
import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;

module fr.linuxdockerdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires Core;
    requires Container;
    requires Volume;
    requires Network;
    requires Image;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens fr.linuxdockerdesktop to javafx.fxml;
    exports fr.linuxdockerdesktop;
    opens fr.linuxdockerdesktop.infra.controllers to javafx.fxml;
    opens fr.linuxdockerdesktop.window to javafx.fxml;
    provides CommandRunnerAdapter with CommandRunner;
    uses Loader;
}