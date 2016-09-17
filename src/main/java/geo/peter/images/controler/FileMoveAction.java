package geo.peter.images.controler;

import java.nio.file.CopyOption;
import java.nio.file.Path;

interface FileMoveAction {
    void run(Path source, Path destination, CopyOption[] options);
    void run(Path source, Path destination);
}
