package useCases;

import fr.dockerdesk.linuxdockerdesktop.core.stubs.FakeCommandRunnerAdapter;
import fr.dockerdesk.linuxdockerdesktop.core.useCases.NetworkLoader;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class NetworkLoaderTest {
    @Test
    public void should_display_network_list(){
        var sut = new NetworkLoader(new FakeCommandRunnerAdapter());
        var output = sut.load();
        assertArrayEquals(output.get(0).toArray(), new String[]{"NETWORK ID", "NAME", "DRIVER", "SCOPE"});
        assertArrayEquals(output.get(1).toArray(), new String[]{"5dbb1ade7543", "bridge", "bridge", "local"});
        assertArrayEquals(output.get(2).toArray(), new String[]{"273a02c09f05", "host", "host", "local"});
        assertArrayEquals(output.get(3).toArray(), new String[]{"89cef1acafbc", "none", "null", "local"});
    }
}
