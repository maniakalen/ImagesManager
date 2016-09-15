package geo.peter.images.controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by maniakalen on 14/09/2016.
 */
public class JCustomFileChooser
{
    private JPanel panel;
    private JTextField file;
    private JButton selector;

    public JCustomFileChooser(String label)
    {
        this.panel = new JPanel();
        this.file = new JTextField();
        this.file.setPreferredSize(new Dimension(140, 25));
        this.selector = new JButton("Browse");

        this.selector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame wdw = new Frame();
            }
        });
        panel.setLayout(new BorderLayout());
        JLabel l = new JLabel(label);
        l.setPreferredSize(new Dimension(80, 25));
        panel.add(l, BorderLayout.WEST);
        panel.add(this.file, BorderLayout.CENTER);
        panel.add(this.selector, BorderLayout.EAST);


    }
    public JPanel getFileChooser()
    {
        return this.panel;
    }
    public static void addTo(JComponent element, String label)
    {

        element.add((new JCustomFileChooser(label)).getFileChooser());
    }

    protected static class JFileChooserFrame
    {
        private JFileChooser chooser;
        public JFileChooserFrame()
        {
            JPanel panel = new JPanel();
            this.chooser = new JFileChooser();
            panel.add(chooser);
        }

        public JFileChooserFrame(int type)
        {
            this();
            this.chooser.setFileSelectionMode(type);
        }

        public static JFileChooserFrame getDirectoryChooser()
        {
            return new JFileChooserFrame(JFileChooser.DIRECTORIES_ONLY);
        }
    }
}
