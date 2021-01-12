Pitanja i odgovori
=================

### KLASE II
---
### 76.	Koju klasu naslijeđuju sve klase (direktno ili indirektno)?

Klasu `Object`
---
### 77.	Čemu služe `equals()` i `getHashCode()` metode?

- Metoda `equals()` uspoređuje dva objekta i vraća true ako su jednaki.
- Vrijednost koju vraća `getHashCode()` je cijeli broj koji mapira objekt u hash tablicu. 

Ove metode se moraju prepisati zajedno.
---
### 78.	Koja metoda služi za konverziju objekta u string (npr. + operatorom i spajanjem sa String)?

Metoda `toString()` – vraća String reprezentaciju objekta.
---
### 79.	Kojim članovima može pristupiti statički ugniježdena klasa?  Sa kojim modifikatorima pristupa su dostupni članovi statički ugniježdenoj klasi?

- Statički ugniježđena klasa može pristupiti samo statičkim članovima u svojem okružujućem kontekstu. 
- Imaju sve modifikatore pristupa (private, protected, public i bez modifikatora).
---
### 80.	Kojim članovima može pristupiti unutrašnja klasa?  Sa kojim modifikatorima pristupa su dostupni članovi unutrašnje klase?

- Unutrašnja klasa je pridružena instanci klase u kojoj je definirana – ima direktan pristup varijablama i metodama te instance. 
- Moguće je definirati sve modifikatore pristupa.
---
### 81.	Kako se kreira nova instanca unutrašnje klase?

Unutrašnje klase se ne mogu kreirati bez da su pridružene nekoj instanci klase u kojem je definirana.

```java
<referenca klase>.new <poziv konstruktora ugnježđene klase>
```

Unutar klase u kojoj se nalazi ugniježdena klasa može se
koristiti i običan poziv:

```java
new <poziv konstruktora ugnježđene klase> // što je ekvivalentno
this.new <poziv konstruktora ugnježđene klase>
```
---
### 82.	Kako se pristupa članovima okružujuće klase koji su skriveni u unutrašnjoj klasi?

```java
<naziv klase>.this
```
---
### 83.	Što su to lokalne klase?

Klasa definirana unutar nekog bloka (tijelu metode, tijelu konstruktora, lokalni blok, statički
inicijalizacijski blok, inicijalizacijski blok instance)
---
### 84.	Koja su pravila pristupa lokalne klase članovima okružujuće klase? 

- Ako se radi o ne statičkom bloku, gdje je dostupna `this` referenca onda se lokalna klasa ponaša kao i unutrašnja klasa po pitanju pristupa varijablama klase. Takva klasa je povezana sa instancom okružujuće klase.

- Ako se radi o statičkom bloku onda se ponaša kao i statička ugniježdena klasa po pitanju pristupa varijablama

- Kod lokalne klase ne može se koristiti static modifikator
---
### 85.	Kojim varijablama ima pristup lokalna klasa iz okružujućeg bloka?

Ima pristup samo final parametrima i final lokalnim varijablama iz okružujuće metode.

[primjer](primjeri.md#primjer-lokalnih-klasa)

---
### 86.	Što su to anonimne klase? Navedite elemente iskaza za kreiranje anonimne klase?

Anonimne klase objedinjuju definiciju i kreiranje objekta klase u jedan iskaz:

```java
new <naziv nadklase koja se naslijeđuje> (<opcionalna lista argumenata koji se prosljeđuje konstruktoru>)
{ <definicija članova> }
```

Anonimne klase:

- nemaju ime
- mogu biti instancirane samo jednom
- dostupne su samo sa mjesta gdje su definirane
- nemaju konstruktor (jer nemaju naziv)
- ne mogu biti statičke

[primjer](primjeri.md#primjer-anonimne-klase)
---
### 87.	Navedite pravila pristupa anonimne klase varijablama i metodama okružujućeg bloka/klase.

- Za anonimnu klasu vrijede ista pravila pristupa varijablama i metodama okružujuće metode/klase kao i za lokalnu klasu

### INTERFACE
---
### 88. Što je to interface?

Interface predstavlja imenovani skup metoda bez implementacije. Može definirati konstante.
---
### 89. Navedite razlike između interface-a i apstraktne klase?

- Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može 
- Klasa može implementirati mnogo interface-a, ali smije imati samo jednu nadklasu
- Interface nije dio hijerarhije klasa. Klase koje nisu u odnosu mogu implementirati isti interface
---
### 90. Navedite elemente deklaracije interface-a?

Pomoću ključne riječi interface i naziva

primjer:
```java
public interface InterfaceName {
    <InterfaceBody>
}
```

- nije moguće koristiti transient, volatile ili synchronized u deklaraciji člana interface-a
- također, nije moguće koristiti ni private i protected modifikatore
---
### 91. Koliko interface-a može pojedini interface naslijediti?

Interface podržava višestruko naslijeđivanje; novi interface može se proširiti listom interface-a pomoću `extends`

primjer:

```java
public interface A {
      void a();
}

public interface B {
      void b();
}

public interface AB extends A, B {
}
```
---
### 92. Koji su implicitni modifikatori uz metodu interface-a?

`public` i `abstract`
---
### 93. Koji su implicitni modifikatori uz varijablu interface-a?

`public`, `static` i `final`

### ENUM
---
### 94. Navedite elemente deklaracije enum tipa?

```java
// enum naziv { <popis enum konstanti> }
enum E { E1, E2, E3 }
```

[primjer](primjeri.md#primjer-enum)

[primjer](primjeri.md#primjer-enum-s-konstruktorom)

---
### 95. Koliko instanci enum tipa se može kreirati za vrijeme izvođenja programa?

Ne mogu se kreirati nove instance tipa enum.
---
### 96. Koji su implicitni modifikatori za enum varijable?

`final` i `static`
---
### 97. Kada se inicijaliziraju enum konstante?

Prilikom učitavanja enum tipa
---
### 98. Navedite razlike između enum tipa i klase?

- nije moguće kreirati nove enum instance
- enum ne može biti naslijeđena
---
### 99. Opišite metodu `values()` enum tipa.

```
static EnumTypeName[] values(); // vraća niz enum konstanti redoslijedom kako su definirani
```
---
### 100. Opišite metodu `valueOf()` enum tipa.

```java
Static EnumTypeName valueOf("naziv"); // vraća enum konstantu sa specificiranim nazivom
```
---
### 101. Opišite metodu `ordinal()` enum tipa.

```java
final int ordinal(); // vraća redni broj enum konstante počevši od 0
```
---
### 102. Koliko klasa i koliko interface-a može enum tip naslijediti?

- Enum implicitno naslijeđuje klasu `java.lang.Enum` i ne može biti naslijeđena (Enum klasa je implicitno final)
- Enum klasa može implementirati više interface-a

### PACKAGE
---
### 103. Što je i što definira paket (package)?

- Paket (`package`) je skup povezanih klasa ili interface-a
- unutar paketa definiraju se različiti tipovi i interface-i
---
### 104. Koji su elementi i pravila deklaracije paketa?

```java
package graphics;
```
- Iskaz `package`mora se uključiti na vrhu svake izvorne datoteke koja definira klasu ili interface unutar `graphics` paketa
---
### 105. Na koji način se mogu koristiti public članovi nekog paketa?

- Svi public članovi su dostupni i izvan paketa
- dohvaćanje pomoću: 
  - njegovog dugog (kvalificiranog) imena
  - uvozom svih članova paketa
  - uvozom člana paketa
---
### 106. Koji su elementi i pravila deklaracije uvoza članova nekog paketa?

Pomoću `import` iskaza na početku datoteke kako bi članu kasnije pristupali pomoću jednostavnog imena

```java
import graphics.Circle; // uvoz Circle člana paketa graphics
import graphics.*; // uvoz svih članova paketa graphics
```
---
### 107. Kako se mogu uvesti statički članovi klase?

Pomoću ključnih riječi `static import`
---
### 108. U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?

```
neki.paket.Klasa
(sources) \ (neki) \ (paket) \ Klasa.java  
```    

direktoriji se prate hijerarhijski prema nazivu paketa 
---
### 109. Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?

```
(classes) \ (neki) \ (paket) \ Klasa.class  
```

direktoriji se prate hijerarhijski prema nazivu paketa, `.class` i `.java` ne moraju biti u istom naddirektoriju

### IZNIMKE
---
### 110. Koje su osnovne prednosti korištenja iznimki za obradu pogreški?

- Odvajanje koda koji obrađuje pogreške od "regularnog" koda
- Propagiranje pogreški kroz call stack
- Grupiranje tipova pogreški i njihovo razlikovanje
---
### 111. Što su to iznimke?

Iznimka je događaj koji ometa prirodni tok izvršavanja programa
---
### 112. Navedite osnovne metode `Throwable` klase.

```java
String getMessage(); // vraća poruku iznimke
String toString(); // vraća se obično kratki opis iznimke
void printStackTrace(); // ispisuje se tok stog poziva (call stack)
```
---
### 113. Navedite glavnu podjelu iznimki? Navedite razlike.

- `Error` - predstavlja "jaku" pogrešku, obično se ne obrađuje
- `Exception` ima mnoge nasljednike - predstavlja grupu iznimki, obrađuje se
---
### 114. Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.

- neprovjeravane - `RuntimeException`, `Error` i podklase -> one koje se ne obrađuju
- provjeravane - sve ostale -> one koje se obrađuju
---
### 115. Navedite pravila rada sa provjeravanim iznimkama.

Metoda mora ili hvatati (`catch`) ili navesti (`specify`) sve provjeravane iznimke koje mogu biti bačene
---
### 116. Navedite i opišite elemente hvatanja i obrade iznimki?

ovim redoslijedom:

- `try` - blok unutar kojeg se može baciti exception
- `catch` - blok koji hvata taj exception i obrađuje ga
- `finally` - blok koji se uvijek izvršava nakon try-catch bloka (neovisno je li bačen exception)
---
### 117. Kako se postiže općeniti exception handler (hvata vište tipova iznimki)?

```java
catch (ThrowableObject t) {
    ...
}
```
---
### 118. Kako se bacaju iznimke? Navedite primjer.

Iskaz `throw` služi za bacanje iznimki:

```java
…
if (size == 0)
    throw new throwable("opis iznimke");
…
```
---
### 119. Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.

```java
someMethod(…)
    throws <ExceptionType1>, <ExceptionType2>, …,<ExceptionTypen>
```

- mogu se baciti podklase provjeravanih iznimki
---
### 120. Kako se definiraju novi tipovi provjeravanih i neprovjeravanih iznimki?

Naslijeđivanjem `Exception` (provjeravanih) i `RuntimeException` (neprovjeravanih) klasa i podklasa
---
### 121. Navedite elemete iskaza „assert“.

```java
assert <boolean izraz> ; // Jednostavni oblik
assert <boolean izraz > : <izraz poruke>;
```
ekvivalentno:

```java
if (<omogućeni asserti> && !<boolean izraz>)
    // Jednostavni oblik
    throw new AssertionError();

if (<omogućeni asserti> && !<boolean izraz>)
    throw new AssertionError(<izraz poruke>);
```
 - Assert poruka se ispisuje kada je assert
vrijednost false
### IO
---
### 122. Navedite podjelu "stream" klasa ovisno o tipu podataka. Navedite glavne klase svake grupe.

`Stream` klase podijeljene su u dvije hijerarhije klasa, ovisno o tipu podataka (karakteri ili bajtovi) nad kojima operiraju.

- Tokovi karaktera: `Reader` i `Writer` (16-bit karakteri)
- Tokovi bajtova: `InputStream` i `OutputStream` (8-bit bajtovi)
---
### 123. Navedite kategorije stream klasa.

- klase koje čitaju/pišu u izvore/ponore podataka
- klase koje izvršavaju neku vrstu procesiranja
---
### 124. Navedite osnovne metode Reader klase.

```java
int read() // vraća int vrijednost pročitanog znaka
int read(char cbuf[])
int read(char cbuf[], int offset, int length)
```---
### 125. Navedite osnovne metode InputStream klase.

```java
int read() // vraća int vrijednost pročitanog byta
int read(byte cbuf[])
int read(byte cbuf[], int offset, int length)
```
---
### 126. Navedite osnovne metode Writer klase.

```java
int write(int c)
int write(char cbuf[])
int write(char cbuf[], int offset, int length)
```
---
### 127. Navedite osnovne metode OutputStream klase.

```java
int write(int c)
int write(byte cbuf[])
int write(byte cbuf[], int offset, int length)
```

### THREADS
---
### 128. Što je to nit i što omogućava?

Nit predstavlja jedan sekvencijalni tok izvršavanja unutar programa. Omogućavaju pokretanje više niti (koji rade različite zadatke) unutar jednog programa
---
### 129. Kako se postiže implementacija niti?

Postiže se:

- implementacijom java.lang.Runnable interface-a
- nasljeđivanjem java.lang.Thread klase
---
### 130. Kada završava nit?

Nit završava kada je završeno izvođenje run metode bilo regularnim putem ili iznimkom
---
### 131. Koji su koraci i način pokretanja niti kod nasljeđivanja Thread klase?

- Klasa koja nasljeđuje Thread klasu prepisuje run metodu
- podklasa može eksplicitno zvati konstruktor nadklase u svom konstruktoru da inicijalizira nit pomoću `super()` poziva
- pokreće se naslijeđena metoda `start()` iz Thread klase na objektu da se proglasi nit spremnim za pokretanje

```java
@Override
public void run() { ... } // prepisivanje run metode
super("threadName"); // inicijaliziranje niti pozivom konstruktora
start(); // pokretanje niti
```
[primjer](primjeri.md#pokretanje-niti-naslije%C4%91ivanjem-thread-klase)
---
### 132. Koji su koraci i načini pokretanja niti kod implementacije Runnable interface-a?

- Klasa implementira `Runnable` interface i definira run metodu koja će se pokrenuti od strane niti. Objekt te klase je `Runnable` objekt
- Kreira se objekt klase Thread putem konstruktora kojem se kao argument proslijeđuje `Runnable` objekt
- Pokreće se `start()` metoda nad Thread objektom. Metoda `start()` zaršava čim je kreirana nova nit

```java
class X implements Runnable {
    public static void main(String[] args) {
        X run = new X(); 
        Thread t = new Thread(run);
        t.start();
    }
    public void run() {
    }
}
```

[primjer](primjeri.md#pokretanje-niti-implementrianjem-runnable-interface-a)
---
### 133. Koja je razlika između daemon i user niti? Koja je metoda za definiranje tipa niti.

- **daemon** – ako u programu ostanu samo daemon niti, program izlazi.
- **user** – program čeka završetak svih user niti
---
### 134. Navedite načine privremenog zaustavljanja niti.

Nit se privremeno zaustavlja:

- Kada je pozvana `sleep()` metoda
- Nit je pozvala `wait()` metodu kako bi pričekala da se nešto dogodi
- Nit je blokirana na IO (input/output) funkciji
---
### 135. Navedite načine pokretanja privremeno zaustavljene niti.

- Ako nit upadne u stanje spavanja, mora proći određeni broj milisekundi
- Ako nit čeka na uvjet, tada drugi objekt mora obavijestiti nit koja čeka da je nastupila promjena (pozivom `notify()` ili `notifyAll()`)
- Ako je nit blokirana IO operacijom, tada ta operacija mora završiti.
---
### 136. Navedite i opišite osnovna stanja niti (`getState()`).

Metoda vraća stanje niti (enum).

- **NEW** (kreirana ali nije startana), 
- **RUNNABLE** (izvršava se u JVM), 
- **BLOCKED** (blokirana čekajući na lock), 
- **WAITING** ( čeka na neodređeno vrijeme da neki drugi thread obavi određenu operaciju), 
- **TIMED_WAITING** (čeka određeno vrijeme da neki drugi thread obavi određenu operaciju), 
- **TERMINATED** (završeno izvršavanje)
---
### 137. Kako se određuje prioritet niti?

Pomoću algoritma koji se zove **fixed priority scheduling** – raspoređuje niti ovisno o njezinom relativnom prioritetu (MIN_PRIORITY 1 do MAX_PRIORITY 10) koje se nasljeđuje od niti koja ju je kreirala ili izmjenjuje metodom `setPriority()`.
---
### 138. Kojim se metodama omogućava da nit omogući izvršavanje i drugih niti?

- Statičkom `yield()` metodom klase `Thread` – trenutna nit prepušta CPU ako postoje druge niti koje čekaju svoje vrijeme

```java
Thread.yield();
```
- Statičkom metodom sleep klase `Thread` – zaustavlja trenutnu nit 

```java
Thread.sleep(long millis)
Thread.sleep(long millis, int nanos)
```
---
### 139. Navedite načine sinkronizacije dijela koda.

Deklariranjem: 

- sinkroniziranih metoda – ako se metoda treba izvršavati u jednoj niti – metoda se deklarira ključnom riječi `synchronized`
 - sinkroniziranih blokova koda – zaključava se brava objekta nad kojim se poziva metoda
---
### 140. Opišite svojstva i način deklaracije sinkronizirane metode.

- Kod sinkroniziranih metoda zaključava se brava objekta nad kojim se poziva metoda

- Ako se metoda objekta treba izvršavati u jednoj niti u jednom trenutku tada se takva metoda treba deklarirati sa ključnom riječi synchronized

- Nit će otključati bravu samim time što će izići iz
sinkronizirane metode
---
### 141. Opišite svojstva i način deklaracije sinkroniziranih blokova.

- Kod sinkroniziranih blokova može se ograditi proizvoljni dio koda i odrediti objekt čija se brava koristi za zaključavanje

```java
synchronized (<izraz koji daje referencu na objekt>) { 
    <blok koda> 
}
```
---
### 142. Koje metode služe za sinkronizaciju različitih niti?

koordiniranje se provodi metodama:

`wait();` - metoda čeka da se nešto dogodi, 

`notify();` - metoda budi samo jednu nit, 

`notifyAll();` - metoda budi sve niti koje su u stanju čekanja na obavijest
---
### 143. Navedite osnovna svojstava wait metoda.

Zaustavlja izvršavanje niti i prebacuje nit u stanje čekanja na obavijest, ostale metode mogu zaključati isti objekt
---
### 144. Kako se pokreće nit koja je zaustavljena pozivom wait metode?

Ako neka druga nit pozove `notify()` metodu, ako istekne vrijeme čekanja ili neka druga nit prekine nit koja čeka (pozivom metode `interrupt()`)
---
### 145. Navedite osnovna svojstva `notify()` i `notifyAll()` metoda.

- `notify()` – budi samo jednu nit
- `notifyAll()` – budi sve niti koje su u stanju čekanja na obavijest 

Koriste se samo za obavještavanje, one ne otključavaju bravu nad objektom.
Nit otključava objekt tek kada izađe iz sinkronizirane metode/bloka.
---
### 146. Kako se grupiraju niti?

Svaka nit je član grupe niti. Grupe omogućavaju mehanizam manipuliranja nitima odjednom. Ako grupa nije navedena, nova nit se stavlja u podrazumijevanu grupu (`main` grupa).

konstruktori u kojima se može odrediti grupa:

```java
Thread(ThreadGroup group, Runnable target)
Thread(ThreadGroup group, Runnable target, String name)
Thread(ThreadGroup group, Runnable target, String name, long stackSize)
Thread(ThreadGroup group, String name)
```
---
### 147. Kako se postiže da nit čeka na završetak izvođenja neke druge niti?

Pozivanjem `join()` metode. Pozivajuća nit metode `join()` ide u wait i nalazi se u wait-u dok se referencirana nit ne završi.

[primjer](primjeri.md#primjer-kori%C5%A1tenja-join-metode)
---
### 148. Koje uvjete mora zadovoljiti prepisana `equals();` metoda?

- Refleksivnost: za svaku referencu self `self.equals(self) = true`
- Simetričnost: za svaku referencu x, y vrijedi da je `x.equals(y) = true` ako i samo ako je `y.equals(x) = true`
- Tranzitivnost: za svaku referencu x, y, z vrijedi da ako je `x.equals(y) = true` i `y.equals(z) = true` onda vrijedi da je i `x.equals(z)=true`
- Konzistentnost: za bilo koju referencu x, y uzastopni pozivi `x.equals(y)` će uvijek dati isti rezultat ako se objekti na koje pokazuju reference nisu mijenjali
- Null usporedba: za svaku referencu obj koja nije null vrijedi `obj.equals(null)=false`
---
### 149. Koje uvjete mora zadovoljiti prepisana `hashCode();` metoda?

- Konzistentnost: višestruko pozivanje metode moraju dati istu hash vrijednost ako se stanje objekta nije toliko promijenilo da se promijeni vrijednost koja se vraća equals metodom
- Ako su dva objekta jednaki po equals metodi tada trebaju dati istu hash vrijednost
- Ako dva objekta nisu jednaki po equals metodi tada nema ograničenja na njihove hash vrijednosti. Ne moraju imati različite hash vrijednosti ali je to preporučljivo
- Objekti sa istim hash vrijednostima ne moraju biti jednaki
---
### 150. Koji interface-i služe za sortiranje objekata? Opišite metode pojedinih interface-a.

`Comparable<E>` interface - služi za prirodno sortiranje objekata
- `int compareTo(E o)` - vraća negativnu,0 , pozitivnu vrijednost ako je trenutni objekt manji, jednak ili veći od proslijeđenog objekta

`Comparator<E>` interface – služi za sortiranje objekata
- `int compare(E o1, E o2)` – vraća negativnu (o1 manji), 0 (jednaki su), pozitivnu (o1 veći) vrijednost
---
### 151. Kako se realizira sekvencijalni dohvat elemenata kolekcije? Opišite metode koje se koriste.

Iterator se dohvaća putem slijedeće metode Collection interface-a:

`Iterator<E> iterator()`

- `boolean hasNext()` – vraća true ako postoji slijedeći element koji se može dohvatiti
- `E next()` – vraća slijedeći element kolekcije
- `void remove()` – opcionalno, izbacuje element koji je zadnji vraćen iz kolekcije

Ako kolekcija implementira Iterable interface onda se kroz takvu kolekciju može kretati putem for(:) petlje:

```java
interface Iterable<E> {
	Iterator<E> iterator();
}
...
for (Integer integer : intList) {
	System.out.println(integer);
}

```
---
### 152. Koje su osnovne vrste kolekcija?

**Setovi**– ne dopuštaju duplikate u kolekciji

**Liste** – čuvaju poredak elemenata i mogu sadržavati duplikate

**Mape** – strukture koje sadrže parove „ključ-vrijednost“
---
### 153. Navedite svojstva i primjere implementacije setova.

**Setovi** 

- implementacije `Set` interface-a ne dopuštaju duplikate u kolekciji
- Set interface ne donosi niti jednu novu metodu u odnosu na `Collection`

```java
Set<String> hash_Set = new HashSet<String>(); 
hash_Set.add("alpha"); 
hash_Set.add("beta"); 
```	

```java
Set<Integer> a = new HashSet<Integer>();  
a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));  
```	---
### 154. Navedite svojstva i primjere implementacije listi.

- čuvaju poredak elemenata i mogu sadržavati duplikate
- Ponašanje definirano List interface-om
- Svaki element ima svoju poziciju u kolekciji i indeks počinje od 0
- Pozicija elemenata se može mijenjati ako se dodaju i uklanjaju elementi iz kolekcije
- Osim metoda koje su definine u `Collection` interface-u, `List` interface definira i svoje metode za rad po listama (preko indeksa)

```java
List<Integer> l1 = new ArrayList<Integer>(); 
  
// dodaje 1 na indeks 0 
l1.add(0, 1); 
  
// dodaje 2 na indeks 1
l1.add(1, 2); 
```			---
### 155. Navedite svojstva i primjere implementacije mapa.

- strukture koje sadrže parove "ključ-vrijednost"
- Ne može sadržavati duplikate ključeva
- Svaki ključ vodi samo do jedne vrijednosti
- I ključ i vrijednost moraju biti objekt
- Implementiraju interface `Map<K,V>`, koji sadrži metode za dodavanje novih elemenata, dohvaćanje postojećih, dohvaćanje Set-a ključeva, dohvaćanje vrijednosti itd.
- Map interface ne nasljeđuje `Collection`

```java
Map<String, Integer> hm = new HashMap<String, Integer>(); 
hm.put("a", new Integer(100));
hm.put("b", new Integer(200)); 
```