package grafos.facu;

import java.util.ArrayList;
import java.util.Iterator;

public class ejerciciosRestantes<T> {
    
    // Ejercicio 3
    // Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
    public boolean tieneCiclo(GrafoDirigido<T> g){

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() == 'B') {
                if (tieneCiclo(g,v)) 
                    return true;
                
            }
        }        

        return false;
    }

    public boolean tieneCiclo(GrafoDirigido<T> g, Vertice<T> actual){

        actual.setColor('A');

        Iterator<Integer> adyacentes = g.obtenerAdyacentes(actual.getId());

        while (adyacentes.hasNext()) {
            Vertice<T> adyacente = g.getVertice(adyacentes.next());
            if (adyacente.getColor() == 'B') {
                if (tieneCiclo(g, adyacente))
                    return true;
            } else if (adyacente.getColor() == 'A') {
                return true;
            }
        }

        actual.setColor('N');
        return false;
    }

    // Ejercicio 4
    // Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el grafo de entrada es acíclico.

    public ArrayList<Vertice<T>> devolverCamino(GrafoDirigido<T> g,Vertice<T> i, Vertice<T> j){
        ArrayList<Vertice<T>> camino = new ArrayList<>();
        ArrayList<Vertice<T>> caminoMasLargo = new ArrayList<>();

        Iterator<Integer> it = g.obtenerVertices();
        
        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        devolverCamino(g, i, j, camino, caminoMasLargo);

        return caminoMasLargo;

    }

    private void devolverCamino(GrafoDirigido<T> g,Vertice<T> actual, Vertice<T> fin, ArrayList<Vertice<T>> camino, ArrayList<Vertice<T>> caminoMasLargo){
        
        camino.add(actual);

        if (actual.equals(fin)) {
            if (camino.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(camino);
            }
        }

        actual.setColor('A');

        Iterator<Integer> vecinos = g.obtenerAdyacentes(actual.getId());

        while (vecinos.hasNext()) {
            Vertice<T> vecino = g.getVertice(vecinos.next());
            if (vecino.getColor() == 'B') {
                devolverCamino(g, vecino, fin, camino, caminoMasLargo);
            }
        }

        camino.remove(camino.size() - 1);
        actual.setColor('B');

    }

}
