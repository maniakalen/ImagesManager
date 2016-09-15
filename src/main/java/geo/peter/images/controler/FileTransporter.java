package geo.peter.images.controler;

import javax.swing.*;
import java.io.File;

/**
 * Created by maniakalen on 15/09/2016.
 */
public class FileTransporter extends SwingWorker<Boolean, Integer>
{
    private File source;
    private File destination;
    public FileTransporter(File source, File destination)
    {
        super();
        this.source = source;
        this.destination = destination;
    }
    @Override
    protected Boolean doInBackground() throws Exception {
        return null;
    }
}
