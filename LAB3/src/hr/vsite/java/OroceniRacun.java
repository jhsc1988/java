package hr.vsite.java;

public class OroceniRacun extends BankovniRacun {

    private final double kamata;

    public OroceniRacun(String brojRacuna, Vlasnik vlasnik, double kamata) {
        super(brojRacuna, vlasnik);
        this.kamata = kamata;
    }

    @Override
    public boolean isplata(double iznos) {
        return false;
    }

    @Override
    public boolean obracunKamata() {
        double trenutnoStanje = getTrenutnoStanje();
        super.uplata(trenutnoStanje * (1 + kamata / 100) - trenutnoStanje);
        toString("klasa: " + getClass().getName() + " - metoda: " + "obracunKamata");
        return true;
    }
}
