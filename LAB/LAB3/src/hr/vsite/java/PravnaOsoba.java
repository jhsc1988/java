package hr.vsite.java;

public class PravnaOsoba extends Vlasnik {

    private String naziv;
    private FizickaOsoba vlasnik;

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

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVlasnik(FizickaOsoba vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String ispisPodataka() {
        return this.vlasnik.getIme() + " " + this.vlasnik.getPrezime();
    }
}
