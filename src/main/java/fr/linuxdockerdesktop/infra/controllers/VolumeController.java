package fr.linuxdockerdesktop.infra.controllers;

import fr.linuxdockerdesktop.infra.services.ServiceLocator;

public class VolumeController extends BaseController {

    public VolumeController(){
        this.loader = ServiceLocator.getVolumeLoader();
    } //for FXMLLoader
}
