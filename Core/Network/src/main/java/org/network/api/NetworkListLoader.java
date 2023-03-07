package org.network.api;


import org.network.entities.NetworkTable;
import org.core.entities.EntityLoader;
import org.core.spi.CommandRunnerAdapter;

import java.util.ServiceLoader;


public class NetworkListLoader extends EntityLoader {
    public NetworkListLoader(CommandRunnerAdapter commandRunnerAdapter){
        super(commandRunnerAdapter);
        this.init();
    }
    public NetworkListLoader(){
        this.commandRunnerAdapter = ServiceLoader.load(CommandRunnerAdapter.class).findFirst().get();
        this.init();
    }

    private void init() {
        this.command = "docker network list";
        this.table = new NetworkTable();
    }
}
