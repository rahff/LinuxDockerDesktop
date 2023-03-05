package fr.linuxdockerdesktop.core.useCases;

import fr.linuxdockerdesktop.core.entities.VolumeListTable;
import fr.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class VolumeListLoader extends EntityLoader {
    public VolumeListLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
        this.command = "docker volume ls";
        this.table = new VolumeListTable();
    }
}
