package hr.vsite.java;

public class Main {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.push(21);
        ll.push(22);
        ll.push(23);
        ll.push(24);

        System.out.println(ll); // toString(); override
        ll.pop();
        System.out.println(ll);

        ll.offer(11);
        ll.offer(12);

        ll.offer(13);
        ll.offer(14);
        ll.offer(15);

        System.out.println(ll);
        ll.poll();
        System.out.println(ll);
    }
}
