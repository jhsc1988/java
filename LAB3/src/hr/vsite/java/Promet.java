package hr.vsite.java;

public class Promet {
    final private double iznosDug;
    final private double iznosPot;

    /**
     * Samo jedan od iznosa mora biti različit od 0
     */
    private Promet(double iznosDug, double iznosPot) {

        if (iznosDug != 0 && iznosPot != 0) {
            throw new RuntimeException("Samo jedan od iznosa mora biti različit od 0");
        }

        this.iznosDug = iznosDug;
        this.iznosPot = iznosPot;
    }

    static public Promet kreirajDugovniPromet(double iznos) {
        return new Promet(iznos, 0);
    }

    static public Promet kreirajPotrazniPromet(double iznos) {
        return new Promet(0, iznos);
    }

    public double getIznosDug() {
        return iznosDug;
    }

    public double getIznosPot() {
        return iznosPot;
    }
}
