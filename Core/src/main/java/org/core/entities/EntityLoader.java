package org.core.entities;



import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;

import java.util.List;

public abstract class EntityLoader implements Loader {
    protected CommandRunnerAdapter commandRunnerAdapter;
    protected String command;
    public EntityLoader(CommandRunnerAdapter commandRunnerAdapter){
        this.commandRunnerAdapter = commandRunnerAdapter;
    }
    public EntityLoader(){}
    public List<List<String>> load() {
        var commandOutput = this.commandRunnerAdapter.run(command);
        return getTableContent(commandOutput);
    }

    protected abstract List<List<String>> getTableContent(String commandOutput);
}
