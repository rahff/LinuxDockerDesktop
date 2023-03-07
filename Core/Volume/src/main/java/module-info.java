import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;
import org.volume.api.VolumeListLoader;

module Volume {
    requires Core;
    provides Loader with VolumeListLoader;
    uses CommandRunnerAdapter;
}