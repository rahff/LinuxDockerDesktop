package useCases;

import fr.linuxdockerdesktop.core.stubs.FakeCommandRunnerAdapter;
import fr.linuxdockerdesktop.core.useCases.VolumeListLoader;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class VolumeLoaderTest {

    @Test
    public void should_display_volume_list() {
        var sut = new VolumeListLoader(new FakeCommandRunnerAdapter());
        var output = sut.load();
        assertArrayEquals(output.get(0).toArray(), new String[]{"DRIVER","VOLUME NAME"});
        assertArrayEquals(output.get(1).toArray(), new String[]{"local", "1a7af77bad3c29d791dd3387335547aadc79d7c9ee0081ffa47b231f9c358de9"});
        assertArrayEquals(output.get(2).toArray(), new String[]{"local", "1bf1908bf73a48e218f305b94cc07e59846beb5d093d076fcc964f828c5837d1"});
        assertArrayEquals(output.get(3).toArray(), new String[]{"local", "8f7e53b6033ac781dfd2e1a7c759fcf267760fb37421f6e798bd406cde377988"});
    }
}
