package tema4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class recorridoMasRapido {

    private static int tiempo = 0;

    public static <T> int run(Grafo<T> ciudad, Vertice<T> esq1, Vertice<T> esq2){
        List<Vertice<T>> caminoMasCorto = new ArrayList<>();
		recorridoMasRapido(ciudad, esq1, esq2, caminoMasCorto);
		return caminoMasCorto; 
    }

    public List<Vertice<T>> recorridoMasRapido(Grafo<T> ciudad, Vertice<T> esq1, Vertice<T> esq2, List<Vertice<T>> caminoMasCorto){
		Iterator<Vertice<Integer>> recorrido = ciudad.obtenerVertices();

		while (recorrido.hasNext()) {
			Vertice<Integer> esquina = ciudad.
		}

		return caminoMasCorto;
	}
    
}
