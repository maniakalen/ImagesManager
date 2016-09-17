package geo.peter.images.controler;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;

class Copy implements FileMoveAction
{
    @Override
    public void run(Path source, Path destination, CopyOption[] options) {
        try {
            Files.copy(source, destination, options);
        } catch (IOException exception) {
            exception.printStackTrace(System.err);
        }
    }
    @Override
    public void run(Path source, Path destination) {
        try {
            Files.copy(source, destination);
        } catch (IOException exception) {
            exception.printStackTrace(System.err);
        }
    }
}
