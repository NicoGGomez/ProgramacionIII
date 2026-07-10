package grafos.facu;

/*

public ... bfs(Grafo<T> g){
    Iterator<Integer> it = g.obtVertices();

    while(it.hasNext()){
        Vertice<T> v = g.getVertice(it.next());
        v.setColor('B');
    }

    it = g.obtVertices();

    while(it.hasNext()){
        Vertice<T> v = g.getVertice(it.next());

        if(v.getColor() == 'B')
            bfs(g, v);
    }
}

private ... bfs(Grafo<T> g, Vertice<T> origen){
    Queue<Vertice<T>> cola = new LinkedList<>();

    origen.setColor('A');
    cola.add(origen);

    while(!cola.isEmpty()){
        Vertice<T> act = cola.poll();

        Iterator<Integer> vecinos = g.obtAdyacentes(act.getId());

        while(vecinos.hasNext()){
            Vertice<T> vecino = g.getVertice(vecinos.next());

            if(vecino.getColor() == 'B'){
                vecino.setColor('A');
                cola.add(vecino);
            }
        }

        act.setColor('N');
    }
}

*/ 

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

    ArrayBlockingQueue<Integer> fila;
    int niveles = 0;

    public <T> void bfsRun(GrafoDirigido<T> g){

        niveles = 0;

        fila = new ArrayBlockingQueue<>(niveles);

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() == 'B')
                bfsVisit(g, v);
        }

    }

    private <T> void bfsVisit(GrafoDirigido<T> g, Vertice<T> v){

        v.setColor('N');
        fila.add(v.getId());

        int nivelActual = 1;
        int siguienteNivel = 0;

        while (!fila.isEmpty()) {
            
            for(int i = 0; i < nivelActual; i++){
                int id = fila.poll();

                Iterator<Integer> adyacentes = g.obtenerAdyacentes(id);

                while (adyacentes.hasNext()) {
                    Vertice<T> adyacente = g.getVertice(adyacentes.next());
                    if (adyacente.getColor() == 'B') {
                        adyacente.setColor('N');
                        fila.add(adyacente.getId());
                        siguienteNivel++;
                    }
                }

            }

            if (siguienteNivel > 0) {
                niveles++;
                nivelActual = siguienteNivel;
                siguienteNivel = 0;
            } else {
                break;
            }

        }

    }

}
