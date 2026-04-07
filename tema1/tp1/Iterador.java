package tema1.tp1;

import java.util.Iterator;

// EJERCICIO 4

public class Iterador<T> implements Iterator<T> {
    
    private Nodo<T> cursor;

    public Iterador (Nodo<T> nodo){
        this.cursor = nodo;
    }
    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

}
