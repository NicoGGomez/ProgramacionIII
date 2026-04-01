package tp1.ejercicio5;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        mySimpleLinkedList<Integer> list1 = new mySimpleLinkedList<>(null);
        list1.insertFront(3);
        list1.insertFront(12);
        list1.insertFront(1);

        mySimpleLinkedList<Integer> list2 = new mySimpleLinkedList<>(null);
        list2.insertFront(22);
        list2.insertFront(12);
        list2.insertFront(5);

        mySimpleLinkedList<Integer> listaOrdenada = interseccion(list1, list2);

        Iterator<Integer> it3 = listaOrdenada.iterator();
        while(it3.hasNext()){
            Integer i = it3.next();
            System.out.print(i + " ");
        }
    }

    // ejercicio 5
    public static mySimpleLinkedList<Integer> interseccion(
            mySimpleLinkedList<Integer> l1,
            mySimpleLinkedList<Integer> l2) {

        mySimpleLinkedList<Integer> resultado = new mySimpleLinkedList<>(null);

        for (Integer e1 : l1) {
            for (Integer e2 : l2) {
                if (e1.equals(e2) && resultado.indexOf(e1) == -1) {
                    resultado.insertFront(e1);
                }
            }
        }

        return resultado;
    }

    // ejercico 6
    public static mySimpleLinkedList<Integer> diferencia(
            mySimpleLinkedList<Integer> l1,
            mySimpleLinkedList<Integer> l2) {

        mySimpleLinkedList<Integer> resultado = new mySimpleLinkedList<>(null);

        for (Integer e1 : l1) {
            if (l2.indexOf(e1) == -1) { // no está en l2
                resultado.insertFront(e1);
            }
        }

        return resultado;
    }

}