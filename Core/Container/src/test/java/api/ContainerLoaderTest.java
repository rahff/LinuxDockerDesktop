package api;


import org.container.api.ContainerListLoader;
import org.core.stubs.FakeCommandRunnerAdapter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ContainerLoaderTest {

    @Test
    public void should_display_list_of_container() {
        ContainerListLoader loader = new ContainerListLoader(new FakeCommandRunnerAdapter());
        var output = loader.load();
        assertArrayEquals(output.get(0).toArray(), new String[]{"CONTAINER ID", "IMAGE", "COMMAND", "CREATED" , "STATUS", "PORTS", "NAMES"});
        assertArrayEquals(output.get(1).toArray(), new String[]{"3d310aa2644e",   "user_account_service_app",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (1) 6 months ago", "", "user_account_service_app_1"});
        assertArrayEquals(output.get(2).toArray(), new String[]{"f4f9ea95d2c7",   "mongo",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (0) 6 months ago", "", "user_account_service_mongodb_1"});
        assertArrayEquals(output.get(3).toArray(), new String[]{"afba6e4ceb58",   "user_account_service_test",  "\"docker-entrypoint.s…\"",  "6 months ago",   "Exited (1) 6 months ago", "", "user_account_service_test_1"});
    }
}
