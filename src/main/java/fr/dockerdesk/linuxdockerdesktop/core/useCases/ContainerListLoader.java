package fr.dockerdesk.linuxdockerdesktop.core.useCases;

import fr.dockerdesk.linuxdockerdesktop.core.entities.ContainerTable;
import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;



public class ContainerListLoader extends EntityLoader {
    public ContainerListLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        this.command = "docker ps -a";
        this.table = new ContainerTable();
    }
}
