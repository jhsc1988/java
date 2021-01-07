**88.	Što je to interface?**

Interface predstavlja imenovani skup metoda bez implementacije. Interface također može definirati konstante. Klasa koja implementira interface, slaže se da će implementirati sve metode definirane u interface-u.

**89.	Navedite razlike između interface-a i apstraktne klase?**

Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može. Klasa može implementirati mnogo interface-a, ali smije imati samo jednu nadklasu. Interface nije dio hijerarhije klasa. Klase koje nisu u odnosu mogu implementirati isti interface.

**90.	Navedite elemente deklaracije interface-a?**

U deklaraciji interface-a dva su elementa nužna: ključna riječ interface i ime interface-a

primjer:
```JAVA
public interface InterfaceName extends SuperInterface {
    InterfaceBody
}
```

**91. Koliko interface-a može pojedini interface naslijediti?**

Dok klasa može proširiti samo jednu klasu, interface može proširiti bilo koji broj interfacea: lista nadinterface je lista interface-a koje proširuju novi interface odvojenih zarezima.

**92.	Koji su implicitni modifikatori uz metodu interface-a?**

Sve metode deklarirane u interface-u implicitno su public i abstract (pa se ne moraju navoditi ti modifikatori)

**93.	Koji su implicitni modifikatori uz varijablu interface-a?**

Sve konstantne vrijednosti definirane u interface-u su implicitno public, `static` i final.

**94.	Navedite elemente deklaracije enum tipa?**

Enum tip (klasa) definira konačni set naziva (enum konstanti ili imenovanih konstanti) i vrijednosti. Za definiranje enum tipa koristi se ključna riječ enum.

primjer:
```JAVA
enum MachineState { BUSY, IDLE, BLOCKED }

```
Također, u tijelu enum deklaracije mogu se definirati konstruktori i članovi ali se najprije moraju navesti enum konstante (lista se mora završiti sa ;)
Nakon svake enum konstante se može navesti lista parametara koji se prosljeđuju odgovarajućem konstruktoru
Kada se učita enum tip za svaku enum konstantu se poziva odgovarajući konstruktor kojem se prosljeđuju parametri definirani uz enum konstantu


**95.	Koliko instanci enum tipa se može kreirati za vrijeme izvođenja programa?**

Ne mogu se kreirati nove instance tipa enum (`static`). Instance enum-a su definirane u popisu enum konstanti.

**96.	Koji su implicitni modifikatori za enum varijable?**

enum konstante su po ponašanju final `static` (te se ključne riječi ne navode) varijable enum tipa koje su implicitno inicijalizirane prilikom učitavanja enum tipa (klase)

**97.	Kada se inicijaliziraju enum konstante?**

Prilikom učitavanja enum tipa (klase). Pošto su enum konstante `static` tada se koriste putem naziva enum tipa.

**98.	Navedite razlike između enum tipa i klase?**

Enum nasljeđuje klasu `java.lang.Enum`, i time dobiva set ponašanja (metode), tretiraju se kao posebne vrste klasa te su mu članovi predefinirani (`static`).

**99.	Opišite metodu „values“ enum tipa.**

```
static EnumTypeName[] values()
```
-	vraća niz enum konstanti definiranih u enum tipu redoslijedom kako su definirane

**100.	Opišite metodu „valueOf“ enum tipa.**

```JAVA
Static EnumTypeName valueOf(String name)
```
-	Vraća enum konstantu sa specificiranim nazivom. Ako ne postoji enum konstanta sa tim nazivom baca se `IllegalArgumentException` (prosljeđuje s samo naziv enum konstante)

**101.	Opišite metodu „ordinal“ enum tipa.**

```JAVA
final int ordinal()
```
-	Vraća redni broj enum konstante (pozicija u deklaraciji enum konstanti). Enum konstante u enum tipu su numerirane počevši od 0.

**102.	Koliko klasa i koliko interface-a može enum tip naslijediti?**

Kao i klase, mogu implementirati interface-e. Enum implicitno nasljeđuje samo klasu `java.lang.Enum` (nema višestrukog nasljeđivanja). Enum klasa se ne može naslijediti niti može biti naslijeđena.

**103. Što je i što definira paket (package)?**

Paket (package) je skup povezanih klasa i interface-a koji omogućuju zaštitu pristupa i upravljanje prostorom imena (namespace)
-	Paketi grupiraju klase po njihovoj funkciji: osnovne klase su u paketu `java.lang`, klase za čitanje i pisanje (ulaz i izlaz) su u `java.io`

**104.	Koji su elementi i pravila deklaracije paketa?**

Deklarira se pomoću iskaza package na vrhu datoteke s izvornim kodom u kojem je definirana klasa ili interface

```JAVA
package graphics;

public class Circle extends Graphic implements Draggable
{
. . .
}
```
Klasa circle je public član graphics paketa
-	Iskaz `package `mora se uključiti na vrhu svake izvorne datoteke koja definira klasu ili interface unutar graphics paketa

**105.	Na koji način se mogu koristiti public članovi nekog paketa?**

Svi public članovi su dostupni i izvan paketa
Za korištenje javnih package članova izvan paketa, mora se učiniti jedno od slijedećeg:
-	Dohvatiti član uz pomoć njegovog dugog (kvalificiranog) imena
-	Uvesti član paketa
-	Uvesti cijeli paket


**106.	Koji su elementi i pravila deklaracije uvoza članova nekog paketa?**

Pomoću import iskaza na početku datoteke prije bilo koje definicije klase ili interface-a, ali nakon package iskaza.

import graphics.Circle;
-	Sada se klasa Circle može koristiti pomoću jednostavnog imena:
Circle myCircle = new Circle();

-	Uvoz cijelog paketa:
import graphics.*;


**107.	Kako se mogu uvesti statički članovi klase?**

Pomoću ključnih riječi static import
-	Nakon uvoza takvi članovi se mogu koristiti sa jednostavnim imenom


**108.	U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?**

Java platforma oslanja se na hijerarhijski datotečni sistem radi upravljanja izvornim i `.class` datotekama. Izvorni kod klase ili interface se smješta u datoteku koja ima isti naziv kao i jednostavno ime klase ili interface-a čiji je nastavak `.java`

**109.	Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?**

Osnovno ime izlazne datoteke je ime klase ili interface-a, a njezina ekstenzija je `.class`.
Kao i .java datoteke, `.class` datoteka također treba biti u nizu direktorija koji odražavaju ime paketa. Međutim, ne mora biti u istom direktoriju u kojem je izvorna datoteka.

**110.	Koje su osnovne prednosti korištenja iznimki za obradu pogreški?**

-	Odvajanje koda koji obrađuje pogreške od "regularnog" koda
-	Propagiranje pogreški kroz call stack
-	Grupiranje tipova pogreški i njihovo razlikovanje


**111.	Što su to iznimke?**

Iznimka je događaj koji ometa prirodni tok izvršavanja programa

**112.	Navedite osnovne metode Throwable klase.**

```JAVA
String getMessage();
```
- vraća poruku iznimke

```JAVA
void printStackTrace();
```
- ispisuje se na standardni izlazni tok stog poziva metoda u trenutku kada je bačena iznimka

```JAVA
String toString();
```
-vraća se kratki opis iznimke koji se najčešće sastoji od naziva klase i stringa kojeg vraća getMessage metoda


**113.	Navedite glavnu podjelu iznimki? Navedite razlike.**

`Throwable` klasa ima dva direktna nasljednika: Pogreške (errors), iznimke (exceptions). Error predstavlja "jaku" pogrešku i tipični java programi ne bi trebali hvatati Error-e. Iznimke (Exception) imaju mnoge nasljednike, koje indiciraju različite tipove iznimki – predstavlja grupu iznimki koje se najčešće žele uhvatiti.

**114.	Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.**

Osim `RuntimeException`, `Error` i njihovih podklasa sve iznimke se nazivaju provjeravanim iznimkama (**checked exceptions**)

**115.	Navedite pravila rada sa provjeravanim iznimkama.**

Metoda mora ili hvatati ili navesti sve provjeravane iznimke koje mogu biti bačene unutar dosega metode
-	Uhvati (catch) blok – metoda će uhvatiti ako osigura exception handler za taj tip iznimke (try-catch-finally) blok
-	Navedi (specify) blok - ako metoda odlučni ne uhvatiti iznimku, tada moda eksplicitno naglasiti da može baciti tu iznimku (throws)

**116.	Navedite i opišite elemente hvatanja i obrade iznimki?**

try
catch
finally
throw

**117.	Kako se postiže općeniti exception handler (hvata vište tipova iznimki)?**

```JAVA
catch (SomeThrowableObject variableName) {
	Java statements
}
```

**118.	Kako se bacaju iznimke? Navedite primjer.**

Iskaz throw služi za bacanje iznimki:

```JAVA
…
if (size == 0)
	throw new EmptyStackException(„opis iznimke“);
…
```
Iskaz throw zahtjeva samo jedan argument: throwable objekt; throwable objekti u Javi su instance ili podklase Throwable klase

Throw iskaz zaustavlja normalno izvođenje i runtime sistem počinje sa traženjem odgovarajućeg exception handlera

**119.	Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.**

Pomoću iskaza `throws`: u `throws` iskazu metode moraju se navesti sve provjeravane iznimke koje nisu obrađene u metodi

```JAVA
someMethod(…)
throws <ExceptionType1>, <ExceptionType2>, …,<ExceptionTypen>
```

U metodi se mogu bacati i provjeravane iznimke koje su podklase iznimki definiranih u `throws` iskazu
U `throws` dijelu mogu se navesti i neprovjeravane iznimke ali to je nepotrebno jer kompajler ne provjerava takve iznimke
Metoda koja koristi metodu koja ima `throws` iskaz mora ili uhvatiti ili navesti te navedene iznimke


**120.	Kako se definiraju novi tipovi provjeravanih i neprovjeravanih iznimki?**

Da bi se definirala nova provjeravana iznimka može se naslijediti `Exception` klasa direktno ili neka druga njena podklasa

Neprovjeravane iznimke se definiraju ako se naslijedi klasa `RuntimeException` ili neka njena podklasa

Iznimke su definirane kao klase i mogu imati svoje članove (varijable, metode, …)


**121.	Navedite elemete iskaza „assert“.**

assert iskazi se koriste u kodu da se dokumentiraju i provjeravaju pretpostavke pod kojima je kod napisan

```JAVA
assert <boolean izraz> ; // Jednostavni oblik
assert <boolean izraz > : <izraz poruke>;
```

ekvivalentno:

```JAVA
if (<omogućeni asserti> && !<boolean izraz>)
// Jednostavni oblik
throw new AssertionError();
if (<omogućeni asserti> && !<boolean izraz>)
throw new AssertionError(<izraz poruke>);
```

**122.	Navedite podjelu „stream“ klasa ovisno o tipu podataka. Navedite glavne klase svake grupe.**

Stream klase podijeljene su u dvije hijerarhije klasa, ovisno o tipu podataka (karakteri ili bajtovi) nad kojima operiraju.

Tokovi karaktera: `Reader` i `Writer` (16-bit karakteri)
Tokovi bajtova: `InputStream` i `OutputStream` (8-bit bajtovi)

**123.	Navedite kategorije stream klasa.**

Glavne kategorije su tokovi karaktera i tokovi bajtova:

**Reader**: čitanje karaktera
**Writer**: pisanje karaktera
**InputStream**: čitanje bajtova
**OutputStream**: pisanje bajtova

**124.	Navedite osnovne metode Reader klase.**

BufferedReader, CharArrayReader, InputStreamReader, FilterReader, PipedReader, StringReader

**125.	Navedite osnovne metode InputStream klase.**

FileInputStream, PipedInputStream, FilterInputStream, ByteArrayInputStream, SequenceInputStream, StringBufferInputStream, ObjectInputStream

**126.	Navedite osnovne metode Writer klase.**

BufferedWriter, CharArrayWriter, OutputStreamWriter, FilterWriter, PipedWriter, StringWriter, PrintWriter

**127.	Navedite osnovne metode OutputStream klase.**

FileOutputStream, PipedOutputStream, FilterOutputStream, ByteArrayOutputStream, ObjectOutputStream, OutputStream*

**128.	Što je to nit i što omogućava?**

Nit predstavlja jedan sekvencijalni tok izvršavanja unutar programa. Omogućavaju pokretanje više niti (koji rade različite zadatke) unutar jednog programa

**129.	Kako se postiže implementacija niti?**

Postiže se:

-	implementacijom java.lang.Runnable interface-a
-	nasljeđivanjem java.lang.Thread klase


**130.	Kada završava nit?**

Nit završava kada je završeno izvođenje run metode bilo regularnim putem ili iznimkom

**131.	Koji su koraci i način pokretanja niti kod nasljeđivanja Thread klase?**

- Klasa koja nasljeđuje Thread klasu prepisuje run metodu
- podklasa može eksplicitno zvati konstruktor nadklase u svom konstruktoru da inicijalizira nit pomoću `super()` poziva
- pokreće se naslijeđena metoda `start()` iz Thread klase na objektu da se proglasi nit spremnim za pokretanje

**132.	Koji su koraci i načini pokretanja niti kod implementacije Runnable interface-a?**


-	Klasa implementira `Runnable` interface i definira run metodu koja će se pokrenuti od strane niti. Objekt te klase je `Runnable` objekt
-	Kreira se objekt klase Thread putem konstruktora kojem se kao argument proslijeđuje `Runnable` objekt
-	Pokreće se `start()` metoda nad Thread objektom. Metoda `start()` zaršava čim je kreirana nova nit


**133.	Koja je razlika između daemon i user niti? Koja je metoda za definiranje tipa niti.**

**daemon** – ako u programu ostanu samo daemon niti, program izlazi.

**user** – program čeka završetak svih user niti

**134.	Navedite načine privremenog zaustavljanja niti.**

Nit se privremeno zaustavlja:
-	Kada je pozvana sleep() metoda
-	Nit je pozvala wait() metodu kako bi pričekala da se nešto dogodi
-	Nit je blokirana na IO (input/output) funkciji


**135.	Navedite načine pokretanja privremeno zaustavljene niti.**

-	Ako nit upadne u stanje spavanja, mora proći određeni broj milisekundi
-	Ako nit čeka na uvjet, tada drugi objekt mora obavijestiti nit koja čeka da je nastupila promjena (pozivom notify ili notifyAll)
-	Ako je nit blokirana IO operacijom, tada ta operacija mora završiti.


**136.	Navedite i opišite osnovna stanja niti (getState).**

Metoda vraća stanje niti (enum).

**NEW** (kreirana ali nije startana), 
**RUNNABLE** (izvršava se u JVM), 
**BLOCKED** (blokirana čekajući na lock), 
**WAITING** ( čeka na neodređeno vrijeme da neki drugi thread obavi određenu operaciju), 
**TIMED_WAITING** (čeka određeno vrijeme da neki drugi thread obavi određenu operaciju), 
**TERMINATED** (završeno izvršavanje)

**137.	Kako se određuje prioritet niti?**

Pomoću algoritma koji se zove **fixed priority scheduling** – raspoređuje niti ovisno o njezinom relativnom prioritetu (MIN_PRIORITY 1 do MAX_PRIORITY 10) koje se nasljeđuje od niti koja ju je kreirala ili izmjenjuje metodom `setPriority()`.

**138.	Kojim se metodama omogućava da nit omogući izvršavanje i drugih niti?**

Statičkom `yield()` metodom klase `Thread` – trenutna nit prepušta CPU ako postoje druge niti koje čekaju svoje vrijeme

```JAVA
Thread.yield();
```

Statičkom metodom sleep klase `Thread` – zaustavlja trenutnu nit 

```JAVA
Thread.sleep(long millis)
Thread.sleep(long millis, int nanos)
```


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