package fr.dockerdesk.linuxdockerdesktop.infra.views.models;

import java.util.List;

public class NetworkListViewObject extends ListViewObject {
    protected NetworkListViewObject(List<List<String>> containerList) {
        super(containerList);
    }

    public static NetworkListViewObject from(List<List<String>> networkList){
        return new NetworkListViewObject(networkList);
    }
}
