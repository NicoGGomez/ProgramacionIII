package tema4;

import java.util.Iterator;

public class tieneCiclo {
    
public <T> boolean run(GrafoDirigido<T> g){

    Iterator<Integer> it = g.obtenerVertices();

    while (it.hasNext()) {
        Vertice<T> v = g.getVertice(it.next());
        v.setColor('B');
    }

    it = g.obtenerVertices();

    while (it.hasNext()) {

        Vertice<T> v = g.getVertice(it.next());

        if (v.getColor() == 'B') {

            if (visit(g, v)) {
                return true;
            }
        }
    }

    return false;
}

public <T> boolean visit(GrafoDirigido<T> g, Vertice<T> v){
    
    v.setColor('A');

    Iterator<Integer> adyacentes = g.obtenerAdyacentes(v.getId());

    while (adyacentes.hasNext()) {

        Vertice<T> w = g.getVertice(adyacentes.next());

        // si está en exploración => ciclo
        if (w.getColor() == 'A') {
            return true;
        }

        // si no fue visitado
        if (w.getColor() == 'B') {
            if (visit(g, w)) {
                return true;
            }
        }
    }

    v.setColor('N');

    return false;
}

}
