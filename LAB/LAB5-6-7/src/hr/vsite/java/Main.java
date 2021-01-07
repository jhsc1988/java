package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    // stavljam u svaku klasu koju želim logirati
    // svaka klasa ima svoj logger - kreiranje loggera nije skupo

    public static void main(String[] args) {
        logger.info("application start");
        logger.trace("number of parameters {}", args.length); // {} placeholder za logger

        try {
            int a = Integer.parseInt(args[0]);
        } catch (NumberFormatException e){
            e.printStackTrace();
            logger.error("Error parsing parameter",e);
        }

    }
}
