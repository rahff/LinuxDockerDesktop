import org.container.api.ContainerListLoader;
import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;

module Container {
    requires Core;
    provides Loader with ContainerListLoader;
    uses CommandRunnerAdapter;
}