package hr.vsite.java;

public abstract class BankovniRacun {
    final private String brojRacuna;
    private final double pocetnoStanje;
    private final Promet[] prometi;
    private Vlasnik vlasnik; // fizicka ili pravna osoba
    private int index;

    public BankovniRacun(String brojRacuna, Vlasnik vlasnik) {
        this.brojRacuna = brojRacuna;
        this.vlasnik = vlasnik;
        this.pocetnoStanje = 0;
        prometi = new Promet[1000];
    }

    public double getTrenutnoStanje() {
        double trenutnoStanje = pocetnoStanje;
        for (int i = 0; i < index; ++i) {
            trenutnoStanje += prometi[i].getIznosPot();
            trenutnoStanje -= prometi[i].getIznosDug();
        }
        return trenutnoStanje;
    }

    public boolean uplata(double iznos) {
        prometi[index++] = Promet.kreirajPotrazniPromet(iznos);
        return true;
    }

    public boolean isplata(double iznos) {
        prometi[index++] = Promet.kreirajDugovniPromet(iznos);
        return true;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public double getPocetnoStanje() {
        return pocetnoStanje;
    }

    /**
     * ne zelim vratiti isti objekt kojeg mogu mijenjati,
     * vraca se kopija
     */
    public Promet[] getPrometi() {
        return prometi.clone(); // clone() stvara shallow kopiju
    }

    @Override
    public String toString() {
        return "" + getTrenutnoStanje();
    }

    public void toString(String metoda) {
        System.out.println(metoda);
    }

    public abstract boolean obracunKamata();
}
