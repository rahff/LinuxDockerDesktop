package fr.dockerdesk.linuxdockerdesktop.infra.views.models;

import java.util.List;

public class ImageListViewObject extends ListViewObject {
    private ImageListViewObject(List<List<String>> containerList) {
        super(containerList);
    }

    public static ImageListViewObject from(List<List<String>> containerList) {
        return new ImageListViewObject(containerList);
    }
}
