package grafos.facu;

import java.util.Iterator;

public class DFS {
    
    public <T> void dfsvisit(GrafoDirigido<T> g){

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() == 'B') 
                dfsRun(g, v);
        }

    }

    private <T> void dfsRun(GrafoDirigido<T> g, Vertice<T> actual){

        actual.setColor('A');

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual.getId());

        while (adyacentes.hasNext()) {
            Vertice<T> adyacente = g.getVertice(adyacentes.next());
            if (adyacente.getColor() == 'B')
                dfsRun(g, adyacente);
        }

        actual.setColor('N');

    }

}
