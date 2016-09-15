package geo.peter.images.controler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by maniakalen on 14/09/2016.
 */
public class JCustomFileChooser
{
    private JPanel panel;
    private JTextField file;
    private JButton selector;

    public JCustomFileChooser()
    {
        this.panel = new JPanel();
        this.file = new JTextField();
        this.selector = new JButton() {

        };

        panel.setLayout(new BorderLayout());
        panel.add(this.file, BorderLayout.CENTER);
        panel.add(this.selector, BorderLayout.CENTER);


    }

    public void addTo(JComponent element)
    {
        element.add(this.panel);
    }
}
