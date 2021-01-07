### INTERFACE

#### 88. Što je to interface?

Interface predstavlja imenovani skup metoda bez implementacije. Interface također može definirati konstante. Klasa koja implementira interface, slaže se da će implementirati sve metode definirane u interface-u.

#### 89. Navedite razlike između interface-a i apstraktne klase?

Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može. Klasa može implementirati mnogo interface-a, ali smije imati samo jednu nadklasu. Interface nije dio hijerarhije klasa. Klase koje nisu u odnosu mogu implementirati isti interface.

#### 90. Navedite elemente deklaracije interface-a?

U deklaraciji interface-a dva su elementa nužna: ključna riječ interface i ime interface-a

primjer:
```JAVA
public interface InterfaceName extends SuperInterface {
    InterfaceBody
}
```

#### 91. Koliko interface-a može pojedini interface naslijediti?

Dok klasa može proširiti samo jednu klasu, interface može proširiti bilo koji broj interfacea: 
- lista nadinterface je lista interface-a koje proširuju novi interface odvojenih zarezima.

TODO: primjer

#### 92. Koji su implicitni modifikatori uz metodu interface-a?

Sve metode deklarirane u interface-u implicitno su `public` i `abstract` (pa se ne moraju navoditi ti modifikatori)

#### 93. Koji su implicitni modifikatori uz varijablu interface-a?

Sve konstantne vrijednosti definirane u interface-u su implicitno `public`, `static` i `final`.

### ENUM

#### 94. Navedite elemente deklaracije enum tipa?

Enum tip (klasa) definira konačni set naziva (enum konstanti ili imenovanih konstanti) i vrijednosti. Za definiranje enum tipa koristi se ključna riječ enum.

primjer:
```JAVA
enum MachineState { BUSY, IDLE, BLOCKED }
```

- Također, u tijelu enum deklaracije mogu se definirati konstruktori i članovi ali se najprije moraju navesti enum konstante (lista se mora završiti sa `;` )
- Nakon svake enum konstante se može navesti lista parametara koji se prosljeđuju odgovarajućem konstruktoru
- Kada se učita enum tip za svaku enum konstantu se poziva odgovarajući konstruktor kojem se prosljeđuju parametri definirani uz enum konstantu

TODO: primjer

#### 95. Koliko instanci enum tipa se može kreirati za vrijeme izvođenja programa?

Ne mogu se kreirati nove instance tipa enum (`static`). Instance enum-a su definirane u popisu enum konstanti.

#### 96. Koji su implicitni modifikatori za enum varijable?

enum konstante su po ponašanju final `static` (te se ključne riječi ne navode) varijable enum tipa koje su implicitno inicijalizirane prilikom učitavanja enum tipa (klase)

#### 97. Kada se inicijaliziraju enum konstante?

Prilikom učitavanja enum tipa (klase). Pošto su enum konstante `static` tada se koriste putem naziva enum tipa.

#### 98. Navedite razlike između enum tipa i klase?

Enum nasljeđuje klasu `java.lang.Enum`, i time dobiva set ponašanja (metode), tretiraju se kao posebne vrste klasa te su mu članovi predefinirani (`static`).

#### 99. Opišite metodu `values()` enum tipa.

```
static EnumTypeName[] values()
```
- vraća niz enum konstanti definiranih u enum tipu redoslijedom kako su definirane

#### 100. Opišite metodu `valueOf()` enum tipa.

```JAVA
Static EnumTypeName valueOf(String name)
```
- Vraća enum konstantu sa specificiranim nazivom. 
- Ako ne postoji enum konstanta sa tim nazivom baca se `IllegalArgumentException` (prosljeđuje s samo naziv enum konstante)

#### 101. Opišite metodu `ordinal()` enum tipa.

```JAVA
final int ordinal()
```
- Vraća redni broj enum konstante (pozicija u deklaraciji enum konstanti). 
- Enum konstante u enum tipu su numerirane počevši od 0.

#### 102. Koliko klasa i koliko interface-a može enum tip naslijediti?

Kao i klase, mogu implementirati interface-e. 

- Enum implicitno nasljeđuje samo klasu `java.lang.Enum` (nema višestrukog nasljeđivanja). 
- Enum klasa se ne može naslijediti niti može biti naslijeđena.

TODO: primjer, multiple inheritance

### PACKAGE

#### 103. Što je i što definira paket (package)?

- Paket (`package`) je skup povezanih klasa i interface-a koji omogućuju zaštitu pristupa i upravljanje prostorom imena (`namespace`)

- Paketi grupiraju klase po njihovoj funkciji: osnovne klase su u paketu `java.lang`, klase za čitanje i pisanje (ulaz i izlaz) su u `java.io` ...

#### 104. Koji su elementi i pravila deklaracije paketa?

Deklarira se pomoću iskaza package na vrhu datoteke s izvornim kodom u kojem je definirana klasa ili interface

```JAVA
package graphics;

public class Circle extends Graphic implements Draggable
{
    ...
}
```

Klasa `circle` je `public` član `graphics` paketa

- Iskaz `package`mora se uključiti na vrhu svake izvorne datoteke koja definira klasu ili interface unutar `graphics` paketa

#### 105. Na koji način se mogu koristiti public članovi nekog paketa?

Svi public članovi su dostupni i izvan paketa
Za korištenje javnih package članova izvan paketa, mora se učiniti jedno od slijedećeg:

- Dohvatiti član uz pomoć njegovog dugog (kvalificiranog) imena
- Uvesti član paketa
- Uvesti cijeli paket


#### 106. Koji su elementi i pravila deklaracije uvoza članova nekog paketa?

Pomoću import iskaza na početku datoteke prije bilo koje definicije klase ili interface-a, ali nakon `package` iskaza.

```JAVA
import graphics.Circle;
```

- Sada se klasa `Circle` može koristiti pomoću jednostavnog imena:
```JAVA
Circle myCircle = new Circle();
```

- Uvoz cijelog paketa:
```JAVA
import graphics.*;
```

#### 107. Kako se mogu uvesti statički članovi klase?

Pomoću ključnih riječi `static import`
- Nakon uvoza takvi članovi se mogu koristiti sa jednostavnim imenom


#### 108. U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?

Java platforma oslanja se na hijerarhijski datotečni sistem radi upravljanja izvornim i `.class` datotekama. Izvorni kod klase ili interface se smješta u datoteku koja ima isti naziv kao i jednostavno ime klase ili interface-a čiji je nastavak `.java`

#### 109. Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?

Osnovno ime izlazne datoteke je ime klase ili interface-a, a njezina ekstenzija je `.class`.
Kao i `.java` datoteke, `.class` datoteka također treba biti u nizu direktorija koji odražavaju ime paketa. Međutim, ne mora biti u istom direktoriju u kojem je izvorna datoteka.

### IZNIMKE

#### 110. Koje su osnovne prednosti korištenja iznimki za obradu pogreški?

- Odvajanje koda koji obrađuje pogreške od "regularnog" koda
- Propagiranje pogreški kroz call stack
- Grupiranje tipova pogreški i njihovo razlikovanje


#### 111. Što su to iznimke?

Iznimka je događaj koji ometa prirodni tok izvršavanja programa

#### 112. Navedite osnovne metode Throwable klase.

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
- vraća se kratki opis iznimke koji se najčešće sastoji od naziva klase i stringa kojeg vraća `getMessage()` metoda


#### 113. Navedite glavnu podjelu iznimki? Navedite razlike.

`Throwable` klasa ima dva direktna nasljednika: Pogreške (**Errors**), iznimke (**Exceptions**). 

- `Error` predstavlja "jaku" pogrešku i tipični java programi ne bi trebali hvatati error-e. 
- `Exception` ima mnoge nasljednike, koje indiciraju različite tipove iznimki – predstavlja grupu iznimki koje se najčešće žele uhvatiti.

#### 114. Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.

Osim `RuntimeException`, `Error` i njihovih podklasa sve iznimke se nazivaju provjeravanim iznimkama (**checked exceptions**)

TODO: razlike

#### 115. Navedite pravila rada sa provjeravanim iznimkama.

Metoda mora ili hvatati ili navesti sve provjeravane iznimke koje mogu biti bačene unutar dosega metode

- Uhvati (`catch`) blok – metoda će uhvatiti ako osigura exception handler za taj tip iznimke (**try-catch-finally**) blok
- Navedi (`specify`) blok - ako metoda odlučni ne uhvatiti iznimku, tada moda eksplicitno naglasiti da može baciti tu iznimku (`throws`)

#### 116. Navedite i opišite elemente hvatanja i obrade iznimki?

try
catch
finally
throw

TODO: opis

#### 117. Kako se postiže općeniti exception handler (hvata vište tipova iznimki)?

```JAVA
catch (SomeThrowableObject variableName) {
    Java statements
}
```

#### 118. Kako se bacaju iznimke? Navedite primjer.

Iskaz `throw` služi za bacanje iznimki:

```JAVA
…
if (size == 0)
    throw new EmptyStackException(„opis iznimke“);
…
```
- zahtjeva samo jedan argument: throwable objekt; throwable objekti u Javi su instance ili podklase `Throwable` klase

- zaustavlja normalno izvođenje i runtime sistem počinje sa traženjem odgovarajućeg exception handlera

#### 119. Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.

Pomoću iskaza `throws`: 

- u `throws` iskazu metode moraju se navesti sve provjeravane iznimke koje nisu obrađene u metodi

```JAVA
someMethod(…)
    throws <ExceptionType1>, <ExceptionType2>, …,<ExceptionTypen>
```

- U metodi se mogu bacati i provjeravane iznimke koje su podklase iznimki definiranih u `throws` iskazu
- U `throws` dijelu mogu se navesti i neprovjeravane iznimke ali to je nepotrebno jer kompajler ne provjerava takve iznimke
- Metoda koja koristi metodu koja ima `throws` iskaz mora ili uhvatiti ili navesti te navedene iznimke


#### 120. Kako se definiraju novi tipovi provjeravanih i neprovjeravanih iznimki?

Da bi se definirala nova provjeravana iznimka može se naslijediti `Exception` klasa direktno ili neka druga njena podklasa

Neprovjeravane iznimke se definiraju ako se naslijedi klasa `RuntimeException` ili neka njena podklasa

Iznimke su definirane kao klase i mogu imati svoje članove (varijable, metode, …)


#### 121. Navedite elemete iskaza „assert“.

`assert` iskazi se koriste u kodu da se dokumentiraju i provjeravaju pretpostavke pod kojima je kod napisan

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

### IO

#### 122. Navedite podjelu "stream" klasa ovisno o tipu podataka. Navedite glavne klase svake grupe.

`Stream` klase podijeljene su u dvije hijerarhije klasa, ovisno o tipu podataka (karakteri ili bajtovi) nad kojima operiraju.

- Tokovi karaktera: `Reader` i `Writer` (16-bit karakteri)
- Tokovi bajtova: `InputStream` i `OutputStream` (8-bit bajtovi)

#### 123. Navedite kategorije stream klasa.

Glavne kategorije su tokovi karaktera i tokovi bajtova:

- **Reader**: čitanje karaktera
- **Writer**: pisanje karaktera
- **InputStream**: čitanje bajtova
- **OutputStream**: pisanje bajtova

#### 124. Navedite osnovne metode Reader klase.

- BufferedReader, 
- CharArrayReader, 
- InputStreamReader, 
- FilterReader, 
- PipedReader, 
- StringReader

#### 125. Navedite osnovne metode InputStream klase.

- FileInputStream, 
- PipedInputStream, 
- FilterInputStream, 
- ByteArrayInputStream, 
- SequenceInputStream, 
- StringBufferInputStream, 
- ObjectInputStream

#### 126. Navedite osnovne metode Writer klase.

- BufferedWriter, 
- CharArrayWriter, 
- OutputStreamWriter, 
- FilterWriter, 
- PipedWriter, 
- StringWriter, 
- PrintWriter

#### 127. Navedite osnovne metode OutputStream klase.

- FileOutputStream, 
- PipedOutputStream, 
- FilterOutputStream, 
- ByteArrayOutputStream, 
- ObjectOutputStream, 
- OutputStream*

### THREADS

#### 128. Što je to nit i što omogućava?

Nit predstavlja jedan sekvencijalni tok izvršavanja unutar programa. Omogućavaju pokretanje više niti (koji rade različite zadatke) unutar jednog programa

#### 129. Kako se postiže implementacija niti?

Postiže se:

- implementacijom java.lang.Runnable interface-a
- nasljeđivanjem java.lang.Thread klase


#### 130. Kada završava nit?

Nit završava kada je završeno izvođenje run metode bilo regularnim putem ili iznimkom

#### 131. Koji su koraci i način pokretanja niti kod nasljeđivanja Thread klase?

- Klasa koja nasljeđuje Thread klasu prepisuje run metodu
- podklasa može eksplicitno zvati konstruktor nadklase u svom konstruktoru da inicijalizira nit pomoću `super()` poziva
- pokreće se naslijeđena metoda `start()` iz Thread klase na objektu da se proglasi nit spremnim za pokretanje

#### 132. Koji su koraci i načini pokretanja niti kod implementacije Runnable interface-a?


- Klasa implementira `Runnable` interface i definira run metodu koja će se pokrenuti od strane niti. Objekt te klase je `Runnable` objekt
- Kreira se objekt klase Thread putem konstruktora kojem se kao argument proslijeđuje `Runnable` objekt
- Pokreće se `start()` metoda nad Thread objektom. Metoda `start()` zaršava čim je kreirana nova nit


#### 133. Koja je razlika između daemon i user niti? Koja je metoda za definiranje tipa niti.

- **daemon** – ako u programu ostanu samo daemon niti, program izlazi.
- **user** – program čeka završetak svih user niti

#### 134. Navedite načine privremenog zaustavljanja niti.

Nit se privremeno zaustavlja:

- Kada je pozvana `sleep()` metoda
- Nit je pozvala `wait()` metodu kako bi pričekala da se nešto dogodi
- Nit je blokirana na IO (input/output) funkciji


#### 135. Navedite načine pokretanja privremeno zaustavljene niti.

- Ako nit upadne u stanje spavanja, mora proći određeni broj milisekundi
- Ako nit čeka na uvjet, tada drugi objekt mora obavijestiti nit koja čeka da je nastupila promjena (pozivom `notify()` ili `notifyAll()`)
- Ako je nit blokirana IO operacijom, tada ta operacija mora završiti.


#### 136. Navedite i opišite osnovna stanja niti (getState).

Metoda vraća stanje niti (enum).

- **NEW** (kreirana ali nije startana), 
- **RUNNABLE** (izvršava se u JVM), 
- **BLOCKED** (blokirana čekajući na lock), 
- **WAITING** ( čeka na neodređeno vrijeme da neki drugi thread obavi određenu operaciju), 
- **TIMED_WAITING** (čeka određeno vrijeme da neki drugi thread obavi određenu operaciju), 
- **TERMINATED** (završeno izvršavanje)

#### 137. Kako se određuje prioritet niti?

Pomoću algoritma koji se zove **fixed priority scheduling** – raspoređuje niti ovisno o njezinom relativnom prioritetu (MIN_PRIORITY 1 do MAX_PRIORITY 10) koje se nasljeđuje od niti koja ju je kreirala ili izmjenjuje metodom `setPriority()`.

#### 138. Kojim se metodama omogućava da nit omogući izvršavanje i drugih niti?

Statičkom `yield()` metodom klase `Thread` – trenutna nit prepušta CPU ako postoje druge niti koje čekaju svoje vrijeme

```JAVA
Thread.yield();
```

Statičkom metodom sleep klase `Thread` – zaustavlja trenutnu nit 

```JAVA
Thread.sleep(long millis)
Thread.sleep(long millis, int nanos)
```

#### 139. Navedite načine sinkronizacije dijela koda.

Deklariranjem: 

- sinkroniziranih metoda – ako se metoda treba izvršavati u jednoj niti – metoda se deklarira ključnom riječi synchronized
 - sinkroniziranih blokova koda – zaključava se brava objekta nad kojim se poziva metoda


#### 140. Opišite svojstva i način deklaracije sinkronizirane metode.

- Kod sinkroniziranih metoda zaključava se brava objekta nad kojim se poziva metoda

- Ako se metoda objekta treba izvršavati u jednoj niti u jednom trenutku tada se takva metoda treba deklarirati sa ključnom riječi synchronized

- Nit će otključati bravu samim time što će izići iz
sinkronizirane metode


#### 141. Opišite svojstva i način deklaracije sinkroniziranih blokova.

- Kod sinkroniziranih blokova može se ograditi proizvoljni dio koda i odrediti objekt čija se brava koristi za zaključavanje

```JAVA
synchronized (<izraz koji daje referencu na objekt>) { 
    <blok koda> 
}
```

#### 142. Koje metode služe za sinkronizaciju različitih niti?

- Zaključavanjem objekta – thread koji pokuša pozvati sinkroniziranu metodu tog objekta bit će blokiran dok se objekt ne otključa

- Jednostavnim koordiniranjem - obavještavanjem kada je thread spreman – metode: 

`wait()`, 

`notify()`, 

`notifyAll()`


#### 143. Navedite osnovna svojstava wait metoda.

Zaustavlja izvršavanje niti i prebacuje nit u stanje čekanja na obavijest, ostale metode mogu zaključati isti objekt

#### 144. Kako se pokreće nit koja je zaustavljena pozivom wait metode?

Ako neka druga nit pozove `notify()` metodu, ako istekne vrijeme čekanja ili neka druga nit prekine nit koja čeka (pozivom metode `interrupt()`)

#### 145. Navedite osnovna svojstva `notify()` i `notifyAll()` metoda.

- `notify()` – budi samo jednu nit
- `notifyAll()` – budi sve niti koje su u stanju čekanja na obavijest 

Koriste se samo za obavještavanje, one ne otključavaju bravu nad objektom.
Nit otključava objekt tek kada izađe iz sinkronizirane metode/bloka.


#### 146. Kako se grupiraju niti?

Svaka nit je član grupe niti. Grupe omogućavaju mehanizam manipuliranja nitima odjednom. Ako grupa nije navedena, nova nit se stavlja u podrazumijevanu grupu (`main` grupa).

Primjer konstruktora:

```JAVA
Thread(ThreadGroup group, Runnable target)
…

```

#### 147. Kako se postiže da nit čeka na završetak izvođenja neke druge niti?

Pozivanjem `join()` metode. Pozivajuća nit metode `join()` ide u wait i nalazi se u wait-u dok se referencirana nit ne završi.

TODO: primjer

#### 148. Koje uvjete mora zadovoljiti prepisana equals metoda?

- Refleksivnost: za svaku referencu self `self.equals(self) = true`
- Simetričnost: za svaku referencu x, y vrijedi da je `x.equals(y) = true` ako i samo ako je `y.equals(x) = true`
- Tranzitivnost: za svaku referencu x, y, z vrijedi da ako je `x.equals(y) = true` i `y.equals(z) = true` onda vrijedi da je i `x.equals(z)=true`
- Konzistentnost: za bilo koju referencu x, y uzastopni pozivi `x.equals(y)` će uvijek dati isti rezultat ako se objekti na koje pokazuju reference nisu mijenjali
- Null usporedba: za svaku referencu obj koja nije null vrijedi `obj.equals(null)=false`


#### 149. Koje uvjete mora zadovoljiti prepisana hashCode metoda?

- Konzistentnost: višestruko pozivanje metode moraju dati istu hash vrijednost ako se stanje objekta nije toliko promijenilo da se promijeni vrijednost koja se vraća equals metodom
- Ako su dva objekta jednaki po equals metodi tada trebaju dati istu hash vrijednost
- Ako dva objekta nisu jednaki po equals metodi tada nema ograničenja na njihove hash vrijednosti. Ne moraju imati različite hash vrijednosti ali je to preporučljivo
- Objekti sa istim hash vrijednostima ne moraju biti jednaki


#### 150. Koji interface-i služe za sortiranje objekata? Opišite metode pojedinih interface-a.

`Comparable<E>` interface - služi za prirodno sortiranje objekata
- `int compareTo(E o)` - vraća negativnu,0 , pozitivnu vrijednost ako je trenutni objekt manji, jednak ili veći od proslijeđenog objekta

`Comparator<E>` interface – služi za sortiranje objekata
- `int compare(E o1, E o2)` – vraća negativnu (o1 manji), 0 (jednaki su), pozitivnu (o1 veći) vrijednost


#### 151. Kako se realizira sekvencijalni dohvat elemenata kolekcije? Opišite metode koje se koriste.

Realizira se iteratorom:

`Iterator<E> iterator()`

- `boolean hasNext()` – vraća true ako postoji slijedeći element koji se može dohvatiti
- `E next()` – vraća slijedeći element kolekcije
- `void remove()` – opcionalno, izbacuje element koji je zadnji vraćen iz kolekcije


#### 152. Koje su osnovne vrste kolekcija?

**Setovi**– ne dopuštaju duplikate u kolekciji

**Liste** – čuvaju poredak elemenata i mogu sadržavati duplikate

**Mape** – strukture koje sadrže parove „ključ-vrijednost“


#### 153. Navedite svojstva i primjere implementacije setova.

**Setovi** – ne dopuštaju duplikate u kolekciji

TODO: završiti ovo

#### 154. Navedite svojstva i primjere implementacije listi.

**Liste** – čuvaju poredak elemenata i mogu sadržavati duplikate

- Ponašanje definirano List interface-om
- Svaki element ima svoju poziciju u kolekciji i indeks počinje od 0
- Pozicija elemenata se može mijenjati ako se dodaju i uklanjaju elementi iz kolekcije
- Osim metoda koje su definine u Collection interface-u, List interface definira i svoje metode za rad po listama (preko indeksa)


#### 155. Navedite svojstva i primjere implementacije mapa.

**Mape** – strukture koje sadrže parove "ključ-vrijednost"

- Ne može sadržavati duplikate ključeva
- Svaki ključ vodi samo do jedne vrijednosti
- I ključ i vrijednost moraju biti objekt
- Implementiraju interface `Map<K,V>`, koji sadrži metode za dodavanje novih elemenata, dohvaćanje postojećih, dohvaćanje Set-a ključeva, dohvaćanje vrijednosti itd.
- Map interface ne nasljeđuje `Collection`
