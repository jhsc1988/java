package hr.vsite.java;

public class Node<E> {
    Node next;
    Node prev;
    E data;

    public Node(){
        next = null;
        prev = null;
        data = null;
    }
}

/*
* C:
* Node nextS;
* Node * nextP;
* nextS.data;
* nextP->data;
* *nextP.data;
*
* JAVA:
* Node next; // referenca - "pointer" na instancu klase Node
* next.data;
*
* */