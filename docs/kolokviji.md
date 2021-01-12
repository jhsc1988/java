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

---
> C. `System.out.println(Foo.this.a); `
---

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

---
> C. 0 45 
---

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

---
> D. 4 
---

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

---
> A. 1 
---

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

---
> C. 2 
---

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

---
> B. sai0s08 1
---

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

---
> B. uhvaćen Exception
---

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

---
> A. Ništa
---

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

---
> B. AssertionError: 0
---

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

---
> B. Brojeve od 1 20 sekvencijalno
---

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

---
> C. a3
---

#### 12. Što će se ispisati?

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

---
> C. „main gotov“ i samo neki brojevi redoslijednom od 0 (maksimalno do 20)
---

#### 13. Koji interface predstavlja strukturu podataka u koju se mogu pridruživati duplikati?

A. java.util.Map

B. java.util.List

C. java.util.Set 

D. java.util.Collection

---
> B. java.util.List
---

#### 14. Što vraća read() metoda InputStream -a?

A. string 

B. byte kao int vrijednost

C. char kao int vrijednost 

D. char[]

---
> C. char kao int vrijednost 
---

#### 15. Koja tvrdnja nije točna za hashCode metodu?

A. višestruko pozivanje metode moraju dati istu hash vrijednost ako se stanje objekta nije promijenilo

B. Ako dva objekta nisu jednaki po equals metodi tada moraju dati različite hash vrijednosti

C. vraća int vrijednost

D. Ako su dva objekta jednaki po equals metodi tada trebaju dati istu hash vrijednost

---
> B. Ako dva objekta nisu jednaki po equals metodi tada moraju dati različite hash vrijednosti
---

II.kolokvij - primjer 2
=================

#### 1. Koji iskaz treba dodati u liniju 10 da se inicijalizira Bar klasa?

```java
class Foo
{
    class Bar{ }
}
class Test
{
    public static void main (String [] args)
    {
        Foo f = new Foo();
        /* Linije 10: inicijalizacija kase Bar? */
    }
}
```

A) `Foo.Bar b = new Foo.Bar(); `

B) `Foo.Bar b = f.new Bar();`

C) `Bar b = new f.Bar(); `

D) `Bar b = new Bar();`


#### 2. Što će se ispisati?

```java
public abstract class AbstractTest
{
    public abstract class Bar
    {
        public int getNum()
        {
            return 38;
        }
    }
    public int getNum()
    {
        return 45;
    }
    public static void main (String [] args)
    {
        AbstractTest t = new AbstractTest()
        {
            public int getNum()
            {
                return 22;
            }
        };
        AbstractTest.Bar f = t.new Bar()
        {
            public int getNum()
            {
                return 57;
            }
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }
}
```
A) 57 22 

B) 45 38

C) 45 57 

D) Greška kod prevođenja

#### 3. Koja linija će rezultirati sa greškom kod prevođenja?

```java
public class Test{
    private int i = 0;
    private static int j = 0;
    private void foo(final int k){
        int l = 0;
        class Bar{
            private void goo(){
                System.out.println(i); // 1)
                System.out.println(j); // 2)
                System.out.println(k); // 3)
                System.out.println(l); // 4)
            }
        }
    }
}
```
A) 1 

B) 2

B) 3 

D) 4

#### 4. Koji iskaz nije valjan (greška kod prevođenja)?

```java
public interface Test{
    public int a = 1; // 1
    protected int b = 1; // 2
    final int c = 1; // 3
    static int d = 1; // 4
}
```

A) 1 

B) 2

C) 3 

D) 4

> B) 2

#### 5. Što će se ispisati?

```java
enum Test {
    PRVI(7, 30), DRUGI(12, 15), TRECI(19, 45);
    private int hh;
    private int mm;
    Test(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }
    public int getHour() {
        return hh;
    }
    public int getMins() {
        return mm;
    }
}

public class TestAll{
    public static void main(String args[]){
        Test t = new Test(4, 5);
        if (t==Test.PRVI)
            System.out.println("prvi");
        else if (t==Test.DRUGI)
            System.out.println("drugi");
        else
            System.out.println("ostalo"); }
}
```
A) prvi 

B) ostalo

C) drugi 

D) Greška kod prevođenja

#### 6. Što će se ispisati?

```java
enum Rank {
    FIRST(20), SECOND(0), THIRD(8);
    Rank(int value) {
        System.out.print(value);
    }
}
public class EnumCreation {
    public static void main (String[] args) {
        System.out.println("\n" + Rank.values().length);
    }
}
```

A) 2008 

B) 2008 3

C) Greška kod prevođenja 

D) 3

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
            throw new Exc1();
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
}
```

A) Greška kod prevođenja 

B) uhvaćen `Exception`

C) uhvaćen `Ex0 `

D) Ništa, program završava sa greškom


#### 8. Što će se ispisati?

```java
class TestException extends Exception {}
public class ExceptionTest
{
    public void runTest() throws TestException {}
    public void test() /* Kod X */
    {
        try {
            runTest();
        } catch (Exception e) {
        }
    }
}
```

A) Ništa 

B) `catch ( Exception e )`

C) `throws Exception `

D) `throws RuntimeException`

#### 9. Što će se ispisati ako su uključene tvrdnje „assert“?

```java
public class X {
    public static void main(String[] args) {
        for (int i=10; i>0; i--)
            check(i);
        System.out.print("Sve je provjereno");
    }
    public static void check(int i) {
        assert i>5 : i;
    }
}
```

A) AssertionError: 5 

B) AssertionError: 10

C) Sve je provjereno 

D) Greška kod prevođenja

#### 10. Što će se ispisati?

```java
public class MyThread extends Thread
{
    public static void main(String [] args)
    {
        MyThread t = new MyThread();
        t.start();
        System.out.print("one. ");
        t.start();
        System.out.print("two. ");
    }
    public void run()
    {
        System.out.print("Thread ");
    }
}
```

A) Greška kod prevođenja 

B) Iznimka kod izvođenja programa

C) Thread one. Thread two 

D) Redoslijed ispisa nije moguće odrediti

#### 11. Ako je nit zaustavljena naredbom u linij 13, kojom naredbom neka druga nit može ponovno pokrenuti ovu nit?

```java
public class ThreadDemo {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private Object lock3 = new Object();
    private Object lock4 = new Object();
    public synchronized void doSomething() {
        synchronized (lock1) {
            synchronized (lock2) {
                synchronized (lock3) {
                    synchronized (lock4) {
                        try {
                            lock2.wait(); // linija 13
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }
}
```

A) `lock1.notifyAll()` 

B) `lock2.notifyAll()`

C) `lock3.notifyAll()`

D) `lock4.notifyAll()`

#### 12. Što će se ispisati?

```java
public class Happy {
    final StringBuffer sb1 = new StringBuffer();
    final StringBuffer sb2 = new StringBuffer();
    public static void main(String args[]) {
        final Happy h = new Happy();
        new Thread() {
            public void run() {
                synchronized (h) {
                    h.sb1.append("A");
                    h.sb2.append("B");
                    System.out.println(h.sb1);
                    System.out.println(h.sb2);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                synchronized (h) {
                    h.sb1.append("D");
                    h.sb2.append("C");
                    System.out.println(h.sb1);
                    System.out.println(h.sb2);
                }
            }
        }.start();
    }
}
```

A) A B AD BC 

B) AD BC AD BC

C) A BC AD BC 

D) Redoslijed se ne može utvrditi

#### 13. Koji interface predstavlja strukturu podataka u koju se mogu pridruživati duplikati?

A) `java.util.Map` 

B) `java.util.List`

C) `java.util.Set` 

D) `java.util.Collection`

#### 14. Koje će se vrijednosti nalaziti u kolekciji?

```java
class Element {
    int i;
    public Element(int i){
        this.i=i;
    }
    public boolean equals(Object obj) {
        return true;
    }
    public int hashCode(){
        return 1;
    }
    public String toString(){
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
        System.out.println(lhs);
    }
}
```

A) 1 

B) 5

C) 1, 3, 4, 5 

D) 1, 1, 3, 4, 5

#### 15. Koji je index elementa „treci“?

```java
public static void main(String[] args) {
        List<String> lhs = new ArrayList<String>(5);
        lhs.add(0, "prvi");
        lhs.add(1, "drugi");
        lhs.add(2, "treci");
        lhs.add(2, "cetvrti");
        lhs.add(1, "peti");
        System.out.println(lhs);
}
```

A) 2 

B) 3

C) 4 

D) 5

II.kolokvij - 20130220
=================

#### 1. Koji iskaz treba dodati u liniju 10 da se inicijalizira Bar klasa?

```java
class Foo
{
    class Bar{ }
}
class Test
{
    public static void main (String [] args)
    {
        Foo f = new Foo();
        /* Linije 10: inicijalizacija kase Bar? */
    }
}
```

A)	`Foo.Bar b = new Foo.Bar();`
B)	`Foo.Bar b = f.new Bar();`
C)	`Bar b = new f.Bar();`
D)	`Bar b = new Bar();`

#### 2. Što će se ispisati?

```java
public abstract class AbstractTest
{
    int a;
    public abstract class Bar
    {
        int a = 65;
        public int getNum()
        {
            return a;
        }
    }

    public int getNum()
    {
        return a;
    }

    public static void main (String [] args)
    {
        AbstractTest t = new AbstractTest()
        {
            int a = 45;
            public int getNum()
            {
                return a;
            }
        };
        AbstractTest.Bar f = t.new Bar()
        {
            int a = 34;
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }
}
```

A)	65 45

B)	34 0

C)	34 45

D)	65 0

#### 3. Koja linija će rezultirati sa greškom kod prevođenja?

```java
public class Test{
    private int i = 0;
    private static int j = 0;

    private static void foo(final int k){
        final int l = 0;
        class Bar{
            private void goo(){
                System.out.println(i); // 1)
                System.out.println(j); // 2)
                System.out.println(k); // 3)
                System.out.println(l); // 4)
            }
        }
    }
}
```

A) 1

B) 2

B) 3

D) 4

#### 4. Koji iskaz nije valjan (greška kod prevođenja)?

```java
public interface Test{
    public int a = 1; // 1
    protected int b = 1; // 2
    final int c = 1; // 3
    static int d = 1; // 4
}
```

A)	1 			

B)	2

C)	3			

D)	4

#### 5. Što će se ispisati?

```java
enum Test {
    PRVI(7, 30), DRUGI(12, 15), TRECI(19, 45);
    private int hh;
    private int mm;

    Test(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }

    public int getHour() {
        return hh;
    }

    public int getMins() {
        return mm;
    }
}

public class TestAll {
    public static void main(String args[]) {
        Test t = Test.DRUGI;
        int i = 4 * t.ordinal();
        i = i % t.values().length;
        printData(i);
    }

    static void printData(int i) {
        System.out.println(Test.values()[i].getHour() + ":" + Test.values()[i].getMins());
    }
}
```

A) 7:30				

B) 12:15

C) 19:45				

D) Greška kod prevođenja

#### 6. Što će se ispisati?

```java
enum Rank {
    FIRST(1), SECOND(2), THIRD(3);
    Rank(int value) {
        System.out.print(value);
    }
}
public class EnumCreation {
    public static void main (String[] args) {
        System.out.println("\n" + Rank.values().length);
    }
}
```

A) 3 123

B) 3

C) 123 3

D) Greška kod prevođenja

#### 7. Što će se ispisati?

```java
class Exc0 extends Exception { }
class Exc1 extends Exc0 { }
public class TestException
{
    public static void main(String args[])
    {
        try
        {
            foo();
        }
        catch (Exc1 e0)
        {
            System.out.println("uhvaćen Ex1 ");
        }
        catch (Exception e)
        {
            System.out.println("uhvaćen Exception");
        }
    }

    public static void foo() throws Exc0 {
        throw new Exc1();
    }
}
```

A) Greška kod prevođenja

B) uhvaćen Exception

C) uhvaćen Ex1

D) Ništa, program završava sa greškom

#### 8. Koji iskaz treba staviti na umjesto /* Kod X */ da se kod može uspješno prevesti?

```java
class TestException extends Exception {}
public class ExceptionTest
{
    public void runTest() throws TestException {}
    public void test() /* Kod X */
    {
        runTest();
    }
}
```

A) Ništa

B) catch ( Exception e )

C) throws Exception

D) throws RuntimeException

#### 9. Što će se ispisati ako su uključene tvrdnje „assert“?

```java
public class TestAssert {
    public static void main(String[] args) {
        for (int i=10; i>0; i--)
            check(i, 3);
        System.out.print("Sve je provjereno");
    }
    public static void check(int i, int j) {
        assert i>j : "param i=" + i + " j=" +j;
    }
}
```

A) Sve je provjereno

B) Greška kod prevođenja

C) AssertionError: param i=10 j=3	

D) AssertionError: param i=3 j=3

#### 10. Što će se ispisati?

```java
public class ThreadDemo
{
    private int count = 1;
    public void doSomething()
    {
        for (int i = 0; i < 10; i++){
            synchronized (this) {
                System.out.println(count++);
            }
        }
    }
    public static void main(String[] args)
    {
        ThreadDemo demo = new ThreadDemo();
        Thread a1 = new MyThread(demo);
        Thread a2 = new MyThread(demo);
        a1.start();
        a2.start();
    }
}
class MyThread extends Thread
{
    ThreadDemo demo;
    public MyThread(ThreadDemo td)
    {
        demo = td;
    }
    public void run()
    {
        demo.doSomething();
    }
}
```

A) Brojeve od 0 19 sekvencialno

B) Brojeve od 0 19 ali nije moguće odrediti redoslijed

C) Brojeve od 1 20 sekvencialno

D) Brojeve od 1 20 ali nije moguće odrediti redoslijed


#### 11. Nit je zaustavljena naredbom u linij 13 i nakon toga je nit probuđena naredbom lock2.notifyAll(). Da bi nit nastavila sa radom brave kojih objekata mora nit ponovno zaključati?

```java
public class ThreadDemo {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private Object lock3 = new Object();
	private Object lock4 = new Object();

	public synchronized void doSomething() {
		synchronized (lock1) {
			synchronized (lock2) {
				synchronized (lock3) {
					synchronized (lock4) {
						try {
							lock2.wait(); // linija 13
						} catch (InterruptedException e) {
						}
					}
				}
			}
		}
	}
}
```

A) lock1 lock2 lock3 lock4			

B) lock1 lock2

C) lock2
	
D) niti jednog


#### 12. Što će se ispisati?

```java
public class ThreadDemo2 {
	public static void main(String[] args) {
		Thread t = new Nit(0);
		Thread t2 = new Nit(20);
		t.start();
		t2.start();
		System.out.println("main gotov!");
	} 
}

class Nit extends Thread {
	int start;
	public Nit(int start){
		this.start=start;
	}
	public void run() {
		for (int i = start; i<start+20; i++)
			System.out.println(i);
	}
}
```

A) svi brojevi 0-39 pa „main gotov“

B) „main gotov“ pa svi brojevi 0-39

C) „main gotov“ i svi brojevi od 0 do 39, ali nije moguće odrediti redoslijed

D) Greška kod prevođenja


#### 13. Koji interface predstavlja strukturu podataka u koju se mogu pridruživati parovi ključ-vrijednosti?

 A) java.util.Map
 
 B) java.util.List
 
 C) java.util.Set
 
 D) java.util.Collection

#### 14. Koje će se vrijednosti nalaziti u kolekciji?

```java
class Element {
    int i;
    public Element(int i){
        this.i=i;
    }
    public boolean equals(Object obj) {
        return i%2==0;
    }
    public int hashCode(){
        return i%2==0 ? 1 : 0;
    }
    public String toString(){
        return  "" + i;
    }
}

public class TestCol {
    public static void main(String[] args) {
        Set<Element> lhs = new LinkedHashSet<Element>();
        lhs.add(new Element(1));
        lhs.add(new Element(2));
        lhs.add(new Element(3));
        lhs.add(new Element(4));
        lhs.add(new Element(5));
        lhs.add(new Element(6));
        System.out.println(lhs);
    }
}
```

A) 1, 2, 3, 4, 5		
	
B) 1, 3, 5

C) 1, 2, 4, 6	
		
D) 1, 2, 3, 5

#### 15. Koliko elemenata se nalazi u listi?

```java
public static void main(String[] args) {
        List<String> lhs = new ArrayList<String>(5);
        lhs.add(0, "prvi");
        lhs.add(1, "prvi");
        lhs.add(2, "treci");
        lhs.add(2, "cetvrti");
        lhs.set(1, "prvi");
        lhs.remove(0);
}
```

A) 2					

B) 3

C) 4					

D) 5

II.kolokvij - 20140122
=================

#### 1. Ako u metodi goo želimo ispisati varijablu a sa vrijednošću 4 koji iskaz trebamo upotrijebiti?

```java
class Foo
{
    int a = 4;
    class Bar{
        int a = 5;
        public void goo(){
            /* ispis varijable*/
        }

    }
}
```

A)	System.out.println(this.a);

B)	System.out.println(super.a);

C)	System.out.println(Foo.this.a);

D)	System.out.println(a); 

#### 2. Što će se ispisati?

```java
public class O
{
    int a;
    public static class I extends O
    {
        public int getNum()
        {
            return a;
        }
    }

    public int getNum()
    {
        return a;
    }

    public static void main (String [] args)
    {
        O t = new O()
        {
            int a = 45;
            public int getNum()
            {
                return a;
            }
        };

        I f = new I()
        {
            int a = 34;
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }
}
```

A)	34 45

B)	34 0

C)	0 45	

D)	Greška kod prevođenja


#### 3. Koja linija neće rezultirati sa greškom kod prevođenja?

```java
public class Local{
    private int a = 0;
    public  int b = 0;

    private static void foo(int c){
        final int d = 0;
        class Bar{
            private void goo(){
                System.out.println(a); // 1)
                System.out.println(b); // 2)
                System.out.println(c); // 3)
                System.out.println(d); // 4)
            }
        }
    }
}
```

A) 1

B) 2

B) 3

D) 4

#### 4. Koja je valjana deklaracija metode interface-a?

```java
interface Test{
    int foo(); // 1
    protected int goo(); // 2
    public static int hoo(); // 3
    public int koo() {return i}; // 4
}
```

A) 1

B) 2

C) 3

D) 4


#### 5. Koliko instanci enum tipa EnumTest postoje?

```java
enum EnumTest {
    PRVI, DRUGI;
}
```

A)	0

B)	1

C)	2

D)	neograničeno (mogu se kreirati nove po potrebi)

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

A) sai0s08
		
B) sai0s08 1

C) Greška kod prevođenja

D) 1

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

A) Greška kod prevođenja

B) uhvaćen Exception

C) uhvaćen Ex0

D) Ništa, program završava sa greškom


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

A) Ništa

B) catch ( Exception e )

C) throws Exception

D) throws RuntimeException


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

A) AssertionError: 6

B) AssertionError: 0

C) Sve je provjereno

D) Greška kod prevođenja

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

A) Brojeve od 0 19 ali nije moguće odrediti redoslijed

B) Brojeve od 1 20 sekvencialno

C) Brojeve od 1 20 ali nije moguće odrediti redoslijed

D) Greška kod prevođenja


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

A) a1

B) a2

C) a3

D) a4


#### 12. Što će se ispisati?

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

A) svi brojevi 0-20 pa „main gotov“

B) „main gotov“ pa svi brojevi 0-20 

C) „main gotov“ i samo neki brojevi redoslijednom od 0 (maksimalno do 20)

D) Greška kod prevođenja

#### 13. Koji interface predstavlja strukturu podataka u koju se mogu pridruživati duplikati?

 A) java.util.Map
 
 B) java.util.List
 
 C) java.util.Set
 
 D) java.util.Collection


#### 14. Što vraća read() metoda InputStream -a?

A) string

B) byte kao int vrijednost

C) char kao int vrijednost

D) char[]


#### 15. Koja tvrdnja nije točna za hashCode metodu?

A) višestruko pozivanje metode moraju dati istu hash vrijednost ako se stanje objekta nije promijenilo
					
B) Ako dva objekta nisu jednaki po equals metodi tada moraju dati različite hash vrijednosti

C) vraća int vrijednost

D) Ako su dva objekta jednaki po equals metodi tada trebaju dati istu hash vrijednost

II.kolokvij - 20160127
=================

Teorija:

#### 1. Navedite razlike između enum tipa i klase?
#### 2. Kako se definira lista iznimki koje može baciti metoda?  Koje se sve iznimke mogu baciti iz metode obzirom na listu iznimki metode.
#### 3. Navedite kategorije stream klasa.
#### 4. Kako se određuje prioritet niti?
#### 5. Kako se definira lokacija kompajliranih klasa za interpreter (JVM)?
#### 6. Koji su koraci i način pokretanja niti kod implementacije Runnable interface-a?
#### 7. Kojim varijablama ima pristup lokalna klasa iz okružujućeg bloka?
#### 8. Navedite svojstva i primjere implementacije setova.
#### 9. Navedite osnovne metode OutputStream klase.
#### 10.	Kako se mogu uvesti statički članovi klase?

Zadaci:

#### 1. Što će se ispisati ako su uključene tvrdnje „assert“? (3)

```java
enum Color {
	RED, GREEN, BLUE;
}

public class TestEnum2 {

	private static void printColor(Color a) {
		assert a.ordinal() < 2 : "Ordinal = " + a.ordinal();
		System.out.println(a.ordinal());
	}

	public static void main(String[] args) {
		Color[] colors = Color.values();
		for (int i = 0; i < colors.length; i++) {
			printColor(colors[i]);
		}
	}
}
```

#### 2. Što će se ispisati? (4)

```java
public class TestException {

	public static void main(String[] args) {
		test(1);
		test(2);
	}

	public static void test(int i) {
		try {
			System.out.println("1");
			goo(i);
			System.out.println("2");
		} catch (Exc2 e) {
			System.out.println("3");
		} catch (Exception e) {
			System.out.println("4");
		} finally {
			System.out.println("5");
		}
		System.out.println("6");
	}

	public static void goo(int i) throws Exc2 {
		if (i == 1)
			throw new Exc2();
		if (i == 2)
			throw new Exc1();
	}
} 
```

#### 3. Što će se ispisati? (3)

```java
interface I {
	int a = 3;

	public int getNum();
}

public class O implements I {
	int a = 12;

	public int getNum() {
		return a;
	}

	public static void main(String[] args) {
		O t = new O() {
			int a = 15;
			public int getNum() {
				return a + super.a;
			}
		};

		I f = new I() {
			public int getNum() {
				return a + 1;
			}
		};
		System.out.println(f.getNum() + " " + t.getNum());
	}
}
```

#### 4. Navedite elemente Set-a lhs? (4)

```java
public class ThreadDemo4 {
    private int count = 1;

    public void doSomething() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                System.out.println(count++);
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo4 demo1 = new ThreadDemo4();
        ThreadDemo4 demo2 = new ThreadDemo4();
        Thread a1 = new MyThread4(demo1);
        Thread a2 = new MyThread4(demo2);
        a1.start();
        a2.start();
    }
}

class MyThread4 extends Thread {
    ThreadDemo4 demo;

    public MyThread4(ThreadDemo4 td) {
        demo = td;
    }

    public void run() {
        demo.doSomething();
    }
}
```

#### 5. Da li se može jednoznačno odrediti ispis? Ako da, što će se ispisati? Ako ne, zbog čega? (6)

```java
public class ThreadDemo4 {
    private int count = 1;

    public void doSomething() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                System.out.println(count++);
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo4 demo1 = new ThreadDemo4();
        ThreadDemo4 demo2 = new ThreadDemo4();
        Thread a1 = new MyThread4(demo1);
        Thread a2 = new MyThread4(demo2);
        a1.start();
        a2.start();
    }
}

class MyThread4 extends Thread {
    ThreadDemo4 demo;

    public MyThread4(ThreadDemo4 td) {
        demo = td;
    }

    public void run() {
        demo.doSomething();
    }
}
```