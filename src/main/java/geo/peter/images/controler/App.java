package geo.peter.images.controler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

/**
 * Hello world!
 *
 */
public class App implements ActionListener
{
    private JFrame frame;
    private JCustomFileChooser source;
    private JCustomFileChooser destination;
    private App()
    {
        this.frame = new JFrame("Images transfer");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.frame.getContentPane().add(panel);

        this.source = JCustomFileChooser.addTo(panel, "Source");
        this.destination = JCustomFileChooser.addTo(panel, "Destination");
        JButton start = new JButton("Start");
        panel.add(start);

        start.addActionListener(this);

        this.frame.pack();
        this.frame.setVisible(true);
    }

    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new App();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog progressBar = new JDialog(this.frame);

        File sourceFile = this.source.getSelection();
        int count = sourceFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    String path = pathname.getAbsolutePath().toLowerCase();
                    return path.endsWith(".jpeg") || path.endsWith(".jpg");
                }
                return false;
            }
        }).length;
        if (count == 0) {
            JOptionPane.showMessageDialog(frame,
                    "No image files found",
                    "Files not found",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JPanel panel = new JPanel();
            JProgressBar progress = new JProgressBar(0, count);

            (new FileTransporter(this.source.getSelection(), this.destination.getSelection())).execute();

            progressBar.pack();
            progressBar.setVisible(true);
        }
    }
}
