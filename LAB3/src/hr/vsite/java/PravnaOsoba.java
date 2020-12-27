package hr.vsite.java;

public class PravnaOsoba extends Vlasnik {

    private final String naziv;
    private final FizickaOsoba vlasnik;

    public PravnaOsoba(String oib, String naziv, FizickaOsoba vlasnik) {
        super(oib);
        this.naziv = naziv;
        this.vlasnik = vlasnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public FizickaOsoba getVlasnik() {
        return vlasnik;
    }

    @Override
    public String ispisPodataka() {
        return this.vlasnik.getIme() + " " + this.vlasnik.getPrezime();
    }
}
