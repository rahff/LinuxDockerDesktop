package fr.linuxdockerdesktop.core.useCases;

import fr.linuxdockerdesktop.core.entities.NetworkTable;
import fr.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class NetworkListLoader extends EntityLoader {
    public NetworkListLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        this.command = "docker network list";
        this.table = new NetworkTable();
    }
}
