package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.services.ServiceLocator;
import org.core.api.Loader;


public class NetworkController extends  BaseController {

    public NetworkController(){
        this.loader = ServiceLocator.getNetworkLoader();
    }

}
