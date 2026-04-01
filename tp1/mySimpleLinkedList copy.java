package programacion3.tp1;

public class mySimpleLinkedList<T> {
	
	private Node<T> first;
	
	public mySimpleLinkedList(Node<T> first) {
		this.first = first;
	}
	
	public void insertFront(T info) {
		Node<T> insertado = new Node(info, null); //creo nodo con la info q llega por parametro
		insertado.getNext(this.first); //le digo q el prox nodo sera el que tengo en la primer posicion ahora 
		this.first = insertado; //hago q el nodo q cree sea el primero
	}
	
	public T extractFront() {        
		if (this.first == null) // verifico first (q contenga info)
			return null; // si no tiene nada retorno nulo

		// si tiene paso a hacer esto

		T info = this.first.getInfo(); //en una var info guardo la info del nodo
		this.first = this.first.getNext(); // seteo q el primer nodo va a ser el siguiente (eliminandolo, ya q no se va a poder acceder)
		return info; // retorno la info

	}

	public boolean isEmpty() {
		if (this.size() != 0)  // verifico q yo (lista) tenga nodos
			return true; // si tengo retorno true

		return false; // si no false
	}
	
	public T get(int index) {
		Node<T> nodo = this.first; // meto el nodo first en un nodo temp
		int i = 0;
		while(nodo != null){ // q recorra todos los nodos
			if (i == index) {	// si el i es igual al index q me dan
				return nodo.getInfo(); // retorno la informacion
			}
			nodo = nodo.getNext(); // si no cambio al siguiente nodo
			i++; // incremento el i (posicion del nodo)
		}
		return null; // si no encuentra la posicion index retorna null
	}
	
	public int size() {
		Node<T> nodo = this.first; // meto el nodo first en un nodo temp
		int i = 0; 
		while (nodo != null){ // q recorra todos los nodos
			nodo.getNext(); // cambio al siguiente nodo
			i++; // incremento el i (posicion del nodo)
		}
		return i; // retorno la cantidad de posiciones q haya 
	}
	
	@Override
	public String toString() {
		String text = ""; // variable de texto vacia  
		Node<T> nodo = this.first; // meto el nodo first en un nodo temp
		while (nodo != null) { // q recorra todos los nodos	
			text += nodo.getInfo(); // sumo la info de cada nodo a la variable
			nodo = nodo.getNext(); // cambio al siguiente nodo
		}
		return text; // retorno el texto
	}

	public int indexOf(T elemento){
		Node<T> nodo = this.first; // meto el nodo first en un nodo temp
		int i = 0;
		while (nodo != null) { // q recorra todos los nodos	
			if (nodo.getInfo().equals(elemento)) { //verifico si la info es igual al elemento pasado por parametro
				return i; // si lo es retorno el index
			}
			nodo = nodo.getNext(); // si no cambio al siguiente nodo
			i++; // e incremento a la siguietne posicion
		}
		return -1; // si no encuentra la igualdad y se termina la lista retorno -1
	}
	
}