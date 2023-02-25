package fr.dockerdesk.linuxdockerdesktop.infra.controller;

import fr.dockerdesk.linuxdockerdesktop.core.useCases.EntityLoader;


public class VolumeController extends BaseController{
    public VolumeController(EntityLoader loader){
        super(loader);
        this.loader = loader;
    }
}
