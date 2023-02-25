package fr.dockerdesk.linuxdockerdesktop.core.useCases;

import fr.dockerdesk.linuxdockerdesktop.core.entities.NetworkTable;
import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class NetworkLoader extends EntityLoader {
    public NetworkLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        this.command = "docker network list";
        this.table = new NetworkTable();
    }
}
