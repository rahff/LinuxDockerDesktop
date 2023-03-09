package org.core.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseTable {
    protected final String SEPARATOR = "\\|";
    protected final String MORE_ONE_SPACE = "\\s{2,}";
    protected List<List<String>> content;

    protected BaseTable(){
        this.content = new ArrayList<>();
    }

    protected void parseCommandOutput(String commandOutput) {
        List<String> lines = getLines(commandOutput);
        addLinesToContent(lines);
    }

    private void addLinesToContent(List<String> lines) {
        var listLength = lines.size();
        for (int i = 0; i < listLength; i++) {
            this.content.add(getColumn(lines, i));
        }
    }

    protected List<String> getLines(String commandOutput) {
        return commandOutput.lines()
                .map((line)-> line.replaceAll(MORE_ONE_SPACE, SEPARATOR))
                .collect(Collectors.toList());
    }

    protected List<String> getColumn(List<String> data, int column) {
        return Arrays.stream(data.get(column).split(SEPARATOR)).collect(Collectors.toList());
    }

    public List<List<String>> getContent(String commandOutput) {
        this.content.clear();
        this.parseCommandOutput(commandOutput);
        return content;
    }
}
