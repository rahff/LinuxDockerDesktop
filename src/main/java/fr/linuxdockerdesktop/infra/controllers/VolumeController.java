package fr.linuxdockerdesktop.infra.controllers;

import org.core.api.Loader;

public class VolumeController extends BaseController{
    public VolumeController(Loader loader){
        super(loader);
        this.loader = loader;
    }

    public VolumeController(){} //for FXMLLoader
}
