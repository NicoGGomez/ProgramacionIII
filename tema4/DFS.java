package tema4;

import java.util.Iterator;

public class DFS {

    private static int tiempo = 0;

    public static <T> int run(GrafoDirigido<T> G){

        tiempo = 0;

        // hace q la lista se iterable
        Iterator<Integer> it = G.obtenerVertices(); 

        //pintar todos los nodos de blanco (no visitado)
        while(it.hasNext()){
            Vertice<T> v = G.getVertice(it.next());
            v.setColor('B');
        }
        // llega al final de la lista 

        // vuelve a hacer la lista iterable
        it = G.obtenerVertices();

        // recorre nuevamente la lista
        while (it.hasNext()) {
            Vertice<T> v = G.getVertice(it.next());
            // se fija si esta pintado de blanco, osea no visito y si no esta visitado hace la funcion visitar
            if (v.getColor() == 'B') {
                visit(v, G);
            }
        }

        return tiempo;
    }

    public static <T> void visit(Vertice<T> v, GrafoDirigido<T> G){
        // comienza con estado amarillo, como q comenzo a visitarse y suma uno a tiempo
        v.setColor('A');
        tiempo++;
        v.setTiempoInicial(tiempo);

        // hace iterable la lista de los adyacentes para poder recorrerlos
        Iterator<Integer> it = G.obtenerAdyacentes(v.getId());
    
        // recorre la nueva lista de adyacentes
        while (it.hasNext()) {
            Vertice<T> u = G.getVertice(it.next());
            // pregunta si estan visitados, si no lo estan hace la funcion visit(), si no sale
            if (u.getColor() == 'B') {
                visit(u, G);
            }
        }

        // lo pinta de negro como ya terminado de recorrer
        v.setColor('N');
        v.setTiempoFinal(++tiempo);
    }

}
