package hr.vsite.java;

import java.io.*;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserConfig {

    private static final String propertiesFile = "chat.properties";
    private static final String hostPropertieName = "host";
    private static final String portPropertieName = "port";
    private static final String userPropertieName = "user";

    private static String host;
    private static int port;
    private static String korisnik;

    // logger
    private static final Logger log = LoggerFactory.getLogger(UserConfig.class);

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        UserConfig.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        UserConfig.port = port;
    }

    public static String getKorisnik() {
        return korisnik;
    }

    public static void setKorisnik(String korisnik) {
        UserConfig.korisnik = korisnik;
    }

    public static void loadParams() {
        log.info("loadParams Enter");
        Properties props = new Properties();
        InputStream is = null;
        // Najprije pokušavamo učitati iz lokalnog direktorija
        //
        try {
            File f = new File(propertiesFile);
            is = new FileInputStream(f);
        } catch (Exception e) {
            e.printStackTrace();
            is = null;
        }
        try {
            // pokušavaju se učitati parametri
            props.load(is);
        } catch (Exception e) {
        }
        // prvi parametar: naziv postavke
        // drugi parametar: ako nije nađena vrijednost onda se vraća drugi
        // parametar
        host = props.getProperty(hostPropertieName, "192.168.0.1");
        port = new Integer(props.getProperty(portPropertieName, "8080"));
        korisnik = props.getProperty(userPropertieName, "anonymous");
    }

    public static void saveParamChanges() {
        try {
            Properties props = new Properties();
            props.setProperty(hostPropertieName, host);
            props.setProperty(portPropertieName, "" + port);
            props.setProperty(userPropertieName, korisnik);
            File f = new File(propertiesFile);
            OutputStream out = new FileOutputStream(f);
            props.store(out, "Opcionalni header komentar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
