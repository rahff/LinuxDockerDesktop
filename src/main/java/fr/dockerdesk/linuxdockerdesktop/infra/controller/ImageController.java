package fr.dockerdesk.linuxdockerdesktop.infra.controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.ImageListLoader;
import fr.dockerdesk.linuxdockerdesktop.infra.views.models.ImageListViewObject;

public class ImageController extends BaseController{

    public ImageController(ImageListLoader loader){
        super(loader);
        this.loader = loader;
    }
}
