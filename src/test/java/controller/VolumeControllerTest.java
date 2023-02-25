package controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.VolumeLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.adapters.CommandRunner;
import fr.dockerdesk.linuxdockerdesktop.infra.controller.VolumeController;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ListViewObject;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.VolumeListViewObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VolumeControllerTest {
    @Test
    public void should_build_VolumeListViewObjet_from_specific_loader_to_render_it_to_the_view() {
        var sut = new VolumeController(new VolumeLoader(new CommandRunner()));
        ListViewObject result = sut.getViewObject();
        assertEquals(List.of("DRIVER", "VOLUME NAME"),
                result.getHeader());
        assertEquals(List.of("local", "1a7af77bad3c29d791dd3387335547aadc79d7c9ee0081ffa47b231f9c358de9"),
                result.getRowList().get(0));
        assertEquals(List.of("local", "9c40f6c6866ea914bc577b0dea66eaa1a087d0b3e7cca16b6e70609657d39f21"),
                result.getRowList().get(3));
        assertEquals(List.of("local", "hexagonal_mongodb_data"),
                result.getRowList().get(8));
    }
}
