primjeri
=================

- kompilacija primjera sa predavanja/interneta
---

#### Primjer lokalnih klasa

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
            final double f7 = TLCWithLocalClasses.this.nsf1;// (7) varijabla iz instance klase koja 
			// okružuje ovu klasu
            final int f8 = nsf2; // (8) iz instance klase koja okružuje ovu klasu.
            final int f9 = sf; // (9) static član klase koja okružuje ovu klasu.
            int hlv; // (10) skriva lokalnu varijablu metode. (nema načina pristupa skrivenoj varijabli)
        }
    }
}
```

#### Primjer anonimne klase

```java
interface IDrawable { // (1)
    void draw();
}
class Shape implements IDrawable { // (2)
    public void draw(){System.out.println("Drawing a Shape."); }
}
class Painter { // (3) najgornja klasa
    public Shape createShape() { // (4) ne-static Metoda
        return new Shape(){ // (5) naslijeđuje nadklasu (2)
            public void draw(){System.out.println("Drawing a new Shape.");}
        };
    }
    public static IDrawable createIDrawable() { // (7) Static Metoda
        return new IDrawable(){ // (8) implementira sučelje (1)
            public void draw() {
                System.out.println("Drawing a new IDrawable.");
            }
        };
    }
}
```
#### Primjer enum

```java
enum MachineState { BUSY, IDLE, BLOCKED }

public class Machine {
    private MachineState state;
    public void setState(MachineState state) { this.state = state; }
    public MachineState getState() { return this.state; }
}
....
        Machine machine = new Machine();
        machine.setState(MachineState.IDLE); // (1)prosijeđuje se vrijednsot.
        // machine.setState(1); // (2) Greško kod prevođenja!
        MachineState state = machine.getState(); // (3)Deklariranje
        //referencijalnog tipa (enum)
        System.out.println(
        "The machine state is: " + state // (4) Ispis naziv enum vrijednosti.
        // MachineState newState = new MachineState();//(5) greška kod prev.
        );
```

#### Primjer enum s konstruktorom

```java
public enum Meal {
    BREAKFAST(7, 30), LUNCH(12, 15), DINNER(19, 45); // (1)

    // varijable: (3)
    private final int hh;
    private final int mm;
    // konstruktor(2)
    Meal(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }

    // metode instance: (4)
    public int getHour() {
        return this.hh;
    }

    public int getMins() {
        return this.mm;
    }
}

public class MealAdministrator {
    public static void main(String[] args) {
        System.out.printf( // (5)
                "Please note that no eggs will be served at %s, %02d:%02d.%n",
                Meal.BREAKFAST, Meal.BREAKFAST.getHour(), Meal.BREAKFAST.getMins()
        );
        System.out.println("Meal times are as follows:");
        Meal[] meals = Meal.values(); // (6)
        for (Meal meal : meals) // (7)
            System.out.printf("%s served at %02d:%02d%n",
                    meal, meal.getHour(), meal.getMins()
            );
        Meal formalDinner = Meal.valueOf("DINNER"); // (8)
        System.out.printf("Formal dress is required for %s at %02d:%02d.%n",
                formalDinner, formalDinner.getHour(), formalDinner.getMins()
        );
    }
}
/*
Output:
        Please note that no eggs will be served at BREAKFAST, 07:30.
        Meal times are as follows:
        BREAKFAST served at 07:30
        LUNCH served at 12:15
        DINNER served at 19:45
        Formal dress is required for DINNER at 19:45.
 */
```

---
#### pokretanje niti naslijeđivanjem `Thread` klase

```java
class Counter extends Thread {
    private int currentValue;
    public Counter(String threadName) {
        super(threadName); // (1) inicijalizacija niti
        currentValue = 0;
        System.out.println(this);
        // setDaemon(true);
        start(); // (2) pokretanje niti
    }
    public int getValue() {
        return currentValue;
    }
    public void run() { // (3) prepisuje se iz nadklase.
        try {
            while (currentValue < 5) {
                System.out.println(getName() + ": " + (currentValue++));
                Thread.sleep(250); // (4) threnutna nit spava.
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println("Exit from thread: " + getName());
    }
}

class Client {
    public static void main(String[] args) {
        System.out.println("Method main() runs in thread "
                + Thread.currentThread().getName()); // (5) trenutna nit
        Counter counterA = new Counter("Counter A"); // (6) kreiranje niti
        Counter counterB = new Counter("Counter B"); // (7) kreiranje niti
        System.out.println("Exit from main() method.");
    }
}

/*
Output:
        Method main() runs in thread main
        Thread[Counter A,5,main]
        Thread[Counter B,5,main]
        Counter A: 0
        Exit from main() method.
        Counter B: 0
        Counter A: 1
        Counter B: 1
        Counter A: 2
        Counter B: 2
        Counter B: 3
        Counter A: 3
        Counter A: 4
        Counter B: 4
        Exit from thread: Counter A
        Exit from thread: Counter B
 */
```

---
#### pokretanje niti implementrianjem `Runnable` interface-a

```java

class Counter implements Runnable {
    private int currentValue;

    public Counter() {
        currentValue = 0;
    }

    public int getValue() {
        return currentValue;
    }

    public void run() { // (1) Ulazna točka niti
        try {
            while (currentValue < 5) { // (2) ispisuje se naziv niti
                System.out.println(Thread.currentThread().getName() + ": "
                        + (currentValue++));
                Thread.sleep(250); // (3) Trenutna nit je zaustavljena
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()
                    + " interrupted.");
        }
        System.out.println("Exit from thread: "
                + Thread.currentThread().getName());
    }
}

class Client {
    public static void main(String[] args) {
        Counter counterA = new Counter(); // (4) kreira se Counter objekt.
        Thread worker = new Thread(counterA, "Counter A");//(5) kreira se nova nit
        System.out.println(worker);
        worker.start(); // (6) pokreće se nit.
        try {
            int val;
            do {
                val = counterA.getValue(); // (7) dohvat vrijednosti brojača.
                System.out.println("Counter value read by " // (8) ispis naziva trenutne niti
                        + Thread.currentThread().getName() + ": " + val);
                Thread.sleep(1000); // (9) Trenutna nit je zaustavljena
            } while (val < 5);
        } catch (InterruptedException e) {
            System.out.println("The main thread is interrupted.");
        }
        System.out.println("Exit from main() method.");
    }
}
```

---
#### primjer korištenja `join();` metode

```java
class TestJoinMethod1 extends Thread {
    public static void main(String[] args) {
        TestJoinMethod1 t1 = new TestJoinMethod1();
        TestJoinMethod1 t2 = new TestJoinMethod1();
        TestJoinMethod1 t3 = new TestJoinMethod1();
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        t2.start();
        t3.start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}

/*
Output:
       1
       2
       3
       4
       5
       1
       1
       2
       2
       3
       3
       4
       4
       5
       5
*/
```
