package geo.peter.images.controler;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private JFrame frame;
    private App()
    {
        this.frame = new JFrame("Images transfer");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        this.frame.getContentPane().add(panel);

        JPanel source = new JPanel();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        source.add(new JLabel("Source: "));
        source.add(chooser);

        JPanel destination = new JPanel();
        JFileChooser chooserdest = new JFileChooser();
        chooserdest.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        destination.add(new JLabel("Destination: "));
        destination.add(chooserdest);

        panel.add(source);
        panel.add(destination);

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
