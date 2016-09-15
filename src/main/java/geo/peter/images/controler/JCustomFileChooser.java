package geo.peter.images.controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by maniakalen on 14/09/2016.
 */
public class JCustomFileChooser implements ActionListener
{
    private JPanel panel;
    private JTextField file;
    private JFrame parent;
    private File selection;
    public JCustomFileChooser(String label, JFrame parent)
    {
        this.panel = new JPanel();
        this.file = new JTextField();
        this.file.setPreferredSize(new Dimension(140, 25));
        JButton selector = new JButton("Browse");
        selector.addActionListener(this);
        this.parent = parent;
        panel.setLayout(new BorderLayout());
        JLabel l = new JLabel(label);
        l.setPreferredSize(new Dimension(80, 25));
        panel.add(l, BorderLayout.WEST);
        panel.add(this.file, BorderLayout.CENTER);
        panel.add(selector, BorderLayout.EAST);


    }
    public JPanel getFileChooser()
    {
        return this.panel;
    }
    public static void addTo(JComponent element, String label)
    {
        JFrame root = (JFrame)element.getRootPane().getParent();
        element.add((new JCustomFileChooser(label, root)).getFileChooser());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int response = fc.showOpenDialog(this.parent);
        if (response == JFileChooser.APPROVE_OPTION) {
            this.selection = fc.getSelectedFile();
            this.file.setText(this.selection.toString());
        }
    }
}
