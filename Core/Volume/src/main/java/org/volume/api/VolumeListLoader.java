package org.volume.api;


import org.core.entities.EntityLoader;
import org.core.spi.CommandRunnerAdapter;
import org.volume.entities.VolumeListTable;

import java.util.List;
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
    }
    protected List<List<String>> getTableContent(String commandOutput) {
        return VolumeListTable.factory().getContent(commandOutput);
    }

}
