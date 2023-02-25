package fr.dockerdesk.linuxdockerdesktop.core.useCases;

import fr.dockerdesk.linuxdockerdesktop.core.entities.VolumeListTable;
import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;



public class VolumeLoader extends EntityLoader {
    public VolumeLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
        this.command = "docker volume ls";
        this.table = new VolumeListTable();
    }
}
