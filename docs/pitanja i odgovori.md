Pitanja i odgovori
=================

### KLASE II

#### 76.	Koju klasu nasljeđuju sve klase (direktno ili indirektno)?

Klasu `Object`

#### 77.	Čemu služe `equals()` i `getHashCode()` metode?

- Metoda `equals()` uspoređuje dva objekta i vraća true ako su jednaki.
- Vrijednost koju vraća `getHashCode()` je cijeli broj koji mapira objekt u hash tablicu. 

Ove metode se moraju prepisati zajedno.

#### 78.	Koja metoda služi za konverziju objekta u string (npr. + operatorom i spajanjem sa String)?

Metoda `toString()` – vraća String reprezentaciju objekta.

#### 79.	Kojim članovima može pristupiti statički ugniježdena klasa?  Sa kojim modifikatorima pristupa su dostupni članovi statički ugniježdenoj klasi?

- Statički ugniježđena klasa može pristupiti samo statičkim članovima u svojem okružujućem kontekstu. 
- Imaju sve modifikatore pristupa (private, protected, public i bez modifikatora).

#### 80.	Kojim članovima može pristupiti unutrašnja klasa?  Sa kojim modifikatorima pristupa su dostupni članovi unutrašnje klase?

- Unutrašnja klasa je pridružena instanci klase u kojoj je definirana – ima direktan pristup varijablama i metodama te instance. 
- Moguće je definirati sve modifikatore pristupa.

#### 81.	Kako se kreira nova instanca unutrašnje klase?

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

#### 82.	Kako se pristupa članovima okružujuće klase koji su skriveni u unutrašnjoj klasi?

```java
<Naziv klase>.this
```

#### 83.	Što su to lokalne klase?

Klasa definirana unutar nekog bloka (Tijelo metode, tijelu konstruktora, lokalni blok, statički
inicijalizacijski blok, inicijalizacijski blok instance)

#### 84.	Koja su pravila pristupa lokalne klase članovima okružujuće klase? 

- Ako se radi o ne statičkom bloku, gdje je dostupna `this` referenca onda se lokalna klasa ponaša kao i unutrašnja klasa po pitanju pristupa varijablama klase. Takva klasa je povezana sa instancom okružujuće klase.

- Ako se radi o statičkom bloku onda se ponaša kao i statička ugniježdena klasa po pitanju pristupa varijablama

- Kod lokalne klase ne može se koristiti static modifikator

#### 85.	Kojim varijablama ima pristup lokalna klasa iz okružujućeg bloka?

Ima pristup samo final parametrima i final lokalnim varijablama iz okružujuće metode

#### 86.	Što su to anonimne klase? Navedite elemente iskaza za kreiranje anonimne klase?

Anonimne klase objedinjuju definiciju i kreiranje objekta klase u jedan iskaz:

```java
new <naziv nadklase koja se nasljeđuje> (<opcionalna lista argumenata koji se prosljeđuje konstruktoru>)
{ <definicija članova> }
```

#### 87.	Navedite pravila pristupa anonimne klase varijablama i metodama okružujućeg bloka/klase.

Za anonimnu klasu vrijede ista pravila pristupa varijablama i metodama okružujuće metode/klase kao i za lokalnu klasu

### INTERFACE

#### 88. Što je to interface?

Interface predstavlja imenovani skup metoda bez implementacije. Može definirati konstante.

#### 89. Navedite razlike između interface-a i apstraktne klase?

- Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može 
- Klasa može implementirati mnogo interface-a, ali smije imati samo jednu nadklasu
- Interface nije dio hijerarhije klasa. Klase koje nisu u odnosu mogu implementirati isti interface

#### 90. Navedite elemente deklaracije interface-a?

Pomoću ključne riječi interface i naziva

primjer:
```java
public interface InterfaceName {
    InterfaceBody
}
```

#### 91. Koliko interface-a može pojedini interface naslijediti?

Interface podržava višestruko nasljeđivanje; novi interface može se proširiti listom interface-a pomoću `extends`

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

#### 92. Koji su implicitni modifikatori uz metodu interface-a?

`public` i `abstract`

#### 93. Koji su implicitni modifikatori uz varijablu interface-a?

`public`, `static` i `final`

### ENUM

#### 94. Navedite elemente deklaracije enum tipa?

```java
// enum naziv { <popis enum konstanti> }
enum E { E1, E2, E3 }
```

#### 95. Koliko instanci enum tipa se može kreirati za vrijeme izvođenja programa?

Ne mogu se kreirati nove instance tipa enum operatorom `new`

#### 96. Koji su implicitni modifikatori za enum varijable?

`final` i `static`

#### 97. Kada se inicijaliziraju enum konstante?

Prilikom učitavanja enum tipa

#### 98. Navedite razlike između enum tipa i klase?

- nije moguće kreirati nove enum instance
- enum ne može biti nasljeđena

#### 99. Opišite metodu `values()` enum tipa.

```
static EnumTypeName[] values(); // vraća niz enum konstanti redoslijedom kako su definirani
```

#### 100. Opišite metodu `valueOf()` enum tipa.

```java
Static EnumTypeName valueOf("naziv"); // vraća enum konstantu sa specificiranim nazivom
```

#### 101. Opišite metodu `ordinal()` enum tipa.

```java
final int ordinal(); // vraća redni broj enum konstante počevši od 0
```

#### 102. Koliko klasa i koliko interface-a može enum tip naslijediti?

- Enum implicitno nasljeđuje samo klasu `java.lang.Enum`
- Enum klasa može implementirati više interface-a

### PACKAGE

#### 103. Što je i što definira paket (package)?

- Paket (`package`) je skup povezanih klasa ili interface-a
- unutar paketa definiraju se različiti tipovi i interface-i

#### 104. Koji su elementi i pravila deklaracije paketa?

```java
package graphics;
```
- Iskaz `package`mora se uključiti na vrhu svake izvorne datoteke koja definira klasu ili interface unutar `graphics` paketa

#### 105. Na koji način se mogu koristiti public članovi nekog paketa?

- Svi public članovi su dostupni i izvan paketa
- dohvaćanje pomoću: 
  - njegovog dugog (kvalificiranog) imena
  - uvozom cijelog paketa
  - uvozom člana paketa

#### 106. Koji su elementi i pravila deklaracije uvoza članova nekog paketa?

Pomoću `import` iskaza na početku datoteke

```java
import graphics.Circle; // uvoz Circle člana paketa graphics
import graphics.*; // uvoz svih članova paketa graphics
```

#### 107. Kako se mogu uvesti statički članovi klase?

Pomoću ključnih riječi `static import`

#### 108. U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?

```
neki.paket.Klasa
(sources) \ (neki) \ (paket) \ Klasa.java  
```    

direktoriji se prate hijerarhijski prema nazivu paketa 

#### 109. Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?

```
neki.paket.Klasa
(classes) \ (neki) \ (paket) \ Klasa.class  
```

direktoriji se prate hijerarhijski prema nazivu paketa, `.class` i `.java` ne moraju biti u istom naddirektoriju

### IZNIMKE

#### 110. Koje su osnovne prednosti korištenja iznimki za obradu pogreški?

- Odvajanje koda koji obrađuje pogreške od "regularnog" koda
- Propagiranje pogreški kroz call stack
- Grupiranje tipova pogreški i njihovo razlikovanje

#### 111. Što su to iznimke?

Iznimka je događaj koji ometa prirodni tok izvršavanja programa

#### 112. Navedite osnovne metode `Throwable` klase.

```java
String getMessage(); // vraća poruku iznimke
String toString(); // vraća se obično kratki opis iznimke
void printStackTrace(); // ispisuje se tok stog poziva (call stack)
```

#### 113. Navedite glavnu podjelu iznimki? Navedite razlike.

- `Error` - predstavlja "jaku" pogrešku, obično se ne obrađuje
- `Exception` ima mnoge nasljednike - predstavlja grupu iznimki, obrađuje se

#### 114. Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.

- neprovjeravane - `RuntimeException`, `Error` i podklase -> one koje se ne obrađuju
- provjeravane - sve ostale -> one koje se obrađuju

#### 115. Navedite pravila rada sa provjeravanim iznimkama.

Metoda mora ili hvatati (`catch`) ili navesti (`specify`) sve provjeravane iznimke koje mogu biti bačene

#### 116. Navedite i opišite elemente hvatanja i obrade iznimki?

ovim redoslijedom:

- `try` - blok unutar kojeg se može baciti exception
- `catch` - blok koji hvata taj exception i obrađuje ga
- `finally` - uvijek se izvršava nakon try-catch bloka (neovisno je li bačen exception)

#### 117. Kako se postiže općeniti exception handler (hvata vište tipova iznimki)?

```java
catch (ThrowableObject t) {
    ...
}
```

#### 118. Kako se bacaju iznimke? Navedite primjer.

Iskaz `throw` služi za bacanje iznimki:

```java
…
if (size == 0)
    throw new throwable("opis iznimke");
…
```

#### 119. Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.

```java
someMethod(…)
    throws <ExceptionType1>, <ExceptionType2>, …,<ExceptionTypen>
```

- mogu se baciti podklase provjeravanih iznimki

#### 120. Kako se definiraju novi tipovi provjeravanih i neprovjeravanih iznimki?

Nasljeđivanjem `Exception` (provjeravanih) i `RuntimeException` (neprovjeravanih) klasa i podklasa

#### 121. Navedite elemete iskaza „assert“.

```java
assert <boolean izraz> ; // Jednostavni oblik
assert <boolean izraz > : <izraz poruke>;
```
