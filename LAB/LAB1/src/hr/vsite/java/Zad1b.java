package hr.vsite.java;

import java.util.ArrayList;
import java.util.Scanner;


public class Zad1b {

    private static void removeCalculated(ArrayList<String> a, int j) {
        for (int i = 0; i < 3; i++)
            a.remove(j - 1);
    }

    public static void main(String[] args) {

        for (String arg : args) {

// 1. zad
            ArrayList<String> a = new ArrayList<>();

            Scanner s = new Scanner(arg);
            s.useDelimiter("(?<=[-+*/])|(?=[-+*/])"); // regex lookahead

            while (s.hasNext()) {
                String t = s.next();
                a.add(t);
            }

            for (Object o : a) System.out.println(o);

// 2. zad

            int rez = Integer.parseInt(a.get(0));
            for (int i = 1; i < a.size(); i += 2) {
                switch (a.get(i)) {
                    case "+":
                        rez += Integer.parseInt(a.get(i + 1)); // ili intValue(a.get(i + 1));
                        break;
                    case "-":
                        rez -= Integer.parseInt(a.get(i + 1));
                        break;
                    case "*":
                        rez *= Integer.parseInt(a.get(i + 1));
                        break;
                    case "/":
                        rez /= Integer.parseInt(a.get(i + 1));
                        break;
                }
            }
            for (Object o : a) System.out.print(o);
            System.out.print("=" + rez + "\n");

// 3. zad

            for (Object o : a) System.out.print(o);
            for (int i = 1; i < a.size(); ) {
                switch (a.get(i)) {
                    case "*":
                        rez = Integer.parseInt(a.get(i - 1)) * Integer.parseInt(a.get(i + 1));
                        removeCalculated(a, i);
                        a.add(i - 1, Integer.toString(rez));
                        break;
                    case "/":
                        rez = Integer.parseInt(a.get(i - 1)) / Integer.parseInt(a.get(i + 1));
                        removeCalculated(a, i);
                        a.add(i - 1, Integer.toString(rez));
                        break;
                    default:
                        i += 2;
                }
            }

            rez = Integer.parseInt(a.get(0));
            for (int i = 1; i < a.size(); i += 2) {
                switch (a.get(i)) {
                    case "+":
                        rez += Integer.parseInt(a.get(i + 1));
                        break;
                    case "-":
                        rez -= Integer.parseInt(a.get(i + 1));
                        break;
                }
            }
            System.out.print("=" + rez);
        }
    }
}