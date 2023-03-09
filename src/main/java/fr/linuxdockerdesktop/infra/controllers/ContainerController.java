package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.services.ServiceLocator;


public class ContainerController extends BaseController {
    public ContainerController(){
        this.loader = ServiceLocator.getContainerLoader();
    }
}
