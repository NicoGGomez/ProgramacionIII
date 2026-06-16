package tema4;

import java.util.ArrayList;
import java.util.Iterator;

/* 

obtengo los vertices
los pinto de blanco(no recorrido)
comienzo el recorrido desde el vertice1 

lo pinto de amarillo
verifico si llego al final (actual == fin)
lo agrego al arreglo
itero en los adyacentes
verifico si esta en la lista
si no esta hago la funcion con este vertice

*/

public class caminoMasSimple {
    
    public static <T> ArrayList<Vertice<T>> run(GrafoDirigido<T> g, Vertice<T> inicio,Vertice<T> fin){
        int cantidadCaminoCorto = 0;
        ArrayList<Vertice<T>> caminoSimple = new ArrayList<>();

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        visit(g, inicio, fin, caminoSimple);

        return caminoSimple;
    }

    public static <T> void visit(GrafoDirigido<T> g, Vertice<T> verticeActual,Vertice<T> fin, ArrayList<Vertice<T>> camino){

        verticeActual.setColor('A');
        
        if (verticeActual == fin) {
            
        }

        camino.add(verticeActual);

        Iterator<Integer> it = g.obtenerAdyacentes(verticeActual.getId());
        
        while (it.hasNext()) {
            Vertice<T> verticeSig = g.getVertice(it.next());
            
            if (!camino.contains(verticeSig)) {
                visit(g, verticeSig, fin, camino);
            }

        }


    }

}
