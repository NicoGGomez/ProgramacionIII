package grafos.facu;

import java.util.Iterator;

public class DFS {
    
    public <T> void dfsRun(GrafoDirigido<T> g){

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() == 'B') 
                dfsVisit(g, v);
        }

    }

    private <T> void dfsVisit(GrafoDirigido<T> g, Vertice<T> actual){

        actual.setColor('A');

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual.getId());

        while (adyacentes.hasNext()) {
            Vertice<T> adyacente = g.getVertice(adyacentes.next());
            if (adyacente.getColor() == 'B')
                dfsVisit(g, adyacente);
        }

        actual.setColor('N');

    }

}
