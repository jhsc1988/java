II.kolokvij - primjer 1
=================

#### 1. Ako u metodi goo želimo ispisati varijablu a sa vrijednošću 4 koji iskaz trebamo upotrijebiti?

```java
class Foo {
    int a = 4;

    class Bar {
        int a = 5;

        public void goo() {
            /* ispis varijable*/
        }
    }
}
```

A. `System.out.println(this.a);`
B. `System.out.println(super.a);`
C. `System.out.println(Foo.this.a); `
D. `System.out.println(a);`

> C. `System.out.println(Foo.this.a); `

#### 2. Što će se ispisati?

```java
public class O {
    int a;

    public static void main(String[] args) {
        O t = new O() {
            int a = 45;

            public int getNum() {
                return a;
            }
        };
        I f = new I() {
            int a = 34;
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }

    public int getNum() {
        return a;
    }

    public static class I extends O {
        public int getNum() {
            return a;
        }
    }
}
```

A. 34 45 
B. 34 0
C. 0 45 
D. Greška kod prevođenja

> C. 0 45 

#### 3. Koja linija neće rezultirati sa greškom kod prevođenja?

```java
public class Local {
    public int b = 0;
    private int a = 0;

    private static void foo(int c) {
        final int d = 0;
        class Bar {
            private void goo() {
                System.out.println(a); // 1)
                System.out.println(b); // 2)
                System.out.println(c); // 3)
                System.out.println(d); // 4)
            }
        }
    }
}
```

A. 1 
B. 2
B. 3 
D. 4

> D. 4 

#### 4. Koja je valjana deklaracija metode interface-a?

```java
interface Test{
    int foo(); // 1
    protected int goo(); // 2
    public static int hoo(); // 3
    public int koo() {return i}; // 4
}
```

A. 1 
B. 2
C. 3 
D. 4

> A. 1 

#### 5. Koliko instanci enum tipa EnumTest postoje?

```java
enum EnumTest {
	PRVI, DRUGI;
}
```

A. 0 
B. 1
C. 2 
D. neograničeno (mogu se kreirati nove po potrebi)

> C. 2 

#### 6. Što će se ispisati?

```java
enum Enum {
    FIRST("a"), SECOND(0), THIRD("08");
    Enum(int value) {
        System.out.print("i" + value);
    }
    Enum(String value) {
        System.out.print("s" + value);
    }
}
public class EnumCreation {
    public static void main(String[] args) {
        System.out.println(" " + Enum.valueOf("SECOND").ordinal());
    }
}
```

A. sai0s08 
B. sai0s08 1
C. Greška kod prevođenja 
D. 1

> B. sai0s08 1

#### 7. Što će se ispisati?

```java
class Exc0 extends Exception { }
class Exc1 extends Exc0 { }
public class Test
{
    public static void main(String args[])
    {
        try
        {
            foo();
        }
        catch (Exc0 e0)
        {
            System.out.println("uhvaćen Ex0 ");
        }
        catch (Exception e)
        {
            System.out.println("uhvaćen Exception");
        }
    }
    public static void foo() throws Exc0 {
        throw new RuntimeException();
    }
}
```
A. Greška kod prevođenja 
B. uhvaćen Exception
C. uhvaćen Ex0 
D. Ništa, program završava sa greškom

> B. uhvaćen Exception

#### 8. Koji iskaz treba staviti na umjesto /* Kod X */ da se kod može uspješno prevesti?

```java
class TestException extends RuntimeException {}
public class ExceptionTest
{
    public void runTest() throws TestException {}
    public void test() /* Kod X */
    {
        runTest();
    }
}
```

A. Ništa 
B. catch ( Exception e )
C. throws Exception 
D. throws RuntimeException

> A. Ništa

#### 9. Što će se ispisati ako su uključene tvrdnje „assert“?

```java
public class X {
    public static void main(String[] args) {
        for (int i=0; i<10; i++)
            check(i);
        System.out.print("Sve je provjereno");
    }
    public static void check(int i) {
        assert i>5 : i;
    }
}
```

A. AssertionError: 6 
B. AssertionError: 0
C. Sve je provjereno 4
D. Greška kod prevođenja

> B. AssertionError: 0

#### 10. Što će se ispisati?

```java
public class ThreadDemo
{
    private int count = 1;
    public synchronized void doSomething()
    {
        for (int i = 0; i < 10; i++)
            System.out.println(count++);
    }
    public static void main(String[] args)
    {
        ThreadDemo demo = new ThreadDemo();
        Thread a1 = new A(demo);
        Thread a2 = new A(demo);
        a1.start();
        a2.start();
    }
}
class A extends Thread
{
    ThreadDemo demo;
    public A(ThreadDemo td)
    {
        demo = td;
    }
    public void run()
    {
        demo.doSomething();
    }
}
```

A. Brojeve od 0 19 ali nije moguće odrediti redoslijed
B. Brojeve od 1 20 sekvencijalno
C. Brojeve od 1 20 ali nije moguće odrediti redoslijed
D. Greška kod prevođenja

> B. Brojeve od 1 20 sekvencijalno

#### 11. Ako su sve niti zaustavljene pozivom wait metode koja će se nit „probuditi“ pozivom metode notifyAll u liniji 16?

```java
public class ThreadDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();
        Object lock4 = new Object();
        Thread a1 = new A(lock1);
        Thread a2 = new A(lock2);
        Thread a3 = new A(lock3);
        Thread a4 = new A(lock4);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        synchronized(lock3){
            lock3.notifyAll(); // buđenje niti; linija 16
        }
    }
}
class A extends Thread {
    Object lock;
    public A(Object td) {
        lock = td;
    }
    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) { }
        }
    }
}
```

A. a1 
B. a2
C. a3 
D. a4

> C. a3

##### 12. Što će se ispisati?

```java
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new A();
        t.setDaemon(true);
        t.start();
        System.out.println("main gotov!");
    }
}
class A extends Thread {
    public void run() {
        for (int i = 0; i<=20; i++)
            System.out.println(i);
    }
}
```

A. svi brojevi 0-20 pa „main gotov“
B. „main gotov“ pa svi brojevi 0-20
C. „main gotov“ i samo neki brojevi redoslijednom od 0 (maksimalno do 20)
D. Greška kod prevođenja

> C. „main gotov“ i samo neki brojevi redoslijednom od 0 (maksimalno do 20)

#### 13. Koji interface predstavlja strukturu podataka u koju se mogu pridruživati duplikati?

A. java.util.Map 
B. java.util.List
C. java.util.Set 
D. java.util.Collection

> B. java.util.List

#### 14. Što vraća read() metoda InputStream -a?

A. string 
B. byte kao int vrijednost
C. char kao int vrijednost 
D. char[]

> C. char kao int vrijednost 

#### 15. Koja tvrdnja nije točna za hashCode metodu?

A. višestruko pozivanje metode moraju dati istu hash vrijednost ako se stanje objekta nije promijenilo
B. Ako dva objekta nisu jednaki po equals metodi tada moraju dati različite hash vrijednosti
C. vraća int vrijednost
D. Ako su dva objekta jednaki po equals metodi tada trebaju dati istu hash vrijednost