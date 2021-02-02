package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class UserConfig {

    /**
     * Klasa sadrži metode za
     * čitanje i pisanje postavki iz chat.properties
     * datoteke
     */
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
        log.info("getHost() Enter");

        return host;
    }

    public static void setHost(String host) {

        log.info("setHost() Enter");

        UserConfig.host = host;

        log.info(" host: {} set", host);
        log.info("setHost() Exit");

    }

    public static int getPort() {

        log.info("getPort() Enter");

        return port;
    }

    public static void setPort(int port) {

        log.info("setPort() Enter");

        UserConfig.port = port;

        log.info("port: {} set", port);
        log.info("setPort() Exit");
    }

    public static String getKorisnik() {

        log.info("getKorisnik() Enter");

        return korisnik;
    }

    public static void setKorisnik(String korisnik) {

        log.info("setKorisnik() Enter");

        UserConfig.korisnik = korisnik;

        log.info("setKorisnik: {} set", korisnik);
        log.info("setKorisnik() Exit");
    }

    public static void loadParams() {
        log.info("loadParams() Enter");
        Properties props = new Properties();
        InputStream is = null;
        // Najprije pokušavamo učitati iz lokalnog direktorija
        //
        try {
            File f = new File(propertiesFile);
            is = new FileInputStream(f);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Greška u kreiranju nove datoteke", e);
            is = null;
        }
        try {
            // pokušavaju se učitati parametri
            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Greška u učitavanju parametara", e);
        }
        // prvi parametar: naziv postavke
        // drugi parametar: ako nije nađena vrijednost onda se vraća drugi
        // parametar
        host = props.getProperty(hostPropertieName, "192.168.0.1");
        port = Integer.valueOf(props.getProperty(portPropertieName, "8080"));
        korisnik = props.getProperty(userPropertieName, "anonymous");

        log.info("loadParams() Exit");
    }

    public static void saveParamChanges() {

        log.info("saveParamChanges() Enter");

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

        log.info("saveParamChanges() Exit");
    }

}
