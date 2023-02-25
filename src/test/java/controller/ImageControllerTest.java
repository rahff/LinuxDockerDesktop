package controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.ImageListLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.adapters.CommandRunner;
import fr.dockerdesk.linuxdockerdesktop.infra.controller.ImageController;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ImageListViewObject;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ListViewObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ImageControllerTest {
    @Test
    public void should_build_ImageListViewObjet_from_specific_loader_to_render_it_to_the_view() {
        var sut = new ImageController(new ImageListLoader(new CommandRunner()));
        ListViewObject imageListViewObject = sut.getViewObject();
        assertEquals(List.of("REPOSITORY", "TAG", "IMAGE ID", "CREATED", "SIZE"),
                imageListViewObject.getHeader());
        assertEquals(new ArrayList<List<String>>(),
                imageListViewObject.getRowList());
    }
}
