package adapters;



import fr.linuxdockerdesktop.infra.adapters.CommandRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandRunnerAdapterTest {

    @Test
    public void should_get_output_of_command() {
        var sut = new CommandRunner();
        var dockerPs_aOutput = sut.run("docker container ls -a");
        assertEquals(dockerPs_aOutput.trim(), "CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES");
        var dockerImagesLsOutput = sut.run("docker image list -a");
        assertEquals(dockerImagesLsOutput.trim(), "REPOSITORY   TAG       IMAGE ID   CREATED   SIZE");
    }
}
