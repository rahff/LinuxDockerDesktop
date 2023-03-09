package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.services.ServiceLocator;
import org.core.api.Loader;

public class ImageController extends BaseController{

    public ImageController(){
        this.loader = ServiceLocator.getImageLoader();
    } //for FXMLLoader

}
