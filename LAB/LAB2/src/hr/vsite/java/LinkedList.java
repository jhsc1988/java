package hr.vsite.java;

public class LinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * @return peek – vraća slijedeći element sa stoga ali element ostaje u stogu
     */
    public Object peek(){
        return head.next.data;
    }

    /**
     * @param data push - stavlja novi element na stog
     */
    public void push(E data){
        Node <E>n = new Node<>();
        n.data = data;

        if (size == 0){
            head = n;
            tail = n;
        }
        else {
            head.prev = n;
            n.next = head;
            head = n;
        }
        ++size;
    }

    /**
     * @return pop – dohvaća element sa stoga
     */
    public Object pop(){
        if (size == 0)
            return null;

        Node popNode = head;
        head = head.next;
        head.prev = null;
        --size;
        return popNode.data;
    }

    /**
     * @param data stavlja element na kraj reda
     */
    public void offer(E data){
        push(data);
    }

    /**
     * @return dohvaća element sa početka reda
     */
    public Object poll(){
        if (size == 0)
            return null;
        Node pollNode = tail;
        tail.prev.next = null;
        tail = tail.prev;
        --size;
        return pollNode.data;
    }

    /**
     * @return dohvaća element sa početka reda ali element ostaje u redu
     */
    public Object element(){
        return tail.data;
    }

    /**
     * @return vraća broj elemenata u listi
     */
    public int size(){
        return size;
    }

    /**
     * @return vraća boolean da li je lista prazna
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @param data prima element
     * @return vraća boolean - da li lista sadržava neki element
     */
    public boolean contains(E data){
        Node iter = head;

        while (iter != null){
            if (iter.data == data)
                return true;
            iter = iter.next;
        }
        return false;
    }

    /**
     * @return formatira string sa vrijednostima elemenata u listi
     */
    @Override
    public String toString() {
        String str = "";
        Node iter = head;

        while (iter != null){
            str = str + iter.data + " ";
            iter = iter.next;
        }
        return str;
    }
}
