package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChatClient {
    // logger
    private static final Logger log = LoggerFactory.getLogger(ChatClient.class);
    // time
    private final SimpleDateFormat formatter;
    private JPanel masterPanel;
    // form elementi
    private final JFrame frame;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton Send_button;
    private JButton Postavke;
    // socket
    private Socket soc;
    // chat properties r-w
    private BufferedReader br;
    private PrintWriter pw;
    // date
    private Date date;
    // statement with params
    private PreparedStatement statement;
    // db connection
    private Connection con;
    // statement string
    private final String selectString = "SELECT [user],text,time FROM chat";
    private final String updateString = "INSERT INTO chat ([user], text, time) VALUES (?,?,?)";

    public ChatClient() {
        log.info("ChatClient() enter");

        // date format
        formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // GUI elementi
        frame = new JFrame("ChatClient");
        frame.setContentPane(masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 400));
        // frame.pack(); // ovako ne radi setSize();
        frame.setVisible(true);

        // properties
        UserConfig.loadParams();

        connect();

        try {
            con = DbConnect.db_connect();
            statement = con.prepareStatement(selectString);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                //get
                String user = rs.getString(1);
                String text = rs.getString(2);
                Timestamp time = rs.getTimestamp(3);

                // append to text area
                textArea1.append(formatter.format(time) + " " + user + ": " + text + "\n");
            }
        } catch (SQLException e) {
            log.error("connection error", e);
            try {
                statement.close();
                con.close();
            } catch (SQLException ee) {
                log.error("connection close error", ee);
            }
        }
        Send_button.addActionListener(new ActionListener() {
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

    public static void main(String[] args) {

        log.info("application start");

        ChatClient window = new ChatClient();
    }

    private void sendData() {
        log.info("sendData() enter");

        date = new Date();

        String text = textField1.getText();
        textArea1.append(formatter.format(date) + " " + UserConfig.getKorisnik() + ": " + text + "\n");
        textField1.setText("");

        try {
            statement = con.prepareStatement(updateString);
            statement.setString(1, UserConfig.getKorisnik());
            statement.setString(2, text);
            statement.setTimestamp(3, new Timestamp(date.getTime()));
            statement.executeUpdate();
            log.info("update db OK");
        } catch (SQLException e) {
            log.error("update db error", e);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                log.error("close() db error");
            }
        }
        log.info("sendData() exit");
    }

    private void connect() {
        log.info("connect() enter");
        try {

            soc = new Socket(UserConfig.getHost(), UserConfig.getPort());
            pw = new PrintWriter(soc.getOutputStream());
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
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
            log.info("Socket Server vjerojatno nije pokrenut - java; run: java SocketServer is SocketServer foldera");

            frame.dispose();
        }
        log.info("connect() exit");
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
        Send_button = new JButton();
        Send_button.setBackground(new Color(-13766032));
        Font Send_buttonFont = this.$$$getFont$$$("Segoe UI", Font.PLAIN, 10, Send_button.getFont());
        if (Send_buttonFont != null) Send_button.setFont(Send_buttonFont);
        Send_button.setText("Send");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        masterPanel.add(Send_button, gbc);
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
        textArea1.setText("");
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
