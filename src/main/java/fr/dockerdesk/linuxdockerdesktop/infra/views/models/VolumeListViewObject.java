package fr.dockerdesk.linuxdockerdesktop.infra.views.models;

import java.util.List;

public class VolumeListViewObject extends ListViewObject {
    protected VolumeListViewObject(List<List<String>> containerList) {
        super(containerList);
    }

    public static VolumeListViewObject from(List<List<String>> volumeList) {
        return new VolumeListViewObject(volumeList);
    }
}
