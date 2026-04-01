package tp1.ejercicio5;

import java.util.Iterator;

public class myIterator<T> implements Iterator<T>{
    private Node<T> cursor;

    public myIterator(Node<T> cursor){
        this.cursor = cursor;
    } 

    public boolean hasNext(){
        return cursor != null;
    }

    public T next(){
        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }
}