package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Klasa sadrži metode za
 * čitanje i pisanje postavki iz chat.properties
 * datoteke
 */
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
        log.info("getHost() returning host");
        return host;
    }

    public static void setHost(String host) {
        log.info("setHost() setting host");
        UserConfig.host = host;
    }

    public static int getPort() {
        log.info("getPort() returning port");
        return port;
    }

    public static void setPort(int port) {
        log.info("setPort() setting port");
        UserConfig.port = port;
    }

    public static String getKorisnik() {
        log.info("getKorisnik() returning korisnik");
        return korisnik;
    }

    public static void setKorisnik(String korisnik) {
        log.info("setKorisnik() setting korisnik");
        UserConfig.korisnik = korisnik;
    }

    public static void loadParams() {
        log.info("loadParams() enter");

        Properties props = new Properties();
        InputStream is = null;

        // Najprije pokušavamo učitati iz lokalnog direktorija
        try {
            File f = new File(propertiesFile);
            is = new FileInputStream(f);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Greška u kreiranju nove datoteke", e);
        }
        try {
            // pokušavaju se učitati parametri
            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Greška u učitavanju parametara", e);
        }

        // prvi parametar: naziv postavke
        // drugi parametar: ako nije nađena vrijednost onda se vraća drugi parametar
        host = props.getProperty(hostPropertieName, "192.168.0.1");
        port = Integer.parseInt(props.getProperty(portPropertieName, "8080"));
        korisnik = props.getProperty(userPropertieName, "anonymous");

        log.info("loadParams() exit");
    }

    public static void saveParamChanges() {

        log.info("saveParamChanges() enter");

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
            log.error("Greška u zapisivanju parametara", e);
        }

        log.info("saveParamChanges() exit");
    }

}
