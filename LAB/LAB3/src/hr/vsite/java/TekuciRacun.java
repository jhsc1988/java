package hr.vsite.java;

public class TekuciRacun extends BankovniRacun {

    private final double dozvoljeniMinus;
    private final double kamata;
    private final double zateznaKamata;

    public TekuciRacun(String brojRacuna, Vlasnik vlasnik, double dozvoljeniMinus, double Kamata, double zateznaKamata) {
        super(brojRacuna, vlasnik);
        this.dozvoljeniMinus = dozvoljeniMinus;
        this.kamata = Kamata;
        this.zateznaKamata = zateznaKamata;
    }

    @Override
    public boolean isplata(double iznos) {
        if (getTrenutnoStanje() - iznos < dozvoljeniMinus)
            return false;
        super.isplata(iznos);
        toString("klasa: " + getClass().getName() + " - metoda: " + "isplata");
        return true;
    }

    @Override
    public boolean obracunKamata() {
        double trenutnoStanje = getTrenutnoStanje();
        if (getTrenutnoStanje() < 0) {
            super.isplata(trenutnoStanje * (1 + zateznaKamata / 100) - trenutnoStanje);
        } else {
            super.uplata(trenutnoStanje * (1 + kamata / 100) - trenutnoStanje);
        }
        toString("klasa: " + getClass().getName() + " - metoda: " + "obracunKamata");
        return true;
    }
}
