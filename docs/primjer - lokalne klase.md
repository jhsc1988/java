```java
class Base {
    protected int nsf1;
}

class TLCWithLocalClasses { // najgornja klasa
    private static int sf; // statička varijabla (var. Klase)
    private double nsf1; //ne statička varijabla (var. instance)
    private int nsf2; // ne statička varijabla

    static void staticMethod(final int fp) { // Static metoda
        final int flv = 10; // final lokalna varijabla
        final int hlv = 30; // final (skrivena) lokalna varijabla
        int nflv = 20; // ne-final lokalna varijabla
        class StaticLocal extends Base { // Static lokalna klasa
            //static int f1; // (11) nije OK. Static članovi nisu dozvoljeni
            final static int f2 = 10;// (12) final static članovi jesu dozv.
            final int f3 = fp; // (13) final parametar metode koja okružuje klasu
            final int f4 = flv; // (14) final lokalna var. metode koja okružuje k.
            //double f5 = nflv; // (15) Nije OK. Samo final var. Iz metode koja okružuje klasu
            final double f6 = nsf1; // (16) nasljeđeno iz nadklase
            final double f6a = this.nsf1; // (16a) nasljeđeno iz nadklase
            final double f6b = super.nsf1; // (16b) nasljeđeno iz nadklase
            //double f7 = TLCWithLocalClasses.this.nsf1; //(17) nema instance klase koja okružuje
            //int f8 = nsf2; // (18) nema instance klase koja okružuje
            final int f9 = sf; // (19) static član klase koja okružuje ovu klasu.
            int hlv; // (20) skriva lokalnu varijablu metode. (nema načina pristupa skrivenoj varijabli)
        }
    }

    void nonStaticMethod(final int fp) { // ne statička metoda
        final int flv = 10; // final lokalna varijabla
        final int hlv = 30; // final (skrivena) lokalna varijabla
        int nflv = 20; // ne-final lokalna varijable
        class NonStaticLocal extends Base { // ne statička lokalna klasa
            //static int f1; // (1) nije OK. Static članovi nisu dozvoljeni
            final static int f2 = 10;// (2) final static članovi jesu dozv.
            final int f3 = fp; // (3) final parametar metode koja okružuje klasu
            final int f4 = flv; // (4) final lokalna var. metode koja okružuje k.
            //double f5 = nflv; // (5) Nije OK. Samo final var. Iz metode koja okružuje klasu
            final double f6 = nsf1; // (6) nasljeđeno iz nadklase
            final double f6a = this.nsf1; // (6a) nasljeđeno iz nadklase
            final double f6b = super.nsf1; // (6b) nasljeđeno iz nadklase
            final double f7 = TLCWithLocalClasses.this.nsf1;// (7) varijabla iz instance klase koja okružuje ovu klasu
            final int f8 = nsf2; // (8) iz instance klase koja okružuje ovu klasu.
            final int f9 = sf; // (9) static član klase koja okružuje ovu klasu.
            int hlv; // (10) skriva lokalnu varijablu metode. (nema načina pristupa skrivenoj varijabli)
        }
    }
}
```



