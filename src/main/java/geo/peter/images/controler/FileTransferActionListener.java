package geo.peter.images.controler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;

class FileTransferActionListener implements ActionListener
{
    private JFrame frame;
    private JCustomFileChooser source;
    private JCustomFileChooser destination;
    private FileMoveAction action;

    FileTransferActionListener(JFrame frame, JCustomFileChooser source, JCustomFileChooser dest, FileMoveAction action)
    {
        this.frame = frame;
        this.source = source;
        this.destination = dest;
        this.action = action;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog progressBar = new JDialog(this.frame);
        progressBar.setLocationRelativeTo(null);
        try {
            File sourceFile = this.source.getSelection();
            FileFilter images = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isFile()) {
                        String path = pathname.getAbsolutePath().toLowerCase();
                        return path.endsWith(".jpeg") || path.endsWith(".jpg") || path.endsWith(".mov") || path.endsWith(".mp4");
                    }
                    return false;
                }
            };
            File[] files = sourceFile.listFiles(images);
            if (files == null) throw new NullPointerException();
            int count = files.length;
            if (count == 0) {
                JOptionPane.showMessageDialog(frame,
                        "No image files found",
                        "Files not found",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                JProgressBar progress = new JProgressBar(0, count);
                JLabel prg = new JLabel("0");
                panel.add(progress);
                panel.add(prg);
                progressBar.add(panel);
                FileTransporter transporter = new FileTransporter(files, this.destination.getSelection(), prg, this.action);
                transporter.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equals(evt.getPropertyName())) {
                            progress.setValue((Integer) evt.getNewValue());
                        }
                    }
                });
                transporter.execute();

                progressBar.pack();
                progressBar.setVisible(true);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
