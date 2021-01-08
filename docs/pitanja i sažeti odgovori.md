Pitanja i sažeti odgovori
=================

### INTERFACE

#### 88. Što je to interface?

Interface predstavlja imenovani skup metoda bez implementacije.

#### 89. Navedite razlike između interface-a i apstraktne klase?

- Interface ne može implementirati niti jednu metodu, dok apstraktna klasa može 
- Klase ne podržavaju višestruko nasljeđivanje, interface podržava 

#### 90. Navedite elemente deklaracije interface-a?

Pomoću ključne riječi interface i naziva

primjer:
```java
public interface InterfaceName {
    InterfaceBody
}
```

#### 91. Koliko interface-a može pojedini interface naslijediti?

Interface podržava višestruko nasljeđivanje

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
Static EnumTypeName valueOf(String name); // vraća enum konstantu sa specificiranim nazivom
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

- Paket (`package`) je skup povezanih klasa
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
import graphics.Circle; // uvoz Circle člana
import graphics.*; // uvoz svih članova
```

#### 107. Kako se mogu uvesti statički članovi klase?

Pomoću ključnih riječi `static import`

#### 108. U kojem su odnosu public klasa i naziv i lokacija datoteke koja sadrži definiciju te klase?

- /neki/paket/Klasa.java
- neki.paket.Klasa.java

direktoriji se prate hijerarhijski prema nazivu paketa 

#### 109. Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?

- /neki/paket/Klasa.class
- neki.paket.Klasa.class

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
String toString(); // vraća se kratki opis iznimke
void printStackTrace(); // ispisuje se tok stog poziva
```

#### 113. Navedite glavnu podjelu iznimki? Navedite razlike.

- `Error` - predstavlja "jaku" pogrešku
- `Exception` ima mnoge nasljednike - predstavlja grupu iznimki 

#### 114. Koje iznimke spadaju u grupe provjeravanih i neprovjeravanih iznimki. Navedite razlike između te dvije grupe.

- neprovjeravane - `RuntimeException`, `Error` i podklase -> one koje se ne obrađuju
- provjeravane - sve ostale -> one koje se obrađuju

#### 115. Navedite pravila rada sa provjeravanim iznimkama.

Metoda mora ili hvatati (`catch`) ili navesti (`specify`) sve provjeravane iznimke koje mogu biti bačene

#### 116. Navedite i opišite elemente hvatanja i obrade iznimki?

ovim redoslijedom:

- `try` - unutar kojeg se može baciti exception
- `catch` - hvata taj exception
- `finally` - uvijek se izvrši nakon obrade

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
