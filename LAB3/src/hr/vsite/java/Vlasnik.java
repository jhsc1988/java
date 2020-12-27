package hr.vsite.java;

public abstract class Vlasnik {

    final private String oib;
    private String adresa;

    public Vlasnik(String oib) {
        this.oib = oib;
    }

    public String getOib() {
        return oib;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public abstract String ispisPodataka();
}

