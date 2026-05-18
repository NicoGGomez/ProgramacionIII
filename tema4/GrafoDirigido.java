package tema4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

    HashMap<Integer, Vertice<T>> vertices = new HashMap<>();

	public int DFS(){
		int tiempo = 0;
		Iterator<Integer> it = obtenerVertices();

		while (it.hasNext()) {
			Vertice<T> v = getVertice(it.next());
			v.setColor('B');
		}

		it = obtenerVertices();

		while (it.hasNext()) {
			Vertice<T> v = getVertice(it.next());
			if (v.getColor() == 'B') {
				DFS(tiempo, v);
			} 
		}

		return tiempo;
	}

	public void DFS(int tiempo, Vertice<T> vertice){
		vertice.setColor('A');
		tiempo++;
		vertice.setTiempoInicial(tiempo);

		Iterator<Integer> it = obtenerAdyacentes(vertice.getId());

		while (it.hasNext()) {
			Vertice<T> v = getVertice(tiempo);
		}
	}

	@Override
	public void agregarVertice(int verticeId) {
		vertices.put(verticeId, new Vertice<>(verticeId));
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);

		Iterator<Integer> it = obtenerVertices();

		while (it.hasNext()) {
			getVertice(it.next()).borrarArco(verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		getVertice(verticeId1).agregarArco(verticeId2, etiqueta);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1) || !vertices.containsKey		    (verticeId2)) return;

		getVertice(verticeId1).borrarArco(verticeId2);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) return false;

		return getVertice(verticeId1).contieneArco(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		return getVertice(verticeId1).obtenerArco(verticeId2);
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int suma = 0;
		for (Vertice<T> v : vertices.values()) {
			suma += v.getCantidadArcos();
		}
		return suma;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator(); 
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
			return getVertice(verticeId).obtenerAdyacentes().iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> res = new ArrayList<>();
		for (Vertice<T> v : vertices.values()) {
			res.addAll(v.obtenerArcos());
		}
		return res.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return getVertice(verticeId).obtenerArcos().iterator();
	}

	public Vertice<T> getVertice(int id) {
		return vertices.get(id);
	}

}
