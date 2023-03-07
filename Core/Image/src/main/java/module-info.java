import org.core.api.Loader;
import org.core.spi.CommandRunnerAdapter;
import org.image.api.ImageListLoader;

module Image {
    requires Core;
    provides Loader with ImageListLoader;
    uses CommandRunnerAdapter;
}