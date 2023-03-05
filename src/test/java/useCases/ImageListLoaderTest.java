package useCases;

import fr.linuxdockerdesktop.core.stubs.FakeCommandRunnerAdapter;
import fr.linuxdockerdesktop.core.useCases.ImageListLoader;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class ImageListLoaderTest {

    @Test
    public void should_display_image_list() {
        var sut = new ImageListLoader(new FakeCommandRunnerAdapter());
        var output = sut.load();
        assertArrayEquals(output.get(0).toArray(), new String[]{"REPOSITORY", "TAG", "IMAGE ID" , "CREATED", "SIZE"});
        assertArrayEquals(output.get(1).toArray(), new String[]{"mysql", "latest", "43fcfca0776d", "5 months ago", "449MB"});
        assertArrayEquals(output.get(2).toArray(), new String[]{"hexagonal_app", "latest", "27a330b1ec16", "6 months ago", "304MB"});
        assertArrayEquals(output.get(3).toArray(), new String[]{"hexagonal_test", "latest","38bc8b782645", "6 months ago", "304MB"});
    }
}
