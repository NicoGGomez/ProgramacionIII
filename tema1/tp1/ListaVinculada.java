package tema1.tp1;

import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T> {
	
	private Nodo<T> first;
	
	public ListaVinculada() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Nodo<T> tmp = new Nodo<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	// EJERCICIO 1
	public T extractFront() {		
		if (this.first == null) {
			return null;
		}
		T info = this.first.getInfo();
		this.first = this.first.getNext();
		return info;
	}

	// EJERCICIO 1
	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		}
		return false;
	}
	
	// EJERCICIO 1
	public T get(int index) {
		Nodo<T> nodo = this.first;
		int i = 0;
		while (nodo != null) {
			if (index == i) {
				return nodo.getInfo();
			}
			nodo = nodo.getNext();
			i++;
		}
		return null;
	}
	
	// EJERCICIO 1
	public int size() {
		Nodo<T> nodo = this.first;
		int medida = 0;
		while (nodo != null) {
			medida++;
			nodo = nodo.getNext();
		}
		return medida;
	}
	
	// EJERCICIO 1 
	@Override
	public String toString() {
		Nodo<T> nodo = this.first;
		String txt = "";
		while (nodo != null) {
			txt += nodo.getInfo();
			nodo = nodo.getNext();
		}
		return txt;
	}

	// EJERCICO 3
	public int indexOf(T elemento){
		Nodo<T> nodo = this.first;
		int i = 0;
		while (nodo != null) {
			if (nodo.getInfo().equals(elemento)) {
				return i;
			}
			nodo = nodo.getNext();
			i++;
		}
		return -1;
	}

	// EJERCICIO 4
	@Override
	public Iterator<T> iterator() {
		return new Iterador<T>(this.first);
	}
	
}
