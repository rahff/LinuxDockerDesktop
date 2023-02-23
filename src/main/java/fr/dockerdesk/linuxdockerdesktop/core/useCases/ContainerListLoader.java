package fr.dockerdesk.linuxdockerdesktop.core.useCases;

import fr.dockerdesk.linuxdockerdesktop.core.entities.ContainerTable;

import java.util.List;

public class ContainerListLoader {
    public List<List<String>> load() {
        String commandOutput = "CONTAINER ID   IMAGE                       COMMAND                  CREATED        STATUS                    PORTS     NAMES\n" +
                "3d310aa2644e   user_account_service_app    \"docker-entrypoint.s…\"   6 months ago   Exited (1) 6 months ago             user_account_service_app_1\n" +
                "f4f9ea95d2c7   mongo                       \"docker-entrypoint.s…\"   6 months ago   Exited (0) 6 months ago             user_account_service_mongodb_1\n" +
                "afba6e4ceb58   user_account_service_test   \"docker-entrypoint.s…\"   6 months ago   Exited (1) 6 months ago             user_account_service_test_1\n";

        return ContainerTable.from(commandOutput).getContent();
    }
}
