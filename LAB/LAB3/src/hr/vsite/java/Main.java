package hr.vsite.java;

public class Main {

    public static void main(String[] args) {

        // prvi zadatak sa modifikacijama iz drugog
        FizickaOsoba v1 = new FizickaOsoba("1", "Ivo", "Ivić");
        v1.setAdresa("Maksimir 22");

        FizickaOsoba v2 = new FizickaOsoba("2", "Mate", "Matić");
        v1.setAdresa("Maksimir 11");

        BankovniRacun b1 = new TekuciRacun("1", v1, 0, 0, 0);
        BankovniRacun b2 = new TekuciRacun("2", v2, 0, 0, 0);

        b1.uplata(100);
        b2.isplata(90);

        System.out.println("b1 " + b1 + " HRK");
        System.out.println("b2 " + b2 + " HRK");
        System.out.println();

        BankovniRacun b3 = b1;

        System.out.println("b3 " + b3 + " HRK");
        System.out.println();

        b3.isplata(100);
        b2.uplata(200);

        System.out.println("b1 " + b1 + " HRK");
        System.out.println("b2 " + b2 + " HRK");
        System.out.println("b3 " + b3 + " HRK");
        System.out.println();

        b3 = new TekuciRacun("3", v1, 0, 0, 0);
        b3.uplata(250);

        System.out.println("b1 " + b1 + " HRK");
        System.out.println("b2 " + b2 + " HRK");
        System.out.println("b3 " + b3 + " HRK");
        System.out.println();

        // drugi zadatak

        FizickaOsoba v4 = new FizickaOsoba("3", "Pero", "Perić");
        v4.setAdresa("Maksimir 10");

        FizickaOsoba v5 = new FizickaOsoba("3333", "Hrvoje", "Horvat");
        v5.setAdresa("Maksimir 9");

        PravnaOsoba p1 = new PravnaOsoba("4", "Neki d.o.o.", v5);
        BankovniRacun b11;
        BankovniRacun b22;

        b11 = new TekuciRacun("111", v4, 100, 4, 14);
        b22 = new OroceniRacun("333", p1, 5);

        System.out.println(b11.getVlasnik().ispisPodataka() + " stanje: " + b11.getTrenutnoStanje());
        System.out.println(b22.getVlasnik().ispisPodataka() + " stanje: " + b22.getTrenutnoStanje());

        b11.uplata(100);
        b22.uplata(200);

        System.out.println(b11.getVlasnik().ispisPodataka() + " stanje: " + b11.getTrenutnoStanje());
        System.out.println(b22.getVlasnik().ispisPodataka() + " stanje: " + b22.getTrenutnoStanje());

        b11.obracunKamata();
        b22.obracunKamata();

        System.out.println(b11.getVlasnik().ispisPodataka() + " stanje: " + b11.getTrenutnoStanje());
        System.out.println(b22.getVlasnik().ispisPodataka() + " stanje: " + b22.getTrenutnoStanje());

        b11.isplata(200);
        b22.isplata(10);

        System.out.println(b11.getVlasnik().ispisPodataka() + " stanje: " + b11.getTrenutnoStanje());
        System.out.println(b22.getVlasnik().ispisPodataka() + " stanje: " + b22.getTrenutnoStanje());

        b11.obracunKamata();
        b22.obracunKamata();

        System.out.println(b11.getVlasnik().ispisPodataka() + " stanje: " + b11.getTrenutnoStanje());
        System.out.println(b22.getVlasnik().ispisPodataka() + " stanje: " + b22.getTrenutnoStanje());
    }
}
