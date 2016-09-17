package geo.peter.images.controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;

/**
 * Hello world!
 *
 */
public class App
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

        JPanel actions = new JPanel();
        actions.setLayout(new FlowLayout());
        JButton move = new JButton("Move");
        JButton copy = new JButton("Copy");
        actions.add(move);
        actions.add(copy);
        panel.add(actions);

        move.addActionListener(new FileTransferActionListener(this.frame, this.source, this.destination, new Move()));
        copy.addActionListener(new FileTransferActionListener(this.frame, this.source, this.destination, new Copy()));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setLocation(dim.width/2-this.frame.getSize().width/2, dim.height/2-this.frame.getSize().height/2);


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
}
