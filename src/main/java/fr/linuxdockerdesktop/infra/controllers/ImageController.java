package fr.linuxdockerdesktop.infra.controllers;

import org.core.api.Loader;

public class ImageController extends BaseController{

    public ImageController(Loader loader){
        super(loader);
        this.loader = loader;
    }

    public ImageController(){} //for FXMLLoader
}
