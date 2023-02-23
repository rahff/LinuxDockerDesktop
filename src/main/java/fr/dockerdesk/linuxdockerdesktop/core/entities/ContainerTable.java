package fr.dockerdesk.linuxdockerdesktop.core.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Collectors;

public class ContainerTable {

    private final int TABLE_SIZE = 7;
    private List<List<String>> content;

    private ContainerTable(String commandOutput){
        this.content = new ArrayList<>();
        this.parseCommandOutput(commandOutput);
    }

    public static ContainerTable from(String commandOutput) {
        return new ContainerTable(commandOutput);
    }

    private void parseCommandOutput(String output) {
        List<String> outputLines = output.lines()
                .map((line)-> line.replaceAll("\\s{2,}", "|"))
                .collect(Collectors.toList());
        List<String> header = this.getTableHeader(outputLines);
        this.content.add(header);
        for (int i = 1; i < outputLines.size(); i++) {
            this.content.add(getTableColumn(outputLines, i));
        }
    }

    private List<String> getTableColumn(List<String> data, int column) {
        var currentLine = data.get(column);
        return Arrays.stream(currentLine.split("\\|")).collect(Collectors.toList());
    }

    private List<String> getTableHeader(List<String> data) {
       var currentLine = data.get(0);
       currentLine = currentLine.replaceAll("CONTAINER ID", "ID");
       return Arrays.stream(currentLine.split("\\|")).collect(Collectors.toList());

    }

    public List<List<String>> getContent() {
        return this.content;
    }
}
