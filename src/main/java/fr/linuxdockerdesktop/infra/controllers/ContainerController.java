package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.services.ServiceLocator;
import org.core.api.Loader;


public class ContainerController extends BaseController {


    public ContainerController(){
        this.loader = ServiceLocator.getContainerLoader();
    } //for FXMLLoader


}
