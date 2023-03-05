package fr.linuxdockerdesktop.core.useCases;

import fr.linuxdockerdesktop.core.entities.ContainerTable;
import fr.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class ContainerListLoader extends EntityLoader {
    public ContainerListLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        this.command = "docker ps -a";
        this.table = new ContainerTable();
    }
}
