package hr.vsite.java;

import javax.swing.*;
import java.awt.*;

public class HelloWorld2 {
    private JPanel masterPanel;

    HelloWorld2() {

        $$$setupUI$$$();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldForm");
        frame.setContentPane(new HelloWorld2().masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void $$$setupUI$$$() {
        masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout(0, 0));
        final JLabel label1 = new JLabel();
        label1.setText("Label");
        masterPanel.add(label1, BorderLayout.CENTER);
    }


    public JComponent $$$getRootComponent$$$() {
        return masterPanel;
    }
}
