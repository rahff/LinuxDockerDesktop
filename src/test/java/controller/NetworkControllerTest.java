package controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.NetworkLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.adapters.CommandRunner;

import fr.dockerdesk.linuxdockerdesktop.infra.controller.NetworkController;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ListViewObject;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.NetworkListViewObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class NetworkControllerTest {
    @Test
    public void should_build_NetworkListViewObjet_from_specific_loader_to_render_it_to_the_view() {
        var sut = new NetworkController(new NetworkLoader(new CommandRunner()));
        ListViewObject result = sut.getViewObject();
        assertEquals(List.of("NETWORK ID", "NAME", "DRIVER", "SCOPE"),
                result.getHeader());
        assertEquals(List.of("5dbb1ade7543", "bridge", "bridge", "local"),
                result.getRowList().get(0));
        assertEquals(List.of("273a02c09f05", "host", "host", "local"),
                result.getRowList().get(1));
        assertEquals(List.of("89cef1acafbc", "none", "null", "local"),
                result.getRowList().get(2));
    }
}
