#### Koji je točan iskaz instanciranja anonimne klase
interface Runnable?

```java
public interface Runnable {
public abstract void run();
}
```
1. `Runnable r = new Runnable() { };`
2. `Runnable r = new Runnable(public void run() {
});`
3. `Runnable r = new Runnable { public void
run(){}};`
4. `Runnable r = new Runnable() {public void
run() { }};`

---

Točan odgovor 4):
Kod 1 nije implementirana metoda run, 2 i 3
greška u sintaksi

---

#### Što će se ispisati?
```java
public class Foo {
    Foo() {
        System.out.print("foo");
    }

    public static void main(String[] args) {
        Foo f = new Foo();
        f.makeBar();
    }

    void makeBar() {
        (new Bar() {
        }).go();
    }

    class Bar {
        Bar() {
            System.out.print("bar");
        }

        public void go() {
            System.out.print("hi");
        }
    } /* class Bar ends */
}

```

1. Greška kod prevođenja 
2. Iznimka kod izvođenja 
3. foobarhi
4. barhi

---

Točan odgovor 3):
Najprije se kreira Foo instanca i u konstruktoru
se ispisuje "foo". Nakon toga se poziva
makeBar metoda koja kreira Bar instancu a u
konstruktoru se ispisuje "bar". Nakon toga se
pozivom metode ispisuje "hi". Treba paziti da
se instanca unutrašnje klase može kreirati
jedino putem reference na vanjsku klasu. Pošto
se instanca unutrašnje klase radi unutar
vanjske klase tada se koristi podrazumjevana
referenca vanjske klase this:
`this.new Bar()).go();`

---

#### Što će se ispisati?

```java
public enum Color {
    RED("Red Color"),
    GREEN("Blue Color"),
    BLUE("Blue Color");
    private final String displayName;

    Color(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return displayName;
    }
}

class ColorTest {
    public static void main(String[] args) {
        Color redColor = Color.RED;
        System.out.println(redColor);
        Color blueColor = Color.BLUE;
        System.out.println(blueColor);
    }
}
```

1.RED i BLUE
2."Red Color" "Blue Color" 
3. Greška kod prevođenja
4. redColor i blueColor

---

Točan odgovor 2):
Enumi su klase pa mogu imati i varijable i
konstruktore. Kod deklaracije emum konstanti
definira se i parametar za konstruktor.
Prilikom ispisa objekta poziva se toString()
metoda da se dobije string opis klase. Ako
enum nema definiranu toString metodu ispisuje
se naziv enum konstante (RED)

---

#### Što će se ispisati?

```java
enum Color {
    RED, GREEN, BLUE
}

public class TestEnum2 {
    private static void printColor(Color a) {
        System.out.println(a.ordinal());
    }

    public static void main(String[] args) {
        Color redColor = Color.BLUE;
        switch (redColor) {
            case BLUE:
                printColor(redColor);
                break;
            case RED:
                printColor(redColor);
                break;
            case GREEN:
                printColor(redColor);
                break;
        }
    }
}
```

1. 0 
2. 1 
3. 2
4. Greška kod prevođenja

---

Točan odgovor 3):
Enum se može koristiti u switch iskazu. Ordinal
metoda vraća redni broj enum konstante u listi
konstanti; za BLUE to je 2

---

#### Što će se ispisati?

```java
public class X {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.print("A");
        } catch (Exception ex) {
            System.out.print("B");
        } finally {
            System.out.print("C");
        }
        System.out.print("D");
    }

    public static void badMethod() {
        throw new Error();
    }
}
```

1. ABCD 
2. Greška kod prevođenja 
3. C pa kraj sa ispisom greške
4. BC pa kraj sa ispisom greške

---

Točan odgovor 3):
Error nije provjeravana iznimka pa metoda ne
mora definirati tu iznimku u throws dijelu. U
try-catch bloku hvata se samo Exception
iznimka a Error nije podklasa Exception klase.
Zbog toga se ispisuje samo C iz finally dijela
prije nego program završi sa Error iznimkom

---

#### Što će se ispisati ako su uključene tvrdnje (assert)?

```java
for(int i=2;i< 4;i++)
    for(int j=2;j< 4;j++)
        assert i!=j:j;
```

1. Neće se ništa ispisati
2. Broj 2 sa AssertionError
3. Greška kod prevođenje
4. Broj 3 sa AssertionError

---

Točan odgovor 2):
Assert poruka se ispisuje kada je assert
vrijednost false

---

#### Koji kod treba umetnuti da se ipravno pokrene nit?

```java
class X implements Runnable {
    public static void main(String[] args) {
        /* Kod za pokretanje niti? */
    }

    public void run() {
    }
}
```

1. `Thread t = new Thread(X);`
2. `Thread t = new Thread(X); t.start();`
3. `X run = new X(); Thread t = new Thread(run);
t.start();`
4. `Thread t = new Thread(); x.run();`

---

Točan odgovor 3):
Nit se kreira putem Thread objekta kojem se u
ovom slučaju treba proslijediti referencu na
objekt koji implementira intarface Runnable.
Nit se pokreće pozivom metode start

---

#### Koja metoda će sigurno zaustaviti nit?

1. `wait()`
2. `notify()`
3. `notifyall()`
4. Izlaz iz sinkronizacijskog dijela koda

---

Točan odgovor 1)

---

#### Što će se ispisati?

```java
class s1 implements Runnable {
    int x = 0, y = 0;

    public static void main(String[] args) {
        s1 run1 = new s1();
        s1 run2 = new s1();
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();
    }

    int addX() {
        x++;
        return x;
    }

    int addY() {
        y++;
        return y;
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(addX() + " " + addY());
    }
}
```

1. Greška kod prevođenja
2. Ispisat će se: 1 1 2 2 3 3 4 4 5 5...
3. Ispisat će se ali nije definiran redoslijed
4. Ispisat će se: 1 2 3 4 5 6... 1 2 3 4 5 6...

---

Točan odgovor 3)
Nakon pokretanja više niti ne može se odrediti
kojim se redoslijedom izvršavaju (ako nisu
sinkronizirane)

---

#### Koji interface predstavlja strukturu podataka u koju se ne mogu pridruživati duplikati?

1. java.util.Map
2. java.util.List
3. java.util.Set
4. java.util.Collection

---

Točan odgovor 3):
U Set kolekcije se ne mogu pridruživati
duplikati

---

#### Koji će elementi biti u kolekciji?

```java
package enums;

class Element {
    int i;

    public Element(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {
        return i > 2;
    }

    public int hashCode() {
        return i > 3 ? 0 : 1;
    }

    public String toString() {
        return "" + i;
    }
}

public class TestCol {
    public static void main(String[] args) {
        Set<Element> lhs = new LinkedHashSet<Element>();
        lhs.add(new Element(1));
        lhs.add(new Element(1));
        lhs.add(new Element(3));
        lhs.add(new Element(4));
        lhs.add(new Element(5));
    }
}
```

1. 1, 3, 4, 5
2. 1, 3 
3. 3, 4, 5
4. 1, 1, 4

---

Točan odgovor 4):
Set ne dopušta duplikate ali se provjera da li
je nešto duplikat radi putem metode equals.
Kod hash tablica (HashSet i LinkedHashSet)
gleda se i hashCode. Pravilo je da ako su dva
objekta jednaka onda moraju imati i iste hash
vrijednosti. Ako su hash vrijednosti različite
HashSet i LinkedHashSet neće niti provjeravati
jednakost putem metode equals, a ako su hash
vrijednosti jednake tek tada se poziva i
equals metoda da se usporedi novi element sa
postojećim elementima u Set-u koji imaju isti
hash kod.

---

#### Što vraća read() metoda Reader-a?

1. string
2. byte kao int vrijednost
3. char kao int vrijednost
4. char[]

---

Točan odgovor 3)

---

#### Što će se ispisati?

```java
public class Outer {
    private final int a = 7;

    class Inner {
        public void displayValue() {
            System.out.println("Value of a is " + a);
        }
    }
}

public class Test {
    public static void main(String... args) throws Exception {
        Outer mo = new Outer();
        Outer.Inner inner = mo.new Inner();
        inner.displayValue();
    }
}
```

1. Value of a is 7
2. Greška kod prevođenja
3. Greška prilikom izvođenja.
4. Value of a is 7

---

Točan odgovor 1):
Instanca unutrašnje klase ne može postojati a da
nije povezana sa instancom vanjske klase i
zbog toga ima pristup članovima instance
vanjske klase (i private članovima)

---

#### Što će se ispisati?

```java
class MyThread extends Thread {
    MyThread() {
        System.out.print(" MyThread");
    }

    public void run() {
        System.out.print(" bar");
    }

    public void run(String s) {
        System.out.println(" baz");
    }
}

public class TestThreads {
    public static void main(String[] args) {
        Thread t = new MyThread() {
            public void run() {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}
```

1. Foo 
2. MyThread foo 
3. MyThread bar
4. foo bar

---

Točan odgovor 2):
Pokretanjem niti se poziva run metoda. Nit se
pokreće putem objekta Thread klase. U ovom
slučaju imamo MyThread klasu koja naslijeđuje
Thread klasu ali se sama nit pokreće putem
anonimne klase koja naslijeđuje tu MyThread
klasu i u kojoj je prepisana metoda run

---

