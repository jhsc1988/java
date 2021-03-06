package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class ConfigWindow extends JDialog {

    private JPanel Postavke;
    private JTextField host;
    private JTextField port;
    private JTextField korisnik;
    private JButton spremiButton;
    private JButton odustaniButton;

    // logger
    private static final Logger log = (Logger) LoggerFactory.getLogger(ChatClient.class);

    public void CheckEnter(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            UserConfig.setHost(host.getText());
            UserConfig.setPort(Integer.valueOf(port.getText()));
            UserConfig.setKorisnik(korisnik.getText());

            UserConfig.saveParamChanges();
            dispose();
        }
    }

    public int CheckAnswer() {
        int confirmed = JOptionPane.showOptionDialog(Postavke,
                "Da li ste sigurni da želite zatvoriti prozor bez snimanja promjena?", "Pitanje!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Da", "Ne"}, "Ne");
        return confirmed;
    }

    public ConfigWindow() {

        log.info("ConfigWindow Enter");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                if (host.getText().equals(UserConfig.getHost()) && port.getText().equals(String.valueOf(UserConfig.getPort())) && korisnik.getText().equals(UserConfig.getKorisnik())) {
                    dispose();
                } else if (CheckAnswer() == 0)
                    dispose();
            }
        });

        this.setContentPane(this.Postavke);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();

        this.host.setText(UserConfig.getHost());
        this.port.setText(String.valueOf(UserConfig.getPort()));
        this.korisnik.setText(UserConfig.getKorisnik());

        odustaniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CheckAnswer() == 0)
                    dispose();
            }
        });

        spremiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (host.getText().equals(UserConfig.getHost()) && port.getText().equals(String.valueOf(UserConfig.getPort())) && korisnik.getText().equals(UserConfig.getKorisnik())) {
                    dispose();
                } else {

                    UserConfig.setHost(host.getText());
                    UserConfig.setPort(Integer.valueOf(port.getText()));
                    UserConfig.setKorisnik(korisnik.getText());

                    UserConfig.saveParamChanges();
                    dispose();
                }
            }
        });
        host.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                CheckEnter(e);
            }
        });


        port.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                CheckEnter(e);

            }
        });

        korisnik.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                CheckEnter(e);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Postavke = new JPanel();
        Postavke.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Segoe UI", -1, 10, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Host:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        Postavke.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        Postavke.add(spacer2, gbc);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Segoe UI", -1, 10, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Port:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        Postavke.add(label2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        Postavke.add(spacer3, gbc);
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Segoe UI", -1, 10, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Korisnik:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        Postavke.add(label3, gbc);
        host = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(host, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(spacer4, gbc);
        port = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(port, gbc);
        korisnik = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(korisnik, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        Postavke.add(spacer5, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.BOTH;
        Postavke.add(panel1, gbc);
        spremiButton = new JButton();
        spremiButton.setBackground(new Color(-13766032));
        Font spremiButtonFont = this.$$$getFont$$$("Segoe UI", -1, 10, spremiButton.getFont());
        if (spremiButtonFont != null) spremiButton.setFont(spremiButtonFont);
        spremiButton.setText("Spremi");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spremiButton, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer7, gbc);
        odustaniButton = new JButton();
        odustaniButton.setBackground(new Color(-13766032));
        Font odustaniButtonFont = this.$$$getFont$$$("Segoe UI", -1, 10, odustaniButton.getFont());
        if (odustaniButtonFont != null) odustaniButton.setFont(odustaniButtonFont);
        odustaniButton.setText("Odustani");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(odustaniButton, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        Postavke.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Postavke.add(spacer10, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Postavke;
    }

}
