package fr.linuxdockerdesktop.infra.controllers;

import org.core.api.Loader;

public class NetworkController extends  BaseController{
    public NetworkController(Loader loader) {
        super(loader);
        this.loader = loader;
    }

    public NetworkController(){} //for FXMLLoader
}
