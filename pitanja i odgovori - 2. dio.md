**88.	Što je to interface?**

Interface predstavlja imenovani skup metoda bez implementacije. Interface također može definirati konstante. Klasa koja implementira interface, slaže se da će implementirati sve metode definirane u interface-u.

**89.	Navedite razlike između interface-a i apstraktne klase?**

Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može. Klasa može implementirati mnogo interface-a, ali smije imati samo jednu nadklasu. Interface nije dio hijerarhije klasa. Klase koje nisu u odnosu mogu implementirati isti interface.

**90.	Navedite elemente deklaracije interface-a?**

U deklaraciji interface-a dva su elementa nužna: ključna riječ interface i ime interface-a

```JAVA
public interface InterfaceName extends SuperInterface {
    InterfaceBody
}
```

**91.Koliko interface-a može pojedini interface naslijediti?**

Dok klasa može proširiti samo jednu klasu, interface može proširiti bilo koji broj interfacea: lista nadinterface je lista interface-a koje proširuju novi interface odvojenih zarezima.

**92.	Koji su implicitni modifikatori uz metodu interface-a?**

Sve metode deklarirane u interface-u implicitno su public i abstract (pa se ne moraju navoditi ti modifikatori)

**93.	Koji su implicitni modifikatori uz varijablu interface-a?**

Sve konstantne vrijednosti definirane u interface-u su implicitno public, static i final.

**94.	Navedite elemente deklaracije enum tipa?**

**95.	Koliko instanci enum tipa se može kreirati za vrijeme izvođenja programa?**

**96.	Koji su implicitni modifikatori za enum varijable?**

**97.	Kada se inicijaliziraju enum konstante?**

**98.	Navedite razlike između enum tipa i klase?**

**99.	Opišite metodu „values“ enum tipa.**

**100.	Opišite metodu „valueOf“ enum tipa.**

**101.	Opišite metodu „ordinal“ enum tipa.**

**102.	Koliko klasa i koliko interface-a može enum tip naslijediti?**

**.	Što je i što definira paket (package)?**

**104.	Koji su elementi i pravila deklaracije paketa?**

**105.	Na koji način se mogu koristiti public članovi nekog paketa?**

**106.	Koji su elementi i pravila deklaracije uvoza članova nekog paketa?**

**107.	Kako se mogu uvesti statički članovi klase?**

**108.	U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?**

**109.	Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?**

**110.	Koje su osnovne prednosti korištenja iznimki za obradu pogreški?**

**111.	Što su to iznimke?**

**112.	Navedite osnovne metode Throwable klase.**

**113.	Navedite glavnu podjelu iznimki? Navedite razlike.**

**114.	Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.**

**115.	Navedite pravila rada sa provjeravanim iznimkama.**

**116.	Navedite i opišite elemente hvatanja i obrade iznimki?**

**117.	Kako se postiže općeniti exception handler (hvata vište tipova iznimki)?**

**118.	Kako se bacaju iznimke? Navedite primjer.**

**119.	Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.**

**120.	Kako se definiraju novi tipovi provjeravanih i neprovjeravanih iznimki?**

**121.	Navedite elemete iskaza „assert“.**

**122.	Navedite podjelu „stream“ klasa ovisno o tipu podataka. Navedite glavne klase svake grupe.**

**123.	Navedite kategorije stream klasa.**

**124.	Navedite osnovne metode Reader klase.**

**125.	Navedite osnovne metode InputStream klase.**

**126.	Navedite osnovne metode Writer klase.**

**127.	Navedite osnovne metode OutputStream klase.**

**128.	Što je to nit i što omogućava?**

**129.	Kako se postiže implementacija niti?**

**130.	Kada završava nit?**

**131.	Koji su koraci i način pokretanja niti kod nasljeđivanja Thread klase?**

**132.	Koji su koraci i načini pokretanja niti kod implementacije Runnable interface-a?**

**133.	Koja je razlika između daemon i user niti? Koja je metoda za definiranje tipa niti.**

**134.	Navedite načine privremenog zaustavljanja niti.**

**135.	Navedite načine pokretanja privremeno zaustavljene niti.**

**136.	Navedite i opišite osnovna stanja niti (getState).**

**137.	Kako se određuje prioritet niti?**

**138.	Kojim se metodama omogućava da nit omogući izvršavanje i drugih niti?**

**139.	Navedite načine sinkronizacije dijela koda. **

**140.	Opišite svojstva i način deklaracije sinkronizirane metode.**

**141.	Opišite svojstva i način deklaracije sinkroniziranih blokova.**

**142.	Koje metode služe za sinkronizaciju različitih niti?**

**143.	Navedite osnovna svojstava wait metoda.**

**144.	Kako se pokreće nit koja je zaustavljena pozivom wait metode?**

**145.	Navedite osnovna svojstva notify i notifyAll metoda.**

**146.	Kako se grupiraju niti?**

**147.	Kako se postiže da nit čeka na završetak izvođenja neke druge niti?**

**148.	Koje uvjete mora zadovoljiti prepisana equals metoda?**

**149.	Koje uvjete mora zadovoljiti prepisana hashCode metoda?**

**150.	Koji interface-i služe za sortiranje objekata? Opišite metode pojedinih interface-a.**

**151.	Kako se realizira sekvencijalni dohvat elemenata kolekcije? Opišite metode koje se koriste.**

**152.	Koje su osnovne vrste kolekcija?**

**153.	Navedite svojstva i primjere implementacije setova.**

**154.	Navedite svojstva i primjere implementacije listi.**

**155.	Navedite svojstva i primjere implementacije mapa.**