package fr.dockerdesk.linuxdockerdesktop.infra.views.models;

import java.util.List;

public class ContainerListViewObject extends ListViewObject {

    private ContainerListViewObject(List<List<String>> containerList){
        super(containerList);
    }
    public static ContainerListViewObject from(List<List<String>> containerList) {
        return new ContainerListViewObject(containerList);
    }

}
