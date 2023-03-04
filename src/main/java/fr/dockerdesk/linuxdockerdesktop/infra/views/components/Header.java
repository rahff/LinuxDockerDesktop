package fr.dockerdesk.linuxdockerdesktop.infra.views.components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class Header extends MenuBar {

    public Header() {
        this.getMenus().addAll(new Menu("File"), new Menu("options"));
    }
}
