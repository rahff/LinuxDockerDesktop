package fr.linuxdockerdesktop.infra.services;

import org.core.api.Loader;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class ServiceLocator {

    private static ServiceLocator instance;
    private List<Loader> loaders;

    private ServiceLocator(){
        getLoaders();
    }

    public static ServiceLocator getInstance() {
        if(ServiceLocator.instance == null){
            ServiceLocator.instance = new ServiceLocator();
        }
        return instance;
    }
    public Loader getContainerLoader() {
       return loaders.stream()
               .filter((loader) -> loader.getClass().toString().contains("ContainerListLoader"))
               .findFirst().get();
    }
    public Loader getVolumeLoader() {
       return loaders.stream()
               .filter((loader) -> loader.getClass().toString().contains("VolumeListLoader"))
               .findFirst().get();
    }
    public Loader getNetworkLoader() {
       return loaders.stream()
               .filter((loader) -> loader.getClass().toString().contains("NetworkListLoader"))
               .findFirst().get();
    }
    public Loader getImageLoader() {
       return loaders.stream()
               .filter((loader) -> loader.getClass().toString().contains("ImageListLoader"))
               .findFirst().get();
    }

    private void getLoaders() {
        this.loaders = ServiceLoader.load(Loader.class).stream().map(loaderProvider -> loaderProvider.get()).collect(Collectors.toList());
    }

}
