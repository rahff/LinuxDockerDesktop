package fr.linuxdockerdesktop.infra.controllers;

import org.core.api.Loader;

public class ContainerController extends BaseController{
    public ContainerController(Loader loader){
        super(loader);
        this.loader = loader;
    }

    public ContainerController(){} //for FXMLLoader
}
