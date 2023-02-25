package fr.dockerdesk.linuxdockerdesktop.core.useCases;

import fr.dockerdesk.linuxdockerdesktop.core.entities.ImageTable;
import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class ImageListLoader extends EntityLoader {

    public ImageListLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
        this.commandRunnerAdapter = commandRunnerAdapter;
        this.command = "docker images -a";
        this.table = new ImageTable();
    }
}
