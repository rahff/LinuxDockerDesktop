package controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.ContainerListLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.adapters.CommandRunner;
import fr.dockerdesk.linuxdockerdesktop.infra.controller.ContainerController;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ContainerListViewObject;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ListViewObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContainerControllerTest {

    @Test
    public void should_build_containerListViewObjet_from_specific_loader_to_render_it_to_the_view() {
        var sut = new ContainerController(new ContainerListLoader(new CommandRunner()));
        ListViewObject containerListViewObject = sut.getViewObject();
        assertEquals(List.of("CONTAINER ID", "IMAGE", "COMMAND", "CREATED", "STATUS", "PORTS", "NAMES"),
                containerListViewObject.getHeader());
        assertEquals(new ArrayList<List<String>>(),
                containerListViewObject.getRowList());
    }
}
