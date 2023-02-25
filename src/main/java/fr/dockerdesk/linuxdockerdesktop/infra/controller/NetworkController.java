package fr.dockerdesk.linuxdockerdesktop.infra.controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.EntityLoader;


public class NetworkController extends  BaseController{
    public NetworkController(EntityLoader loader) {
        super(loader);
        this.loader = loader;
    }
}
