package org.container.api;


import org.container.entities.ContainerTable;
import org.core.entities.EntityLoader;
import org.core.spi.CommandRunnerAdapter;

import java.util.ServiceLoader;


public class ContainerListLoader extends EntityLoader {

    public ContainerListLoader(){
        this.commandRunnerAdapter = ServiceLoader.load(CommandRunnerAdapter.class).findFirst().get();
        initTemplate();
    }
    public ContainerListLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        initTemplate();
    }
    private void initTemplate() {
        this.command = "docker ps -a";
        this.table = new ContainerTable();
    }
}
