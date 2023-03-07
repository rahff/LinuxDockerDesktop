import org.network.api.NetworkListLoader;
import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;

module Network {
    requires Core;
    provides Loader with NetworkListLoader;
    uses CommandRunnerAdapter;
}