
/*

2. Camino en grafo

Dado un grafo y dos vértices `A` y `B`, determinar si existe un camino entre ellos.

*/

import java.util.Iterator;

public class ejercicioGPT2<T> {
    
    public boolean caminoEntreGrafos(Vertice<T> A, Vertice<T> B, GrafoDirigido<T> g){

        Iterator<T> it = g.obtenerVertices();

        while(it.hasNext()){
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        return caminoEntreGrafos(A, B, g)

    }

    public boolean caminoEntreGrafos(Vertice<T> actual, Vertice<T> fin, GrafoDirigido<T> g){

        actual.setColor('A');

        if (actual.equals(fin))
            return true;

        Iterator<T> vecinos = g.obtenerAdyacentes(actual.getId());

        while (vecinos.hasNext()) {
            Vertice<T> vecino = g.getVertice(vecinos.next());
            if (vecino.getColor() == 'B') {
                if (caminoEntreGrafos(vecino, fin, g))
                    return true;
            }
        }

        return false;
    }


}
