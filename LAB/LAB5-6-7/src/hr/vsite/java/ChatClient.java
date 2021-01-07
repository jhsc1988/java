package hr.vsite.java;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChatClient {

    // form elementi
    private JFrame frame;
    private JPanel masterPanel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JButton Postavke;

    // socket
    private Socket soc;
    private BufferedReader br;
    private PrintWriter pw;

    // time
    private SimpleDateFormat formatter;
    private Date date;


    // logger
    private static final Logger log = (Logger) LoggerFactory.getLogger(ChatClient.class);

    public ChatClient() {

        log.info("ChatClient() Enter");

        formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        frame = new JFrame("ChatClient");
        frame.setContentPane(masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 400));
        // frame.pack(); // ovako ne radi setSize();
        frame.setVisible(true);

        UserConfig postavke = new UserConfig();
        postavke.loadParams();

        connect();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData();
            }
        });
        Postavke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigWindow dialog = new ConfigWindow();

                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    sendData();
            }
        });
        log.info("ChatClient() Exit");
    }

    private void sendData() {
        log.info("sendData() Enter");

        date = new Date();

        String text = textField1.getText();
        textArea1.append(formatter.format(date) + " " + UserConfig.getKorisnik() + ": " + text + "\n");
        textField1.setText("");

        log.info("sendData() Exit");
    }

    public static void main(String[] args) {
        log.info("application start");

        ChatClient window = new ChatClient();

    }

    private void connect() {
        log.info("connect() Enter");
        try {

            soc = new Socket(UserConfig.getHost(), UserConfig.getPort());
            pw = new PrintWriter(soc.getOutputStream());
            br = new BufferedReader(new
                    InputStreamReader(soc.getInputStream()));
            String response;
            try {
                response = br.readLine();
                if (textArea1.getText().length() > 0)
                    textArea1.append("\n");
                textArea1.append(response);
                textArea1.setText(null);
            } catch (IOException e) {
                log.error("Greška kod čitanja inicijalnog odgovora", e);
                JOptionPane.showMessageDialog(textArea1, "Greška kod čitanja inicijalnog odgovora", "Greška!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (UnknownHostException e) {
            log.error("Nepoznati host", e);
            e.printStackTrace();
            frame.dispose();
        } catch (IOException e) {
            log.error("IO iznimka", e);
            frame.dispose();
        }
        log.info("connect() Exit");
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
        masterPanel = new JPanel();
        masterPanel.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        masterPanel.add(spacer2, gbc);
        textField1 = new JTextField();
        textField1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 2, 0, 2);
        masterPanel.add(textField1, gbc);
        button1 = new JButton();
        button1.setBackground(new Color(-13766032));
        Font button1Font = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 10, button1.getFont());
        if (button1Font != null) button1.setFont(button1Font);
        button1.setText("Send");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(button1, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        masterPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        masterPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(spacer6, gbc);
        Postavke = new JButton();
        Postavke.setBackground(new Color(-13766032));
        Font PostavkeFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 10, Postavke.getFont());
        if (PostavkeFont != null) Postavke.setFont(PostavkeFont);
        Postavke.setText("Postavke");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(Postavke, gbc);
        textArea1 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        masterPanel.add(textArea1, gbc);
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
        return masterPanel;
    }

}