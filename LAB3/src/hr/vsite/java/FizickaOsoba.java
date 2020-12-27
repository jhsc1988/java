package hr.vsite.java;

public class FizickaOsoba extends Vlasnik {

    private String ime;
    private String prezime;

    public FizickaOsoba(String oib, String ime, String prezime) {
        super(oib);
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String ispisPodataka() {
        return this.getIme() + " " + this.getPrezime();
    }
}
