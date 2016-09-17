package geo.peter.images.controler;

import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class FileTransporter extends SwingWorker<Boolean, Integer>
{
    private File[] source;
    private File destination;
    private FileMoveAction action;
    private JLabel prg;

    FileTransporter(File[] source, File destination, JLabel prg, FileMoveAction action)
    {
        super();
        this.prg = prg;
        this.source = source;
        this.destination = destination;
        this.action = action;
    }
    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            String dest = this.destination.toString();
            String destination;
            int progress = 0;
            setProgress(progress);
            for (File file : this.source) {
                destination = "";
                if (file.isFile()) {
                    Date date = new Date(file.lastModified());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH)+1;
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    destination += dest + File.separator + year + File.separator + month + File.separator + day;
                    File destDir = new File(destination);
                    if (!destDir.exists()) {
                        try{
                            if (!destDir.mkdirs()) {
                                continue;
                            }
                        } catch(SecurityException se){
                            se.printStackTrace(System.err);
                        }
                    }
                    destination += File.separator + file.getName();
                    this.action.run(file.toPath(), Paths.get(destination));
                    progress += 1;
                    setProgress(progress);
                    publish(progress);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        for (int number : chunks) {
            this.prg.setText(Integer.toString(number));
        }
    }
}
