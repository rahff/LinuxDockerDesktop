package fr.linuxdockerdesktop.infra.views.models;

import java.util.List;

public class ListViewObject {
    protected List<List<String>> entityList;

    protected ListViewObject(List<List<String>> entityList){
        this.entityList = entityList;
    }
    public List<String> getHeader() {
        return this.entityList.get(0);
    }

    public List<List<String>> getRowList() {
        return this.entityList.subList(1, entityList.size());
    }

    public static ListViewObject from(List<List<String>> entityList) {
        return new ListViewObject(entityList);
    }
}
