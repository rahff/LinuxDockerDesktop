package useCasesTest;


import fr.dockerdesk.linuxdockerdesktop.core.useCases.ContainerListLoader;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class ContainerLoaderTest {

    @Test
    public void should_display_list_of_container() {
        ContainerListLoader loader = new ContainerListLoader();
        var output = loader.load();
        assertArrayEquals(output.toArray(), new String[][]{
                {"ID", "IMAGE","COMMAND", "CREATED" , "STATUS", "PORTS","NAMES"},
                {"3d310aa2644e",   "user_account_service_app",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (1) 6 months ago ", "user_account_service_app_1"},
                {"f4f9ea95d2c7",   "mongo",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (0) 6 months ago ", "user_account_service_mongodb_1"},
                {"afba6e4ceb58",   "user_account_service_test",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (1) 6 months ago ", "user_account_service_test_1"},
        });

    }

}
