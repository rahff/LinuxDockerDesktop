package org.container.entities;


import org.core.entities.BaseTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ContainerTable extends BaseTable {
    private final int TABLE_SIZE = 7;
    private final int PORTS_INDEX = 5;
    public ContainerTable(){
        super();
    }

    public static ContainerTable factory(){
        return new ContainerTable();
    }

    @Override
    protected List<String> getColumn(List<String> data, int column) {
        var currentLine = data.get(column);
        var splitedLine = Arrays.stream(currentLine.split(SEPARATOR)).collect(Collectors.toList());
        return correctedLine(splitedLine);
    }

    private List<String> correctedLine(List<String> splitedLine) {
        if(portFieldNotPresent(splitedLine.size())){
            splitedLine.add(PORTS_INDEX, "");
        }
        return splitedLine;
    }

    private boolean portFieldNotPresent(int size) {
        return size < TABLE_SIZE;
    }
}
