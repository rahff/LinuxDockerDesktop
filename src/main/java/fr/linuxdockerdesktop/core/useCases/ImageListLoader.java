package fr.linuxdockerdesktop.core.useCases;

import fr.linuxdockerdesktop.core.entities.ImageTable;
import fr.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;


public class ImageListLoader extends EntityLoader {

    public ImageListLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
        this.commandRunnerAdapter = commandRunnerAdapter;
        this.command = "docker images -a";
        this.table = new ImageTable();
    }
}
