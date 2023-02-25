package fr.dockerdesk.linuxdockerdesktop.core.stubs;

import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;

public class FakeCommandRunnerAdapter implements CommandRunnerAdapter {
    @Override
    public String run(String command) {
        switch (command) {
            case "docker ps -a":
                return "CONTAINER ID   IMAGE                       COMMAND                  CREATED        STATUS                    PORTS     NAMES\n" +
                        "3d310aa2644e   user_account_service_app    \"docker-entrypoint.s…\"   6 months ago   Exited (1) 6 months ago             user_account_service_app_1\n" +
                        "f4f9ea95d2c7   mongo                       \"docker-entrypoint.s…\"   6 months ago   Exited (0) 6 months ago             user_account_service_mongodb_1\n" +
                        "afba6e4ceb58   user_account_service_test   \"docker-entrypoint.s…\"   6 months ago   Exited (1) 6 months ago             user_account_service_test_1\n";

            case "docker images -a":
                return "REPOSITORY                                TAG            IMAGE ID       CREATED         SIZE\n" +
                        "mysql                                     latest         43fcfca0776d   5 months ago    449MB\n" +
                        "hexagonal_app                             latest         27a330b1ec16   6 months ago    304MB\n" +
                        "hexagonal_test                            latest         38bc8b782645   6 months ago    304MB\n";

            case "docker volume ls":
                return "DRIVER    VOLUME NAME\n" +
                        "local     1a7af77bad3c29d791dd3387335547aadc79d7c9ee0081ffa47b231f9c358de9\n" +
                        "local     1bf1908bf73a48e218f305b94cc07e59846beb5d093d076fcc964f828c5837d1\n" +
                        "local     8f7e53b6033ac781dfd2e1a7c759fcf267760fb37421f6e798bd406cde377988\n";

            case "docker network list":
                return "NETWORK ID     NAME      DRIVER    SCOPE\n" +
                        "5dbb1ade7543   bridge    bridge    local\n" +
                        "273a02c09f05   host      host      local\n" +
                        "89cef1acafbc   none      null      local";

                default: throw new RuntimeException("unknown command");
        }

    }
}
