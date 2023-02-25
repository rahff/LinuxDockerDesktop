package fr.dockerdesk.linuxdockerdesktop.infra.controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.EntityLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ListViewObject;

public abstract class BaseController {

    protected EntityLoader loader;
    protected BaseController(EntityLoader loader){
        this.loader = loader;
    }


    public ListViewObject getViewObject() {
        var entityList = loader.load();
        return ListViewObject.from(entityList);
    }
}
