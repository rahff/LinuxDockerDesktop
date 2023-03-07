package org.volume.api;


import org.core.entities.EntityLoader;
import org.core.spi.CommandRunnerAdapter;
import org.volume.entities.VolumeListTable;

import java.util.ServiceLoader;

public class VolumeListLoader extends EntityLoader {
    public VolumeListLoader(CommandRunnerAdapter commandRunnerAdapter) {
        super(commandRunnerAdapter);
       this.init();
    }

    public VolumeListLoader() {
        this.commandRunnerAdapter = ServiceLoader.load(CommandRunnerAdapter.class).findFirst().get();
        this.init();
    }

    private void init() {
        this.command = "docker volume ls";
        this.table = new VolumeListTable();
    }
}
