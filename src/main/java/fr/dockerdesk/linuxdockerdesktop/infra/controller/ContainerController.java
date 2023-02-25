package fr.dockerdesk.linuxdockerdesktop.infra.controller;


import fr.dockerdesk.linuxdockerdesktop.core.useCases.EntityLoader;


public class ContainerController extends BaseController{
    public ContainerController(EntityLoader loader){
        super(loader);
        this.loader = loader;
    }
}
