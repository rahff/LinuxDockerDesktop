package fr.dockerdesk.linuxdockerdesktop.infra.views;


import fr.dockerdesk.linuxdockerdesktop.infra.views.components.Header;
import fr.dockerdesk.linuxdockerdesktop.infra.views.components.SideBar;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    public MainView() {
        this.init();
    }

    private void init() {
        this.setTop(new Header());
        this.setLeft(new SideBar());
    }

}
