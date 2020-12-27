package hr.vsite.java;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // niz brojeva koje treba sortirati
        int[] sequence = new int[100];


        //-------ˇˇˇˇˇ1. dio vježbeˇˇˇˇˇ-----------
        // inicijaliziramo niz sa slučajnim brojevima od 0 do 255
        //zakomentirajte poziv kada radite 2. dio vježbe
        initSequence(sequence);
        //-------^^^^^1. dio vježbe^^^^^-----------


        //-------ˇˇˇˇˇ2. dio vježbeˇˇˇˇˇ-----------
        //odkomentirajte kada radite 2. dio vježbe
        //sequence = initUserSequence();
        //-------^^^^^2. dio vježbe^^^^^-----------


        printSequence(sequence);
        sortSequence(sequence);
        printSequence(sequence);
        if (checkSequence(sequence)) {
            System.out.println("Niz je ispravno sortiran!");
        } else {
            System.out.println("Niz nije ispravno sortiran!!!");
        }

    }

    private static int[] initUserSequence() {
        /*
         * Ovdje treba napisati kod koji će od korisnika zatražiti duljinu niza
         * i elemente niza koji se sortiraju
         */
        int[] sequence = null;
        int sequenceLength = -1;
        //inicijializacija Scanner objekta koji nam
        //olakšava parsiranje toka znakova koji korisnik upisuje
        Scanner s = new Scanner(System.in);
        // ----------ˇˇˇˇvaš kod ide ovdjeˇˇˇˇ--------------

        // ----------^^^^vaš kod ide ovdje^^^^--------------
        return sequence;
    }

    // metoda koja vraća slijedeći int
    private static int getNextInt(Scanner s) {
        /*
         * metode hasNext...() i next...() su blokirajuće
         * tj. program će tu stati ako nije ništa upisano
         * */
        while (true) {
            // ako je upisan int onda se vraća upisani broj
            if (s.hasNextInt()) {
                return s.nextInt();
            }
            //ako je nešto drugo upisano onda se to preskače
            if (s.hasNext()) {
                System.out.println("Morate upisati broj!");
                s.next();
            }
        }
    }

    private static void sortSequence(int[] sequence) {
        /*
         * U ovoj metodi treba napisati kod koji sortira niz brojeva od najvećeg
         * do najmanjeg (metodom kako je objašnjeno na lab. vježbama)
         */

        int n = sequence.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (sequence[j] > sequence[j - 1]) {
                    temp = sequence[j - 1];
                    sequence[j - 1] = sequence[j];
                    sequence[j] = temp;
                }
            }
        }

    }

    private static void initSequence(int[] sequence) {
        Random r = new Random();
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = r.nextInt(255);
        }
    }

    private static boolean checkSequence(int[] sequence) {
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] < sequence[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void printSequence(int[] sequence) {
        int numPerRow = 14;
        for (int i = 0; i < sequence.length; i++) {
            System.out.printf("%03d ", sequence[i]);
            if ((i + 1) % numPerRow == 0 && i != 0)
                System.out.println();
        }
        System.out.println();
    }

}
