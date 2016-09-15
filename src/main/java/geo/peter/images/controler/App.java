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

        JCustomFileChooser.addTo(panel, "Source");
        JCustomFileChooser.addTo(panel, "Destination");


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
