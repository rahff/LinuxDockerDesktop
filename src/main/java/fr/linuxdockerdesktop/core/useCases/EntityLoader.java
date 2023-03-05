package fr.linuxdockerdesktop.core.useCases;

import fr.linuxdockerdesktop.core.entities.BaseTable;
import fr.linuxdockerdesktop.core.ports.in.Loader;
import fr.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;

import java.util.List;

public abstract class EntityLoader implements Loader {

    protected CommandRunnerAdapter commandRunnerAdapter;
    protected BaseTable table;

    protected String command;
    public EntityLoader(CommandRunnerAdapter commandRunnerAdapter){
        this.commandRunnerAdapter = commandRunnerAdapter;
    }
    public List<List<String>> load() {
        var commandOutput = this.commandRunnerAdapter.run(command);
        return table.getContent(commandOutput);
    }
}
