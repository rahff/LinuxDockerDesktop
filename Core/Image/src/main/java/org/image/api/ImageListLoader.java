package org.image.api;


import org.core.entities.EntityLoader;
import org.core.spi.CommandRunnerAdapter;
import org.image.entities.ImageTable;

import java.util.ServiceLoader;

public class ImageListLoader extends EntityLoader {

    public ImageListLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
        this.commandRunnerAdapter = commandRunnerAdapter;
        this.init();
    }

    public ImageListLoader(){
        this.commandRunnerAdapter = ServiceLoader.load(CommandRunnerAdapter.class).findFirst().get();
        this.init();
    }

    private void init() {
        this.command = "docker images -a";
        this.table = new ImageTable();
    }
}
