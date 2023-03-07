package services;


import fr.linuxdockerdesktop.infra.services.ServiceLocator;

import org.core.api.Loader;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceLocatorTest {

    @Test
    public void serviceLocator_should_use_ServiceLoader_to_get_services_implementation() {
        var sut = ServiceLocator.getInstance();
        var loader = sut.getImageLoader();
        assertTrue(loader instanceof Loader);
    }
}
