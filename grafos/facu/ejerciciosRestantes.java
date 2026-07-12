package grafos.facu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

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

    // Ejercicio 5
    // Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista con todos los vértices a partir de los cuales exista un camino en G que termine en v.

    public ArrayList<Vertice<T>> caminoHastaVertice(GrafoDirigido<T> g, Vertice<T> v){

        ArrayList<Vertice<T>> camino = new ArrayList<>();

        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> vertice = g.getVertice(it.next());
            vertice.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> vertice = g.getVertice(it.next());
        
            Iterator<Integer> aux = g.obtenerVertices();
            while(aux.hasNext())
                g.getVertice(aux.next()).setColor('B');

            if (caminoHastaVertice(g, vertice, v))
                camino.add(vertice);
        }

        return camino;

    }

    private boolean caminoHastaVertice(GrafoDirigido<T> g, Vertice<T> actual, Vertice<T> fin){
        if (actual.equals(fin))
            return true;

        actual.setColor('A');

        Iterator<Integer> vecinos = g.obtenerAdyacentes(actual.getId());

        while (vecinos.hasNext()) {
            Vertice<T> vecino = g.getVertice(vecinos.next());
            if (vecino.getColor() == 'B') 
                if (caminoHastaVertice(g, vecino, fin))
                    return true;
        }

        actual.setColor('N');
        return false;
    }

    // Ejercicio 6
    // Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor cantidad de cuadras posible.
    public ArrayList<Vertice<T>> caminoMasCorto(GrafoDirigido<T> g, Vertice<T> esq1, Vertice<T> esq2){
        ArrayList<Vertice<T>> camino = new ArrayList<>();
        ArrayList<Vertice<T>> caminoMasCorto = new ArrayList<>();
        
        int niveles = 0;
        ArrayBlockingQueue<Integer> fila = new ArrayBlockingQueue<>(niveles);

        Iterator<Integer> it = g.obtenerVertices();
        
        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        caminoMasCorto(g, esq1, esq2, camino, caminoMasCorto, fila, niveles);        

        return caminoMasCorto;

    }

    private void caminoMasCorto(GrafoDirigido<T> g, Vertice<T> esqAct, Vertice<T> esqFin, ArrayList<Vertice<T>> camino, ArrayList<Vertice<T>> caminoMasCorto, ArrayBlockingQueue<Integer> fila, int niveles){

        esqAct.setColor('N');
        fila.add(esqAct.getId());

        int nivelActual = 1;
        int sigNivel = 0;

        while (!fila.isEmpty()) {
            
            for(int i = 0; i < nivelActual; i++){
                int id = fila.poll();

                Iterator<Integer> vecinos = g.obtenerAdyacentes(id);

                while (vecinos.hasNext()) {
                    Vertice<T> vecino = g.getVertice(vecinos.next());
                    if (vecino.getColor() == 'B') {
                        camino.add(esqAct);
                        vecino.setColor('N');
                        fila.add(vecino.getId());
                        sigNivel++;
                    }
                }

            }

            if (sigNivel > 0) {
                niveles++;
                nivelActual = sigNivel;
                sigNivel = 0;
            } else {
                break;
            }

        }

    }

    // Ejercicio 7
    // Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos Aires a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito.
    public ArrayList<ArrayList<Vertice<T>>> caminosAlternativos(GrafoDirigido<T> ciudades, Vertice<T> buenosAires, Vertice<T> tandil){

        ArrayList<ArrayList<Vertice<T>>> caminos = new ArrayList<>();
        ArrayList<Vertice<T>> camino = new ArrayList<>();

        Iterator<Integer> it = ciudades.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = ciudades.getVertice(it.next());
            v.setColor('B');
        }

        it = ciudades.obtenerVertices();

        caminosAlternativos(ciudades, tandil, buenosAires, camino, caminos);

        return caminos;

    }

    private void caminosAlternativos(GrafoDirigido<T> ciudades, Vertice<T> actual, Vertice<T> fin, ArrayList<Vertice<T>> camino, ArrayList<ArrayList<Vertice<T>>> caminos){

        actual.setColor('A');
        camino.add(actual);

        if(actual.equals(fin)){
            caminos.add(new ArrayList<>(camino));
        }
        else{
            Iterator<Integer> vecinos = ciudades.obtenerAdyacentes(actual.getId());

            while(vecinos.hasNext()){
                Vertice<T> vecino = ciudades.getVertice(vecinos.next());

                if(actual.obtenerArco(vecino.getId()).getEtiqueta().equals("Cortado"))
                    continue;

                if(vecino.getColor() == 'B')
                    caminosAlternativos(ciudades, vecino, fin, camino, caminos);
            }
        }

        camino.remove(camino.size()-1);
        actual.setColor('B');

    }

}
