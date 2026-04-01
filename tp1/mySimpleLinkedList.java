package programacion3.tp1;

public class mySimpleLinkedList<T> {
	
	private Node<T> first;
	
	public mySimpleLinkedList(Node<T> first) {
		this.first = first;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	public T extractFront() {        
		if (this.first == null)
			return null;

		T info = this.first.getInfo();   // guardo info
		this.first = this.first.getNext(); // “borro” el primero

		return info;
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return false;
		}
		return true;
	}
	
	public T get(int index) {
		Node<T> nodo = this.first;
		int i = 0;
		while(nodo != null){
			if(i == index){
				return nodo.getInfo();
			}
			nodo = nodo.getNext();
			i++;
		}
		return null;
	}
	
	public int size() {
		Node<T> nodo = this.first;
		int i = 0;
		while(nodo != null){
			nodo = nodo.getNext();
			i++;
		}
		return i;
	}
	
	@Override
	public String toString() {
		String texto = "";
		Node<T> nodo = this.first;
		while(nodo != null){
			texto += nodo.getInfo();
			nodo = nodo.getNext();
		}
		return texto;
	}

	public int indexOf(T elemento){
		int i = 0;
		Node<T> nodo = this.first;
		while (nodo != null) {
			if (nodo.getInfo().equals(elemento)) {
				return i;
			}
			nodo = nodo.getNext();
			i++;
		}
		return -1;
	}
	
}